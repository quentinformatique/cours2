import threading

def print_entier(i:int):
    print("l'entier = " + str(i))
    
def print_carre(i:int):
    i = i**2
    print("l'entier au carré = " + str(i))


entier = 1
lstThread = [None, None]

while (entier != 0):
    entier = int(input("Entrez un entier : "))
    lstThread[0] = threading.Thread(target= print_entier, args= (entier,))
    lstThread[0].start()
    lstThread[0].join()

    lstThread[1] = threading.Thread(target= print_carre, args= (entier,))
    lstThread[1].start()
    lstThread[1].join()
    