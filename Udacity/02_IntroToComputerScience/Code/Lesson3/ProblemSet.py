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

print("***List***")
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


print("***Product List***")
print("Product list of [9]:", product_list([9]))  # 9
print("Product list of [1,2,3,4]:", product_list([1, 2, 3, 4]))  # 24
print("Product list of [9]:", product_list([]), "\n")  # 1


###
# Greatest
###
# Define a procedure, greatest, that takes as input a list of positive numbers, 
# and returns the greatest number in that list. If the input list is empty, the output should be 0.
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


print("***Greatest***")
print("Greatest of [4,23,1]:", greatest([4, 23, 1]))  # 23
print("Greatest of []:", greatest([]))  # 0
print("Greatest of [4,23,25]:", greatest_for([4, 23, 25]))  # 25
print("Greatest of [24,82,7]:", greatest_for([24, 82, 7]))  # 82
print("Greatest of []:", greatest_for([]), "\n")  # 0


###
# List of Lists
###
# Define a procedure, total_enrollment, that takes as an input a list of elements, where each element is a list 
# containing three elements: a university name, the total number of students enrolled, and the annual tuition fees.
# The procedure should return two numbers, not a string, giving the total number of students enrolled at all of the
# universities in the list, and the total tuition fees (which is the sum of the number of students enrolled times the 
# tuition fees for each university).
def total_enrollment(list_of_elements):
    total_students = 0
    total_fees = 0
    for e in list_of_elements:
        total_students = total_students + e[1]
        total_fees = total_fees + e[2] * e[1]
    return total_students, total_fees


def total_enrollment_sol(list_of_elements):
    total_students = 0
    total_tuition = 0
    for name, students, price in list_of_elements:
        total_students = total_students + students
        total_tuition = total_tuition + students * price
    return total_students, total_tuition


udacious_univs = [['Udacity', 90000, 0]]

usa_univs = [['California Institute of Technology', 2175, 37704],
             ['Harvard', 19627, 39849],
             ['Massachusetts Institute of Technology', 10566, 40732],
             ['Princeton', 7802, 37000],
             ['Rice', 5879, 35551],
             ['Stanford', 19535, 40569],
             ['Yale', 11701, 40500]]

print("***List of Lists***")
print_total = "(total_students, total_fees)"
print(print_total, total_enrollment(udacious_univs))  # (90000,0)
print(print_total, total_enrollment(usa_univs))  # (77285,3058581079)
print(print_total, total_enrollment_sol(udacious_univs))  # (90000,0)
print(print_total, total_enrollment_sol(usa_univs), "\n")  # (77285,3058581079)


###
# Max Page
###
# The web crawler we built at the end of Unit 3 has some serious flaws if we were going to use it in a real crawler. 
# One problem is if we start with a good seed page, it mightrun for an extremely long time (even forever, since the 
# number of URLS on the web is not actually finite). This question and the following one explore two different ways
# to limit the pages that it can crawl.
# Modify the crawl_web procedure to take a second parameter, max_pages, that limits the number of pages to crawl. 
# Your procedure should terminate the crawl after max_pages different pages have been crawled, or when there are no
# more pages to crawl.

# The following definition of get_page provides an interface
# to the website found at http://www.udacity.com/cs101x/index.html
def get_page(url):
    try:
        if url == "http://www.udacity.com/cs101x/index.html":
            return ('<html> <body> This is a test page for learning to crawl! '
                    '<p> It is a good idea to '
                    '<a href="http://www.udacity.com/cs101x/crawling.html">learn to '
                    'crawl</a> before you try to  '
                    '<a href="http://www.udacity.com/cs101x/walking.html">walk</a> '
                    'or  <a href="http://www.udacity.com/cs101x/flying.html">fly</a>. '
                    '</p> </body> </html> ')
        elif url == "http://www.udacity.com/cs101x/crawling.html":
            return ('<html> <body> I have not learned to crawl yet, but I '
                    'am quite good at '
                    '<a href="http://www.udacity.com/cs101x/kicking.html">kicking</a>.'
                    '</body> </html>')
        elif url == "http://www.udacity.com/cs101x/walking.html":
            return ('<html> <body> I cant get enough '
                    '<a href="http://www.udacity.com/cs101x/index.html">crawling</a>! '
                    '</body> </html>')
        elif url == "http://www.udacity.com/cs101x/flying.html":
            return ('<html> <body> The magic words are Squeamish Ossifrage! '
                    '</body> </html>')
    except:
        return ""
    return ""


