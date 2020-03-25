import org.apache.camel.Exchange;

public class UserPojo {
    private int id;
    private String name;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void process(String body, Exchange exchange) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~ UserPojo - process called ~~~~~~~~~~~~~~~~~~~~~~~~~");
        //Object body = exchange.getIn().getBody();
        if((body == null) || body.toString().isEmpty()) {
            System.out.println("null body");
        }
        else {
            System.out.println("body not null");
        }
        //String name = body.toString();
        //Object obj2 = exchange;
        //String n = obj.toString();
    }
}
