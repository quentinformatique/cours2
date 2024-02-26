import module_tcp as tcp

coord_S = ('127.0.0.1', 65432)
on_continue = True # on arrête les échanges si 'fin' et au moindre problème
while (on_continue == True):
    s = tcp.preparer_client()
    if (s != -1):
        statut_connexion = tcp.connecter(s,coord_S)
        if (statut_connexion != -1):
            requete = tcp.construire_requete()
            if (requete == b'fin'):
                on_continue = False
            statut_envoi = tcp.envoyer(s,requete)
            if (statut_envoi != -1):
                reponse = tcp.recevoir(s)
                if (reponse != -1):
                    tcp.utiliser(reponse)
                else:
                    on_continue = False
            else:
                on_continue = False
        tcp.arreter(s)
