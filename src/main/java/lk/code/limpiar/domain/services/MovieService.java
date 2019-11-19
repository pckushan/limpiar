package lk.code.limpiar.domain.services;

import lk.code.limpiar.domain.boundary.repositories.MovieRepositoryInterface;
import lk.code.limpiar.domain.entities.Movie;
import lk.code.limpiar.domain.types.DomainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

  @Autowired
  private MovieRepositoryInterface movieRepository;
//
//  @Autowired
//  private IMDBClientInterface imdbClient;

  /**
   * Get a Flux of Movies
   *
   */
  public List<Movie> getAllMovies() {

//    return this.movieRepository.findAll();

    return new ArrayList<Movie>();
  }

  /**
   * Get a single Movie by id
   *
   * @param id Movie id
   * @return Mono<Movie>
   */
  public Optional<Movie> getMovieById(String id) throws DomainException {

//    return this.movieRepository.findById(id);

    throw new DomainException("Error", "100");

//    return Optional.empty();
  }

  /**
   * Add a movie
   *
   * @param movie movie
   */
  public String addMovie(Movie movie) {

//    Movie newMovie = this.movieRepository.save(movie);

//    return newMovie.getId();
    return "";
  }

  /**
   * Get rating of the movie
   *
   * @param movie movie
   * @return Mono<Double>
   */
  public double getRating(Movie movie) {

//    return this.imdbClient.getRating(movie);

    return 10.0;
  }

  /**
   * Edit Movie
   *
   * @param movie Movie
   */
  public Optional<Void> edit(Movie movie) {

//    Movie editedBanner = this.movieRepository.save(movie);

    return Optional.empty();
  }

  /**
   * Delete Movie
   * @param id
   */
  public void delete(String id) {

  //	 this.movieRepository.deleteById(id);
  }
}
