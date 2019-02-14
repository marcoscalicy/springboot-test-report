package test;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import config.BeforeTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.http.ContentType;

@Feature("[Treinamento] Avaliação Report Allure")
@Story("Conhecendo as funcionalidade do Report Allure")
public class AvaliacaoReportsIT extends BeforeTest {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Display Name - Teste 01")
    @Description("Teste 01")
    @Issue("1")
    public void testeUmIT() {
        given().log().all().contentType(ContentType.JSON).when().get("/people/1/").then().statusCode(200);
    }


    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Display Name - Teste 2")
    @Description("Descrição - Teste 2")
    @Issue("2")
    public void testeDoisIT() {
        given().log().all().contentType(ContentType.JSON).when().get("/people/1/").then().statusCode(200);
    }

    @Test
    @Link("http://www.cwi.com.br")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Display Name - Teste 3")
    @Description("Descrição - Teste 3")
    public void testTresIT() {
        given().log().all().contentType(ContentType.JSON).when().get("/people/1/").then().statusCode(200);

    }

}
