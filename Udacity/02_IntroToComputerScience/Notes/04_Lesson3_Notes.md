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