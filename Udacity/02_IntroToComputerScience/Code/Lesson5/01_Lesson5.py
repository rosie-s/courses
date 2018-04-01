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

