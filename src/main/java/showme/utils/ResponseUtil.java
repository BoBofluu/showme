package showme.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import showme.models.api.Responses;

/**
 * 共用 Response 回傳方式
 */
public class ResponseUtil {

    public static <T> Responses<T> success(T data) {
        return Responses.<T>builder().data(data).rsMessage(HttpStatus.OK.getReasonPhrase()).build();
    }

    // TODO 制定各式Response回傳共用模組
}
