package lk.code.limpiar.application.exception.types;

import lk.code.limpiar.application.validator.RequestEntityInterface;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class ValidationException extends RuntimeException {

  private Set<ConstraintViolation<RequestEntityInterface>> errors;

  public ValidationException(Set<ConstraintViolation<RequestEntityInterface>> errors) {
    this.errors = errors;
  }

  public Set<ConstraintViolation<RequestEntityInterface>> getErrors() {
    return this.errors;
  }
}
