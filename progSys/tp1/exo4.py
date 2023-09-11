import moduleExo4

nom = input("entre votre nom :")
age = int(input("entre votre age :"))

tuple = (nom, age)

phrase = moduleExo4.phrase(tuple[0], tuple[1])

print(phrase)
print(tuple)
print(moduleExo4.status(tuple))

