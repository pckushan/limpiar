package lk.code.limpiar.externals.webclients;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import lk.code.limpiar.domain.boundary.webclients.IMDBClientInterface;
import lk.code.limpiar.domain.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class IMDBClient implements IMDBClientInterface {

  @Autowired
  private MeterRegistry meterRegistry;

@Override
public Double getRating(Movie movie) {
    //register metrics
    Timer timer = this.meterRegistry.timer("imdb.request.time", "title", movie.getId());
    long start = System.currentTimeMillis();

    // call REST API

    // set metrics
    timer.record(System.currentTimeMillis() - start, TimeUnit.MILLISECONDS);

    return 3.5;
}
}
