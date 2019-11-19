package lk.code.limpiar.application.transport.response.transformers;

import lk.code.limpiar.application.transformer.ResponseEntityInterface;

import java.util.HashMap;
import java.util.Map;

public class ResourceIdentifierTransformer implements ResponseEntityInterface {

  @Override
  public Map transform(Object entity) {

    Map<String, Object> mapping = new HashMap<>();

    mapping.put("id", entity);

    return mapping;

  }
}
