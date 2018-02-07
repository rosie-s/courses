###############################################
#     Lesson 3  - How to Manage Data    #
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
