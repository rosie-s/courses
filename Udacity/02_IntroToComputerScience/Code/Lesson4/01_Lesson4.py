###############################################
#     Lesson 4 - Responding to Queries        #
###############################################


###
# Add to Index
###
# Define a procedure, add_to_index, that takes 3 inputs:
# - an index: [[<keyword>,[<url>,...]],...] - a keyword: String - a url: String
# If the keyword is already in the index, add the url to the list of urls associated with that keyword.
# If the keyword is not in the index, add an entry to the index: [keyword,[url]]
def add_to_index(index, keyword, url):
    for e in index:
        if e[0] == keyword:
            e[1].append(url)
            return
    index.append([keyword, [url]])


ind = []
add_to_index(ind, 'udacity', 'http://udacity.com')
add_to_index(ind, 'computing', 'http://acm.org')
add_to_index(ind, 'udacity', 'http://npr.org')
print("***Add to Index***")
print("Index is:\n", ind,
      sep='')  # [['udacity', ['http://udacity.com', 'http://npr.org']], ['computing', ['http://acm.org']]]


###
# Lookup
###
# Define a procedure, lookup, that takes two inputs:
# - an index - keyword
# The procedure should return a list of the urls associated with the keyword. If the keyword
# is not in the index, the procedure should return an empty list.
def lookup(index, keyword):
    for e in index:
        if e[0] == keyword:
            return e[1]
    return []


index2 = [['udacity', ['http://udacity.com', 'http://npr.org']],
          ['computing', ['http://acm.org']]]
print("\n***Lookup***")
print("Lookup 'udacity':\n", lookup(index2, 'udacity'), sep='')  # ['http://udacity.com','http://npr.org']

###
# Split
###
quote = "In Washington, it's dog eat dog. In academia, it's exactly the opposite. --- Robert Reich"
print("\n***Split***")
print("Quote is:", quote)
print("Split quote:", quote.split())

quote2 = """
    There's no business like show business, 
    but there are several businesses like accounting. 
        (David Letterman)
    """
print("Quote is:", quote2)
print("Split quote:", quote2.split())
