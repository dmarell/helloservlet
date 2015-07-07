/*
 * Created by Daniel Marell 14-02-13 20:02
 */
package se.caglabs.helloservlet;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.webapp.WebXmlConfiguration;

public class Main {
    public static void main(String[] args) throws Exception {
        Server httpServer = new Server(8090);
        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath("/");
        webAppContext.setBaseResource(Resource.newClassPathResource("."));
        webAppContext.addServlet(HelloServlet.class.getName(), "/helloservlet");
        webAppContext.setConfigurations(new Configuration[]{new WebXmlConfiguration()});
        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{webAppContext, new DefaultHandler()});
        httpServer.setHandler(handlers);
        httpServer.start();
    }
}
