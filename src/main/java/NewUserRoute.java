import org.apache.camel.builder.RouteBuilder;

public class NewUserRoute extends RouteBuilder {
    public void configure() {
        from("direct:newUser")
            //.log("-- newUser route hit --")
            .to("bean:UserPojo?method=process")
            //.to("stream:out")
            ;
    }
}