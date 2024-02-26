import module_tcp as tcp
import select

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


def traitement_client(s,cpt):
    on_continue = True
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
    return(on_continue,cpt)    

# programme principal
N = 3
Nc = 0
Nd = 0
s = []
cpt = []
coord_S = ('127.0.0.1', 65432)
s1 = tcp.preparer_serveur(coord_S)
if (s1 != -1):
    s.append(s1)
    while(Nd < N):
        (r,w,e) = select.select(s,[],[])
        if (s1 in r):
            s2 = tcp.accepter(s1)
            if (s2 != -1):
                if (Nc < N):
                    s.append(s2)
                    cpt.append(0)
                    Nc = Nc + 1
                else:
                    tcp.arreter(s2)
                    # comment limiter le nombre de clients acceptés ?
                    # supprimer s1 : mauvaise solution car bloque tout (l'O.S. accepte)
                    # il est préférable d'accepter et d'arrêter immédiatement les échanges
        for i in s[1:]: # pas la 1ère socket car = s1 ne servant qu'à l'acceptation de nouveau client
            if (i in r):
                pos = s.index(i)
                (on_continue,compteur) = traitement_client(i,cpt[pos-1]) # pos-1 car il y a une socket de plus que de clients
                cpt[pos-1] = compteur
                if (on_continue == False):
                    Nd = Nd + 1
                    tcp.arreter(i)
                    s.pop(pos)
                    cpt.pop(pos-1)
    tcp.arreter(s1)
