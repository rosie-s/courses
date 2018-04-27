###############################################
#     Lesson 5 - How Programs Run             #
###############################################
import time
import urllib.request


###
# Stopwatch
###
def time_execution(code):
    start = time.clock()
    result = eval(code)  # Evaluate any string as though it were a python expression
    run_time = time.clock() - start
    return result, run_time


print("***Stopwatch***")
print("Time Execution: '1 + 1'  :", time_execution('1+1'))
print("Time Execution: '1 + 24' :", time_execution('1+24'))
print("Time Execution: '57 + 24':", time_execution('57+24'))


###
# Spin Loop
###
def spin_loop(n):
    i = 0
    while i < n:
        i = i + 1


print("\n***Spin Loop***")
print("Time Execution: spin_loop(1000)     :", time_execution('spin_loop(1000)'))
print("Time Execution: spin_loop(10000)    :", time_execution('spin_loop(10000)'))
print("Time Execution: spin_loop(100000)   :", time_execution('spin_loop(100000)'))
print("Time Execution: spin_loop(1000000)  :", time_execution('spin_loop(1000000)'))


# print("Time Execution: spin_loop(10000000) :", time_execution('spin_loop(10**7)')[1])


###
# Make Big Index
###

# Lookup
def lookup(index, keyword):
    for e in index:
        if e[0] == keyword:
            return e[1]
    return []


# Add to Index
def add_to_index(index, keyword, url):
    for e in index:
        if e[0] == keyword:
            e[1].append(url)
            return
    index.append([keyword, [url]])


# Make String
def make_string(p):
    s = ""
    for e in p:
        s = s + e
    return s


# Big Index
def make_big_index(size):
    index = []
    letters = ['a', 'a', 'a', 'a', 'a', 'a', 'a', 'a']
    while len(index) < size:
        word = make_string(letters)
        add_to_index(index, word, 'fake')
        for i in range(len(letters) - 1, 0, -1):
            if letters[i] < 'z':
                letters[i] = chr(ord(letters[i]) + 1)
                break
            else:
                letters[i] = 'a'
    return index


print("\n***Make Big Index***")
s = "Make Big Index:"
print(s, 3, " :", make_big_index(3))
print(s, 10, ":", make_big_index(10))
index1000 = make_big_index(1000)
print("Time Execution: 'lookup(index1000, udacity)' :", time_execution('lookup(index1000, "udacity")'))
print("Index 999 :", index1000[999])
print("Index  -1 :", index1000[-1])

###
# Hash Function
###

print("\n***Hash Function***")
# ord and chr
print("ord 'a' :", ord('a'))
print("ord 'A' :", ord('A'))
print("ord 'B' :", ord('B'))
print("ord 'b' :", ord('b'))
print("chr ord 'u' :", chr(ord('u')))

# Modulus Operator
print("\nModulus: (odr 'z'+ 3) % ord 'z' ( 'z' is:", ord('z'), ") :", (ord('z') + 3) % ord('z'))
print("Modulus:  odr 'z'+ 3  % ord 'z' ( 'z' is:", ord('z'), ") :", ord('z') + 3 % ord('z'))
print("ord(str(3)):", ord(str(3)))


# Bad Hash
def bad_hash_string(keyword, buckets):
    return ord(keyword[0]) % buckets


# Error print("Bad hash - Empty string input:", bad_hash_string("", 100))

# Test hash
def test_hash_function(func, keys, size):
    results = [0] * size
    keys_used = []
    for w in keys:
        if w not in keys_used:
            hv = func(w, size)
            results[hv] += 1
            keys_used.append(w)
    return results


# Get Page
def get_page(url):
    text = urllib.request.urlopen(url).read().decode('utf8')
    return text


print("\n*Bad Hash*")
words = get_page('http://www.gutenberg.org/cache/epub/1661/pg1661.txt').split()
print("Length of Words:", len(words))


# counts = test_hash_function(bad_hash_string, words, 12)
# print("Counts Bad:", counts)


###
# Better Hash Function
###
# Define a function, hash_string, that takes as inputs a keyword (string) and a number of buckets,
# and returns a number representing the bucket for that keyword.

def hash_string(keyword, buckets):
    h = 0
    for c in keyword:
        h = (h + ord(c)) % buckets
    return h


print("\n*Good Hash*")
hs = "Hash String "
print(hs, 'a, 12 \t:', hash_string('a', 12))  # 1
print(hs, 'b, 12 \t:', hash_string('b', 12))  # 2
print(hs, 'a, 13 \t:', hash_string('a', 13))  # 6
print(hs, 'au, 12 :', hash_string('au', 12))  # 10
print(hs, 'udacity , 12 :', hash_string('udacity', 12))  # 11


# Test
# counts = test_hash_function(hash_string, words, 12)
# print("Counts Good:", counts)


