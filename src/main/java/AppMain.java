/*
    See
    https://tomd.xyz/camel-maven/
 */
//package com.camel_sample;

//import org.apache.camel.CamelContext;
//import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.main.Main;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

public class AppMain {
    public static void main(String[] args) {
        System.out.println("Hello world");

        BasicConfigurator.configure();

        String logsource = "com.camel_sample";
        //logsource = "AppMain.main";

        //Logger logger = Logger.getLogger(logsource);
        //logger.setLevel(Level.ERROR);

        Main camelmain = new Main();
        //camelmain.addRouteBuilder(new FileRouteBuilder());
        //camelmain.addRouteBuilder(new RESTRouteBuilder());
        camelmain.addRouteBuilder(new EnrichTestRoute1());

        try {
            camelmain.run(args);
        }
        catch(Exception e) {
            System.out.println("AppMain.main - Exception: '" + e.getMessage() + "'");
        }

//        CamelContext ctx = new DefaultCamelContext();
//        ctx.addRoutes(new FileRouteBuilder());
//        //ctx.addRoutes(new RESTRouteBuilder());
//        ctx.start();
//        Thread.sleep(10000);
//        ctx.stop();
    }
}