def get_next_target(page):
    start_link = page.find('<a href=')
    if start_link == -1:
        return None, 0
    start_quote = page.find('"', start_link)
    end_quote = page.find('"', start_quote + 1)
    url = page[start_quote + 1:end_quote]
    return url, end_quote


def union(p, q):
    for e in q:
        if e not in p:
            p.append(e)


def get_all_links(page):
    links = []
    while True:
        url, endpos = get_next_target(page)
        if url:
            links.append(url)
            page = page[endpos:]
        else:
            break
    return links


def crawl_web(seed, max_pages):
    tocrawl = [seed]
    crawled = []  # len(crawled) is length of crawl
    while tocrawl:
        page = tocrawl.pop()
        if page not in crawled and len(crawled) < max_pages:
            union(tocrawl, get_all_links(get_page(page)))
            crawled.append(page)
    return crawled


print("***Crawl Max Length***")
print(crawl_web("http://www.udacity.com/cs101x/index.html", 1))
# ['http://www.udacity.com/cs101x/index.html']

print(crawl_web("http://www.udacity.com/cs101x/index.html", 3))
# ['http://www.udacity.com/cs101x/index.html',
# 'http://www.udacity.com/cs101x/flying.html',
# 'http://www.udacity.com/cs101x/walking.html']

print(crawl_web("http://www.udacity.com/cs101x/index.html", 500))
# ['http://www.udacity.com/cs101x/index.html',
# 'http://www.udacity.com/cs101x/flying.html',
# 'http://www.udacity.com/cs101x/walking.html',
# 'http://www.udacity.com/cs101x/crawling.html',
# 'http://www.udacity.com/cs101x/kicking.html']

print("")


###
# Max Depth
###
#
# This question explores a different way (from the previous question)
# to limit the pages that it can crawl.
###
# Modify the crawl_web procedure to take a second parameter, max_depth, that limits the depth of the search.
# We can define the depth of a page as the number of links that must be followed to reach that page starting from the 
# seed page, that is, the length of the shortest path from the seed to the page. No pages whose depth exceeds max_depth
# should be included in the crawl.
# For example, if max_depth is 0, the only page that should be crawled is the seed page. If max_depth is 1, the pages
# that should be crawled are the seed page and every page that it links to directly. If max_depth is 2, the crawl should 
# also include all pages that are linked to by these pages. Note that the pages in the crawl may be in any order.
# The following definition of get_page provides an interface to the website found at
# http://www.udacity.com/cs101x/index.html
def get_page_2(url):
    try:
        if url == "http://www.udacity.com/cs101x/index.html":
            return ('<html> <body> This is a test page for learning to crawl! '
                    '<p> It is a good idea to '
                    '<a href="http://www.udacity.com/cs101x/crawling.html">learn to '
                    'crawl</a> before you try to  '
                    '<a href="http://www.udacity.com/cs101x/walking.html">walk</a> '
                    'or  <a href="http://www.udacity.com/cs101x/flying.html">fly</a>. '
                    '</p> </body> </html> ')
        elif url == "http://www.udacity.com/cs101x/crawling.html":
            return ('<html> <body> I have not learned to crawl yet, but I '
                    'am quite good at '
                    '<a href="http://www.udacity.com/cs101x/kicking.html">kicking</a>.'
                    '</body> </html>')
        elif url == "http://www.udacity.com/cs101x/walking.html":
            return ('<html> <body> I cant get enough '
                    '<a href="http://www.udacity.com/cs101x/index.html">crawling</a>! '
                    '</body> </html>')
        elif url == "http://www.udacity.com/cs101x/flying.html":
            return ('<html> <body> The magic words are Squeamish Ossifrage! '
                    '</body> </html>')
        elif url == "http://top.contributors/velak.html":
            return ('<a href="http://top.contributors/jesyspa.html">'
                    '<a href="http://top.contributors/forbiddenvoid.html">')
        elif url == "http://top.contributors/jesyspa.html":
            return ('<a href="http://top.contributors/elssar.html">'
                    '<a href="http://top.contributors/kilaws.html">')
        elif url == "http://top.contributors/forbiddenvoid.html":
            return ('<a href="http://top.contributors/charlzz.html">'
                    '<a href="http://top.contributors/johang.html">'
                    '<a href="http://top.contributors/graemeblake.html">')
        elif url == "http://top.contributors/kilaws.html":
            return ('<a href="http://top.contributors/tomvandenbosch.html">'
                    '<a href="http://top.contributors/mathprof.html">')
        elif url == "http://top.contributors/graemeblake.html":
            return ('<a href="http://top.contributors/dreyescat.html">'
                    '<a href="http://top.contributors/angel.html">')
        elif url == "A1":
            return '<a href="B1"> <a href="C1">  '
        elif url == "B1":
            return '<a href="E1">'
        elif url == "C1":
            return '<a href="D1">'
        elif url == "D1":
            return '<a href="E1"> '
        elif url == "E1":
            return '<a href="F1"> '
    except:
        return ""
    return ""


