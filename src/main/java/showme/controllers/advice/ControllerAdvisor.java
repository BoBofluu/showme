package showme.controllers.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> defaultHandleException(Exception e) {
        ResponseEntity<ErrorResponse> resultEntity = null;
        // TODO: 增加錯誤log紀錄
        // e.getMessage(), e
        // TODO: body用model包裝
        ErrorResponse response = new ErrorResponse();
        System.out.printf("e : ", e);
        switch (e.getMessage()) {
            case "timeout":
                response.setErrorCode("9999");

                System.out.printf("錯誤原因:%s \n", response.getMessage());
                break;
        }
        response.setMessage("機器人無回應");
        response.setTimestamp(String.valueOf(LocalDateTime.now()));
        // TODO: 組裝共用回傳型別

        resultEntity = new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        return resultEntity;
    }
}
