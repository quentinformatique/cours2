import os

chemin = f"C:\\Users\\{os.getlogin()}\\petit_test"
os.mkdir(chemin)
input("appuyer pour que le dossier soit supprimer")
os.rmdir(chemin)