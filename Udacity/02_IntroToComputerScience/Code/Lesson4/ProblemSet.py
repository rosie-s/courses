###############################################
#           Lesson 4 - Problem Set            #
###############################################

###
# Better Splitting
###
# The built-in <string>.split() procedure works okay, but fails to find all the words on a page because it only uses
# whitespace to split the string. To do better, we should also use punctuation marks to split the page into words.
# Define a procedure, split_string, that takes two inputs: the string to split and a string containing all of the
# characters considered separators. The procedure should return a list of strings that break the source string up by
# the characters in the splitlist.


def split_string(source, splitlist):
    output = []
    at_split = True  # at a split point?
    for char in source:  # iterate through string by each letter
        if char in splitlist:
            at_split = True
        else:
            if at_split:
                output.append(char)
                at_split = False
            else:
                output[-1] = output[-1] + char  # add char to last word
    return output


print("***Split String***")
splitString = "Split String on"

out = split_string("This is a test-of the,string separation-code!", " ,!-")
print("String is: \t\t\t This is a test-of the,string separation-code!")
print(splitString, "!-\"\t", out)  # ['This', 'is', 'a', 'test', 'of', 'the', 'string', 'separation', 'code']

out = split_string("After  the flood   ...  all the colors came out.", " .")
print("String is: \t\t\t After  the flood   ...  all the colors came out.")
print(splitString, " .\t", out)  # ['After', 'the', 'flood', 'all', 'the', 'colors', 'came', 'out']

out = split_string("First Name,Last Name,Street Address,City,State,Zip Code", ",")
print("String is: \t\t\t First Name,Last Name,Street Address,City,State,Zip Code")
print(splitString, ",\t", out)  # ['First Name', 'Last Name', 'Street Address', 'City', 'State', 'Zip Code']
