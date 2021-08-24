import java.util.regex.Pattern
import java.util.regex.Matcher
import groovy.time.TimeCategory 
import groovy.time.TimeDuration

def String simpleMatch(String document, String matchValue) {
    Date start = new Date()
    Integer relevancy = 0
    Integer matchSize = matchValue.size() - 1
    for(i = 0; i<(document.size() - matchSize); i++) {
        if(matchValue == document[i..(i + matchSize)]) {
            relevancy += 1
        }
    }
    Date stop = new Date()
    TimeDuration td = TimeCategory.minus( stop, start )
    return "Elapsed time: $td, $relevancy matches"
}

def String regexMatch(String document, String regexValue) {
    Date start = new Date()
    Integer relevancy = 0
    def pattern = ~regexValue
    def matcher = document =~ pattern
    matcher.find()
    def results = matcher.size()
    Date stop = new Date()
    TimeDuration td = TimeCategory.minus( stop, start )
    return "Elapsed time: $td, $results matches"
}

def String preProcessMatch(String document, String matchValue) {
    Date start = new Date()
    List wordList = document.toLowerCase().split("\\W")
    def lowerCaseMatchValue = matchValue.toLowerCase()
    Map index = [:].withDefault{ 0 }
    wordList.each {
        index[it] += 1
    }
    def results = index[lowerCaseMatchValue]
    Date stop = new Date()
    TimeDuration td = TimeCategory.minus( stop, start )
    return "Elapsed time: $td, $results matches"
}
