###############################################
#           Lesson 2 - Problem Set            #
###############################################

###
# Udacify
###
# Define a procedure, udacify, that takes as input a string, and returns a string that
# is an uppercase 'U' followed by the input string.


def udacify(s):
    return 'U' + s


insert_u = "Add U to word:"
print(insert_u, udacify('dacians'))  # Udacian
print(insert_u, udacify('turn'))  # Uturn
print(insert_u, udacify('boat'))  # Uboat


###
# Median
###
# Define a procedure, median, that takes three numbers as its inputs, and returns the median
# of the three numbers.

def bigger(a, b):
    if a > b:
        return a
    else:
        return b


def biggest(a, b, c):
    return bigger(a, bigger(b, c))


def median(a, b, c):
    big = biggest(a, b, c)
    if big == a:
        return bigger(b, c)
    if big == b:
        return bigger(a, c)
    else:
        return bigger(a, b)


median_str = "Median is:"
print(median_str, median(1, 2, 3))  # 2
print(median_str, median(9, 3, 6))  # 6
print(median_str, median(7, 8, 7))  # 7


###
# Countdown
###
# Define a procedure, countdown, that takes a positive whole number as its input, and prints
# out a countdown from that number to 1, followed by Blastoff!
# The procedure should not return anything. For this question, you just need to call
# the procedure using the line


def countdown(n):
    while n > 0:
        print(n)
        n = n - 1
    print('Blastoff!')


countdown(5)


# Define a procedure, find_last, that takes as input two strings, a search string and a target string,
# and returns the last position in the search string where the target string appears, or -1 if there
# are no occurrences.


def find_last(search, target):
    last_pos = -1
    while True:
        pos = search.find(target, last_pos + 1)
        if pos == -1:
            return last_pos
        last_pos = pos


last = "Last position:"
print(last, find_last('aaaa', 'a'))  # 3
print(last, find_last('aaaaa', 'aa'))  # 3
print(last, find_last('aaaa', 'b'))  # -1
print(last, find_last("111111111", "1"))  # 8
print(last, find_last("222222222", ""))  # 9
print(last, find_last("", "3"))  # -1
print(last, find_last("", ""))  # 0


###############################################
#           Lesson 2 - Optional               #
###############################################

###
# Weekend
###
# Define a procedure weekend which takes a string as its input, and
# returns the boolean True if it's 'Saturday' or 'Sunday' and False otherwise.

def weekend(day):
    if day == 'Saturday' or day == 'Sunday':
        return True
    return False


weekend_str = "Is day entered a day in the weekend?"
print(weekend_str, weekend('Monday'))  # False
print(weekend_str, weekend('Saturday'))  # True
print(weekend_str, weekend('July'))  # False


###
# Stamps
###
# Define a procedure, stamps, which takes as its input a positive integer in
# pence and returns the number of 5p, 2p and 1p stamps (p is pence) required
# to make up that value. The return value should be a tuple of three numbers
# (that is, your return statement should be followed by the number of 5p,
# the number of 2p, and the number of 1p stamps).
#
# Your answer should use as few total stamps as possible by first using as
# many 5p stamps as possible, then 2 pence stamps and finally 1p stamps as
# needed to make up the total.


def stamps(n):
    a, b, c = 0, 0, 0
    while n > 0:
        if n >= 5:
            a += 1
            n -= 5
        elif n >= 2:
            b += 1
            n -= 2
        else:
            c += 1
            n -= 1
    return a, b, c


stamps_str = "pence. No of (5p, 2p, 1p) stamps:"
print(8, stamps_str, (stamps(8)))  # (1, 1, 1)  # one 5p stamp, one 2p stamp and one 1p stamp
print(5, stamps_str, (stamps(5)))  # (1, 0, 0)  # one 5p stamp, no 2p stamps and no 1p stamps
print(29, stamps_str, (stamps(29)))  # (5, 2, 0)  # five 5p stamps, two 2p stamps and no 1p stamps
print(0, stamps_str, (stamps(0)))  # (0, 0, 0)  # no 5p stamps, no 2p stamps and no 1p stamps


###
# Set_Range
###
# The range of a set of values is the maximum value minus the minimum value.
# Define a procedure, set_range, which returns the range of three input values.

# Hint: the procedure, biggest which you coded in this unit
# might help you with this question. You might also like to find a way to
# code it using some built-in functions.

def set_range(a, b, c):
    s_range = max(a, b, c) - min(a, b, c)
    rounded_set_range = round(s_range, 1)
    return rounded_set_range


range_str = "Range of"
print(range_str, "(10,4,7) is:", set_range(10, 4, 7))  # 6  # since 10 - 4 = 6
print(range_str, "(1.1, 7.4, 18.7) is:", set_range(1.1, 7.4, 18.7))  # 17.6 # since 18.7 - 1.1 = 17.6
