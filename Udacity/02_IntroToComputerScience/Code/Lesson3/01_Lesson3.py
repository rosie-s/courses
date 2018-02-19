###############################################
#     Lesson 3  - How to Manage Data          #
###############################################

###
# Stooges
###
# Define a variable, stooges, whose value is
# a  list of the names of the Three Stooges:
# 'Moe' 'Larry' 'Curly'

stooges = ['Moe', 'Larry', 'Curly']
print(stooges)

###
# Days in a month
###
# Given the variable, days_in_month,
# Define a procedure, how_many_days, that takes as input a number
# representing a month, and returns the number of days in that month.

days_in_month = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]


def how_many_days(month_number):
    if month_number <= 0 or month_number > 12:
        return "Invalid number! Valid numbers are 0 - 12"
    return days_in_month[month_number - 1]


print("Days in Month 1:", how_many_days(1))  # >>> 31
print("Days in Month 9:", how_many_days(9))  # >>> 30
print("Days in Month 0:", how_many_days(0))  # Error
print("Days in Month 13:", how_many_days(13))  # Error

###
# Nested Lists
###
beatles = [['John', 1940], ['Paul', 1942],
           ['George', 1943], ['Ringo', 1940]]

print("Members of The Beatles:", beatles)
print("Beatles[3]:", beatles[3])
print("Get name:", beatles[3][0])
print("Get year:", beatles[3][1])

###
# Countries
###
# Given the variable countries defined as:

#             Name    Capital  Populations (millions)
countries = [['China', 'Beijing', 1350],
             ['India', 'Delhi', 1210],
             ['Romania', 'Bucharest', 21],
             ['United States', 'Washington', 307]]

# Write code to print out the capital of India
# by accessing the list

print("Capital of India is:", countries[1][1])

# What multiple of Romania's population is the population
# of China? Calculate this by accessing the list and
# dividing the population of China (1350)
# by the population of Romania (21).

print("What multiple of Romania is China?: ", countries[0][2] / countries[2][2])

###
# Mutation
###
p = ['H', 'e', 'l', 'l', 'o']
q = p
print("p is:", p, "\nq is: ", q)
p[0] = 'Y'
print("Change first value of p:", p, "\nq also changes:", q)

###
# Stooges 2
###
# Write one line of code that changes the value of stooges to be:
# ['Moe','Larry','Shemp']
stooges[2] = 'Shemp'
print("Updated Stooges:", stooges)

###
# Aliasing
###
spies = [0, 0, 7]
agents = spies
print("Spies:", spies, "Agents:", agents)
spies[2] = agents[2] + 1
print("Spies:", spies, "Agents:", agents)


###
# Replace spy
###
# Define a procedure, replace_spy, that takes as its input a list of
# three numbers, and modifies the value of the third element in the
# input list to be one more than its  previous value.


def replace_spy(s):
    s[2] = s[2] + 1


spy = [0, 0, 7]
print("Spy:", spy)
replace_spy(spy)
print("Spy:", spy)
# >>> [0,0,8]

###
# List operations
###
# Append
stooges_four = ['Moe', 'Larry', 'Curly']
print("Stooges Before:", stooges_four)
stooges_four.append('Shemp')
print("Stooges After append:", stooges_four)

# Plus
list_plus = [0, 1] + [2, 3]
print("Add list:", list_plus)

# Len
print("Length of [0,1]:", len([0, 1]))
print("Length of ['a', ['b', ['c']]]:", len(['a', ['b', ['c']]]))
print("Length of Udacity:", len("Udacity"))
print("Length of stooges_four:", len(stooges_four))
print("Length of list_plus:", len(list_plus))

# More append / length
g = [1, 2]
h = [3, 4]
g.append(h)
print("g:", g)
q[1] = 5
print("g:", g)


###
# Loops
###
# Print out every element in a list


# While
def print_all_elements(l):
    i = 0
    while i < len(l):
        print(l[i])
        i = i + 1


