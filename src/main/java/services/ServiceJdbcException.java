package services;

public class ServiceJdbcException extends RuntimeException{
    public ServiceJdbcException(String mensaje) {
       super(mensaje);
    }
    public ServiceJdbcException(String mensaje, Throwable cause) {
        super(mensaje, cause);
    }
}
