import org.json.simple.JSONObject;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class APIAssign {

    @Test
    public void post() {
        JSONObject show = new JSONObject();

        show.put("name", "Lisa");
        show.put("job", "Librarian");

        System.out.println(show.toJSONString());

        given().
                body(show.toJSONString()).
        when().
                post ("https://reqres.in/api/users").
        then().
            statusCode(201);
    }
    
    @Test
    public void patch() {
        JSONObject show = new JSONObject();

        show.put("name", "Diluc");
        show.put("job", "Police");

        System.out.println(show.toJSONString());

        given().
                body(show.toJSONString()).
        when().
                patch ("https://reqres.in/api/users").
        then().
            statusCode(200);
    }
    
    @Test
    public void get() {

        when().
                get ("https://reqres.in/api/users").
        then().
            statusCode(200).log().all();
    }
    
    @Test
    public void delete() {

        when().
                delete ("https://reqres.in/api/users").
        then().
            statusCode(204).log().all();
    }

}