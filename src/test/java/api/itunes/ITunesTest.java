package api.itunes;

import com.fasterxml.jackson.core.JsonProcessingException;
import dto.OuterErrorITunesDto;
import dto.OuterITunesDto;
import io.restassured.RestAssured;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Map;

public class ITunesTest {

    private static final String BASE_URL = "https://itunes.apple.com";

    @Test
    public void checkSearch() throws JsonProcessingException {
        JsonPath jsonPath = RestAssured.given()
                .header("Content-Type", "application/json")
                .baseUri(BASE_URL)
                .params(Map.of("term", "David+dallas",
                        "country", "US",
                        "media", "music",
                        "limit", "1"))
                .get("/search")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();

        OuterITunesDto outerITunesDto = new ObjectMapper().readValue(jsonPath.prettyPrint(), OuterITunesDto.class);
        Assert.assertTrue(outerITunesDto.getResults().stream().allMatch(result->result.getTrackName()
                .equals("Runnin'")));
        Assert.assertTrue(outerITunesDto.getResults().stream().allMatch(result -> result.getArtistName()
                .equals("David Dallas")));
        Assert.assertTrue(outerITunesDto.getResults().stream().allMatch(result->result.getDiscNumber() == 1));
    }

    @Test
    public void checkLookUp() throws JsonProcessingException {
        JsonPath jsonPath = RestAssured.given()
                .header("Content-Type", "application/json")
                .baseUri(BASE_URL)
                .params(Map.of("id", "259120415",
                        "entity", "album",
                        "limit", "10"))
                .get("/lookup")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();

        OuterITunesDto outerITunesDto = new ObjectMapper().readValue(jsonPath.prettyPrint(), OuterITunesDto.class);
        Assert.assertEquals(outerITunesDto.getResultCount(), 11);
        Assert.assertTrue(outerITunesDto.getResults().stream().allMatch(result -> result.getArtistName()
                .equals("Tim McMorris")));
        Assert.assertTrue(outerITunesDto.getResults().stream().allMatch(result -> result.getArtistId() == 259120415));
    }

    @Test
    public void checkErrorSearch() throws JsonProcessingException {
        JsonPath jsonPath = RestAssured.given()
                .header("Content-Type", "application/json")
                .baseUri(BASE_URL)
                .params(Map.of("term", "Okean+Elzy",
                        "country", "UAs",
                        "media", "musicVideo"))
                .get("/search")
                .then()
                .statusCode(400)
                .extract()
                .body()
                .jsonPath();

        OuterErrorITunesDto outerErrorITunesDto = new ObjectMapper()
                .readValue(jsonPath.prettyPrint(), OuterErrorITunesDto.class);
        Assert.assertEquals(outerErrorITunesDto.getErrorMessage(), "Invalid value(s) for key(s): [country]");
        Assert.assertEquals(outerErrorITunesDto.getQueryParameters().getCallback(), "A javascript function to handle your search results");
        Assert.assertEquals(outerErrorITunesDto.getQueryParameters().getCountry(), "ISO-2A country code");
    }
}
