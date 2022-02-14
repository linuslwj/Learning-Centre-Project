'''review: python class to define (model) a real-world object
class <classname>:
    #constructor-method,__init__(),
    #a series of accessor methods (getter methods)
    #these can be also property method (this allows us to treat as a variable
    #a series of mutator methods (setter methods)
    #we can make use of the property to update the attribute
    #these accessor and mutator methods have to with the attribute defined
    # in this class
    #usually, provide a useful method, __str__(). this returns the attribute's value
    #as a single string
'''

def main():
    
    a,b = 16,5
    c = 0
    
    while True:
        if a >= b:
            c = c + 1
            a = a - b
        else:
            break
    print(a,b,c)
    
main()
