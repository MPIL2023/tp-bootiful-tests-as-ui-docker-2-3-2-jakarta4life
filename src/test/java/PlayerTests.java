import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;


public class PlayerTests {

    // The endpoint being tested
    private static final String PLAYERS_ENDPOINT = "players";

    @Test
    public void testPlayerFindAll() {
        // Perform a GET request to the endpoint
        Response response = given().port(8090).when().get(PLAYERS_ENDPOINT);

        // Verify the HTTP status code is 200
        response.then().assertThat().statusCode(200);

    }
}
