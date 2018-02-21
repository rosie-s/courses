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
- If 2 variable names (p , q) refer to the same object, any change made to the object p refers to also affects
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
```python
[0, 1] + [2, 3] # [0, 1, 2, 3]
```
### Len
- Takes a list as its input and produces as its output a number that is the length of the list.
```
len(<list>)
```
- Example
```python
len([0, 1])    # 2
len(['a', ['b', ['c']]]) # 2
len("Udacity") # 7
```

## How Computers Store Data
- **Register:** Holds the data that CPU is currently processing
- **DRAM:** Holds program instruction and data that the program requires for execution

### DRAM
```python
print(2 ** 10) # 1KB - 1024 
print(2 ** 20) # 1MB - 1048576
print(2 ** 30) # 1GB - 1073741824
print(2 ** 40) # 1TB - 1099511627776
```
- 2gb of memory
```
2^30 * 2 * 8 ~ 17 billion light switches
....
1 byte = 8  bit
1 bit ~ light switch
```
- Latency - Time to retrieve a value

    Latency for 2GB DRAM is 12 nanosecond
- Cost for 2GB DRAM - $10

### Memory Hierarchy
```
          Cost per Bit    Latency     Latency-Distance
--------|-------------|------------|-------------------
Bit       $0.50           1sec        300,000 km
CPU
Register  $0.001          <0.4ns      0.12 m

DRAM      n$0.58          12ns        3.6m
```
### Hard Drives
- 1.0TB 
```
8 * 2^40 bits ~ 8.8 trillion bits ~ 8 trillion bits
Latency -> 7milliseconds (1/1000th second)
Cost    -> $100

          Cost per Bit    Latency     Latency-Distance
--------|-------------|------------|-------------------
H.Drive       $0.01        7ms        2098km ~ 2100 km
```

## Loops
- While and For Loop

### While
```
while <test>:
    <Block>
``` 
### For
```
for <name> in <list>:
    <Block>
```

## Index
```
<list>.index(<value>)
```
- If `<value>` is in the `1ist`, returns the first position where `<value>` is found in the `<list>`.
- Otherwise, produces an error.

## In and Not In
```
"<value> not in <list>" is exactly equivalent to saying "not <value> in <list>"
```
### In
```
<value> in <list>
```
- If `<value>` is in the `1ist`, output is `True`.  
- Otherwise, output is `False`.

### Not In
```
<value> not in <list>
```
- If `<value>` is not in the `1ist`, the result of value not in list is `True`.
- If the value is in the list, then the result of value not in list is `False`.

## Pop
```
<list>.pop() -> element
```
- Mutates the list by removing and returning it's last element

```python
a = [1, 2, 3]
b = a
x = a.pop() # x = 3
```

## Web Crawler - Crawling Process
```
start with tocrawl = [seed]
crawled = []
while there are more pages tocrawl:
    pick a page from tocrawl 
    check if we already crawled it
    add that page to crawled
    add all the link targets on this page tocrawl
return crawled    
```
