###############################################
#       Lesson 2 - How to Repeat              #
###############################################

###
# Procedure for get_next_target
###
href = '<a href='
link = ('<div id="top_bin"><div id="top_content" class="width960">'
        '<div class="udacity float-left"><a href="http://udacity.com">')
start = link.find(href)


def get_next_target_orig(s):
    open_double_quote = s.find('"', start)
    open_double_quote = open_double_quote + 1
    close_double_quote = s.find('"', open_double_quote)
    url = s[open_double_quote:close_double_quote]
    return url, close_double_quote


###
# Procedure with no return
###
def add(a, b):
    print("Enter Sum")
    print("a is", a)
    a = a + b
    print("a is", a)


print("Procedure should return 'None':", add(1, 1))


###
# Square Procedure
###
# Define a procedure, square, that takes one number
# as its input, and returns the square of that
# number (result of multiplying the number by itself).

def square(c):
    return c * c


d = 5
print('The square root of', d, 'is :', square(5))  # 25


###
# Sum 3 Procedure
###
# Define a procedure, sum3, that takes three
# inputs, and returns the sum of the three input numbers.

def sum3(e, f, g):
    return e + f + g


n1 = 1
n2 = 2
n3 = 3
print('The sum of', n1, n2, n3, 'is :', sum3(1, 2, 3))  # 6


###
# Abbaize
###
# Define a procedure, abbaize, that takes two strings as its inputs,
# and returns a string that is the first input,
# followed by two repetitions of the second input, followed by the first input.
def abbaize(s1, s2):
    return s1 + s2 + s2 + s1


word1 = 'dog'
word2 = 'cat'
print("Abbaize for " + word1, word2 + " is: ", abbaize(word1, word2))  # 'dogcatcatdog'


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


def bigger_2(num1, num2):
    if num1 < num2:
        num1 = num2
    return num1


###
# If-Else
##
def bigger_if_else(h, k):
    if h > k:
        j = h  # or return a
    else:
        j = k  # or return b
    return j


big_str = "The bigger number is:"
print(big_str, bigger(2, 7))  # 7
print(big_str, bigger(3, 2))  # 3
print(big_str, bigger_2(3, 3))  # 3
print(big_str, bigger_if_else(0, 8))  # 8


###
# Is Friend?
###
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


###
# Or
###

def is_friend_or(name):
    return name[0] == 'D' or name[0] == 'N'


print(friends_str, is_friend('Nicole'))  # True


###
# Biggest Number
###
# Define a procedure, biggest, that takes three  numbers as inputs and
# returns the largest of those three numbers.

def biggest(c, e, f):
    return bigger(bigger(c, e), f)


def biggest_2(c, e, f):
    if c > e:
        if c > f:
            return c
        else:
            return f
    else:
        if e > f:
            return e
        else:
            return f


def biggest_3(c, e, f):
    return max(c, e, f)


print(big_str, biggest(3, 6, 9))  # 9
print(big_str, biggest(6, 9, 3))  # 9
print(big_str, biggest_2(9, 3, 6))  # 9
print(big_str, biggest_3(3, 3, 9))  # 9
print(big_str, biggest_2(9, 3, 9))  # 9

###
# Loops
###
# While
i = 0
while i < 10:
    print("i is:", i)
    i = i + 1


###
# Print Numbers
###
# Define a procedure, print_numbers, that takes as input a positive whole number, and prints
# out all the whole numbers from 1 to the input number.
# Make sure your procedure prints "upwards", so from 1 up to the input number.

def print_numbers(p):
    n = 0
    while n < p:
        n = n + 1
        print("Print ", n)


print_numbers(3)


###
# Factorial
###
# Define a procedure, factorial, that takes one number as its input
# and returns the factorial of that number.

def factorial(n):
    if n == 0 or n == 1:
        return 1
    a = n
    while n > 1:
        n = n - 1
        a = a * n
    return a


def factorial_2(n):
    result = 1
    while n >= 1:
        result = result * n
        n = n - 1
    return result


fact = "Factorial of"
print(fact, 4, factorial(4))  # 24
print(fact, 5, factorial(5))  # 120
print(fact, 6, factorial(6))  # 720
print(fact, 6, factorial_2(6))  # 720


# Modify the get_next_target procedure so that if there is a link it behaves as before,
# but if there is no link tag in the input string, it returns None, 0.
# Also note that your answer will appear in parentheses if you print it.

def get_next_target(s):
    start_link = s.find('<a href=')
    # Code goes here
    if start_link == -1:
        return None, 0
    open_double_quote = s.find('"', start_link)
    open_double_quote = open_double_quote + 1
    close_double_quote = s.find('"', open_double_quote)
    url = s[open_double_quote:close_double_quote]
    return url, close_double_quote


###
# Print All Links
###
def print_all_links(page):
    while True:
        url, close_double_quote = get_next_target(page)
        if url:
            print(url)
            page = page[close_double_quote:]
        else:
            break


all_links = 'this <a href="test1">link 1</a> is <a href="test2">link 2</a> a <a href="test3">link 3</a>'
print("Extracted links from:", all_links)
print_all_links(all_links)
