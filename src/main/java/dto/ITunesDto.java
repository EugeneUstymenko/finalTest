package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ITunesDto {

    private int discNumber;
    private Boolean isStreamable;
    private String artistName;
    private int artistId;
}
