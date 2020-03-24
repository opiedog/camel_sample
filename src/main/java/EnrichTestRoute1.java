import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.Exchange;

public class EnrichTestRoute1 extends RouteBuilder {
    public void configure() {
        from("timer://enrichtimer?repeatCount=1")   //.bean(new AddrGenerator(), "getAddr")
                //.marshal().json()   //JsonLibrary.Jackson
                .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
                .enrich("https://us-street.api.smartystreets.com/street-address?auth-id=b906cedd-d896-b507-9a58-a4b8117bed8f&auth-token=JYIq7zyVrO3XwZoULGKs&street=1600+amphitheatre+pkwy&city=mountain+view&state=CA&candidates=10")
                .log("${body}")
                ;
    }
}

/*

let authId = "b906cedd-d896-b507-9a58-a4b8117bed8f";    // your auth id here
let authToken = "JYIq7zyVrO3XwZoULGKs";                 // your auth token here

https://us-street.api.smartystreets.com/street-address?auth-id=b906cedd-d896-b507-9a58-a4b8117bed8f&auth-token=JYIq7zyVrO3XwZoULGKs&street=1600+amphitheatre+pkwy&city=mountain+view&state=CA&candidates=10
 */