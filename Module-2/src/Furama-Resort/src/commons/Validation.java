package commons;

import models.House;
import models.Room;
import models.Villa;
import services.HouseManager;
import services.RoomManager;
import services.VillaManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class Validation {
    private static final int SERVICE_VILLA = 1;
    private static final int SERVICE_HOUSE = 2;
    private static final int SERVICE_ROOM = 3;

    private static final String NOT_EMPTY_REGEX = "^\\w[\\w\\s]*$";
    private static final String SERVICE_ID_VILLA_REGEX = "^SVVL-\\d{4}$";
    private static final String SERVICE_ID_HOUSE_REGEX = "^SVHO-\\d{4}$";
    private static final String SERVICE_ID_ROOM_REGEX = "^SVRO-\\d{4}$";
    //    private static final String STRING_REGEX = "^[A-Z][a-z]*$";
    //    private static final String AREA_REGEX = "^(30\\.\\d*[1-9]|((3[1-9])|([4-9]\\d)|([1-9]\\d{2,}))(\\.\\d+)?)$";
    private static final String RENTAL_TYPE_REGEX = "^(Year|Month|Day|Hour)$";
    private static final String BIRTHDAY_REGEX = "^([0-2][1-9]|[1-3]0|31)/(0[1-9]|1[0-2])/(190[1-9]|19[1-9]\\d|2\\d{3})$";
    private static final String EXTERNAL_SERVICE_REGEX = "^(massage|karaoke|food|drink|car)$";
    private static final String STRING_REGEX = "^[A-Z][a-z]*(\\s[A-Z][a-z]*)*$";
    private static final String ID_CARD_REGEX = "^\\d{3}(\\s\\d{3}){2}$";
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+((_|\\.)?[A-Za-z0-9]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+){1,3}$";
    private static final String GENDER_REGEX = "^(male|female|unknown)$";
    private static final String PHONE_REGEX = "^0[0-9]{9}$";
    private static final String ADDRESS_REGEX = "^[A-Z\\d][a-z0-9]*(\\s[A-Z][a-z0-9]*)*$";

    public static boolean isNotEmpty(String string) {
        try {
            if (Pattern.matches(NOT_EMPTY_REGEX, string)) {
                return true;
            }
            throw new Exception("Input value cannot be empty");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean validateServiceId(String serviceId, int serviceType) {
        boolean result = false;
        switch (serviceType) {
            case SERVICE_VILLA:
                result = validateVillaId(serviceId);
                break;
            case SERVICE_HOUSE:
                result = validateHouseId(serviceId);
                break;
            case SERVICE_ROOM:
                result = validateRoomId(serviceId);
        }
        return result;
    }

    public static boolean validateVillaId(String serviceId) {
        try {
            if (Pattern.matches(SERVICE_ID_VILLA_REGEX, serviceId)) {
                List<Villa> listVilla = new VillaManager().findAll();
                for (Villa villa : listVilla) {
                    if (villa.getServiceId().equals(serviceId)) {
                        throw new Exception("Service ID is duplicate");
                    }
                }
                return true;
            }
            throw new Exception("Service ID must be in the format SVXX-YYYY");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean validateHouseId(String serviceId) {
        try {
            if (Pattern.matches(SERVICE_ID_HOUSE_REGEX, serviceId)) {
                List<House> listHouse = new HouseManager().findAll();
                for (House house : listHouse) {
                    if (house.getServiceId().equals(serviceId)) {
                        throw new Exception("Service ID is duplicate");
                    }
                }
                return true;
            }
            throw new Exception("Service ID must be in the format SVXX-YYYY");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean validateRoomId(String serviceId) {
        try {
            if (Pattern.matches(SERVICE_ID_ROOM_REGEX, serviceId)) {
                List<Room> listRoom = new RoomManager().findAll();
                for (Room room : listRoom) {
                    if (room.getServiceId().equals(serviceId)) {
                        throw new Exception("Service ID is duplicate");
                    }
                }
                return true;
            }
            throw new Exception("Service ID must be in the format SVXX-YYYY");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean validateString(String string) {
        try {
            if (Pattern.matches(STRING_REGEX, string)) {
                return true;
            }
            throw new Exception("Input must be capitalized first letter of each word");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean validateArea(String area) {
        try {
//            return Pattern.matches(AREA_REGEX, area);
            if (Double.parseDouble(area) > 30) {
                return true;
            }
            throw new Exception("Area must be larger than 30");
        } catch (NumberFormatException e) {
            System.out.println("Area must be a real number");
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean validatePositiveNumber(String number) {
        try {
            if (Double.parseDouble(number) > 0) {
                return true;
            }
            throw new Exception("Input must be a positive number");
        } catch (NumberFormatException e) {
            System.out.println("Input must be a real number");
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean validateNoOfPeople(String number) {
        try {
            int num = Integer.parseInt(number);
            if (num > 0 && num < 20) {
                return true;
            }
            throw new Exception("Input must be a positive integer and less than 20");
        } catch (NumberFormatException e) {
            System.out.println("Input must be an integer");
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean validateRentalType(String rentalType) {
        try {
            if (Pattern.matches(RENTAL_TYPE_REGEX, rentalType)) {
                return true;
            }
            throw new Exception("Rental type must be either Year/Month/Day/Hour");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean validateExternalService(String serviceName) {
        try {
            if (Pattern.matches(EXTERNAL_SERVICE_REGEX, serviceName)) {
                return true;
            }
            throw new Exception("Input must be either massage/karaoke/food/drink/car");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean validateBirthday(String birthday) {
        try {
            if (!Pattern.matches(BIRTHDAY_REGEX, birthday)) {
                throw new Exception("Birthday must be in the format dd/mm/yyyy and greater than 1900");
            } else {
                String[] date = birthday.split("/");
                int year = Integer.parseInt(date[2]);
                String temp = date[0] + "/" + date[1] + "/" + (year + 18);
                Date dateTemp = new SimpleDateFormat("dd/MM/yyyy").parse(temp);
                if (dateTemp.compareTo(new Date()) <= 0) {
                    return true;
                }
                throw new Exception("Birthday must be at least 18 years before the current date");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean validateIdCard(String idCard) {
        try {
            if (Pattern.matches(ID_CARD_REGEX, idCard)) {
                return true;
            }
            throw new Exception("Id Card must have 9 digits and be in the format XXX XXX XXX");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean validateGender(String gender) {
        try {
            if (Pattern.matches(GENDER_REGEX, gender.toLowerCase())) {
                return true;
            }
            throw new Exception("Gender must be either Male/Female/Unknown");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean validatePhone(String phone) {
        try {
            if (Pattern.matches(PHONE_REGEX, phone)) {
                return true;
            }
            throw new Exception("Phone numbers must be in 10-digit format");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean validateEmail(String email) {
        try {
            if (Pattern.matches(EMAIL_REGEX, email)) {
                return true;
            }
            throw new Exception("Email must be in the correct format abc@abc.abc");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean validateAddress(String address) {
        try {
            if (Pattern.matches(ADDRESS_REGEX, address)) {
                return true;
            }
            throw new Exception("Address must be capitalized first letter of each word");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
