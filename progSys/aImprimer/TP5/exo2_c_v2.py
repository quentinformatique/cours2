import module_udp as udp

separateur = b'|'

def construire_requete(pseudo):
    message = input("Saisir la requête (saisir 'fin' pour arrêter) : ")
    bloc = pseudo.encode() + separateur + message.encode()
    return(bloc)


def utiliser(bloc):
    print('Réponse reçue = ',bloc.decode())
    (message,code,compteur) = bloc.split(separateur)
    print('Message reçu = ',message.decode())
    print('Code = ',code.decode())
    print('Compteur = ',int(compteur.decode()))
    print('Utilisation de la réponse effectuée')


# programme principal
pseudo = input('Saisir votre pseudo : ')
fin = pseudo.encode() + separateur + b'fin'

coord_S = ('127.0.0.1', 65432)
s = udp.preparer_client()
on_continue = True # on arrête les échanges si 'fin' et au moindre problème
if (s != -1):
    while (on_continue == True):
        requete = construire_requete(pseudo)
        if (requete == fin):
            on_continue = False
        statut_envoi = udp.envoyer(s,coord_S,requete)
        if (statut_envoi != -1):
            (reponse, coord_S) = udp.recevoir(s)
            if (reponse != -1):
                utiliser(reponse)
            else:
                on_continue = False
        else:
            on_continue = False 
    udp.arreter(s)

