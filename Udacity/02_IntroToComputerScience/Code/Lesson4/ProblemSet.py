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


print("***Improving the Index***")
index = crawl_web("http://www.udacity.com/cs101x/index.html")
print("Look for 'is':", lookup(index, "is"))  # ['http://www.udacity.com/cs101x/index.html']
