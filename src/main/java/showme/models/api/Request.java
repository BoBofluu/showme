package showme.models.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Request<T> {

    private T data;

    public boolean isValidate() {
        return false;
    }
}
