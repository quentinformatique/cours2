def f(x: float)-> float:
    return x**2 - 2*x + 1

def gradf(x:float)-> float:
    return 2*x -2

def descente(x:float, a: float)-> float:
    precedent = x
    deplacement = precedent - a * gradf(x)
    i = 0 
    while i <= 100 and f(precedent) > f(deplacement):
        i += 1
        precedent = deplacement
        deplacement = precedent - a * gradf(x)
        print(f"itération {i},\nA{i-1} = {precedent},\nA{i} = {deplacement}\n\n")

    return deplacement


print(descente(13, 0.1))