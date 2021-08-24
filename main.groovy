import java.util.regex.Pattern
import java.util.regex.Matcher
import groovy.time.TimeCategory 
import groovy.time.TimeDuration

def String simpleMatch(String document, String matchValue) {
    Date start = new Date()
    Integer relevancy = 0
    Integer matchSize = matchValue.size() - 1
    for(i = 0; i<document.size(); i++) {
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

/*
def preProcessMatch(String document, String matchValue) {
    Date start = new Date()
    document = document.toLowerCase().replaceAll("\\s", "")
    Date stop = new Date()
    TimeDuration td = TimeCategory.minus( stop, start )
    return "Elapsed time: $td, $results matches"
}
*/
