import groovy.json.JsonSlurper
import org.apache.log4j.*

def log = Logger.getLogger('c')

//response.contentType = 'application/json'

//if (headers['Content-Type'] != "application/json") {
//    throw new RuntimeException("Please use 'application/json' header")
//}

//def jsonContent = request.reader.text
//
//def content = jsonContent ? new JsonSlurper().parseText(jsonContent) : ''
//
//def nr = content.nr
//log.info(nr)

json."echo" {
    original 12
    messages 'a','b','c'
}