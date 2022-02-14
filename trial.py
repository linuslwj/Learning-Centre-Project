import random

from random import shuffle

def getLetterMap():
    stringList = list('abcdefghij')
    shuffle(stringList)
    return ''.join(stringList)  
        
def main():
    
    x = getLetterMap()
    
    num1 = random.randint(0,9)
    num2 = random.randint(0,9)
    
    ans = num1 + num2
    
    if ans >=10:
       
            d1 = 1
            d2 = ans - 10
            
    else:
        d1 = 0
        d2 = ans
    
    cheat_sheet = str(num1) + str(num2) + str(d1) + str(d2)
    ltr_puzzle = x[num1] + x[num2] + x[d1] + x[d2]
    
    print(ltr_puzzle[0])
    
main()