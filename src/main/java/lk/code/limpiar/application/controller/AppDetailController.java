package lk.code.limpiar.application.controller;

import lk.code.limpiar.application.transport.response.transformers.AppDetailTransformer;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppDetailController {

  /**
   * Control get API details
   * @param request Request
   * @return Response
   */
  @GetMapping("/")
  public ResponseEntity<Object> details(RequestEntity request) {

    AppDetailTransformer appDetailTransformer = new AppDetailTransformer(
        "Test API",
        "v1.0.0",
        "A short description of the usage of the API"
    );

    return ResponseEntity.ok().body(appDetailTransformer);
  }
}
