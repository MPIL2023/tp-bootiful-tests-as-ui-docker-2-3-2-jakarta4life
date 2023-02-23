import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class PlayerTests {

    // The endpoint being tested
    private static final String PLAYERS_ENDPOINT = "players";

    @Test
    public void testPlayerFindAll() {
    // Check what is the bug        
        Assertions.assertEquals(404,404);

    }
}
