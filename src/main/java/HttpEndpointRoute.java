import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;

public class HttpEndpointRoute extends RouteBuilder {
    public void configure() {
        // https://camel.apache.org/manual/latest/rest-dsl.html
        // configure to use netty-http on localhost with the given port
        // and enable auto binding mode
        int portNum = 8080;
        restConfiguration()
                .component("netty-http").host("localhost")
                .port(portNum)
                //.bindingMode(RestBindingMode.auto)
                .bindingMode(RestBindingMode.json)
                ;

        // use the rest DSL to define the rest services
        // Call this route like this:
        //      http://localhost:8080/users?id=123&name=myname
        rest("/users/")
                //.get("/{id}/{name}")
                .get()
                //.post()
                .type(UserPojo.class)
                .outType(UserPojo.class)
                //.to("direct:newUser")
                .to("bean:UserPojo?method=process")
                //.to("stream:out")
                //.to("file:testfiles/outputfolder?fileName=HttpUsersRequest.txt")
                ;
    }
}
