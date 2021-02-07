package commons;

public class NotFoundVehicelException extends Exception {
    public NotFoundVehicelException() {
    }

    @Override
    public String getMessage() {
        return "Biển kiểm soát không tồn tại";
    }
}
