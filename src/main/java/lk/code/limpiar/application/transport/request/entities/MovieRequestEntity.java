package lk.code.limpiar.application.transport.request.entities;

import lk.code.limpiar.application.validator.RequestEntityInterface;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class MovieRequestEntity implements RequestEntityInterface {

    @NotEmpty
    @Size(min = 4, max = 7)
    private String title;

    private String id;
}
