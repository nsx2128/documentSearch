import java.util.regex.Pattern
import java.util.regex.Matcher

def Integer simpleMatch(String document, String matchValue) {
    Integer relevancy = 0
    Integer matchSize = matchValue.size() - 1
    for(i = 0; i<document.size(); i++) {
        if(matchValue == document[i..(i + matchSize)]) {
            relevancy += 1
        }
    }
    return relevancy
}

def Integer regexMatch(String document, String regexValue) {
    Integer relevancy = 0
    def pattern = ~regexValue
    def matcher = document =~ pattern
    matcher.find()
    return matcher.size()
}

/*
def preProcessMatch(String document, String matchValue) {
    document = document.toLowerCase().replaceAll("\\s", "")
}
*/
