package lk.code.limpiar.application.exception.types;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class BaseException extends Exception {

  private String code;

  public BaseException(String message) {

    super(message);
  }

  public BaseException(String message, String code) {

    super(message);
    this.code = code;
  }
}
