def phrase(ch1:str, ch2:int):
    return ch1 + " " + str(ch2)

def status(tulpe):
    if tulpe[1] >= 0 and tulpe[1] <= 3:
        return "bébé"
    elif tulpe[1] <= 12:
        return "enfant"
    elif tulpe[1] <= 17:
        return "ado"
    elif tulpe[1] <= 65:
        return "adulte"
    elif tulpe[1] > 65:
        return "senior"
    else: 
        return "age invalide"