###
# Creating an Empty Hash Table
###
# Define a procedure, make_hashtable, that takes as input a number, nbuckets, and returns an empty 
# hash table with nbuckets empty buckets.
def make_hashtable_while(nbuckets):
    i = 0
    table = []
    while i < nbuckets:
        table.append([])
        i = i + 1
    return table


def make_hashtable(nbuckets):
    table = []
    for unused in range(0, nbuckets):
        table.append([])
    return table


print("\n*Empty Hash Table*")
print("Using While loop (3):", make_hashtable_while(3))
print("Using For Loop (3):", make_hashtable(3))


###
# Finding the Right Bucket
###
# Define a procedure, hashtable_get_bucket,that takes two inputs - a hashtable, and a keyword,
# and returns the bucket where the keyword could occur.
def hashtable_get_bucket(htable, keyword):
    return htable[hash_string(keyword, len(htable))]


table = [[['Francis', 13], ['Ellis', 11]], [], [['Bill', 17], ['Zoe', 14]], [['Coach', 4]],
         [['Louis', 29], ['Rochelle', 4], ['Nick', 2]]]

print("\n*Finding the Right Bucket*")
print("Zoe   :", hashtable_get_bucket(table, "Zoe"))  # [['Bill', 17], ['Zoe', 14]]
print("Brick :", hashtable_get_bucket(table, "Brick"))  # []
print("Lilith:", hashtable_get_bucket(table, "Lilith"))  # [['Louis', 29], ['Rochelle', 4], ['Nick', 2]]


###
# Adding Keywords
###
# Define a procedure,hashtable_add(htable,key,value) that adds the key to the hashtable (in the correct bucket), 
# with the correct value and returns the new hashtable.
def hashtable_add(htable, key, value):
    bucket = hashtable_get_bucket(htable, key)
    bucket.append([key, value])
    return htable


table = make_hashtable(5)
hashtable_add(table, 'Bill', 17)
hashtable_add(table, 'Coach', 4)
hashtable_add(table, 'Ellis', 11)
hashtable_add(table, 'Francis', 13)
hashtable_add(table, 'Louis', 29)
hashtable_add(table, 'Nick', 2)
hashtable_add(table, 'Rochelle', 4)
hashtable_add(table, 'Zoe', 14)
print("\n*Adding Keywords*")
print("Table: ", table)
# [[['Ellis', 11], ['Francis', 13]], [], [['Bill', 17],
# ['Zoe', 14]], [['Coach', 4]], [['Louis', 29], ['Nick', 2], ['Rochelle', 4]]]


###
# Lookup
###
# Define a procedure, hashtable_lookup(htable,key), that takes two inputs, a hashtable and a key (string),
# and returns the value associated with that key.
def hashtable_lookup(htable, key):
    bucket = hashtable_get_bucket(htable, key)
    for entry in bucket:
        if entry[0] == key:
            return entry[1]
    return None

print("\n*Lookup*")
print("Lookup: Francis -", hashtable_lookup(table, 'Francis')) # 13
print ("Lookup: Louis   -", hashtable_lookup(table, 'Louis')) # 29
print ("Lookup: Zoe     -", hashtable_lookup(table, 'Zoe')) # 14


###
# Update
###
# Define a procedure,hashtable_update(htable,key,value) that updates the value associated with key. If key is already in the
# table, change the value to the new value. Otherwise, add a new entry for the key and value.
def hashtable_update(htable,key,value):
    bucket = hashtable_get_bucket(htable, key)
    for entry in bucket:
        if entry[0] == key:
            entry[1] = value
            return htable
    bucket.append([key,value])
    return htable

print("\n*Lookup*")
print("Table Before: \n", table)
hashtable_update(table, 'Bill', 42)
hashtable_update(table, 'Rochelle', 94)
hashtable_update(table, 'Zed', 68)
print("Updated table: \n", table)
# [[['Ellis', 11], ['Francis', 13]], [['Zed', 68]], [['Bill', 42],
# ['Zoe', 14]], [['Coach', 4]], [['Louis', 29], ['Nick', 2], ['Rochelle', 94]]]


###
# Dictionaries
###
elements = {'hydrogen':1, 'helium':2, 'carbon':6}

print("\n***Dictionaries***")

print("Dictionary:", elements)
print("Hydrogen:", elements[hydrogen])
print("Carbon:", elements[carbon])

# Error - print("Lithium:", elements[lithium])
print("Lithium:", 'lithium' in elements)

elements['lithium'] = 3 # Add lithium
elements['nitrogen'] = 8
print("Lithium:", elements[lithium])
print("Nitrogen Before:", elements[nitrogen])

elements['nitrogen'] = 7 # Modify
print("Nitrogen After:", elements[nitrogen])
