import threading
import time

# méthode de démarrage du thread
def methode_thread(nb, sleep): 
	id = threading.get_native_id()
	for i in range(nb):
		print('op n° ' + str(i) +' du thread id ' +str(id))
		time.sleep(sleep) 


# tout ce qui suit définit le thread principal
cpt = 5
nb_thread = 3
t = [None]*nb_thread
for i in range(nb_thread):
	t[i] = threading.Thread(target= methode_thread, args= (cpt,i,))
	
depart = time.time()
for i in range(nb_thread):
	t[i].start()

for j in range(cpt):
	print('op processus n° '+str(j) + 'du thread principal')
	time.sleep(0.2)

for i in range(nb_thread):
	       t[i].join(timeout = 3.5)
fin = time.time()

for i in range(nb_thread):
    print('thread ' + str(i) + ' en vie ?' + str(t[i].is_alive()))

print('durée tot = ' + str(fin-depart))