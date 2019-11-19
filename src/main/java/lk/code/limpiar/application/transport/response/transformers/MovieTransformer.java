package lk.code.limpiar.application.transport.response.transformers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lk.code.limpiar.application.transformer.ResponseEntityInterface;
import lk.code.limpiar.domain.entities.Movie;

import java.util.HashMap;
import java.util.Map;

public class MovieTransformer implements ResponseEntityInterface {

  @Override
  public Map transform(Object datum) {

    ObjectMapper mapper = new ObjectMapper();
    Movie movie = (Movie)datum;

    Map<String, Object> mapping = new HashMap<>();

    mapping.put("transformed_id", movie.getId());
    mapping.put("transformed_title", movie.getTitle());

    return mapping;
  }
}
