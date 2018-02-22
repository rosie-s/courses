###############################################
#           Lesson 3 - Problem Set            #
###############################################

###
# List
###
# Find original values of p so p = [1,2,3]
p = [0, 1, 1]
# p = [1, 0, 1]
# p = [-99, 100, 1]
p[0] = p[0] + p[1]
p[1] = p[0] + p[2]
p[2] = p[0] + p[1]

print("p is :", p, "\n")


###
# Product List
###
# Define a procedure, product_list, that takes as input a list of numbers,
# and returns a number that is the result of multiplying all those numbers together.

def product_list(list_of_numbers):
    result = 1
    for e in list_of_numbers:
        result = result * e
    return result


print("Product list of [9]:", product_list([9]))  # 9
print("Product list of [1,2,3,4]:", product_list([1, 2, 3, 4]))  # 24
print("Product list of [9]:", product_list([]), "\n")  # 1


###
# Greatest
###
# Define a procedure, greatest, that takes as input a list
# of positive numbers, and returns the greatest number
# in that list. If the input list is empty, the output should be 0.

def greatest(list_of_numbers):
    result = 0
    i = 0
    while i < len(list_of_numbers):
        if list_of_numbers[i] > result:
            result = list_of_numbers[i]
        i = i + 1
    return result


def greatest_for(list_of_numbers):
    result = 0
    for e in list_of_numbers:
        if e > result:
            result = e
    return result


print("Greatest of [4,23,1]:", greatest([4, 23, 1]))  # 23
print("Greatest of []:", greatest([]))  # 0
print("Greatest of [4,23,25]:", greatest_for([4, 23, 25]))  # 25
print("Greatest of [24,82,7]:", greatest_for([24, 82, 7]))  # 82
print("Greatest of []:", greatest_for([]))  # 0
