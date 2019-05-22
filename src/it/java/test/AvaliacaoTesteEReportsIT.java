package test;

import config.BeforeTest;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.http.ContentType;
import io.restassured.response.ResponseBodyExtractionOptions;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

@Feature("[Star Wars API] Consulta Integrantes")
@Story("Consultando integrantes dos filmes")
public class AvaliacaoTesteEReportsIT extends BeforeTest {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Display Name - Consulta Serviço")
    @Description("Teste 01 - Cosulta Serviço")
    @Issue("1")
    @Step("Consulta ao endpoint : XYZ")
    public void testeConsultaStatusDoServicoIT() {
                given().log().all()
                    .contentType(ContentType.JSON)
                .when()
                    .get("/people/1/")
                .then().log().all()
                    .statusCode(200);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Display Name - Teste 2")
    @Description("Descrição - Teste 2")
    @Issue("2")
    @Step("Consulta ao endpoint : XYZ")
    public void testeFalhaIT() {
            given().log().all()
                .contentType(ContentType.JSON)
            .when()
                .get("/people/1/")
            .then().log().all()
                .statusCode(400);
    }

    @Test
    @Link("https://www.google.com.br/")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Display Name - Valida nome Ator")
    @Description("Descrição - Valida Nome Ator")
    @Step("Consulta ao endpoint : XYZ")
    public void testValidaNomeAtorIT() {
        ResponseBodyExtractionOptions reponse = given().log().all()
                    .contentType(ContentType.JSON)
                .when()
                    .get("/people/1/")
                .then().log().all()
                    .statusCode(200)
                    .extract().body();

        Assert.assertEquals("Luke Skywalker", reponse.jsonPath().getString("name"));
    }
}
