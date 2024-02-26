import module_tcp as tcp

coord_S = ('127.0.0.1', 65432)
s1 = tcp.preparer_serveur(coord_S)
if (s1 != -1):
    s2 = tcp.accepter(s1)
    if (s2 != -1):
        requete = tcp.recevoir(s2)
        if (requete != -1):
            bloc = tcp.analyser(requete)
            reponse = tcp.construire_reponse(bloc)
            tcp.envoyer(s2,reponse)
        tcp.arreter(s2)
    tcp.arreter(s1)
