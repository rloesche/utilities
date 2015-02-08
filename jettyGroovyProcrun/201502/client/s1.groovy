@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.7' )

import groovyx.net.http.*
import static groovyx.net.http.Method.*
import static groovyx.net.http.ContentType.*

try{

    def http = new HTTPBuilder( 'http://localhost:8080/' )

    http.request( POST, JSON ) { req ->
      uri.path    = '/scripts/s1.groovy'
      //uri.path    = '/scripts/g1.groovy'
      body = [
        nr : 1,
        first : 'Boßb',
        last : 'BuüilderÖ',
        address : [
          street : '123 Some St',
          town : 'Boston',
          state : 'MA',
          zip : 92345
        ],
        bob : []
      ]
      response.success = { resp, json ->
        println resp.status
        println json
      }
      response.failure = { resp, json ->

        println resp.status
        println json
      }
    }
}catch( e){
  println e.message
}