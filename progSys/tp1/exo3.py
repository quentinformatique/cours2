import moduleExo3

nom = input("entre votre nom :")
age = int(input("entre votre age :"))

tuple = (nom, age)

phrase = moduleExo3.phrase(tuple[0], tuple[1])

print(phrase)
print(tuple)

