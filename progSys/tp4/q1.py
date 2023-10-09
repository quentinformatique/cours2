f = open("page.html", "r")
contenueA = f.read()
f.close()

f = open("page.html", "r")
contenueB = f.readlines()
f.close()

result = open("resultA.txt", "w")
result.write(contenueA)
result.close()


result = open("resultB.txt", "w")
for i in contenueB:
    result.write(i)
result.close()

result = open("resultC.txt", "w")
result.writelines(contenueB)
result.close()

f = open("page.html", "rb")
contenueD = f.read()
f.close()

result = open("resultD.txt", "wb")
result.write(contenueD)
result.close()