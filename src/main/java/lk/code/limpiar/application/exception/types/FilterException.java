package lk.code.limpiar.application.exception.types;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FilterException extends BaseException {

  public FilterException(String message) {

    super(message);
  }

  public FilterException(String message, String code) {

  	super(message, code);
  }
}
