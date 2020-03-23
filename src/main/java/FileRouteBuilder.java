import org.apache.camel.builder.RouteBuilder;

public class FileRouteBuilder extends RouteBuilder {
    public void configure() {
        from("file:testfiles/inputfolder?noop=true")
                .log("route called")
                .to("file:testfiles/outputfolder");
    }
}
