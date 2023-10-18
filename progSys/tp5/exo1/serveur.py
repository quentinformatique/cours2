# serveur UDP "echo" du cours
import socket
s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
coord_S = ('127.0.0.1', 65432)
s.bind(coord_S)
print("le serveur ecoute")
(requete, coord_C) = s.recvfrom(1024)	# attente et E3 ; pas d’E4
reponse = requete			# E5 : écho
print("requete client : " + reponse.decode())
s.sendto(reponse, coord_C)		# E6
s.close()  