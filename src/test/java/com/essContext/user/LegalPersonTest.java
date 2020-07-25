package com.essContext.user;

import com.essContext.BaseTest;
import org.junit.jupiter.api.Test;

import static com.essContext.BaseRequestBody.body;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class LegalPersonTest extends BaseTest {
    @Test
    void should_return_success_given_legalPersonInfo_when_register() {
        given().contentType("application/json")
                .body(body()
                        .put("type", 1)
                        .put("companyName", "中国一汽")
                        .put("companyCode", "JLCC00000000000001")
                        .put("name", "张建国")
                        .put("idType", 1)
                        .put("idCode", "11111111111111111")
                        .build())
                .when().post("/api/legalPerson/register")
                .then().log().body()
                .body("type", equalTo("1"))
                .statusCode(200);
    }

}
