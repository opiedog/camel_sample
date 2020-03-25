import com.fasterxml.jackson.databind.ObjectMapper;
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

    //
    public void process(Exchange exchange) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~ UserPojo - process called ~~~~~~~~~~~~~~~~~~~~~~~~~");

        String sId = (String) exchange.getIn().getHeader("id");
        int id = Integer.parseInt(sId);
        String name = (String) exchange.getIn().getHeader("name");

        this.name = name;
        this.id = id;

        exchange.getIn().setBody(this);

        /**
        //Object body = exchange.getIn().getBody();
        if((body == null) || body.toString().isEmpty()) {
            System.out.println("null body");
        }
        else {
            System.out.println("body not null");
            String bodyStr = exchange.getIn().getBody(String.class);
            byte[] body2 = bodyStr.getBytes();
            System.out.println("body2.length: " + body2.length);
            System.out.println("(String) body2.length: " + exchange.getIn().getBody(String.class).length());

            try {
                ObjectMapper objectMapper = new ObjectMapper();
                //JsonFileContext jsonFileContext = objectMapper.readValue(body, JsonFileContext.class);
                //exchange.setProperty("jsonFileContext", jsonFileContext);
                String ss = bodyStr.toString();
            } catch (Exception e) {
                exchange.setException(e);
            }
        }
        **/
        //String name = body.toString();
        //Object obj2 = exchange;
        //String n = obj.toString();
    }
}
