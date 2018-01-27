# Lesson 2 - _How to Repeat_

## Introducing Procedures
A _procedure_ is something that takes **inputs** in, does some work on those inputs, and produces **outputs** as results.
```
Inputs -> |Procedure| -> Outputs
```  
### Example - Operator + 
```
Inputs           -> |Procedure| -> Outputs
Number1, Number2 -> |    +    | -> Sum of inputs
```
### Procedures in Python
```
    Inputs ->(<name>,<name>,...),(<name>),()
      |
def <name> (<parameters>):
    <block of code>
```
### Return Statement
```
 return <expression>,<expression>,.... 
```
Can have zero return expressions, meaning there's no output.

### Side-Effects
Things that we can see, but that are not the outputs.
```
           |   Print    |
Inputs  -> | Procedure  | -> Outputs
           |side-effects|
```
* For example, if we printed something out, we would see that result happen. 
We'd see everything that happens when the code and procedure runs. 
But we would not get it as an output.

## Using Procedures
```
<procedure> (<input>,<input>,....)
                |
        Operands/Arguments
```
### Define and Use
```python
#Define
def rest_of_strings(s):  # s     = 'audacity'
    return s[1:]         # s[1:] = 'udacity'

#Use
print (rest_of_strings('audacity')) # udacity   
```

## Comparisons
Python provides lots of different operators for doing comparisons, e.g
 - `<`  : Less than 
 - `>`  : Greater than
 - `<=` : Less than or equal to
 - `!=` : Not equal to
 - `==` : Equality
```
<Numbers> <Operator> <Number>
```
Output of a comparison is boolean: `True` `False`

### Example of Comparison 
```python
print (2 < 3) # True
```

## If
```
if <Test Expression>:
    <Block>    
```
### Example of If
```python
def absolute(x):
    if x < 0:
        x = -x
    return x
```
## If-Else
```
if <Test Expression>:
    <Block>   
else:
    <Block> 
```
### Example of If-Else
```python
def bigger_if_else(a, b):
    if a > b:
        r = a  # or return a
    else:
        r = b  # or return b
    return r
```

## Or
```
<Expression> or <Expression>
```
- If the 1st expression evaluates to **TRUE**, the value is **TRUE** and the second expression is not evaluated
- If the 1st expression evaluates to **FALSE**, the value is the **value of the second expression** 

```python
def is_friend_or(name):
    return name[0] == 'D' or name[0] == 'N'
    
print (True or False)  # T
print (False or True)  # T
print (True or True)   # T  
print (False or False) # F 
```

## While Loop
``` 
 while <TestExpression>:  0,1,2.....times
       <Block>
```
### Example of While Loop
```python
i = 0
while i < 10:
    print("i is:", i)
    i = i + 1
```

## Break
``` 
 while <TestExpression>: 
       <Block>
       if <BreakTest>:
           break
       <More Code>         
 <After While>  
```

### Example of Break
```python
def print_numbers(p):
    n = 0
    while True:
        if n > p:
            break
        print (n)
        n = n + 1       
```

## Multiple Assignment
```
<Name1>, <Name2>,... = <Expression1>, <Expression2>,...   
```
### Example of Multiple Assignment
```python
a, b = 1 , 2
```

## Tips
### Max Value
`max()`
```python
def biggest_3(d, e, f):
    return max(d, e, f)
```
