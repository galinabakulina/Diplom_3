import data.*;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiHelper {
    public static final String URL = "https://stellarburgers.nomoreparties.site";

    private static final String REGISTER_USER = "/api/auth/register";
    private static final String AUTH_USER = "/api/auth/user";
    private static final String LOGIN_USER = "/api/auth/login";

    @Step("Send post request to " + REGISTER_USER)
    public static Response registerUser(String email, String password, String name) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(new RegisterRequest(email, password, name))
                .when()
                .post(REGISTER_USER);
    }

    @Step("Send post request to " + LOGIN_USER)
    public static Response login(String email, String password){
        return given()
                .header("Content-type", "application/json")
                .body(new LoginRequest(email, password))
                .post(LOGIN_USER);
    }

    @Step("Send delete request to " + AUTH_USER)
    public static void deleteUser(String accessToken) {
        given()
                .header("Content-type", "application/json")
                .header("Authorization", String.valueOf(accessToken))
                .when()
                .delete(AUTH_USER);
    }
}