import socket

TAILLE = 128

def preparer_client():
    # with ... as ... pas utilisable car socket automatiquement fermée dès la sortie du bloc !
    try:
        s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
        print('Description socket : ',s)
    except OSError:
        print('Création socket échouée')
        return(-1)
    else:
        print('Création socket réussie')
        return(s)


def preparer_serveur(coord):
    try:
        s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
        print('Description socket : ',s)
    except OSError:
        print('Création socket échouée')
        return(-1)
    else:
        print('Création socket réussie')
        try:
            s.bind(coord)
        except OSError:
            print('bind() échoué')
            s.close()
            return(-1)
        else:
            print('bind() réussi')
            return(s)


def construire_requete():
    # unique opération à faire ici : saisie requête
    requete = input('Saisir la requête : ')
    return(requete.encode())


def construire_reponse(bloc):
    # ici, "écho" => on retourne ce qu'on a reçu 
    print('Construction réponse effectuée')
    return bloc 


def analyser(bloc):
    # ici, pas d'analyse car on retourne ce qu'on a reçu
    print('Analyse requête effectuée')
    return bloc 


def utiliser(bloc):
    # unique opération à faire ici : afficher le bloc
    print('réponse reçue = '+ bloc.decode())


def envoyer(s,coord,bloc):
    try:
        qte = s.sendto(bloc, coord)
    except OSError:
        print('Envoi refusé car trop volumineux')
        return(-1)
    else:    
        print('Quantité données envoyées = ',qte)
        return(0)


def recevoir(s):
    try:
        (bloc, coord) = s.recvfrom(TAILLE) # on pourrait vérifier les coordonnées
    except ConnectionResetError: # Spécifique Windows et avec adresse de rebouclage
        print('Problème réception : interlocuteur absent ou parti')
        return(-1, coord)
    except OSError:
        print('Réception refusée car trop volumineuse')
        return(-1, coord)
    else:
        return(bloc, coord)


def arreter(s):
    try:
        s.close()
    except OSError:
        print('Socket encore ouverte !')
    else:
        print('Socket correctement fermée')





