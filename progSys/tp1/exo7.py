def dessinPiramide(h):
    fin = ""
    for n in range(0, h+1):
        for j in range(0, h-n):
            fin += " "
        for a in range(0, (2*n+1)):
            fin += "*"
        fin += "\n"
    return fin

print(dessinPiramide(25))
