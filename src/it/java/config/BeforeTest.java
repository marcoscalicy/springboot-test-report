package config;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.marcoscalicy.treinamento.report.SpringTestReportApplication;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import lombok.extern.slf4j.Slf4j;

@ActiveProfiles("it")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = SpringTestReportApplication.class)
public abstract class BeforeTest {

    @LocalServerPort
    private Integer port;

    @Value("${it.api.base-url}")
    protected String baseUrl;
    
    @Before
    public void setUp() {
       
        RestAssured.reset();
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.addHeader("Content-Type", "application/json");
        requestSpecBuilder.setBaseUri(baseUrl + "/api");
        RestAssured.requestSpecification = requestSpecBuilder.build();
    }
}

