# client UDP "echo" du cours
import socket
s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
coord_S = ('127.0.0.1', 65432)
requete = input('Saisir la requête : ')	#  E1
s.sendto(requete.encode(), coord_S)	#  E2
print("le client attend")
(reponse, coord_S) = s.recvfrom(1024)	#  attente et E7 
print('Réponse client = ', reponse.decode())  	#  E8
s.close() 