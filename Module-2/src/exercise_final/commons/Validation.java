package exercise_final.commons;

import exercise_final.models.Car;
import exercise_final.models.Motorbike;
import exercise_final.models.Truck;
import exercise_final.services.CarManager;
import exercise_final.services.MotorbikeManager;
import exercise_final.services.TruckManager;

import java.util.regex.Pattern;

public class Validation {
    private static final int VEHICLE_TRUCK = 1;
    private static final int VEHICLE_CAR = 2;
    private static final int VEHICLE_MOTORBIKE = 3;

    private static final String REQUIRED_STRING_REGEX = "^\\w+$";
    private static final String NO_PLATE_TRUCK_REGEX = "^\\d{2}C-\\d{3}\\.\\d{2}$";
    private static final String NO_PLATE_CAR_REGEX = "^\\d{2}Y-\\d{3}\\.\\d{2}$";
    private static final String NO_PLATE_MOTORBIKE_REGEX = "^\\d{2}-[A-Z]\\d-\\d{3}\\.\\d{2}$";

    public static boolean isEmpty(String string) {
        if (Pattern.matches(REQUIRED_STRING_REGEX, string)) {
            return false;
        }
        System.out.println("Trường bắt buộc nhập giá trị");
        return true;
    }

    public static boolean validateNoPlate(String noPlate, int vehicleType) {
        boolean result = false;
        switch (vehicleType) {
            case VEHICLE_TRUCK:
                result = validateTruck(noPlate);
                break;
            case VEHICLE_CAR:
                result = validateCar(noPlate);
                break;
            case VEHICLE_MOTORBIKE:
                result = validateMotorbike(noPlate);
        }
        return result;
    }

    public static boolean validateTruck(String noPlate) {
        if (Pattern.matches(NO_PLATE_TRUCK_REGEX, noPlate)) {
            Truck truck = new TruckManager().findById(noPlate);
            if (truck != null) {
                System.out.println("Số biển kiểm soát đã tồn tại");
                return false;
            }
            return true;
        }
        System.out.println("Biển kiểm soát phải đúng định dạng XXC-XXX.XX (X: 0-9)");
        return false;
    }

    public static boolean validateCar(String noPlate) {
        if (Pattern.matches(NO_PLATE_CAR_REGEX, noPlate)) {
            Car car = new CarManager().findById(noPlate);
            if (car != null) {
                System.out.println("Số biển kiểm soát đã tồn tại");
                return false;
            }
            return true;
        }
        System.out.println("Biển kiểm soát phải đúng định dạng XXY-XXX.XX (X: 0-9)");
        return false;
    }

    public static boolean validateMotorbike(String noPlate) {
        if (Pattern.matches(NO_PLATE_MOTORBIKE_REGEX, noPlate)) {
            Motorbike motorbike = new MotorbikeManager().findById(noPlate);
            if (motorbike != null) {
                System.out.println("Số biển kiểm soát đã tồn tại");
                return false;
            }
            return true;
        }
        System.out.println("Biển kiểm soát phải đúng định dạng XX-YZ-XXX.XX (X: 0-9)");
        return false;
    }
}
