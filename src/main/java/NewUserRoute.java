import org.apache.camel.builder.RouteBuilder;

public class NewUserRoute extends RouteBuilder {
    public void configure() {
        from("direct:newUser")
                //.log("-- newUser route hit --")
                .log("xyz body 2 == ${body}")
                .to("bean:UserPojo?method=process")
                //.to("stream:out")
                ;
    }
}