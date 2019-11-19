package lk.code.limpiar.application.controllers;


import lk.code.limpiar.application.exception.types.HandlerException;
import lk.code.limpiar.application.transformer.ResponseEntityTransformer;
import lk.code.limpiar.application.transport.request.entities.MovieRequestEntity;
import lk.code.limpiar.application.transport.response.transformers.MovieTransformer;
import lk.code.limpiar.application.transport.response.transformers.ResourceIdentifierTransformer;
import lk.code.limpiar.application.validator.RequestEntityValidator;
import lk.code.limpiar.domain.entities.Movie;
import lk.code.limpiar.domain.services.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@Slf4j // logger (generates a class property of name `log`)
public class MovieController {

  @Autowired
  private RequestEntityValidator validator;

  @Autowired
  private ResponseEntityTransformer transformer;

  @Autowired
  private MovieService movieService;

  /**
   * Handle get all movies request
   *
   * @param request ServerRequest
   * @return ServerResponse
   */
  @GetMapping("/movies")
  public ResponseEntity<List<Map>> get(RequestEntity request) {

    List<Movie> movies = this.movieService.getAllMovies();

    List<Map> trMovies = this.transformer.transform(movies, new MovieTransformer());

    // logging
    log.info("Lombok logger");
    return ResponseEntity.ok().body(trMovies);
  }

  /**
   * Handle get movie by id
   *
   * @param id
   * @return
   */
  @GetMapping("/movies/{id}")
  public ResponseEntity<?> getById(@PathVariable String id) throws Exception, RuntimeException {

    Optional<Movie> movie = this.movieService.getMovieById(id);

    Optional<Map> trMovie = this.transformer.transform(movie, new MovieTransformer());

    return ResponseEntity.ok().body(trMovie);
  }

  /**
   *  Handle get rating of a movie.
   *
   * @param id
   * @return
   */
  @GetMapping("/movies/{id}/rating")
  public ResponseEntity<Optional<Double>> getRating(@RequestParam String id) {

    // map
    Movie movie = new Movie();
    movie.setId(id);
	
	  Optional<Double> rating = Optional.of(this.movieService.getRating(movie));

//    Mono<Map> trMovie = this.transformer.transform(movie, new MovieTransformer());

	  return ResponseEntity.ok().body(rating);
  }

  /**
   * Handle creating a new movie entry
   *
   * @param request
   * @return
   */
  @PostMapping("/movies")
  public ResponseEntity<Optional<Map>> getRating(@RequestBody MovieRequestEntity request) {
  	
      // validate
      this.validator.validate(request);

      // map
      Movie movie = new Movie();
      movie.setTitle(request.getTitle());

	  Optional<String> movieId = Optional.ofNullable(this.movieService.addMovie(movie));
        

        Optional<Map> trMovieId = transformer.transform(movieId, new ResourceIdentifierTransformer());

    return ResponseEntity.ok().body(trMovieId);
  }

  /**
   * Handle updating of an existing movie
   *
   * @param id
   * @param request
   * @return
   */
  @PutMapping("/movies/{id}")
  public ResponseEntity<Movie> edit(@RequestParam String id ,@RequestBody MovieRequestEntity request) {
  	
          // validate
          this.validator.validate(request);

          // map
          Movie movie = new Movie();
          movie.setId(id);
          movie.setTitle(request.getTitle());
	
	  Optional<Void> movieId = this.movieService.edit(movie);
    

    return ResponseEntity.noContent().build();
  }

  /**
   * Handle deletion of an existing movie
   *
   * @param id
   * @return
   */
  @DeleteMapping("/movies/{id}")
  public ResponseEntity<Movie> delete(@RequestParam String id) {

      this.movieService.delete(id);

      return  ResponseEntity.noContent().build();
  }
}
