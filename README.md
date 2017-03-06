# anagram-finder

RESTful web service that allows fast searches for anagrams in a text file containing every word in the English dictionary. NOTE: A word is NOT considered it's own anagram*. This web service includes APIs for the following commands:

POST /words.json  Takes a JSON array of English-language words and adds them to the dictionary
GET  /anagrams/{word}.json  Returns a JSON-array of English-language words that are anagrams of the word passed in the URL
    -- Also supports 2 optional query parameters:  1) limit (non-negative integer value limiting the number of anagrams returned --          unlimited by default and 2) includeProperNouns (include proper nouns in the response -- true by default)
DELETE  /words/{word}.json  Deletes a single word (passed in the URL) from the dictionary
DELETE  /words.json  Deletes the entire contents of the dictionary
GET  /words.json  Returns the entire contents of the dictionary in alphabetical order
DELETE  /anagrams/{anagram}.json  Delete ALL anagrams (*and the word itself) from the dictionary. Returns number of words deleted

To build:  mvn clean package
To run/deploy:  java -jar target/anagram-finder-1.0.0.jar

AUTHOR Nathaniel Sandford
