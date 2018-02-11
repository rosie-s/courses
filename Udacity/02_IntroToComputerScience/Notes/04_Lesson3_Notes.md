# Lesson 3 - _How to Manage Data_

## Structured Data
```
      String                     List
         |                        |
Sequence of characters   Sequence of anything!
 s = 'yabba!'             p = ['y','a','b','b','a','!']
 s[0] -> 'y'              p[0] -> 'y'
 s[2:4] -> 'bb'           p[2:4] -> ['b','b']
```
## Grammar for list
```
<list> -> [<Expression>,<Expression>,...]
```
- Empty list: `[]`
- List with 1 element: `[3]`

## Nested Lists
``` python
mixed_up = ['apple', 3, 'oranges', 27, [1, 2, ['alpha', 'beta']]]

beatles = [['John', 1940],
           ['Paul', 1942],
           ['George', 1943],
           ['Ringo', 1940]]              
```

## Mutation
- Mutation _modifies_ an existing object
- Mutation affects the value of other objects
``` python
s = 'Hello'                         p = ['H', 'e', 'l', 'l', 'o']
s = 'Yello'                         p[0] = 'Y'
s = s + 'w' #s is now Yellow        p is now ['Y', 'e', 'l', 'l', 'o']  - Didn't create a new list
                                    q = p
                                    q[4] = '!' # This will change the value of p
```

## Aliasing
2 different ways to refer to the same object
- If 2 variable names (p,q) refer to the same object, any change made to the object p refers to also affects
the value that q refers to. 
- If the value in the first position of p is changed, that also changes the value q refers to. 
```python
p = ['H', 'e', 'l', 'l', 'o']
q = p
p[0] = 'B' # q is also ['B', 'e', 'l', 'l', 'o']
```
- If p is assigned to a new value, this assignment will create a new object. The value of q is the same. 
```python
p = ['B','y','e'] 
# q is still ['B', 'e', 'l', 'l', 'o']
```

## List Operations
### Append 
- Invoked on a list, and takes an element as a parameter, then adds the element to the end of the list.
```
<list>.append(<element>)
```
- Example
```python
stooges = ['Moe', 'Larry', 'Curly']
stooges.append('Shemp')
# stooges is now stooges = ['Moe', 'Larry', 'Curly', 'Shemp']
```
### Plus
- Operates on 2 lists as its operands and produces a new list that consists of all the elements in the 2 lists put together.
```
<list> + <list>
```
- Example
```
[0,1] + [2,3] -> [0,1,2,3]
```
### Len
- Takes a list as its input and produces as its output a number that is the length of the list.
```
len(<list>)
```
- Example
```
len([0,1]) -> 2
len(['a', ['b', ['c']]]) -> 2
len("Udacity") -> 7
```
