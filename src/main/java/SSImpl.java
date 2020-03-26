import org.apache.camel.Exchange;
//import org.apache.camel.json.simple.JsonObject;
//import org.json.JSONObject;
//import java.io.IOException;

public class SSImpl implements java.io.Serializable {
    public SSImpl() {
    }

    public String getAddr() {
        String jsonAddr = "{post_code: 95746}";
        return jsonAddr;
    }

    /*
    let authId = "b906cedd-d896-b507-9a58-a4b8117bed8f";    // your auth id here
    let authToken = "JYIq7zyVrO3XwZoULGKs";                 // your auth token here
     */
    public static String getURL(int whichUrl) {
        // https://smartystreets.com/docs/cloud/us-street-api#http-request-url
        String urlBase_StreetAddr = "https://us-street.api.smartystreets.com/street-address";
        String ssAuth = "auth-id=b906cedd-d896-b507-9a58-a4b8117bed8f&auth-token=JYIq7zyVrO3XwZoULGKs";
        String urlParams = ssAuth;
        String url = "";
        switch (whichUrl) {
            case 1:
                //url = "https://us-street.api.smartystreets.com/street-address?auth-id=b906cedd-d896-b507-9a58-a4b8117bed8f&auth-token=JYIq7zyVrO3XwZoULGKs&street=2850+S+delaware+st&city=san+Mateo&state=CA&candidates=2";
                //[{"input_index":0,"candidate_index":0,"delivery_line_1":"2850 S Delaware St","last_line":"San Mateo CA 94403-2574","delivery_point_barcode":"944032574994",
                //      "components":{"primary_number":"2850","street_predirection":"S","street_name":"Delaware","street_suffix":"St","city_name":"San Mateo","default_city_name":"San Mateo","state_abbreviation":"CA","zipcode":"94403","plus4_code":"2574","delivery_point":"99","delivery_point_check_digit":"4"},
                // "metadata":{"record_type":"H","zip_type":"Standard","county_fips":"06081","county_name":"San Mateo","carrier_route":"C015","congressional_district":"14","building_default_indicator":"Y","rdi":"Commercial","elot_sequence":"0111","elot_sort":"A","latitude":37.54116,"longitude":-122.30488,"precision":"Zip8","time_zone":"Pacific","utc_offset":-8,"dst":true},
                // "analysis":{"dpv_match_code":"D","dpv_footnotes":"AAN1","dpv_cmra":"N","dpv_vacant":"N","active":"N","footnotes":"H#"}}]
                urlParams += "&street=2850+S+delaware+st";
                urlParams += "&city=san+Mateo";
                urlParams += "&state=CA";
                urlParams += "&candidates=2";
                url = urlBase_StreetAddr + "?" + urlParams;
                break;
            case 2:
                //url = "https://us-street.api.smartystreets.com/street-address?auth-id=b906cedd-d896-b507-9a58-a4b8117bed8f&auth-token=JYIq7zyVrO3XwZoULGKs&street=1600+amphitheatre+pkwy&city=mountain+view&state=CA&candidates=10";
                //Response
                //"[{"input_index":0,"candidate_index":0,"delivery_line_1":"1600 Amphitheatre Pkwy","last_line":"Mountain View CA 94043-1351","delivery_point_barcode":"940431351000",
                //    "components":{"primary_number":"1600","street_name":"Amphitheatre","street_suffix":"Pkwy","city_name":"Mountain View","default_city_name":"Mountain View","state_abbreviation":"CA","zipcode":"94043","plus4_code":"1351","delivery_point":"00","delivery_point_check_digit":"0"},
                //"metadata":{"record_type":"S","zip_type":"Standard","county_fips":"06085","county_name":"Santa Clara","carrier_route":"C909","congressional_district":"18","rdi":"Commercial","elot_sequence":"0094","elot_sort":"A","latitude":37.42357,"longitude":-122.08661,"precision":"Zip9","time_zone":"Pacific","utc_offset":-8,"dst":true},
                //"analysis":{"dpv_match_code":"Y","dpv_footnotes":"AABB","dpv_cmra":"N","dpv_vacant":"N","active":"N"}}]"
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

    /*

     */
    public void handleResponse(String body, Exchange exchange) {
        //
        // The incoming body is a string value of a json array:
        //  e.g. "[{'prop': 'something', 'val':123}]"
        // To parse it, I think the only solution is to create a java class
        // of what SmartyStreets sends. That's one big object so I'm not
        // going to waste time on it. (Experimenting with this is what
        // all the stuff below is.)
        // For now, I'll just print it.

        System.out.println("handleResponse: body = '" + body + "'");

        /**
        //        body = "{\"phonetype\":\"N95\",\"cat\":\"WP\"}";
        //        JSONObject json = new JSONObject(body);
        //        String x = json.getString("phonetype");
        public class Person {
            public String name;
            public Integer age;
        }
        ObjectMapper mapper = new ObjectMapper();
        String jsonArray = "[{\"name\":\"mkyong\", \"age\":37}, {\"name\":\"fong\", \"age\":38}]";
        try {
            // 1. convert JSON array to Array objects
            Person[] pp1 = mapper.readValue(jsonArray, Person[].class);

            System.out.println("JSON array to Array objects...");
            for (Person person : pp1) {
                System.out.println(person.name);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        **/
    }
}


