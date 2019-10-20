package lk.code.limpiar.domain.boundary.webclients;

import lk.code.limpiar.domain.entities.Movie;

public interface IMDBClientInterface {

  public Double getRating(Movie movie);
}
