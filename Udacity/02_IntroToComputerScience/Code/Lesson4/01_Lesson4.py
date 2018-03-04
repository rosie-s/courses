###############################################
#     Lesson 4 - Responding to Queries        #
###############################################


###
# Add to Index
###
# Define a procedure, add_to_index, that takes 3 inputs:
# - an index: [[<keyword>,[<url>,...]],...]
# - a keyword: String
# - a url: String
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
print("Index is:\n", ind, sep='')
# [['udacity', ['http://udacity.com', 'http://npr.org']], ['computing', ['http://acm.org']]]