def crawl_web(seed, max_depth):
    tocrawl = [seed]
    crawled = []
    next_depth = []
    depth = 0
    while tocrawl and depth <= max_depth:
        page = tocrawl.pop()
        if page not in crawled:
            union(next_depth, get_all_links(get_page_2(page)))
            crawled.append(page)
        if not tocrawl:
            tocrawl, next_depth = next_depth, []
            depth = depth + 1
    return crawled


print("***Crawl Max Depth***")
print(crawl_web("http://www.udacity.com/cs101x/index.html", 0))
#  ['http://www.udacity.com/cs101x/index.html']

print(crawl_web("http://www.udacity.com/cs101x/index.html", 1))
#  ['http://www.udacity.com/cs101x/index.html',
#  'http://www.udacity.com/cs101x/flying.html',
#  'http://www.udacity.com/cs101x/walking.html',
#  'http://www.udacity.com/cs101x/crawling.html']

print(crawl_web("http://www.udacity.com/cs101x/index.html", 50))
#  ['http://www.udacity.com/cs101x/index.html',
#  'http://www.udacity.com/cs101x/flying.html',
#  'http://www.udacity.com/cs101x/walking.html',
#  'http://www.udacity.com/cs101x/crawling.html',
#  'http://www.udacity.com/cs101x/kicking.html']

print(crawl_web("http://top.contributors/forbiddenvoid.html", 2))
#  ['http://top.contributors/forbiddenvoid.html',
#  'http://top.contributors/graemeblake.html',
#  'http://top.contributors/angel.html',
#  'http://top.contributors/dreyescat.html',
#  'http://top.contributors/johang.html',
#  'http://top.contributors/charlzz.html']

print(crawl_web("A1", 3), "\n")


# ['A1', 'C1', 'B1', 'E1', 'D1', 'F1'] # (May be in any order)


###
# Sudoku
###
# Define a procedure, check_sudoku, that takes as input a square list of lists representing an n x n 
# sudoku puzzle solution and returns the booleanTrue if the input is a valid sudoku square and returns 
# the boolean False otherwise.
# A valid sudoku square satisfies these two properties:
#   1. Each column of the square contains each of the whole numbers from 1 to n exactly once.
#   2. Each row of the square contains each of the whole numbers from 1 to n exactly once.
# You may assume the the input is square and contains at least one row and column.
def check_sudoku(sudoku_list):
    length_of_list = len(sudoku_list)
    digit = 1
    while digit <= length_of_list:
        i = 0
        while i < length_of_list:
            row_count = 0
            column_count = 0
            j = 0
            while j < length_of_list:
                if sudoku_list[i][j] == digit:
                    row_count = row_count + 1
                if sudoku_list[j][i] == digit:
                    column_count = column_count + 1
                j = j + 1
            if row_count != 1 or column_count != 1:
                return False
            i = i + 1  # next row/column
        digit = digit + 1  # next digit
    return True


correct = [[1, 2, 3],
           [2, 3, 1],
           [3, 1, 2]]

incorrect = [[1, 2, 3, 4],
             [2, 3, 1, 3],
             [3, 1, 2, 3],
             [4, 4, 4, 4]]

incorrect2 = [[1, 2, 3, 4],
              [2, 3, 1, 4],
              [4, 1, 2, 3],
              [3, 4, 1, 2]]

incorrect3 = [[1, 2, 3, 4, 5],
              [2, 3, 1, 5, 6],
              [4, 5, 2, 1, 3],
              [3, 4, 5, 2, 1],
              [5, 6, 4, 3, 2]]

incorrect4 = [['a', 'b', 'c'],
              ['b', 'c', 'a'],
              ['c', 'a', 'b']]

incorrect5 = [[1, 1.5],
              [1.5, 1]]

print("***Sudoku***")
check = "Check if Sudoku:"
print(check, check_sudoku(incorrect))  # False
print(check, check_sudoku(correct))  # True
print(check, check_sudoku(incorrect2))  # False
print(check, check_sudoku(incorrect3))  # False
print(check, check_sudoku(incorrect4))  # False
print(check, check_sudoku(incorrect5), "\n")  # False

###############################################
#           Lesson 3 - Optional 1             #
###############################################
print("Problem Set (Optional 1)\n")


