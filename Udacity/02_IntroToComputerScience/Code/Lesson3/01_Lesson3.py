###############################################
#     Lesson 3  - How to Manage Data          #
###############################################

###
# Stooges
###
# Define a variable, stooges, whose value is
# a  list of the names of the Three Stooges:
# 'Moe' 'Larry' 'Curly'

stooges = ['Moe', 'Larry', 'Curly']
print(stooges)

###
# Days in a month
###
# Given the variable, days_in_month,
# Define a procedure, how_many_days, that takes as input a number
# representing a month, and returns the number of days in that month.

days_in_month = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]


def how_many_days(month_number):
    if month_number <= 0 or month_number > 12:
        return "Invalid number! Valid numbers are 0 - 12"
    return days_in_month[month_number - 1]


print("Days in Month 1:", how_many_days(1))  # >>> 31
print("Days in Month 9:", how_many_days(9))  # >>> 30
print("Days in Month 0:", how_many_days(0))  # Error
print("Days in Month 13:", how_many_days(13))  # Error

###
# Nested Lists
###
beatles = [['John', 1940], ['Paul', 1942],
           ['George', 1943], ['Ringo', 1940]]

print("Members of The Beatles:", beatles)
print("Beatles[3]:", beatles[3])
print("Get name:", beatles[3][0])
print("Get year:", beatles[3][1])

###
# Countries
###
# Given the variable countries defined as:

#             Name    Capital  Populations (millions)
countries = [['China', 'Beijing', 1350],
             ['India', 'Delhi', 1210],
             ['Romania', 'Bucharest', 21],
             ['United States', 'Washington', 307]]

# Write code to print out the capital of India
# by accessing the list

print("Capital of India is:", countries[1][1])

# What multiple of Romania's population is the population
# of China? Calculate this by accessing the list and
# dividing the population of China (1350)
# by the population of Romania (21).

print("What multiple of Romania is China?: ", countries[0][2] / countries[2][2])

###
# Mutation
###
p = ['H', 'e', 'l', 'l', 'o']
q = p
print("p is:", p, "\nq is: ", q)
p[0] = 'Y'
print("Change first value of p:", p, "\nq also changes:", q)

###
# Stooges 2
###
# Write one line of code that changes the value of stooges to be:
# ['Moe','Larry','Shemp']
stooges[2] = 'Shemp'
print("Updated Stooges:", stooges)

###
# Aliasing
###
spies = [0, 0, 7]
agents = spies
print("Spies:", spies, "Agents:", agents)
spies[2] = agents[2] + 1
print("Spies:", spies, "Agents:", agents)


###
# Replace spy
###
# Define a procedure, replace_spy, that takes as its input a list of
# three numbers, and modifies the value of the third element in the
# input list to be one more than its  previous value.


def replace_spy(s):
    s[2] = s[2] + 1


spy = [0, 0, 7]
print("Spy:", spy)
replace_spy(spy)
print("Spy:", spy)
# >>> [0,0,8]

###
# List operations
###
# Append
stooges_four = ['Moe', 'Larry', 'Curly']
print("Stooges Before:", stooges_four)
stooges_four.append('Shemp')
print("Stooges After append:", stooges_four)

# Plus
list_plus = [0, 1] + [2, 3]
print("Add list:", list_plus)

# Len
print("Length of [0,1]:", len([0, 1]))
print("Length of ['a', ['b', ['c']]]:", len(['a', ['b', ['c']]]))
print("Length of Udacity:", len("Udacity"))
print("Length of stooges_four:", len(stooges_four))
print("Length of list_plus:", len(list_plus))

# More append / length
p = [1, 2]
q = [3, 4]
p.append(q)
print("p:", p)
q[1] = 5
print("p:", p)


###
# Loops
###
# Print out every element in a list


# While
def print_all_elements(l):
    i = 0
    while i < len(l):
        print(l[i])
        i = i + 1


print("Print Beatles: ")
print_all_elements(beatles)


# For
def print_all_elements_for(l):
    for e in l:
        print(e)


print("Print Stooges: ")
print_all_elements_for(stooges_four)


###
# Sum List
###
# Define a procedure, sum_list, that takes as its input a list of numbers,
# and returns the sum of all the elements in the input list.

def sum_list(s):
    result = 0
    for e in s:
        result = result + e
    return result


print(sum_list([1, 7, 4]))  # 12
print(sum_list([9, 4, 10]))  # 23
print(sum_list([44, 14, 76]))  # 134


###
# Measure Udacity
###
# Define a procedure, measure_udacity, that takes as its input a list of strings,
# and returns a number that is a count of the number of elements in the input
# list that start with the uppercase letter 'U'.

def measure_udacity(l):
    count = 0
    for e in l:
        if e[0] == 'U':
            count = count + 1
    return count


print(measure_udacity(['Dave', 'Sebastian', 'Katy']))  # 0
print(measure_udacity(['Umika', 'Umberto']))  # 2
