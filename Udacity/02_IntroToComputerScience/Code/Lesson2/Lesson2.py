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
print(find_second_print, find_second(danton, 'audace'))
# >>> 25

twister = "she sells seashells by the seashore"
print(find_second_print, find_second(twister, 'she'))
# >>> 13
