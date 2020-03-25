import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.Exchange;
import org.apache.camel.model.dataformat.JsonLibrary;

public class EnrichTestRoute1 extends RouteBuilder {
    public void configure() {
        from("timer://enrichtimer?repeatCount=1")
                //.marshal().json(JsonLibrary.Jackson)
                .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
                .enrich(AddrGenerator.getSSURL(1))

                //.log("xyz body 1 == ${body}")

                //.marshal().json(JsonLibrary.Jackson)

                .convertBodyTo(String.class)

                //.log("xyz body 2 == ${body}")

                // This puts nothing into the SSResponse.txt file (but does create the file)
                //.to("file:testfiles/outputfolder?fileName=SSResponse.txt")

                // This passes an Exchange to the method but I can't get the dang data!
                .bean("AddrGenerator", "acceptSSResponse")
                ;
    }
}

