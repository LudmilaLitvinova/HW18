package org.ua.hillellit.math.model.logger;

import java.io.IOException;
import org.ua.hillellit.math.exceptions.FileMaxSizeReachedException;

public interface Logable {

  public void debug(String message) throws FileMaxSizeReachedException, IOException;

  public void info(String message) throws FileMaxSizeReachedException, IOException;

}
