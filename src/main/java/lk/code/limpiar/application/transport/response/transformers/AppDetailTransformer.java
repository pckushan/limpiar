package lk.code.limpiar.application.transport.response.transformers;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AppDetailTransformer {

  private String name;
  private String version;
  private String usage;
}
