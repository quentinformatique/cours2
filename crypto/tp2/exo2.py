def occurences(chaine):
    return {letter: round(((chaine.count(letter)/len(chaine))*100),2) for letter in 'abcdefghijklmnopqrstuvwxyz'}

def supprimer_caracteres_non_alpha(input_string):
    # Utilisation de isalpha() pour vérifier si chaque caractère est une lettre
    letters_only = ''.join(char for char in input_string if char.isalpha())
    return letters_only

with open ("text.txt", "r") as file:
    print(occurences(supprimer_caracteres_non_alpha(file.read().lower())))