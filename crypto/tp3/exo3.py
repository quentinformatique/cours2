def dechiffrer(message:str, cle:str):
    messageDechiffre = ""
    messageCode = []
    cleCode = []

    for i in message:
        messageCode.append(alphabetCharCode[i])
    for i in cle:
        cleCode.append(alphabetCharCode[i])

    for i in range(len(messageCode)):
        messageDechiffre += alphabetCodeChar[(messageCode[i] - cleCode[i % len(cleCode)])%27]
    return messageDechiffre 

    
alphabetCharCode = {chr(65 + i): i for i in range(26)}
alphabetCharCode[" "] = 26

alphabetCodeChar = {i: chr(65+i) for i in range(26)}
alphabetCodeChar[26] = " "

message = "S FWWOJGORJSOBGWYKBODQNJMOSPJSCOWIYYBGWYUOJPZK BJXZOIVJCAPIPKXG"
cle = "KPOXJK"
print(dechiffrer(message, cle))
