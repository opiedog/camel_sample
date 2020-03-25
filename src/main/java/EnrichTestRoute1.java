import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.Exchange;
import org.apache.camel.model.dataformat.JsonLibrary;

public class EnrichTestRoute1 extends RouteBuilder {
    public void configure() {
        from("timer://enrichtimer?repeatCount=1")
                //.marshal().json(JsonLibrary.Jackson)
                .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
                .enrich(SSImpl.getURL(1))

                // This (logging before converting the body) was causing issues as described here:
                // https://camel.465427.n5.nabble.com/HTTP4-component-body-CachedOutputStream-to-String-td5721616.html
                // Logging before conversion apparently moved the pointer to the end of the stream causing the body to
                // be empty in subsequent calls.
                //.log("xyz body 1 == ${body}")

                .convertBodyTo(String.class)

                // Now logging will have no negative result
                .log("xyz body 2 == ${body}")

                // This puts nothing into the SSResponse.txt file (but does create the file)
                .to("file:testfiles/outputfolder?fileName=SSResponse.txt")

                // This passes the body and an Exchange object to the bean for processing
                .bean("SSImpl", "handleResponse")
                ;
    }
}

