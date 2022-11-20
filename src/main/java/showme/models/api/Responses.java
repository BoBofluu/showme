package showme.models.api;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.logging.log4j.util.Strings;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class Responses<T> implements Serializable {

    private T data;

    private String RsCode;

    private String RsMessage;

    private String Title = Strings.EMPTY;

}
