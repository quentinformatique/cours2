import threading
import time

# méthode de démarrage du thread
def methode_thread(nb): 
	id = threading.get_native_id()
	for i in range(nb):
		print('op n° ' + str(i) +' du thread id ' +str(id))
		time.sleep(1.0) # attends 1 sec

# tout ce qui suit définit le thread principal
cpt = 5
t1 = threading.Thread(target = methode_thread, args = (cpt,))
depart = time.time()
t1.start()

for j in range(cpt):
	print('op processus n° '+str(j))
	time.sleep(0.2)

t1.join(timeout = 2.5) # on attend le thread t1, au max 2,5 s
etat = t1.is_alive() # => vérifie l’état de t1 (! si True, risque zombie)
fin = time.time()
print('durée tot = ' + str(fin-depart) + " / thread en vie ? "+ str(etat))