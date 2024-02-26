import module_tcp as tcp
import threading

separateur = b'|' 

def analyser(bloc):
    print('Requête reçue = ',bloc.decode())
    sep = bloc.index(separateur)
    #pseudo = bloc[0:sep]
    #print('pseudo=',pseudo.decode())
    message = bloc[sep+1:]
    if len(message)<20:
        code = b'c'
    else:
        code = b'l'
    print('Analyse requête effectuée')
    return(message,code)

def construire_reponse(message,code,compteur):
    rep = message + separateur + code + separateur + str(compteur).encode()
    print('Construction réponse effectuée')
    return rep

def traitement_client(s):
    cpt = 0
    on_continue = True
    while (on_continue == True):
        requete = tcp.recevoir(s)
        if (requete != -1):
            (message,code) = analyser(requete)
            cpt = cpt + 1
            if (message == b'fin'):
                on_continue = False
            reponse = construire_reponse(message,code,cpt)
            statut_envoi = tcp.envoyer(s,reponse)
            if (statut_envoi == -1):
                on_continue = False
        else:
            on_continue = False
    tcp.arreter(s)
    return(0)
    

# programme principal
coord_S = ('127.0.0.1', 65432)
s1 = tcp.preparer_serveur(coord_S)
if (s1 != -1):
    s2 = tcp.accepter(s1)
    if (s2 != -1):
        t = threading.Thread(target = traitement_client, args = (s2,))
        t.start()
        t.join()
    tcp.arreter(s1)
