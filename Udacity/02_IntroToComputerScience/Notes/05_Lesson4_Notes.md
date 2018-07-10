# Lesson 4 - _Responding to Queries_

## Split
``` 
    <string>.split() -> [<word>, <word> ...]
```

## The Internet
```
    url -> |Get Page| -> Contents of that page
```
- Get Page
```python
def get_page(url):
    try:
        import urllib.request
        return urllib.request.urlopen(url).read()
    except:
        return ""
```

## Networks
> A group of entities that can communicate, even though they are not all directly connected

### Making a Network
- Way to encode and interpret messages:  
Greeks: "Agamennon is arriving" -> Smoke signal  
Internet: Message -> bits -> electrons/photons

- Way to route messages  
Greeks: Directing smoke signals  
Internet: Routers figure out next hops

- Rules for deciding who gets to use resources  
Greeks: Generals have priority  
Internet: Best effort service

## Measuring Networks
- Latency
- Bandwidth

### Latency
Time it takes message to get from source to destination
- Measured in milliseconds  
1000 ms  = 1 second

### Bandwidth
Amount of information that can be transmitted per unit time 
- Measured in bits per second  
Mbps

#### Bit
1 bit = Smallest unit of information  
0 and 1

## Protocol Used
HTTP - Hypertext Transfer Protocol 
>  The set of rules for transferring files (text, graphic images, sound, video, and other multimedia files) on the World Wide Web. As soon as a Web user opens their Web browser, the user is indirectly making use of HTTP. HTTP is an application protocol that runs on top of the TCP/IP suite of protocols (the foundation protocols for the Internet).