###
# Symmetric Square
###
# A list is symmetric if the first row is the same as the first column, the second row is the same as the 
# second column and so on. Write a procedure, symmetric, which takes a list as input, and returns the
# boolean True if the list is symmetric and False if it is not.
def symmetric(check_list):
    n = len(check_list)
    # Check if it's a square
    for row in check_list:
        if len(row) != n:
            return False
    # Check if it's symmetric:
    for i in range(n):
        for j in range(n):
            if check_list[i][j] != check_list[j][i]:
                return False
    return True


print("***Symmetric Square***")
check_sym = "Check if it's a symmetric square:"

print(check_sym, symmetric([[1, 2, 3],
                            [2, 3, 4],
                            [3, 4, 1]]))  # True

print(check_sym, symmetric([["cat", "dog", "fish"],
                            ["dog", "dog", "fish"],
                            ["fish", "fish", "cat"]]))  # True

print(check_sym, symmetric([["cat", "dog", "fish"],
                            ["dog", "dog", "dog"],
                            ["fish", "fish", "cat"]]))  # False

print(check_sym, symmetric([[1, 2],
                            [2, 1]]))  # True

print(check_sym, symmetric([[1, 2, 3, 4],
                            [2, 3, 4, 5],
                            [3, 4, 5, 6]]))  # False

print(check_sym, symmetric([[1, 2, 3],
                            [2, 3, 1]]), "\n")  # False


###
# Mean
###
# The mean of a set of numbers is the sum of the numbers divided by the number of numbers. Write a procedure, 
# list_mean, which takes a list of numbers as its input and return the mean of the numbers in the list.
def list_mean(list_input):
    result = 0.0
    if len(list_input) == 0:
        return "List is empty, try again"
    for e in list_input:
        result = result + e
    mean = result / len(list_input)
    return mean


print("***Mean***")
mean_string = "Mean is:"
print(mean_string, list_mean([1, 2, 3, 4]))  # 2.5
print(mean_string, list_mean([1, 3, 4, 5, 2]))  # 3.0
print(mean_string, list_mean([]))  # Return message
print(mean_string, list_mean([2]), "\n")  # 2.0

###############################################
#           Lesson 3 - Optional 2             #
###############################################
print("Problem Set (Optional 2)\n")


###
# Anti-Symmetric
###
# Modify Problem Set Symmetric Square to return True if the given square is antisymmetric and False otherwise. 
# An nxn square is called antisymmetric if A[i][j]=-A[j][i] for each i=0,1,...,n-1 and for each j=0,1,...,n-1.
def antisymmetric(check_list):
    n = len(check_list)
    # Check if it's a square
    for row in check_list:
        if len(row) != n:
            return False
    # Check if it's antisymmetric:
    for i in range(n):
        for j in range(n):
            if check_list[i][j] != -check_list[j][i]:
                return False
    return True


print("***Anti-Symmetric Square***")
check_antisym = "Check if it's an antisymmetric square:"
print(check_antisym, antisymmetric([[0, 1, 2],
                                    [-1, 0, 3],
                                    [-2, -3, 0]]))  # True

print(check_antisym, antisymmetric([[0, 0, 0],
                                    [0, 0, 0],
                                    [0, 0, 0]]))  # True

print(check_antisym, antisymmetric([[0, 1, 2],
                                    [-1, 0, -2],
                                    [2, 2, 3]]))  # False

print(check_antisym, antisymmetric([[1, 2, 5],
                                    [0, 1, -9],
                                    [0, 0, 1]]), "\n")  # False


###
# Identity Matrix
###
# Given a list of lists representing a n * n matrix as input, define a procedure that returns True if the 
# input is an identity matrix and False otherwise. An IDENTITY matrix is a square matrix in which all the elements 
# on the principal/main diagonal are 1 and all the elements outside the principal diagonal are 0.
def is_identity_matrix(check_identity):
    n = len(check_identity)
    # Check if it's a square
    for row in check_identity:
        if len(row) != n:
            return False
    # Check if it's antisymmetric:
    for i in range(n):
        for j in range(n):
            if i == j and check_identity[i][j] != 1:
                return False
            elif i != j and check_identity[i][j] != 0:
                return False
    return True


matrix1 = [[1, 0, 0, 0],
           [0, 1, 0, 0],
           [0, 0, 1, 0],
           [0, 0, 0, 1]]

matrix2 = [[1, 0, 0],
           [0, 1, 0],
           [0, 0, 0]]

matrix3 = [[2, 0, 0],
           [0, 2, 0],
           [0, 0, 2]]

