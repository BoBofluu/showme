package showme.controllers.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> defaultHandleException(Exception e) {
        // TODO: 增加錯誤log紀錄
        // e.getMessage(), e
        // TODO: body用model包裝
        Map<String, Object> body = new HashMap<>();
        body.put("exception", "發生預期以外錯誤");
        body.put("timestamp", LocalDateTime.now());

        // TODO: 組裝共用回傳型別
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
