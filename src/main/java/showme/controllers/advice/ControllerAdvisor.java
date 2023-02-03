package showme.controllers.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.SocketTimeoutException;
import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(SocketTimeoutException.class)
    public ResponseEntity<ErrorResponse> defaultHandleException(SocketTimeoutException socketTimeoutException) {
        ResponseEntity<ErrorResponse> resultEntity = null;
        // TODO: 增加錯誤log紀錄
        // e.getMessage(), e
        // TODO: body用model包裝
        ErrorResponse response = new ErrorResponse();

        switch (socketTimeoutException.getMessage()) {
            case "timeout":
//                response.setErrorCode("9999");
                response.setMessage("機器人無回應");
                System.out.printf("錯誤原因:%s \n", response.getMessage());
                break;
        }

        response.setTimestamp(String.valueOf(LocalDateTime.now()));
        // TODO: 組裝共用回傳型別
        if (HttpStatus.INTERNAL_SERVER_ERROR.isError()) {
            resultEntity = new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return resultEntity;
    }
}
