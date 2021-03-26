package common;

import java.util.regex.Pattern;

public class Validate {

    private static final String TENANT_NAME_REGEX = "^[A-Za-z\\s]{5,50}$";
    private static final String PHONE_REGEX = "^0[0-9]{9}$";
    private static final String START_DAY_REGEX = "^([0-2][1-9]|[1-3]0|31)/(0[1-9]|1[0-2])/(190[1-9]|19[1-9]\\d|2\\d{3})$";

    public static String validateTenantName(String name) throws Exception {
        String messageName = null;
        if (!Pattern.matches(TENANT_NAME_REGEX, name)) {
            messageName = "Ten khong chua ky tu so va ky tu dac biet. Do dai tu 5-50 ky tu.";
        }
        return messageName;
    }

    public static String validatePhone(String phone) throws Exception {
        String messagePhone = null;
        if (!Pattern.matches(PHONE_REGEX, phone)) {
            messagePhone = "So dien thoai gom 10 so.";
        }
        return messagePhone;
    }

//    public static boolean validateDate(String date) throws Exception {
//        if (!Pattern.matches(START_DAY_REGEX, date)) {
//            throw new Exception("Ngày phải theo định dạng dd/mm/yyyy");
//        } else {
//            String[] date = birthday.split("/");
//            int year = Integer.parseInt(date[2]);
//            String temp = date[0] + "/" + date[1] + "/" + (year + 18);
//            Date dateTemp = new SimpleDateFormat("dd/MM/yyyy").parse(temp);
//            if (dateTemp.compareTo(new Date()) <= 0) {
//                return true;
//            }
//            throw new Exception("Birthday must be at least 18 years before the current date");
//        }
//    }

    public static String validateNote(String note) throws Exception {
        String messageNote = null;
        if (note.length() > 200) {
            messageNote = "Ghi chu khong duoc vuot qua 200 ky tu.";
        }
        return messageNote;
    }
}
