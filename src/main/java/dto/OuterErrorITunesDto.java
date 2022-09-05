package dto;

import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
public class OuterErrorITunesDto {

    private String errorMessage;
    private ErrorITunesDto queryParameters;
}
