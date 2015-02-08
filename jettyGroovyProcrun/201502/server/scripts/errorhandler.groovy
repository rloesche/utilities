
json."echo" {
    uri request.getAttribute( "javax.servlet.error.request_uri" )
    code response.getStatus()
    reason response.getReason()
}