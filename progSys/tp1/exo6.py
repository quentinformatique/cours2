c = input("entrez une phrase : ")

nombre = 0
i = 0

for a in c:
    nombre +=  i * ord(a)
    i += 1
    
    
print(nombre)