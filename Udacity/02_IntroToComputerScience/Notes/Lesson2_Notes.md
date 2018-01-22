# Lesson 2 - _How to Repeat_

## Introducing Procedures
A _procedure_ is something that takes **inputs** in, does some work on those inputs, and produces **outputs** as results.
````
Inputs -> |Procedure| -> Outputs
````  
### Example - Operator + 
````
Inputs           -> |Procedure| -> Outputs
Number1, Number2 -> |    +    | -> Sum of inputs
````
###Procedures in Python
````
    Inputs ->(<name>,<name>,...),(<name>),()
      |
def <name> (<parameters>):
    <block of code>
```` 
### Return Statement
````
 return <expression>,<expression>,.... 
````
Can have zero return expressions, meaning there's no output.

### Side-Effects
Things that we can see, but that are not the outputs.
````
           |   Print    |
Inputs  -> | Procedure  | -> Outputs
           |side-effects|
````
* For example, if we printed something out, we would see that result happen. 
We'd see everything that happens when the code and procedure runs. 
But we would not get it as an output.