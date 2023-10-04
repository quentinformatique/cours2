import threading

def carre():
    global nb
    while(nb!=0):
        carre = nb * nb
        print('le carré de', nb, 'est :', carre)

def suivant():
    global nb
    while(nb!=0):
        suivant = nb + 1
        print('le suivant de', nb, 'est :', suivant)

nb = int(input('saisir un entier : '))

t1 = threading.Thread(target = suivant)
t2 = threading.Thread(target = carre)
t1.start()
t2.start()

while(nb!=0):
    nb = int(input('saisir un entier (0 pour arrêter) : '))

t1.join()
t2.join()
etat_t1 = t1.is_alive()
etat_t2 = t2.is_alive()
print('thread suivant en vie ? '+str(etat_t1) + '\nthread carre en vie ? ' + str(etat_t2))

 
