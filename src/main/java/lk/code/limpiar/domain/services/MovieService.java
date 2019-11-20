package lk.code.limpiar.domain.services;

import lk.code.limpiar.domain.boundary.repositories.MovieRepositoryInterface;
import lk.code.limpiar.domain.boundary.webclients.IMDBClientInterface;
import lk.code.limpiar.domain.entities.Movie;
import lk.code.limpiar.domain.types.DomainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepositoryInterface movieRepository;

    @Autowired
    private IMDBClientInterface imdbClient;

    /**
     * Get all Movies
     *
     * @return List
     */
    public List<Movie> getAllMovies() throws DomainException {
        return this.movieRepository.findAll();
    }

    /**
     * Get a single Movie by id
     *
     * @param id id
     * @return Movie
     * @throws DomainException exception
     */
    public Optional<Movie> getMovieById(String id) throws DomainException {
        return this.movieRepository.findById(id);
    }

    /**
     * Add a movie
     *
     * @param movie Movie
     * @return String
     */
    public Movie addMovie(Movie movie) throws DomainException {
        return this.movieRepository.save(movie);
    }

    /**
     * Get rating of the movie
     *
     * @param movie Movie
     * @return double
     */
    public double getRating(Movie movie) throws DomainException {
        return this.imdbClient.getRating(movie);
    }

    /**
     * Edit Movie
     *
     * @param movie Movie
     * @return String
     */
    public String edit(Movie movie) throws DomainException {
        Movie editedBanner = this.movieRepository.save(movie);
        return editedBanner.getId();
    }

    /**
     * Delete Movie
     *
     * @param id Id
     */
    public void delete(String id) throws DomainException {
        this.movieRepository.deleteById(id);
    }
}