print("Print Beatles: ")
print_all_elements(beatles)


# For
def print_all_elements_for(l):
    for e in l:
        print(e)


print("Print Stooges: ")
print_all_elements_for(stooges_four)


###
# Sum List
###
# Define a procedure, sum_list, that takes as its input a list of numbers,
# and returns the sum of all the elements in the input list.

def sum_list(s):
    result = 0
    for e in s:
        result = result + e
    return result


print(sum_list([1, 7, 4]))  # 12
print(sum_list([9, 4, 10]))  # 23
print(sum_list([44, 14, 76]))  # 134


###
# Measure Udacity
###
# Define a procedure, measure_udacity, that takes as its input a list of strings,
# and returns a number that is a count of the number of elements in the input
# list that start with the uppercase letter 'U'.

def measure_udacity(l):
    count = 0
    for e in l:
        if e[0] == 'U':
            count = count + 1
    return count


print(measure_udacity(['Dave', 'Sebastian', 'Katy']))  # 0
print(measure_udacity(['Umika', 'Umberto']))  # 2


###
# Find Element
###
# Define a procedure, find_element, that takes as its inputs a list
# and a value of any type, and returns the index of the first
# element in the input list that matches the value.
# If there is no matching element, return -1.

# For
def find_element(input_list, value):
    count = 0
    for e in input_list:
        if e == value:
            return count
        count = count + 1
    return -1


# While
def find_element_while(input_list, value):
    i = 0
    while i < len(input_list):
        if input_list[i] == value:
            return i
        i = i + 1
    return -1


# Index
def find_element_index(input_list, value):
    if value in input_list:
        return input_list.index(value)
    else:
        return -1


# Not In
def find_element_index_not(input_list, value):
    if value not in input_list:
        return -1
    else:
        return input_list.index(value)


print("Find Element 3 in [1, 2, 3]:", find_element([1, 2, 3], 3))  # 2
print("Find Element 'gamma' in ['alpha', 'beta']:", find_element_while(['alpha', 'beta'], 'gamma'))  # -1
print("Find Element 'a' in ['x', 'y', 'z']:", find_element_index(['x', 'y', 'z'], 'a'))
print("Find Element 'ed' in ['ed', 'edd', 'eddy']:", find_element_index_not(['ed', 'edd', 'eddy'], 'ed'))


###
# Union
###
# Define a procedure, union, that takes as inputs two lists.
# It should modify the first input list to be the set union of the two
# lists. You may assume the first list is a set, that is, it contains no
# repeated elements.


def union(l_a, l_b):
    for e in l_b:
        if e not in l_a:
            l_a.append(e)


list_a = [1, 2, 3]
list_b = [2, 4, 6]

print("Before: list_a =", list_a, "list_b =", list_b)
union(list_a, list_b)

print("After Union: list_a =", list_a, "list_b =", list_b)
# list_a = [1,2,3,4,6] list_b [2,4,6]

###
# Pop
###
a = [1, 2, 3]
b = a
x = a.pop()

print("Pop of [1,2,3] is:", x)


