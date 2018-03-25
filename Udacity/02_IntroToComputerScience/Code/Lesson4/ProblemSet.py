###############################################
#           Lesson 4 - Problem Set            #
###############################################


###
# Better Splitting
###
# The built-in <string>.split() procedure works okay, but fails to find all the words on a page because it only uses
# whitespace to split the string. To do better, we should also use punctuation marks to split the page into words.
# Define a procedure, split_string, that takes two inputs: 
# the string to split and a string containing all of the characters considered separators. 
# The procedure should return a list of strings that break the source string up by the characters in the splitlist.
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


###
# Improving the Index
###
# The current index includes a url in the list of urls for a keyword multiple times if the keyword appears
# on that page more than once.
# It might be better to only include the same url once in the url list for a keyword, even if it appears
# many times.
# Modify add_to_index so that a given url is only included once in the url list for a keyword, no matter 
# how many times that keyword appears.
def add_to_index(index, keyword, url):
    for entry in index:
        if entry[0] == keyword:
            if url not in entry[1]:  # Update here
                entry[1].append(url)
            return
    # not found, add new keyword to index
    index.append([keyword, [url]])


def get_page(url):
    try:
        if url == "http://www.udacity.com/cs101x/index.html":
            return '''<html> <body> This is a test page for learning to crawl!
<p> It is a good idea to
<a href="http://www.udacity.com/cs101x/crawling.html">
learn to crawl</a> before you try to
<a href="http://www.udacity.com/cs101x/walking.html">walk</a> or
<a href="http://www.udacity.com/cs101x/flying.html">fly</a>.</p></body>
</html>'''

        elif url == "http://www.udacity.com/cs101x/crawling.html":
            return '''<html> <body> I have not learned to crawl yet, but I am
quite good at  <a href="http://www.udacity.com/cs101x/kicking.html">kicking</a>.
</body> </html>'''

        elif url == "http://www.udacity.com/cs101x/walking.html":
            return '''<html> <body> I cant get enough
<a href="http://www.udacity.com/cs101x/index.html">crawling</a></body></html>'''

        elif url == "http://www.udacity.com/cs101x/flying.html":
            return '''<html>
<body>The magic words are Squeamish Ossifrage!</body></html>'''
    except:
        return ""
    return ""


def union(a, b):
    for e in b:
        if e not in a:
            a.append(e)


def get_next_target(page):
    start_link = page.find('<a href=')
    if start_link == -1:
        return None, 0
    start_quote = page.find('"', start_link)
    end_quote = page.find('"', start_quote + 1)
    url = page[start_quote + 1:end_quote]
    return url, end_quote


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


def crawl_web(seed):
    tocrawl = [seed]
    crawled = []
    index = []
    while tocrawl:
        page = tocrawl.pop()
        if page not in crawled:
            content = get_page(page)
            add_page_to_index(index, page, content)
            union(tocrawl, get_all_links(content))
            crawled.append(page)
    return index


def add_page_to_index(index, url, content):
    words = content.split()
    for word in words:
        add_to_index(index, word, url)


def lookup(index, keyword):
    for entry in index:
        if entry[0] == keyword:
            return entry[1]
    return None


print("\n***Improving the Index***")
index1 = crawl_web("http://www.udacity.com/cs101x/index.html")
print("Look for 'is':", lookup(index1, "is"))  # ['http://www.udacity.com/cs101x/index.html']


###
# Counting Clicks
###
# One way search engines rank pages is to count the number of times a searcher clicks on a returned link.
# This indicates that the person doing the query thought this was a useful link for the query, so it should be
# higher in the rankings next time.
# 
# Modify the index such that for each url in a list for a keyword, there is also a number that counts the number 
# of times a user clicks on that link for this keyword.
# The result of lookup(index,keyword) should now be a list of url entries, where each urL entry is a list of a url 
# and a number indicating the number of times that url was clicked for this query keyword.
#
# You should define a new procedure to simulate user clicks for a given link: record_user_click(index,word,url)
# that modifies the entry in the index for the input word by increasing the count associated with the url by 1.
# You also will have to modify add_to_index in order to correctly create the new data structure, and to prevent 
# the repetition of entries as in homework 4-5.
def record_user_click(index, keyword, url):
    urls = lookup(index, keyword)
    if urls:
        for entry in urls:
            if entry[0] == url:
                entry[1] = entry[1] + 1


def add_to_index(index, keyword, url):
    # format of index: [[keyword, [[url, count], [url, count],..]],...]
    for entry in index:
        if entry[0] == keyword:
            for urls in entry[1]:
                if urls[0] == url:
                    return
            entry[1].append([url, 0])
            return
    # not found, add new keyword to index
    index.append([keyword, [[url, 0]]])


# Here is an example showing a sequence of interactions:
print("\n***Counting Clicks***")
index = crawl_web('http://www.udacity.com/cs101x/index.html')
print("Look for 'is':", lookup(index, 'good'))
# [['http://www.udacity.com/cs101x/index.html', 0], ['http://www.udacity.com/cs101x/crawling.html', 0]]
record_user_click(index, 'good', 'http://www.udacity.com/cs101x/crawling.html')
print("Look for 'is':", lookup(index, 'good'))
# [['http://www.udacity.com/cs101x/index.html', 0], ['http://www.udacity.com/cs101x/crawling.html', 1]]


###
# Time Spent at Routers
###
total_time = 75  # ms traceroute, roundtrip Birmingham -> Sundsvall
one_Way_distance = 2500.0  # km, Birmingham -> Sundsvall
optic_speed = 200000  # km/s
ms_per_second = 1000  # conversion from ms to seconds

