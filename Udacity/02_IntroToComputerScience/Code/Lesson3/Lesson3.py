###############################################
#     Lesson 3 - How to Solve Problems        #
###############################################

###
# Age in days
###
# Given your birthday and the current date, calculate your age in days.
# Account for leap days.


# Define a procedure to check for leap year
def is_leap_year(year):
    if year % 400 == 0:
        return True
    if year % 100 == 0:
        return False
    if year % 4 == 0:
        return True
    return False


# Define a procedure to get days in months
def days_in_month(year, month):
    # if month in (1,3,5,7,8,10,12)
    if month == 1 or month == 3 or month == 5 or month == 7 \
            or month == 8 or month == 10 or month == 12:
        return 31
    else:
        if month == 2:
            if is_leap_year(year):
                return 29
            else:
                return 28
        else:
            return 30


# Define a simple nextDay procedure, that assumes every month has 30 days.
def next_day(year, month, day):
    """
    Warning: Returns the year, month, day of the next day.
    Simple version: assume every month has 30 days.
    """
    if day < days_in_month(year, month):
        return year, month, day + 1
    else:
        if month < 12:
            return year, month + 1, 1
        else:
            return year + 1, 1, 1


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


def my_test():
    # Test next_Day
    next_string = "Next day for"
    print(next_string, '(1999,12,30) is', next_day(1999, 12, 30))  # => (2000, 1, 1)
    print(next_string, '(1999,12,30) is', next_day(2013, 1, 30))  # => (2013, 2, 1)
    print(next_string, '(1999,12,30) is', next_day(2012, 12, 30))  # => (2013, 1, 1)

    # Test with 30-day months!
    assert days_between_dates(2013, 1, 1, 2013, 1, 1) == 0
    assert days_between_dates(2013, 1, 1, 2013, 1, 2) == 1
    assert next_day(2013, 1, 1) == (2013, 1, 2)
    assert next_day(2013, 4, 30) == (2013, 5, 1)
    assert next_day(2012, 12, 31) == (2013, 1, 1)
    print("Test 30 days: Test Finished!")

    # Test with non leap years
    assert next_day(2013, 2, 28) == (2013, 3, 1)
    assert next_day(2013, 9, 30) == (2013, 10, 1)
    assert days_between_dates(2013, 1, 1, 2014, 1, 1) == 365
    print("Test with non leap year: Test Finished!")

    # Test with leap years
    assert next_day(2012, 2, 28) == (2012, 2, 29)
    assert days_between_dates(2012, 1, 1, 2013, 1, 1) == 366
    assert days_between_dates(2013, 1, 1, 2014, 1, 1) == 365
    assert days_between_dates(2013, 1, 24, 2013, 6, 29) == 156
    print("Test with leap year: Test Finished!")


def test():
    # Original test cases
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
my_test()