matrix4 = [[1, 0, 0, 0],
           [0, 1, 1, 0],
           [0, 0, 0, 1]]

matrix5 = [[1, 0, 0, 0, 0, 0, 0, 0, 0]]

matrix6 = [[1, 0, 0, 0],
           [0, 1, 0, 1],
           [0, 0, 1, 0],
           [0, 0, 0, 1]]

matrix7 = [[1, -1, 1],
           [0, 1, 0],
           [0, 0, 1]]

print("***Identity Matrix***")
check_iden = "Check if it's an identity matrix:"
print(check_iden, is_identity_matrix(matrix1))  # True
print(check_iden, is_identity_matrix(matrix2))  # False
print(check_iden, is_identity_matrix(matrix3))  # False
print(check_iden, is_identity_matrix(matrix4))  # False
print(check_iden, is_identity_matrix(matrix5))  # False
print(check_iden, is_identity_matrix(matrix6))  # False
print(check_iden, is_identity_matrix(matrix7), "\n")  # False


###
# Numbers in Lists
###
# Define a procedure that takes in a string of numbers from 1-9 and outputs a list with the following parameters:
# Every number in the string should be inserted into the list. If a number x in the string is less than or equal 
# to the preceding number y, the number x should be inserted into a sublist. Continue adding the following numbers 
# to the sublist until reaching a number z that is greater than the number y. Then add this number z to the normal 
# list and continue. Hint - "int()" turns a string's element into a number
def numbers_in_lists(string_numbers):
    int_list = []
    final_list = []
    sub_list = []
    num = 0
    for e in string_numbers:
        int_list.append(int(e))
    for e in int_list:
        if e <= num:
            sub_list.append(e)
        if e > num:
            if not sub_list == []:
                final_list.append(sub_list)
                sub_list = []
            final_list.append(e)
            num = e
    if not sub_list == []:
        final_list.append(sub_list)
    return final_list


print("***Numbers in Lists***")
check_nil = "Does string match result?:"
nil_output = "Result:"

string = '543987'
result = [5, [4, 3], 9, [8, 7]]
print(check_nil, repr(string), numbers_in_lists(string) == result)
print(nil_output, numbers_in_lists('543987'))

string = '987654321'
result = [9, [8, 7, 6, 5, 4, 3, 2, 1]]
print(check_nil, repr(string), numbers_in_lists(string) == result)
print(nil_output, numbers_in_lists('987654321'))

string = '455532123266'
result = [4, 5, [5, 5, 3, 2, 1, 2, 3, 2], 6, [6]]
print(check_nil, repr(string), numbers_in_lists(string) == result)
print(nil_output, numbers_in_lists('455532123266'))

string = '123456789'
result = [1, 2, 3, 4, 5, 6, 7, 8, 9]
print(check_nil, repr(string), numbers_in_lists(string) == result)
print(nil_output, numbers_in_lists('123456789'))


###
# Crypto Analysis: Frequency Analysis
###
# To analyze encrypted messages, to find out information about the possible algorithm or even language of the clear
# text message, one could perform frequency analysis. This process could be described as simply counting the number of
# times a certain symbol occurs in the given text. For example: For the text "test" the frequency of 'e' is 1, 's' is 1
# and 't' is 2.
# The input to the function will be an encrypted body of text that only contains the lowercase letters a-z. As output
# you should return a list of the normalized frequency for each of the letters a-z. The normalized frequency is simply
# the number of occurrences, i, divided by the total number of characters in the message, n.
def freq_analysis(message):
    alphabet = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
                'v', 'w', 'x', 'y', 'z']
    freq_list = [0.0] * 26
    for e in message:
        if e in alphabet:
            freq_list[alphabet.index(e)] += 1
    for e in freq_list:
        if e > 0.0:
            freq_list[freq_list.index(e)] = e / len(message)
    return freq_list


print("***Frequency Analysis***")
freq = "Frequency Analysis of"
print(freq, "abcd is:", freq_analysis("abcd"))  # [0.25, 0.25, 0.25, 0.25, 0.0, ..., 0.0]
print(freq, "adca is:", freq_analysis("adca"))  # [0.5, 0.0, 0.25, 0.25, 0.0, ..., 0.0]
print(freq, "bewarethebunnies is:", freq_analysis('bewarethebunnies'))  # [0.0625, 0.125, 0.0, 0.0, ..., 0.0]
print(freq, "abcdefghijklmnopqrstuvwxyz is:", freq_analysis('abcdefghijklmnopqrstuvwxyz'))
# [0.038461538461538464, 0.038461538461538464,...0.038461538461538464]