# Calculate
time_on_the_wires = 2 * one_Way_distance / optic_speed * ms_per_second  # [km]/[km/sec] + [ms/s]
total_time_at_routers = total_time - time_on_the_wires
print("\n***Time Spent at Routers***")
print("Total time spent at routers from Birmingham -> Sundsvall (ms):", total_time_at_routers)

###############################################
#           Lesson 4 - Optional               #
###############################################
print("\n----Problem Set (Optional)----")


###
# Word Count
###
# Write a procedure, count_words, which takes as input a string and returns the number of words in the string. 
# You may consider words as strings of characters separated by spaces.
def count_words(input_string):
    a = input_string.split()
    return len(a)


passage = ("The number of orderings of the 52 cards in a deck of cards "
           "is so great that if every one of the almost 7 billion people alive "
           "today dealt one ordering of the cards per second, it would take "
           "2.5 * 10**40 times the age of the universe to order the cards in every "
           "possible way bro.")
print("\n***Word Count***")
print("Length of 'passage' is:", count_words(passage))  # 56


###
# Latency
###
# Write a procedure, speed_fraction, which takes as its inputs the result of a traceroute (in ms) and distance (in km)
# between two points. It should return the speed the data travels as a decimal fraction of the speed of light.
def speed_fraction(result_traceroute, distance):
    speed_of_light = 300000.  # km per second
    return ((2.0 * distance) / result_traceroute) / (speed_of_light / 1000)


print("\n***Latency***")
print("speed_fraction(50, 5000):", speed_fraction(50, 5000))  # 0.666666666667
print("speed_fraction(50,10000):", speed_fraction(50, 10000))  # 1.33333333333


###
# Converting Seconds
###
# Write a procedure, convert_seconds, which takes as input a non-negative number of seconds and returns a string of the form
# '<integer> hours, <integer> minutes, <number> seconds' but where if <integer> is 1 for the number of hours or minutes,
# then it should be hour/minute. Further, <number> may be an integer or decimal, and if it is 1, then it should be followed
# by second. You might need to use int() to turn a decimal into a float depending on how you code this. int(3.0) gives 3
#
# Note that English uses the plural when talking about 0 items, soit should be "0 minutes".
def convert_seconds(seconds):
    minutes = int(seconds / 60)
    seconds -= minutes * 60
    hours = int(minutes / 60)
    minutes -= int(hours * 60)

    string_hours = " hours, "
    string_minutes = " minutes, "
    string_seconds = " seconds"

    if hours == 1:
        string_hours = " hour, "
    if minutes == 1:
        string_minutes = " minute, "
    if seconds == 1:
        string_seconds = " second"

    return str(hours) + string_hours + str(minutes) + string_minutes + str(round(seconds, 2)) + string_seconds


print("\n***Converting Seconds***")
print("Convert 3661 seconds:\t", convert_seconds(3661))  # 1 hour, 1 minute, 1 second
print("Convert 7325 seconds:\t", convert_seconds(7325))  # 2 hours, 2 minutes, 5 seconds
print("Convert 7261.7 seconds:\t", convert_seconds(7261.7))  # 2 hours, 1 minute, 1.7 seconds
print("Convert 0 seconds:\t\t", convert_seconds(0))  # 0 hours, 0 minutes, 0 seconds


###
# Download Calculator
###
# Write a procedure download_time which takes as inputs a file size, the units that file size is given in, 
# bandwidth and the units for bandwidth (excluding per second) and returns the time taken to download the file.
# Your answer should be a string in the form "<number> hours, <number> minutes, <number> seconds"
#
# Some information you might find useful is the number of bits in kilobits (kb), kilobytes (kB), megabits (Mb), 
# megabytes (MB), gigabits (Gb), gigabytes (GB) and terabits (Tb), terabytes (TB).
#
# print 2 ** 10      # one kilobit, kb
# print 2 ** 10 * 8  # one kilobyte, kB
# print 2 ** 20      # one megabit, Mb
# print 2 ** 20 * 8  # one megabyte, MB
# print 2 ** 30      # one gigabit, Gb
# print 2 ** 30 * 8  # one gigabyte, GB
# print 2 ** 40      # one terabit, Tb
# print 2 ** 40 * 8  # one terabyte, TB
#
# Often bandwidth is given in megabits (Mb) per second whereas file size is given in megabytes (MB).

def unit_to_rate(unit):
    unit_list = ['kb', 'kB', 'Mb', 'MB', 'Gb', 'GB', 'Tb', 'TB']
    assert unit in unit_list
    ind = unit_list.index(unit)
    rate = 2 ** ((1 + ind / 2) * 10) * (8 if ind % 2 else 1)
    return rate


def download_time(file_size, unit_file, bandwidth, unit_bandwidth):
    seconds = file_size * unit_to_rate(unit_file) * 1.0 / (bandwidth * unit_to_rate(unit_bandwidth))
    return convert_seconds(seconds)


print("\n***Download Calculator***")
print(download_time(1024, 'kB', 1, 'MB') #  0 hours, 0 minutes, 1 second
print(download_time(1024, 'kB', 1, 'Mb')) # 0 hours, 0 minutes, 8 seconds  # 8.0 seconds is also acceptable
print(download_time(13, 'GB', 5.6, 'MB')) # 0 hours, 39 minutes, 37.1428571429 seconds
print(download_time(13, 'GB', 5.6, 'Mb')) # 5 hours, 16 minutes, 57.1428571429 seconds
print(download_time(10, 'MB', 2, 'kB')) # 1 hour, 25 minutes, 20 seconds  # 20.0 seconds is also acceptable
print(download_time(10, 'MB', 2, 'kb')) # 11 hours, 22 minutes, 40 seconds  # 40.0 seconds is also acceptable
