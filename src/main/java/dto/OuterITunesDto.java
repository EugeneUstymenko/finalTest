package dto;

import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import java.util.List;

@Data
@Jacksonized
public class OuterITunesDto {

    private int resultCount;
    private List<ITunesDto> results;
}
