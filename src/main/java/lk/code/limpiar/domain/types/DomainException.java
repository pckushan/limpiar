package lk.code.limpiar.domain.types;

import lk.code.limpiar.application.exception.types.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DomainException extends BaseException {

  public DomainException(String message) {

    super(message);
  }

  public DomainException(String message, String code) {

    super(message, code);
  }
}
