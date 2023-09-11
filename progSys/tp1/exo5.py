import moduleExo5

nom = input("entre votre nom :")
age = int(input("entre votre age :"))

tuple = (nom, age)

phrase = moduleExo5.phrase(tuple[0], tuple[1])

print(phrase)
print(tuple)
print("annee prochaine : " + str(moduleExo5.anneeProchaie(tuple)[1]))

