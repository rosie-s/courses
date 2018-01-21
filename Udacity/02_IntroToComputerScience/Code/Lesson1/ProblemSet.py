# Write Python code that prints out the number of hours in 7 weeks.
hours = "Hours in 7 weeks:"
hours_in_7_weeks = 24 * 7 * 7
print(hours, hours_in_7_weeks)

# Write Python code that stores the distance in meters that light travels in one
# nanosecond in the variable, nano-distance.
speed_of_light = 299800000.  # meters per second
nano_per_sec = 1000000000.  # 1 billion
nano_distance = (speed_of_light / nano_per_sec)
print("Distance light travels in 1 nanosecond:", nano_distance)

# Given the variables s and t defined as:
s = 'udacity'
t = 'bodacious'
# write Python code that prints out udacious
# without using any quote characters in
# your code.
udacious = (s[0] + t[2:])
udacious2 = (s[:5] + t[6:])
udacious3 = (s[:-2] + t[-3:])
print("Print out 'udacious' from udacity and bodacious:", udacious3)

# Assume text is a variable that holds a string.
# Write Python code that prints out the position
# of the first occurrence of 'hoo' in the value of text,
# or -1 if it does not occur at all.

text = "first hoo"
hoo = text.find("hoo")
print("First occurrence of 'hoo':", hoo)

# Assume text is a variable that holds a string.
# Write Python code that prints out the position
# of the second occurrence of 'zip' in text, or -1 if it does not occur at least twice.

# The Python code should be general enough to
# pass every possible case where 'zip' can occur in a string

text = "all zip files are zipped"
first_zip = text.find("zip")
second_zip = text.find("zip", first_zip + 1)
print("Second occurrence of 'zip':", second_zip)
print("Alternative - Second occurrence of 'zip':", text.find('zip', text.find('zip') + 1))

# Given a variable, x, that stores the  value of any decimal number,
# write Python code that prints out the nearest whole number to x.
# If x is exactly half way between two whole numbers, round up, so
# 3.5 rounds to 4 and 2.5 rounds to 3. You may assume x is not negative.

# x = 3.14159  >>> 3 (not 3.0)
# x = 27.63 >>> 28 (not 28.0)
x = 3.5  # >>> 4 (not 4.0)

# x = 3.14159
add_x = x + 0.5
str_x = str(add_x)
dot = str_x.find('.')
print("Nearest whole number of", x, "is:", str_x[:dot])

###############################################
#       Optional                              #
###############################################

# Which will print out Udacity?
s = "CidatyUcityda"
a = s[6] + s[-2:] + s[7:12]
b = s[6] + s[-2:] + s[7:11]  # this
c = s[6] + s[2:4] + s[7:13]
d = s[-7] + s[2:4] + s[7:11]  # this
e = s[6] + s[-2] + s[3] + s[:2] + s[4:6]
f = s[6] + s[2] + s[3] + s[7:11]  # this

print("Udacity ->", b, d, f)

###
# Text Replacement
###
# To minimize errors when writing long texts with
# complicated expressions you could replace
# the tricky parts with a marker.
# Write a program that takes a line of text and
# finds the first occurrence of a certain marker
# and replaces it with a replacement text.
# The resulting line of text should be stored in a variable.
# All input data will be given as variables.

# Example 1
marker = "AFK"
replacement = "away from keyboard"
line = "I will now go to sleep and be AFK until lunch time tomorrow."

# Example 2 # uncomment this to test with different input
# marker = "EY"
# replacement = "Eyjafjallajokull"
# line = "The eruption of the volcano EY in 2010 disrupted air travel in Europe for 6 days."

find_marker = line.find(marker)
marker_length = len(marker)
line_before_marker = line[:find_marker]
line_after_marker = line[find_marker + marker_length:]

replaced = line_before_marker + replacement + line_after_marker

print("Replace '" + marker + "' with '" + replacement + "':", replaced)

###
# Palindrome
###
# Make a program that checks if a word is a palindrome.
# If the word is a palindrome, print 0 to the terminal,
# -1 otherwise. The word contains lowercase letters a-z and
# will be at least one character long.
#
# HINT!
# You can read a string backwards with the following syntax:
# string[::-1] - where the "-1" means one step back.
# This exercise can be solved with only unit 1 knowledge
# (no loops or conditions)

word = "madam"
# word = "madman"  # uncomment this to test

word_backwards = word[::-1]
is_palindrome = word_backwards.find(word)

print("Is '" + word + "' a palindrome?:", is_palindrome)