############################
#     Web Crawler          #
############################
###
# Get Page
###
# This is a simulated get_page procedure so that you can test your
# code on two pages "http://xkcd.com/353" and "http://xkcd.com/554".
# A procedure which actually grabs a page from the web will be
# introduced in unit 4.
def get_page(url):
    try:
        if url == "http://xkcd.com/353":
            return '<?xml version="1.0" encoding="utf-8" ?><?xml-stylesheet href="http://imgs.xkcd.com/s/c40a9f8.css" type="text/css" media="screen" ?><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd"><html xmlns="http://www.w3.org/1999/xhtml"> <head> <title>xkcd: Python</title> <link rel="stylesheet" type="text/css" href="http://imgs.xkcd.com/s/c40a9f8.css" media="screen" title="Default" /> <!--[if IE]><link rel="stylesheet" type="text/css" href="http://imgs.xkcd.com/s/ecbbecc.css" media="screen" title="Default" /><![endif]--> <link rel="alternate" type="application/atom+xml" title="Atom 1.0" href="/atom.xml" /> <link rel="alternate" type="application/rss+xml" title="RSS 2.0" href="/rss.xml" /> <link rel="icon" href="http://imgs.xkcd.com/s/919f273.ico" type="image/x-icon" /> <link rel="shortcut icon" href="http://imgs.xkcd.com/s/919f273.ico" type="image/x-icon" /> </head> <body> <div id="container"> <div id="topContainer"> <div id="topLeft" class="dialog"> <div class="hd"><div class="c"></div></div> <div class="bd"> <div class="c"> <div class="s">\t<ul> <li><a href="http://xkcd.com/554"">Archive</a><br /></li>\t <li><a href="http://blag.xkcd.com/">News/Blag</a><br /></li> <li><a href="http://store.xkcd.com/">Store</a><br /></li> <li><a href="/about/">About</a><br /></li> <li><a href="http://forums.xkcd.com/">Forums</a><br /></li> </ul> </div> </div> </div> <div class="ft"><div class="c"></div></div> </div> <div id="topRight" class="dialog"> <div class="hd"><div class="c"></div></div> <div class="bd"> <div class="c"> <div class="s"> <div id="topRightContainer"> <div id="logo"> <a href="/"><img src="http://imgs.xkcd.com/s/9be30a7.png" alt="xkcd.com logo" height="83" width="185"/></a> <h2><br />A webcomic of romance,<br/> sarcasm, math, and language.</h2> <div class="clearleft"></div> <br />XKCD updates every Monday, Wednesday, and Friday. </div> </div> </div> </div> </div> <div class="ft"><div class="c"></div></div> </div> </div> <div id="contentContainer"> <div id="middleContent" class="dialog"> <div class="hd"><div class="c"></div></div> <div class="bd"> <div class="c"> <div class="s"><h1>Python</h1><br/><br /><div class="menuCont"> <ul> <li><a href="/1/">|&lt;</a></li> <li><a href="/352/" accesskey="p">&lt; Prev</a></li> <li><a href="http://dynamic.xkcd.com/random/comic/" id="rnd_btn_t">Random</a></li> <li><a href="/354/" accesskey="n">Next &gt;</a></li> <li><a href="/">&gt;|</a></li> </ul></div><br/><br/><img src="http://imgs.xkcd.com/comics/python.png" title="I wrote 20 short programs in Python yesterday. It was wonderful. Perl, Im leaving you." alt="Python" /><br/><br/><div class="menuCont"> <ul> <li><a href="/1/">|&lt;</a></li> <li><a href="/352/" accesskey="p">&lt; Prev</a></li> <li><a href="http://dynamic.xkcd.com/random/comic/" id="rnd_btn_b">Random</a></li> <li><a href="/354/" accesskey="n">Next &gt;</a></li> <li><a href="/">&gt;|</a></li> </ul></div><h3>Permanent link to this comic: http://xkcd.com/353/</h3><h3>Image URL (for hotlinking/embedding): http://imgs.xkcd.com/comics/python.png</h3><div id="transcript" style="display: none">[[ Guy 1 is talking to Guy 2, who is floating in the sky ]]Guy 1: You39;re flying! How?Guy 2: Python!Guy 2: I learned it last night! Everything is so simple!Guy 2: Hello world is just 39;print &quot;Hello, World!&quot; 39;Guy 1: I dunno... Dynamic typing? Whitespace?Guy 2: Come join us! Programming is fun again! It39;s a whole new world up here!Guy 1: But how are you flying?Guy 2: I just typed 39;import antigravity39;Guy 1: That39;s it?Guy 2: ...I also sampled everything in the medicine cabinet for comparison.Guy 2: But i think this is the python.{{ I wrote 20 short programs in Python yesterday. It was wonderful. Perl, I39;m leaving you. }}</div> </div> </div> </div> <div class="ft"><div class="c"></div></div> </div> <div id="middleFooter" class="dialog"> <div class="hd"><div class="c"></div></div> <div class="bd"> <div class="c"> <div class="s"> <img src="http://imgs.xkcd.com/s/a899e84.jpg" width="520" height="100" alt="Selected Comics" usemap=" comicmap" /> <map name="comicmap"> <area shape="rect" coords="0,0,100,100" href="/150/" alt="Grownups" /> <area shape="rect" coords="104,0,204,100" href="/730/" alt="Circuit Diagram" /> <area shape="rect" coords="208,0,308,100" href="/162/" alt="Angular Momentum" /> <area shape="rect" coords="312,0,412,100" href="/688/" alt="Self-Description" /> <area shape="rect" coords="416,0,520,100" href="/556/" alt="Alternative Energy Revolution" /> </map><br/><br />Search comic titles and transcripts:<br /><script type="text/javascript" src="//www.google.com/jsapi"></script><script type="text/javascript"> google.load(\"search\", \"1\"); google.setOnLoadCallback(function() { google.search.CustomSearchControl.attachAutoCompletion( \"012652707207066138651:zudjtuwe28q\", document.getElementById(\"q\"), \"cse-search-box\"); });</script><form action="//www.google.com/cse" id="cse-search-box"> <div> <input type="hidden" name="cx" value="012652707207066138651:zudjtuwe28q" /> <input type="hidden" name="ie" value="UTF-8" /> <input type="text" name="q" id="q" autocomplete="off" size="31" /> <input type="submit" name="sa" value="Search" /> </div></form><script type="text/javascript" src="//www.google.com/cse/brand?form=cse-search-box&lang=en"></script><a href="/rss.xml">RSS Feed</a> - <a href="/atom.xml">Atom Feed</a><br /> <br/> <div id="comicLinks"> Comics I enjoy:<br/> <a href="http://www.qwantz.com">Dinosaur Comics</a>, <a href="http://www.asofterworld.com">A Softer World</a>, <a href="http://pbfcomics.com/">Perry Bible Fellowship</a>, <a href="http://www.boltcity.com/copper/">Copper</a>, <a href="http://questionablecontent.net/">Questionable Content</a>, <a href="http://achewood.com/">Achewood</a>, <a href="http://wondermark.com/">Wondermark</a>, <a href="http://thisisindexed.com/">Indexed</a>, <a href="http://www.buttercupfestival.com/buttercupfestival.htm">Buttercup Festival</a> </div> <br/> Warning: this comic occasionally contains strong language (which may be unsuitable for children), unusual humor (which may be unsuitable for adults), and advanced mathematics (which may be unsuitable for liberal-arts majors).<br/> <br/> <h4>We did not invent the algorithm. The algorithm consistently finds Jesus. The algorithm killed Jeeves. <br />The algorithm is banned in China. The algorithm is from Jersey. The algorithm constantly finds Jesus.<br />This is not the algorithm. This is close.</h4><br/> <div class="line"></div> <br/> <div id="licenseText"> <!-- <a rel="license" href="http://creativecommons.org/licenses/by-nc/2.5/"><img alt="Creative Commons License" style="border:none" src="http://imgs.xkcd.com/static/somerights20.png" /></a><br/> --> This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc/2.5/">Creative Commons Attribution-NonCommercial 2.5 License</a>.<!-- <rdf:RDF xmlns="http://web.resource.org/cc/" xmlns:dc="http://purl.org/dc/elements/1.1/" xmlns:dcterms="http://purl.org/dc/terms/" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns "><Work rdf:about=""><dc:creator>Randall Munroe</dc:creator><dcterms:rightsHolder>Randall Munroe</dcterms:rightsHolder><dc:type rdf:resource="http://purl.org/dc/dcmitype/StillImage" /><dc:source rdf:resource="http://www.xkcd.com/"/><license rdf:resource="http://creativecommons.org/licenses/by-nc/2.5/" /></Work><License rdf:about="http://creativecommons.org/licenses/by-nc/2.5/"><permits rdf:resource="http://web.resource.org/cc/Reproduction" /><permits rdf:resource="http://web.resource.org/cc/Distribution" /><requires rdf:resource="http://web.resource.org/cc/Notice" /><requires rdf:resource="http://web.resource.org/cc/Attribution" /><prohibits rdf:resource="http://web.resource.org/cc/CommercialUse" /><permits rdf:resource="http://web.resource.org/cc/DerivativeWorks" /></License></rdf:RDF> --> <br/> This means you\"re free to copy and share these comics (but not to sell them). <a href="/license.html">More details</a>.<br/> </div> </div> </div> </div> <div class="ft"><div class="c"></div></div> </div> </div> </div> </body></html> '
        elif url == "http://xkcd.com/554":
            return '<?xml version="1.0" encoding="utf-8" ?> <?xml-stylesheet href="http://imgs.xkcd.com/s/c40a9f8.css" type="text/css" media="screen" ?> <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd"> <html xmlns="http://www.w3.org/1999/xhtml"> <head> <title>xkcd: Not Enough Work</title> <link rel="stylesheet" type="text/css" href="http://imgs.xkcd.com/s/c40a9f8.css" media="screen" title="Default" /> <!--[if IE]><link rel="stylesheet" type="text/css" href="http://imgs.xkcd.com/s/ecbbecc.css" media="screen" title="Default" /><![endif]--> <link rel="alternate" type="application/atom+xml" title="Atom 1.0" href="/atom.xml" /> <link rel="alternate" type="application/rss+xml" title="RSS 2.0" href="/rss.xml" /> <link rel="icon" href="http://imgs.xkcd.com/s/919f273.ico" type="image/x-icon" /> <link rel="shortcut icon" href="http://imgs.xkcd.com/s/919f273.ico" type="image/x-icon" /> </head> <body> <div id="container"> <div id="topContainer"> <div id="topLeft" class="dialog"> <div class="hd"><div class="c"></div></div> <div class="bd"> <div class="c"> <div class="s"> <ul> <li><a href="/archive/">Archive</a><br /></li> <li><a href="http://blag.xkcd.com/">News/Blag</a><br /></li> <li><a href="http://store.xkcd.com/">Store</a><br /></li> <li><a href="/about/">About</a><br /></li> <li><a href="http://forums.xkcd.com/">Forums</a><br /></li> </ul> </div> </div> </div> <div class="ft"><div class="c"></div></div> </div> <div id="topRight" class="dialog"> <div class="hd"><div class="c"></div></div> <div class="bd"> <div class="c"> <div class="s"> <div id="topRightContainer"> <div id="logo"> <a href="/"><img src="http://imgs.xkcd.com/s/9be30a7.png" alt="xkcd.com logo" height="83" width="185"/></a> <h2><br />A webcomic of romance,<br/> sarcasm, math, and language.</h2> <div class="clearleft"></div> XKCD updates every Monday, Wednesday, and Friday. <br /> Blag: Remember geohashing? <a href="http://blog.xkcd.com/2012/02/27/geohashing-2/">Something pretty cool</a> happened Sunday. </div> </div> </div> </div> </div> <div class="ft"><div class="c"></div></div> </div> </div> <div id="contentContainer"> <div id="middleContent" class="dialog"> <div class="hd"><div class="c"></div></div> <div class="bd"> <div class="c"> <div class="s"> <h1>Not Enough Work</h1><br/> <br /> <div class="menuCont"> <ul> <li><a href="/1/">|&lt;</a></li> <li><a href="/553/" accesskey="p">&lt; Prev</a></li> <li><a href="http://dynamic.xkcd.com/random/comic/" id="rnd_btn_t">Random</a></li> <li><a href="/555/" accesskey="n">Next &gt;</a></li> <li><a href="/">&gt;|</a></li> </ul> </div> <br/> <br/> <img src="http://imgs.xkcd.com/comics/not_enough_work.png" title="It39;s even harder if you39;re an asshole who pronounces &lt;&gt; brackets." alt="Not Enough Work" /><br/> <br/> <div class="menuCont"> <ul> <li><a href="/1/">|&lt;</a></li> <li><a href="/553/" accesskey="p">&lt; Prev</a></li> <li><a href="http://dynamic.xkcd.com/random/comic/" id="rnd_btn_b">Random</a></li> <li><a href="/555/" accesskey="n">Next &gt;</a></li> <li><a href="/">&gt;|</a></li> </ul> </div> <h3>Permanent link to this comic: http://xkcd.com/554/</h3> <h3>Image URL (for hotlinking/embedding): http://imgs.xkcd.com/comics/not_enough_work.png</h3> <div id="transcript" style="display: none">Narration: Signs your coders don39;t have enough work to do: [[A man sitting at his workstation; a female co-worker behind him]] Man: I39;m almost up to my old typing speed in dvorak [[Two men standing by a server rack]] Man  1: Our servers now support gopher. Man  1: Just in case. [[A woman standing near her workstation speaking to a male co-worker]] Woman: Our pages are now HTML, XHTML-STRICT, and haiku-compliant Man: Haiku? Woman: &lt;div class=&quot;main&quot;&gt; Woman: &lt;span id=&quot;marquee&quot;&gt; Woman: Blog!&lt; span&gt;&lt; div&gt; [[A woman sitting at her workstation]] Woman: Hey! Have you guys seen this webcomic? {{title text: It39;s even harder if you39;re an asshole who pronounces &lt;&gt; brackets.}}</div> </div> </div> </div> <div class="ft"><div class="c"></div></div> </div> <div id="middleFooter" class="dialog"> <div class="hd"><div class="c"></div></div> <div class="bd"> <div class="c"> <div class="s"> <img src="http://imgs.xkcd.com/s/a899e84.jpg" width="520" height="100" alt="Selected Comics" usemap=" comicmap" /> <map name="comicmap"> <area shape="rect" coords="0,0,100,100" href="/150/" alt="Grownups" /> <area shape="rect" coords="104,0,204,100" href="/730/" alt="Circuit Diagram" /> <area shape="rect" coords="208,0,308,100" href="/162/" alt="Angular Momentum" /> <area shape="rect" coords="312,0,412,100" href="/688/" alt="Self-Description" /> <area shape="rect" coords="416,0,520,100" href="/556/" alt="Alternative Energy Revolution" /> </map><br/><br /> Search comic titles and transcripts:<br /> <script type="text/javascript" src="//www.google.com/jsapi"></script> <script type="text/javascript"> google.load("search", "1"); google.search.CustomSearchControl.attachAutoCompletion( "012652707207066138651:zudjtuwe28q", document.getElementById("q"), "cse-search-box"); }); </script> <form action="//www.google.com/cse" id="cse-search-box"> <div> <input type="hidden" name="cx" value="012652707207066138651:zudjtuwe28q" /> <input type="hidden" name="ie" value="UTF-8" /> <input type="text" name="q" id="q" autocomplete="off" size="31" /> <input type="submit" name="sa" value="Search" /> </div> </form> <script type="text/javascript" src="//www.google.com/cse/brand?form=cse-search-box&lang=en"></script> <a href="/rss.xml">RSS Feed</a> - <a href="/atom.xml">Atom Feed</a> <br /> <br/> <div id="comicLinks"> Comics I enjoy:<br/> <a href="http://threewordphrase.com/">Three Word Phrase</a>, <a href="http://oglaf.com/">Oglaf</a> (nsfw), <a href="http://www.smbc-comics.com/">SMBC</a>, <a href="http://www.qwantz.com">Dinosaur Comics</a>, <a href="http://www.asofterworld.com">A Softer World</a>, <a href="http://buttersafe.com/">Buttersafe</a>, <a href="http://pbfcomics.com/">Perry Bible Fellowship</a>, <a href="http://questionablecontent.net/">Questionable Content</a>, <a href="http://www.buttercupfestival.com/buttercupfestival.htm">Buttercup Festival</a> </div> <br/> Warning: this comic occasionally contains strong language (which may be unsuitable for children), unusual humor (which may be unsuitable for adults), and advanced mathematics (which may be unsuitable for liberal-arts majors).<br/> <br/> <h4>We did not invent the algorithm. The algorithm consistently finds Jesus. The algorithm killed Jeeves. <br />The algorithm is banned in China. The algorithm is from Jersey. The algorithm constantly finds Jesus.<br />This is not the algorithm. This is close.</h4><br/> <div class="line"></div> <br/> <div id="licenseText"> <!-- <a rel="license" href="http://creativecommons.org/licenses/by-nc/2.5/"><img alt="Creative Commons License" style="border:none" src="http://imgs.xkcd.com/static/somerights20.png" /></a><br/> --> This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc/2.5/">Creative Commons Attribution-NonCommercial 2.5 License</a>. <!-- <rdf:RDF xmlns="http://web.resource.org/cc/" xmlns:dc="http://purl.org/dc/elements/1.1/" xmlns:dcterms="http://purl.org/dc/terms/" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns "><Work rdf:about=""><dc:creator>Randall Munroe</dc:creator><dcterms:rightsHolder>Randall Munroe</dcterms:rightsHolder><dc:type rdf:resource="http://purl.org/dc/dcmitype/StillImage" /><dc:source rdf:resource="http://www.xkcd.com/"/><license rdf:resource="http://creativecommons.org/licenses/by-nc/2.5/" /></Work><License rdf:about="http://creativecommons.org/licenses/by-nc/2.5/"><permits rdf:resource="http://web.resource.org/cc/Reproduction" /><permits rdf:resource="http://web.resource.org/cc/Distribution" /><requires rdf:resource="http://web.resource.org/cc/Notice" /><requires rdf:resource="http://web.resource.org/cc/Attribution" /><prohibits rdf:resource="http://web.resource.org/cc/CommercialUse" /><permits rdf:resource="http://web.resource.org/cc/DerivativeWorks" /></License></rdf:RDF> --> <br/> This means you"re free to copy and share these comics (but not to sell them). <a href="/license.html">More details</a>.<br/> </div> </div> </div> </div> <div class="ft"><div class="c"></div></div> </div> </div> </div> </body> </html> '
    except:
        return ""
    return ""


###
# Get Next Target
###
def get_next_target(page):
    start_link = page.find('<a href=')
    if start_link == -1:
        return None, 0
    open_double_quote = page.find('"', start_link)
    open_double_quote = open_double_quote + 1
    close_double_quote = page.find('"', open_double_quote)
    url = page[open_double_quote:close_double_quote]
    return url, close_double_quote


###
# Union
###
def union(p, q):
    for e in q:
        if e not in p:
            p.append(e)


###
# Get All Links
###
def get_all_links(page):
    links = []
    while True:
        url, close_double_quote = get_next_target(page)
        if url:
            links.append(url)
            page = page[close_double_quote:]
        else:
            break
    return links


###
# Crawling Web
###
def crawl_web(seed):
    tocrawl = [seed]
    crawled = []
    while tocrawl:
        page = tocrawl.pop()  # Depth first search
        if page not in crawled:
            union(tocrawl, get_all_links(get_page(page)))
            crawled.append(page)
    return crawled


seeds = 'http://xkcd.com/353'
print(crawl_web(seeds))
