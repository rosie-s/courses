###############################################
#       Lesson 2 - How to Repeat              #
###############################################

###
# Procedure for get_next_target
###
href = '<a href='
s = ('<div id="top_bin"><div id="top_content" class="width960">'
     '<div class="udacity float-left"><a href="http://udacity.com">')
start_link = s.find(href)


def get_next_target(s):
    open_double_quote = s.find('"', start_link)
    open_double_quote = open_double_quote + 1
    close_double_quote = s.find('"', open_double_quote)
    url = s[open_double_quote:close_double_quote]
    return url, close_double_quote


###
# Procedure with no return
###
def sum(a, b):
    print("Enter Sum")
    print("a is", a)
    a = a + b
    print("a is", a)


print("Procedure should return 'None':", sum(1, 1))


###
# Square Procedure
###

# Define a procedure, square, that takes one number
# as its input, and returns the square of that
# number (result of multiplying the number by itself).

def square(n):
    return n * n


x = 5
print('The square root of', x, 'is :', square(5))  # 25


###
# Sum 3 Procedure
###

# Define a procedure, sum3, that takes three
# inputs, and returns the sum of the three input numbers.

def sum3(a, b, c):
    return a + b + c


n1 = 1
n2 = 2
n3 = 3
print('The sum of', n1, n2, n3, 'is :', sum3(1, 2, 3))  # 6


###
# Abbaize
###

# Define a procedure, abbaize, that takes two strings as its inputs,
# and returns a string that is the first input,
# followed by two repetitions of the second input,
# followed by the first input.

def abbaize(s1, s2):
    return s1 + s2 + s2 + s1


word1 = 'dog'
word2 = 'cat'
print("Abbaize for " + word1, word2 + "is: ", abbaize(word1, word2))  # 'dogcatcatdog'


###
# Find Second
###

# Define a procedure, find_second, that takes two strings as its inputs: a search string
# and a target string. It should return a number that is the position of the second
# occurrence of the target string in the search string.

def find_second(search, target):
    first_pos = search.find(target)
    second_pos = search.find(target, first_pos + 1)
    return second_pos
    # return search.find(target, search.find(target)+1 )


find_second_print = "Second target is:"

danton = "De l'audace, encore de l'audace, toujours de l'audace"
print(find_second_print, find_second(danton, 'audace'))  # 25

twister = "she sells seashells by the seashore"
print(find_second_print, find_second(twister, 'she'))  # 13

###
# Comparisons
###
print("Is 2 < 3:", 2 < 3)  # True
print("Is 21 < 3:", 21 < 3)  # False
print("Is 7*3 < 21:", 7 * 3 < 21)  # False
print("Is 7*3 != 21:", 7 * 3 != 21)  # False
print("Is 7*3 == 21:", 7 * 3 == 21)  # True


###
# If
###

# Define a procedure, bigger, that takes in two numbers as inputs,
# and returns the greater of the two inputs.
def bigger(num1, num2):
    if num1 > num2:
        return num1
    return num2


# def bigger(num1, num2):
#     if num1 < num2:
#         num1 = num2
#     return num1

###
# If-Else
##
def bigger_if_else(a, b):
    if a > b:
        r = a  # or return a
    else:
        r = b  # or return b
    return r


big_str = "The bigger number is:"
print(big_str, bigger(2, 7))  # 7
print(big_str, bigger(3, 2))  # 3
print(big_str, bigger(3, 3))  # 3
print(big_str, bigger_if_else(0, 8))  # 8


# Define a procedure, is_friend, that takes a string as its input, and
# returns a Boolean indicating if the input string is the name of a friend.
# Assume I am friends with everyone whose name starts with D
# and no one else. You do not need to check for the lower case 'd'

def is_friend(name):
    if name[0] == 'D':
        return True
    else:
        return False


def is_friend_one_line(name):
    return name[0] == 'D'


friends_str = "Are we friends? (D)"
print(friends_str, is_friend('Diane'))  # True
print(friends_str, is_friend('Fred'))  # False
print(friends_str, is_friend_one_line('Amine'))  # False
print(friends_str, is_friend_one_line('Drogo'))  # True


# Assume I am friends with everyone whose name starts with either 'D' or 'N',
# but no one else. You do not need to check for lower case 'd' or 'n'


def is_friend(name):
    if name[0] == 'D':
        return True
    if name[0] == 'N':
        return True
    else:
        return False


friends_str = "Are we friends? (D/N)"
print(friends_str, is_friend('Diane'))  # True
print(friends_str, is_friend('Fred'))  # False
print(friends_str, is_friend('Nadia'))  # True
