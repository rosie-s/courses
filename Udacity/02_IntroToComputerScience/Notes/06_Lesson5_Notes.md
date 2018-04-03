# Lesson 5 - _How Programs Run_

## Algorithm Analysis
- Procedure  
Well-defined sequence of steps that can be executed _mechanically_
- Guaranteed to always _finish_ and produce correct result

## Cost

```
Inputs  -> | Algo 1 | -> Outputs
  ^
Size -> Cost <- $ -> time, memory
```

## Stopwatch
```
start = time.clock() # processor time (in seconds)
        |
    time to execute
        |
stop  = time.clock()
```
- Eval  
Allows us to evaluate any string as though it were a python expression

- e-05  
8.3....e-05 = 0.000083.... seconds

## Predicting Run Time
```
    n   |   Time
10 ^ 5  | 0.005..
10 ^ 6  | 0.05...
10 ^ 7  | 0.5....
10 ^ 8  | 5......
10 ^ 9  | 50.....
```
