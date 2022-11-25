package showme.models.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.apache.logging.log4j.util.Strings;

import java.io.Serializable;

@Data
@Builder
public class Responses<T> implements Serializable {

    private T data;

    private String rsCode;

    @JsonProperty("RsMessage")
    private String rsMessage;

    @JsonProperty("Title")
    private String title = Strings.EMPTY;

}
