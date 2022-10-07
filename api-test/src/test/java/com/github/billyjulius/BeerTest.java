package com.github.billyjulius;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class BeerTest extends Base{

    @DataProvider(name = "perPage")
    public Object[][] perPage() {
        return new Object[][]{{20}, {5}, {1}};
    }

    @Test( dataProvider = "perPage")
    public void testGetBeersPagination(Integer perPage) {
        Response response =
                given()
                    .contentType("application/json")
                    .queryParam("page", 1)
                    .queryParam("per_page", perPage)
                .when()
                    .get("/v2/beers");



        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(perPage.intValue(), response.jsonPath().getList("$").size());
    }

    @Test
    public void testGetBeerSchema() {
        Response response = given()
                .contentType("application/json")
                .when()
                    .get("/v2/beers");

        System.out.println("DEBUG PRINT = " + response.jsonPath().getList("name"));

        response.then()
            .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/beer.json"));
    }
}
