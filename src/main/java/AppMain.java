/*
    See
    https://tomd.xyz/camel-maven/
 */

//import org.apache.camel.CamelContext;
//import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.main.Main;

public class AppMain {
    public static void main(String[] args) {
        System.out.println("Hello world");

        Main camelmain = new Main();
        camelmain.addRouteBuilder(new FileRouteBuilder());

        try {
            camelmain.run(args);
        }
        catch(Exception e) {
            System.out.println("Exception: '" + e.getMessage() + "'");
        }

//        CamelContext ctx = new DefaultCamelContext();
//        ctx.addRoutes(new FileRouteBuilder());
//        //ctx.addRoutes(new RESTRouteBuilder());
//        ctx.start();
//        Thread.sleep(10000);
//        ctx.stop();
    }
}
