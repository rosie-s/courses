###############################################
#     Lesson 4 - How Programs Run             #
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
