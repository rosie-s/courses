# Lesson 2.5 - _How to Solve Problems_


## The Problem
> Given your birthday and the current date, calculate your age in days. Compensate for leap days. Assume that the birthday and current date are correct dates (and no time travel). Simply put, if you were born 1 Jan 2012 and todays date is 2 Jan 2012 you are 1 day old.

### Skeleton
```python

daysOfMonths = [ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

def is_leap_year(year):
    ###
    # Your code here. Return True or False
    # Pseudo code for this algorithm is found at
    # <a href="http://en.wikipedia.org/wiki/Leap_year#Algorithm" 
    # rel="nofollow">http://en.wikipedia.org/wiki/Leap_year#Algorithm</a>
    ###

def days_between_dates(y1, m1, d1, y2, m2, d2):
    ###
    # Your code here.
    ###
    return days

def extra_function(a):
    ###
    # a
    ###
    
```
## Understanding a Problem
```
Given your birthday and the current date, calculate your age in days.
           |----------------------------|           |---------------|
                          |                                  |
                        Inputs                            Outputs
```
### Problem
- A set of _possible_ inputs (set)
- Relationship between those inputs 
- The desired outputs

### Solution
Procedure that can take an input in that set and produce a desired output that satisfies the relationship that we want
```
Inputs           ->       |Procedure| -> Outputs
birthday, current_date -> |         | -> Age in days
```

## What Are The Inputs?
 **Input** : Two dates
 
### What is The Set of Valid Inputs?
- Second date must not be before first date  -> Defensive programming
- Gregorian calendar (15 Oct 1582)

### How Are Inputs Represented?
```python
def days_between_dates(y1, m1, d1, y2, m2, d2):
```

## What Are The Outputs?

- Return a number giving the number of days between the first date and the second date

## Try an Example
``` 
 days_between_dates(2013,1,24,2013,6,29)
    Jan 24 - 31   =  7
    + Feb         = 28
    + Mar         = 31
    + April       = 30
    + May         = 31
    + June 1 - 29 = 29
                  ------
                   156
```

## Algorithm Pseudocode
``` 
days   = # of days in month1 - day1 31 - 24 = 7
month += 1

while month1 < month2:
    days   += # of days in month1
    month1 += 1
days += day2
 
while year1 < year2:
    days   += days in year1    
```
Doesn't handle:
- Input dates in same month
- month2 < month1, year2 > year1
- Counting days in leap years

## Simple Mechanical Algorithm
``` 
days = 0 
while date1 is before date2:
    date1 = advance to next day
    days += 1
return days    
```

### Calculation
#### Question
> Roughly how long will it take a Python program - using this approach - to count days between 12 Dec 1912 and 12 Dec 2012?

#### Solution
```
 Roughly 100 * 365 ~ 36,500 days
 Processor         ~ 1B instructions per second
                                |
                     1nanosecond per instruction
 Each day          ~ 1000 instructions
 1000 * 36500 days -> 36.5m instructions in total
 36.5m             ~ 36ms ~ 0.036 seconds
```

# Pythonista's Guide to All Problems in The Galaxy
**Zeroth Rule - Don't Panic!!**
1. What are the _possible Inputs_?
2. What are the _Outputs_?
3. Work through some examples by hand -> (Solve the problem).
4. _Simple_ mechanical solution -> (Don't optimize prematurely! Simple & Correct).
5. Develop _incrementally_ and _test_ as we go.