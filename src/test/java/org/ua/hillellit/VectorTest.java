package org.ua.hillellit;

import java.util.Arrays;

import org.springframework.core.io.ClassPathResource;
import org.ua.hillellit.math.model.Vector;
import org.ua.hillellit.math.exceptions.FileMaxSizeReachedException;
import org.ua.hillellit.math.model.logger.FileLogger;
import org.ua.hillellit.math.model.logger.FileLoggerConfiguration;
import org.ua.hillellit.math.model.logger.FileLoggerConfigurationLoader;

import static org.junit.Assert.assertEquals;

/**
 * @author Ludmila Litvinova on
 */
public class VectorTest {
  FileLoggerConfigurationLoader flcl = new FileLoggerConfigurationLoader();
  FileLogger fl = new FileLogger(
      flcl.load(new ClassPathResource("src\\main\\resources\\configuration.properties").getPath()));
  @org.junit.Test
  public void checkVectorMethods() throws FileMaxSizeReachedException {

    Vector[] vectors = {new Vector(3.0, 5.0, 7.0), new Vector(2.0, 4.0, 9.0)};
    fl.info("Vectors: " + Arrays.toString(vectors));
    assertEquals(new Vector(5.0, 9.0, 16.0), vectors[0].add(vectors[1]));
    fl.info("Result add: " + vectors[0].add(vectors[1]));
    assertEquals(new Vector(1.0, 1.0, -2.0), vectors[0].subtract(vectors[1]));
    fl.info("Result subtract: " + vectors[0].subtract(vectors[1]));
    assertEquals(89.0, vectors[0].scalarProduct(vectors[1]),0.001);
    fl.info("Result scalarProduct: " + vectors[0].scalarProduct(vectors[1]));
    assertEquals(new Vector(17.0, -13.0, 2.0), vectors[0].crossProduct(vectors[1]));
    fl.info("Result crossProduct: " + vectors[0].crossProduct(vectors[1]));

  }

}