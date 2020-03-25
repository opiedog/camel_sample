import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestParamType;

// Read
// https://www.programcreek.com/java-api-examples/?api=org.apache.camel.model.rest.RestBindingMode
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
                //.dataFormatProperty("prettyPrint", "true")
                ;

        // use the rest DSL to define the rest services
        // Call this route like this:
        //      http://localhost:8080/users?id=123&name=myname
        rest("/users")
                //.get("/{id}/{name}")
                //.produces("application/json")
                .consumes("application/json").produces("application/json")

                .get()
                //.post()

                //.param().name("id").type(RestParamType.path).dataType("int").endParam()
                //.param().name("name").type(RestParamType.path).dataType("String").endParam()

                //.type(UserPojo.class)
                .outType(UserPojo.class)

                //.to("direct:newUser")
                .to("bean:UserPojo?method=process")
                //.to("stream:out")
                //.to("file:testfiles/outputfolder?fileName=HttpUsersRequest.txt")
                ;
    }
}
