package lk.code.limpiar.externals.repositories;

import lk.code.limpiar.domain.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, String> {

  /**
   * Get Movie by title
   * @param title title
   * @return Movies
   */
  List<Movie> findByTitle(String title);
}
