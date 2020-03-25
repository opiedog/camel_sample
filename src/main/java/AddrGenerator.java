//import org.apache.camel.json.simple.JsonObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.apache.camel.converter.stream.CachedOutputStream;
import org.json.JSONObject;

import java.io.IOException;

//import java.io.*;
//import java.nio.charset.Charset;
//import java.nio.charset.StandardCharsets;
//import java.util.Scanner;

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

    Response
    "[{"input_index":0,"candidate_index":0,"delivery_line_1":"1600 Amphitheatre Pkwy","last_line":"Mountain View CA 94043-1351",
    "delivery_point_barcode":"940431351000",
    "components":{"primary_number":"1600","street_name":"Amphitheatre","street_suffix":"Pkwy","city_name":"Mountain View","default_city_name":"Mountain View","state_abbreviation":"CA","zipcode":"94043","plus4_code":"1351","delivery_point":"00","delivery_point_check_digit":"0"},
    "metadata":{"record_type":"S","zip_type":"Standard","county_fips":"06085","county_name":"Santa Clara","carrier_route":"C909","congressional_district":"18","rdi":"Commercial","elot_sequence":"0094","elot_sort":"A","latitude":37.42357,"longitude":-122.08661,"precision":"Zip9","time_zone":"Pacific","utc_offset":-8,"dst":true},
    "analysis":{"dpv_match_code":"Y","dpv_footnotes":"AABB","dpv_cmra":"N","dpv_vacant":"N","active":"N"}}]"

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
    public void acceptSSResponse(String body, Exchange exchange) {
        //
        // The incoming body is a string value of a json array:
        //  e.g. "[{'prop': 'something', 'val':123}]"
        // To parse it, I think the only solution is to create a java class
        // of what SmartyStreets sends. That's one big object so I'm not
        // going to waste time on it. (Experimenting with this is what
        // all the stuff below is.)
        // For now, I'll just print it.

        System.out.println("acceptSSResponse: body = '" + body + "'");

//        body = "{\"phonetype\":\"N95\",\"cat\":\"WP\"}";
//        JSONObject json = new JSONObject(body);
//        String x = json.getString("phonetype");

        /*
        public class Person {
            public String name;
            public Integer age;
        }
        */
//        ObjectMapper mapper = new ObjectMapper();
//        String jsonArray = "[{\"name\":\"mkyong\", \"age\":37}, {\"name\":\"fong\", \"age\":38}]";
//        try {
//            // 1. convert JSON array to Array objects
//            Person[] pp1 = mapper.readValue(jsonArray, Person[].class);
//
//            System.out.println("JSON array to Array objects...");
//            for (Person person : pp1) {
//                System.out.println(person.name);
//            }
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }

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
    }
}


