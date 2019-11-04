package lk.code.limpiar.application.exception.types;

public class ServerException extends BaseException {

  public ServerException(String message) {

    super(message);
  }

  public ServerException(String message, String code) {

  	super(message, code);
  }
}
