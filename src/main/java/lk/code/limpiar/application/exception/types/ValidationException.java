package lk.code.limpiar.application.exception.types;

import lk.code.limpiar.application.validator.RequestEntityInterface;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import java.util.Set;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class ValidationException extends RuntimeException {

  private Set<ConstraintViolation<RequestEntityInterface>> errors;

  public ValidationException(Set<ConstraintViolation<RequestEntityInterface>> errors) {
    this.errors = errors;
  }

  public Set<ConstraintViolation<RequestEntityInterface>> getErrors() {
    return this.errors;
  }
}
