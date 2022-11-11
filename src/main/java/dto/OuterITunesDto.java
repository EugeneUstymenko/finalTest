package dto;

import lombok.Data;
import java.util.List;

@Data
public class OuterITunesDto {

    private int resultCount;
    private List<ITunesDto> results;
}
