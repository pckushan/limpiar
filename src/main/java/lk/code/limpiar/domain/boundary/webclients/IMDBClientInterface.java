package lk.code.limpiar.domain.boundary.webclients;

import lk.code.limpiar.domain.entities.Movie;

import java.util.Optional;

public interface IMDBClientInterface {

  public Optional<Double> getRating(Movie movie);
}
