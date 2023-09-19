import os
import shutil

total, used, free = shutil.disk_usage("D:")
pourcetage_occupation = (used/total) * 100
print ("pourcentage d'occupation de D: " + str(pourcetage_occupation), "%")

folders = os.listdir("D:\\non_vide")

print(folders)
   
for i in folders:
    if os.path.isfile("D:\\non_vide\\"+i):
        print(i + " est un fichier")
        os.remove("D:\\non_vide\\"+i)
    else :
        print(i + " est un dossier")
        os.rmdir("D:\\non_vide\\"+i)
    