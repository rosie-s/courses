# Lesson 1 - _How to Get Started_

## Printing
````python
print(3)
print(1 + 1)
````
## Python Grammar for Arithmetic Expressions
````
Expression  ->  Expression Operator Expression
Expression  ->  Number
Operator    ->  +       - Terminal
Operator    ->  *       - Terminal
Number      ->  0,1,..  - Terminal
Expression  -> (Expression)
````

### Sample 1
````
       Expression
       |
Expression    Operator    Expression
    |             |           |
Number            +         Number
    |                         |
    1                         1
````    
### Sample 2
````
       Expression
       |
Expression    Operator    Expression
    |             |           |
Exp  Op   Exp     +         Number
 |    |    |                  |
 N    *  Exp Op Exp           1
 |        ...|...
 2       3   +   3
````  

## Variables
Assignment Statement:  
`Name = Expression`  
````python
speed_of_light = 299792458
````

## Strings
Can use single quote or double quotes
````python
print('Hello')
print("Hello")
````
Can use `+` with Strings  
````
<String> + <String> -> Concatenation of the two strings
````
````python
print("Hello " + "World!")
````  

### String and Numbers
Print `!` 12 times:
````python
print("!" * 12)
````

### Indexing Strings
```
<String> [<expression>] -> One-character String
               |
             Number
````
#### Examples of Indexing
````python
print('udacity'[0])     # -> 'u'
    #     |
    # '0123456'
print('udacity'[1 + 1]) # -> 'a'
print('udacity'[-1])    # -> 'y'
````
### Selecting Sub-Sequences
````
   S         START         STOP
<String> [<expression>:<expression] -> String that is a sub-sequence of the characters in S 
               |            |          starting from position START, and ending with position STOP-1
             Number       Number                    
````    
#### Examples of Sub-Sequences
````python
word = "drogon"
print(word[3:4])  # g
print(word[4:6])  # on
print(word[3:])   # gon
print(word[:4])   # drog
print(word[:])    # drogon
````

### Find Strings in Strings
````
<String>.find(<String>) -> Number that gives first position in search string where the target string appears.   
                           If the target string is not found, output is -1
````
#### Examples of Finding Strings
````python
stark = "Winter is coming"
print(stark.find("is"))     # 7
print(stark[7:])            # is coming
print(stark.find("W"))      # 0 
print(stark.find("tyrell")) # -1

````

### Finding with Numbers
````
<string>.find(<string>,<number>)  -> Number that gives first position in search string where the target 
                                     string appears [at or after <number>]. 
                                     If the target string is not found, output is -1
````
#### Examples of Finding with Numbers
```python
lorry = "Red lorry, yellow lorry, red lorry, yellow lorry."
print(lorry.find('lorry'))      # 4
print(lorry.find('lorry', 0))   # 4
print(lorry.find('lorry', 4))   # 4
print(lorry.find('lorry', 6))   # 18
print(lorry.find('lorry', 19))  # 29
print(lorry.find('lorry', 30))  # 43
print(lorry.find('lorry', 43))  # 43
print(lorry.find('lorry', 44))  # -1
```
## Tips
### Rounding numbers
`str(<Number>) -> String`
````python
str(89) # '89'
````

### Length of a string
`len(string)`
````python
name = "rosie-s"
string_length = len(name) #7
````

### Read a string backwards
````python
name = "rosie-s"
print(name[::-1]) #s-eisor
```` 
Where the `-1` means one step back.