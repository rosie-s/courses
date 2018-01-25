###############################################
#       Lesson 1 - How to Get Started         #
###############################################

###
# Printing
###
print(3)
print(1 + 1)
print((52 * 3) + (12 * 9))
print(365 * 24 * 60 * 60)

# Print out number of minutes in 7 weeks
print(60 * 24 * 49)
print(7 * 7 * 24 * 60)  # Quiz answer

# Write Python code to print out how far light travels
# in centimeters in one nanosecond.  Use the values
# defined below.
# speed_of_light = 299792458   meters per second
# centimeters = 100            one meter is 100 centimeters
# nanosecond = 1.0/1000000000  one billionth of a second
print(299792458 * 100 * (1.0 / 1000000000))

# 2.7 Ghz processor = 2.7 billion cycles per second (Time we have for one cycle is less than a nanosecond)
# Cycle - Time a computer has to do one step
# How many centimeters does light travel in the time a computer has for one cycle?
print(299792458 * 100 * (1.0 / 1000000000) * 1 / 2.7)

###
#  Variables
###
speed_of_light = 299792458
billionth = 1.0 / 1000000000
nano_stick = speed_of_light * billionth * 100  # centimeters
print(speed_of_light)
print(speed_of_light * 100)  # Convert to centimeters
print(nano_stick)

# Given the variables defined here, write Python
# code that prints out the distance, in meters,
# that light travels in one processor cycle.

speed_of_light = 299792458.0  # meters per second
cycles_per_second = 2700000000.0  # 2.7 GHz
cycle_distance = speed_of_light / cycles_per_second

print(cycle_distance)  # meters
print(cycle_distance * 100)  # cm

# Write python code that defines the variable
# age to be your age in years, and then prints
# out the number of days you have been alive.

age = 4
days_in_year = 365.25
days_since_last_bday = 0
print(age * days_in_year + days_since_last_bday)

###
# Strings
###
print('Hello')
print("Hello")
hello = "Howdy"
print(hello)

# Define a variable, name, and assign to it a string that is your name.
name = "rosie-s"
print("Hello " + name)
print(name[0])
print(name[-1])

print('udacity'[0])  # -> 'u'
# '0123456'
print('udacity'[1 + 1])  # -> 'a''
print('udacity'[-1])  # -> # 'y'

###
# Sub-Sequences
###
word = "assume"
print(word[3:4])  # u
print(word[4:6])  # me
print(word[3:])  # ume
print(word[:4])  # assu
print(word[:])  # assume

# Write Python code that prints out Udacity (with a capital U),
# given the definition of s below.

s = 'audacity'
print("U" + s[2:])

# For any string, s='<any_string>'
# The following are always equivalent to s
print(s[:])
print(s + s[0:-1 + 1])
print(s[0:])
print(s[:3] + s[3:])

###
# Find
###
pythagoras = "There is geometry in the humming of the strings, there is music in the spacing of the spheres."
print(pythagoras.find("string"))
print(pythagoras[40:])
print(pythagoras.find("T"))
print(pythagoras.find("algebra"))

danton = "De l'audace, encore de l'audace, toujours de l'audace."
print(danton.find('audace'))  # 5
print(danton.find('audace', 0))  # 5
print(danton.find('audace', 5))  # 5
print(danton.find('audace', 25))  # 25
print(danton.find('audace', 26))  # 47
print(danton.find('audace', 47))  # 47
print(danton.find('audace', 48))  # -1

# For any variables s and t that are strings, an i that is a number
# Which of the following are equivalent to s.find(t,i)
s = 'audacity'
t = 'city'
i = 3
print(s[i:].find(t))  # result is 0
# print(s.find(t)[:i]) Can't index from a number
print(s[i:].find(t) + i)  # Only equivalent in cases where t is found
print(s[i:].find(t[i:]))

# Write Python code that initializes the variable
# start_link to be the value of the position
# where the first '<a href=' occurs in a page.

page = ('<div id="top_bin"> <div id="top_content" class="width960">'
        '<div class="udacity float-left"> <a href="/">')

href = '<a href='
start_link = page.find(href)

# Write Python code that assigns to the
# variable url a string that is the value
# of the first URL that appears in a link
# tag in the string page.
# Your code should print http://udacity.com
# Make sure that if page were changed to

# page = '<a href="http://udacity.com">Hello world</a>'

# that your code still assigns the same value to the variable 'url',
# and therefore still prints the same thing.

# page = contents of a web page
page = ('<div id="top_bin"><div id="top_content" class="width960">'
        '<div class="udacity float-left"><a href="http://udacity.com">')
open_double_quote = page.find('"', start_link)
open_double_quote = open_double_quote+1
close_double_quote = page.find('"', open_double_quote)
url = page[open_double_quote:close_double_quote]
print(url)
