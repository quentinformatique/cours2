import socket

def peparer_serveur(ip:str, port:int):
    serveur = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    coord_S = (ip, port)
    serveur.bind(coord_S)

def preparer_client(ip:str, port:int):
    serveur = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    coord_S = (ip, port)

def analyser():
    pass

def utiliser():
    pass

def construire_requete():
    requete = input('Saisir la requête : ')	#  E1
    s.sendto(requete.encode(), coord_S)	#  E2

def construire_reponse():
    pass

def envoyer():
    pass

def recevoir():
    pass

def arreter():
    pass
