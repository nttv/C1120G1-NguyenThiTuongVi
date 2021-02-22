package commons;

public class DuplicateMedicalRecordException extends Exception {
    public DuplicateMedicalRecordException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
