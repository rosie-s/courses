###############################################
#       Lesson 2 - How to Repeat              #
###############################################

# Procedure for get_next_target
href = '<a href='
s = ('<div id="top_bin"><div id="top_content" class="width960">'
     '<div class="udacity float-left"><a href="http://udacity.com">')
start_link = s.find(href)


def get_next_target(s):
    open_double_quote = s.find('"', start_link)
    open_double_quote = open_double_quote + 1
    close_double_quote = s.find('"', open_double_quote)
    url = s[open_double_quote:close_double_quote]
    return url, close_double_quote
