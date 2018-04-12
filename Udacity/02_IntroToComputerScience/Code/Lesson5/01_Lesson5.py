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
print("Time Execution: spin_loop(10000000) :", time_execution('spin_loop(10**7)')[1])


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
counts = test_hash_function(bad_hash_string, words, 12)
print("Counts Bad:", counts)


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
counts = test_hash_function(hash_string, words, 12)
print("Counts Good:", counts)
