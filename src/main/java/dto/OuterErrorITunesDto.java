package dto;

import lombok.Data;

@Data
public class OuterErrorITunesDto {

    private String errorMessage;
    private ErrorITunesDto queryParameters;
}
