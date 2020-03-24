//import org.apache.camel.json.simple.JsonObject;
import org.apache.camel.Exchange;
import org.apache.camel.converter.stream.CachedOutputStream;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class AddrGenerator implements java.io.Serializable {
    public AddrGenerator() {
    }

    //public JsonObject

    public String getAddr() {
        String jsonAddr = "{post_code: 95746}";
        return jsonAddr;
    }

    /*

    let authId = "b906cedd-d896-b507-9a58-a4b8117bed8f";    // your auth id here
    let authToken = "JYIq7zyVrO3XwZoULGKs";                 // your auth token here

    https://us-street.api.smartystreets.com/street-address?auth-id=b906cedd-d896-b507-9a58-a4b8117bed8f&auth-token=JYIq7zyVrO3XwZoULGKs&street=1600+amphitheatre+pkwy&city=mountain+view&state=CA&candidates=10
     */
    public static String getSSURL(int whichUrl) {
        String urlBase_StreetAddr = "https://us-street.api.smartystreets.com/street-address";
        String ssAuth = "auth-id=b906cedd-d896-b507-9a58-a4b8117bed8f&auth-token=JYIq7zyVrO3XwZoULGKs";
        String urlParams = ssAuth;
        String url = "";
        switch (whichUrl) {
            case 1:
                //url = "https://us-street.api.smartystreets.com/street-address?auth-id=b906cedd-d896-b507-9a58-a4b8117bed8f&auth-token=JYIq7zyVrO3XwZoULGKs&street=1600+amphitheatre+pkwy&city=mountain+view&state=CA&candidates=10";
                urlParams += "&street=1600+amphitheatre+pkwy";
                urlParams += "&city=mountain+view";
                urlParams += "&state=CA";
                urlParams += "&candidates=10";
                url = urlBase_StreetAddr + "?" + urlParams;
                break;
            default:
                break;

        }
        return url;
    }

    //
    public void acceptSSResponse(Exchange exchange) throws IOException {

        Object body = exchange.getIn().getBody();

/*
        byte[] bytes = exchange.getIn().getBody(byte[].class);
        StringBuilder sb1 = new StringBuilder();
        byte b = 0;
        for(int idx=0; idx<bytes.length; idx++) {
            b = bytes[idx];
            sb1.append((char)b);
        }
*/

/*
        // (((CachedOutputStream.WrappedInputStream) body).cachedOutputStream).getInputStream()
        // ((CachedOutputStream.WrappedInputStream) body).inputStream

        //exchange.getIn().getBody(CachedOutputStream.WrappedInputStream.class).inputStream

        InputStream os = exchange.getIn().getBody(InputStream.class);

        StringBuilder sb = new StringBuilder();
        int c = 0;
        while((c = os.read()) != -1) {
            sb.append((char)c);
        }
*/

        String s1 = body.toString();
        //String s2 = body.toByteArray();
    }
}
