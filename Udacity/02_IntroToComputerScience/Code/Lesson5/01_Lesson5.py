###############################################
#     Lesson 5 - How Programs Run             #
###############################################
import time


###
# Stopwatch
###
def time_execution(code):
    start = time.clock()
    result = eval(code)  # Evaluate any string as though it were a python expression
    run_time = time.clock() - start
    return result, run_time


print("***Stopwatch***")
print("Time Execution: '1 + 1'  :", time_execution('1+1'))
print("Time Execution: '1 + 24' :", time_execution('1+24'))
print("Time Execution: '57 + 24':", time_execution('57+24'))


###
# Spin Loop
###
def spin_loop(n):
    i = 0
    while i < n:
        i = i + 1


print("\n***Spin Loop***")
print("Time Execution: spin_loop(1000)     :", time_execution('spin_loop(1000)'))
print("Time Execution: spin_loop(10000)    :", time_execution('spin_loop(10000)'))
print("Time Execution: spin_loop(100000)   :", time_execution('spin_loop(100000)'))
print("Time Execution: spin_loop(1000000)  :", time_execution('spin_loop(1000000)'))
print("Time Execution: spin_loop(10000000) :", time_execution('spin_loop(10**7)')[1])


###
# Make Big Index
###

# Lookup
def lookup(index, keyword):
    for e in index:
        if e[0] == keyword:
            return e[1]
    return []


# Add to Index
def add_to_index(index, keyword, url):
    for e in index:
        if e[0] == keyword:
            e[1].append(url)
            return
    index.append([keyword, [url]])


# Make String
def make_string(p):
    s = ""
    for e in p:
        s = s + e
    return s


# Big Index
def make_big_index(size):
    index = []
    letters = ['a', 'a', 'a', 'a', 'a', 'a', 'a', 'a']
    while len(index) < size:
        word = make_string(letters)
        add_to_index(index, word, 'fake')
        for i in range(len(letters) - 1, 0, -1):
            if letters[i] < 'z':
                letters[i] = chr(ord(letters[i]) + 1)
                break
            else:
                letters[i] = 'a'
    return index


print("\n***Make Big Index***")
s = "Make Big Index:"
print(s, 3, " :", make_big_index(3))
print(s, 10, ":", make_big_index(10))
index1000 = make_big_index(1000)
print("Time Execution: 'lookup(index1000, udacity)' :", time_execution('lookup(index1000, "udacity")'))
print("Index 999 :", index1000[999])
print("Index  -1 :", index1000[-1])
