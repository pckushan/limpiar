package lk.code.limpiar.application.validator;

import lk.code.limpiar.application.exception.types.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Component
public class RequestEntityValidator {

  @Autowired
  private Validator validator;

  public void validate(RequestEntityInterface target) throws ValidationException {

    Set<ConstraintViolation<RequestEntityInterface>> errors = this.validator.validate(target);

    if(!errors.isEmpty()) {
      throw new ValidationException(errors);
    }
  }
}