package lk.code.limpiar.application.exception.types;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class HandlerException extends BaseException {

  public HandlerException(String message) {

    super(message);
  }

  public HandlerException(String message, String code) {

    super(message, code);
  }
}
