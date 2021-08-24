# documentSearch
Document Search problem

/**/
This is a simple groovy script that can be run with simply calling the function with the 2 parameters being matchValue and the document to search. It can be used on any groovy console and I used https://www.tutorialspoint.com/execute_groovy_online.php . 
/**/

Which approach is fastest? Why?

The simple string match is definitely not the fastest. The regex search works in a similar way as the simple search but it allows for more than 1 word to be matched at a time and is better optimized so it runs faster than simple string search. The fastest approach however is going to be preprocessing the content and searching the index. The reason for this we are able to remove excess fluff from the document that we know will not match the search term. We can also remove nuances such as upper case vs lower case differences. The big reason it works fastest is that once we have traversed the document once and indexed everything, there is not a need to traverse it again for different search terms. This cuts down on time significantly.   


Provide some thoughts on what you would do on the software or hardware side to make this program scale to handle massive content and/or very large request volume (5000 requests/second or more).

What I would do to handle large content would be to make sure on the hardware side we had enough RAM to hold/cache the content and multiple processors to iterate through the contnent faster and on the software side, I would try to preprocess the content as much as possible and eliminate the fluff. For the large request volume, on the software side, I would make sure there are no duplicate requests and if so, only do those requests once. If there are many requests that are the same, it would be prudent to cache the results. On the hardware side, I would focus more on having as many processors as possible so we can do multiple requests at a time.    
