
@Grapes([
 @Grab('org.eclipse.jetty:jetty-server:9.2.7.v20150116'),
 @Grab('org.eclipse.jetty:jetty-servlet:9.2.7.v20150116'),
 @Grab('javax.servlet:javax.servlet-api:3.1.0'),
 //@GrabExclude('org.eclipse.jetty.orbit:javax.servlet:3.0.0.v201112011016'),
 @GrabConfig(systemClassLoader=true)
])

import org.eclipse.jetty.server.Server
import org.eclipse.jetty.server.handler.*
import org.eclipse.jetty.servlet.*
import groovy.servlet.*
 
def server = new Server(8080)

def handler = new ServletContextHandler(ServletContextHandler.SESSIONS)
//def handler = new ServletContextHandler()
handler.contextPath = '/'
handler.resourceBase = '.'

eh = new ErrorPageErrorHandler()
eh.addErrorPage(400,501,"/scripts/errorhandler.groovy")
handler.setErrorHandler(eh)

handler.addServlet(GroovyServlet, '/scripts/*')

def filesHolder = handler.addServlet(DefaultServlet, '/')
filesHolder.setInitParameter('resourceBase', './pages')

server.handler = handler

server.start()
server.join()
