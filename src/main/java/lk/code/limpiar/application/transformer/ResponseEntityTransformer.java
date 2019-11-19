package lk.code.limpiar.application.transformer;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ResponseEntityTransformer {

/**
 * Transform a Mono of entities using the given transformer
 *
 * @param entityObject
 * @param transformer
 * @return
 */
public Optional<Map> transform(Optional<?> entityObject, ResponseEntityInterface transformer) {
	
	return entityObject.map(transformer::transform);

}

/**
 * Transform a Flux of entities using the given transformer
 *
 * @param transformer Response Transformer
 * @return Flux
 */
public List<Map> transform(List<?> entityList, ResponseEntityInterface transformer) {
	
	return entityList.stream()
			       .map(transformer::transform)
			       .collect(Collectors.toList());
	
}
}
