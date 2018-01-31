###############################################
#     Lesson 3 - How to Solve Problems        #
###############################################

###
# Age in days
###
# Given your birthday and the current date, calculate your age in days.
# Account for leap days.

###
# Step 1
###
# Define a simple nextDay procedure, that assumes every month has 30 days.


def next_day(year, month, day):
    """
    Warning: Returns the year, month, day of the next day.
    Simple version: assume every month has 30 days.
    """
    if day < 30:
        return year, month, day + 1
    else:
        if month < 12:
            return year, month + 1, 1
        else:
            return year + 1, 1, 1


next_String = "Next day for"
print(next_String, '(1999,12,30) is', next_day(1999, 12, 30))  # => (2000, 1, 1)
print(next_String, '(1999,12,30) is', next_day(2013, 1, 30))  # => (2013, 2, 1)
print(next_String, '(1999,12,30) is', next_day(2012, 12, 30))  # => (2013, 1, 1)


def date_is_before(year1, month1, day1, year2, month2, day2):
    """Returns True if year1-month1-day1 is before
       year2-month2-day2. Otherwise, return False."""
    if year1 < year2:
        return True
    if year1 == year2:
        if month1 < month2:
            return True
        if month1 == month2:
            return day1 < day2
    return False


def days_between_dates(year1, month1, day1, year2, month2, day2):
    """Returns the number of days between year1/month1/day1
       and year2/month2/day2. Assumes inputs are valid dates
       in Gregorian calendar, and the first date is not after
       the second."""
    # program defensively! Add an assertion if the input is not valid!
    assert not date_is_before(year2, month2, day2, year1, month1, day1)
    days = 0
    while date_is_before(year1, month1, day1, year2, month2, day2):
        year1, month1, day1 = next_day(year1, month1, day1)
        days += 1
    return days


def test():
    test_cases = [((2012, 1, 1, 2012, 2, 28), 58),
                  ((2012, 1, 1, 2012, 3, 1), 60),
                  ((2011, 6, 30, 2012, 6, 30), 366),
                  ((2011, 1, 1, 2012, 8, 8), 585),
                  ((1900, 1, 1, 1999, 12, 31), 36523)]

    for (args, answer) in test_cases:
        result = days_between_dates(*args)
        if result != answer:
            print("Test with data:", args, "failed")
        else:
            print("Test case passed!")


test()
