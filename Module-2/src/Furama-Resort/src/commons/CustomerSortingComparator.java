package commons;

import models.Customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class CustomerSortingComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        if (o1.getCustomerName().equals(o2.getCustomerName())) {
            Date birthday1 = null;
            Date birthday2 = null;
            try {
                birthday1 = new SimpleDateFormat("dd/MM/yyyy").parse(o1.getCustomerBirthday());
                birthday2 = new SimpleDateFormat("dd/MM/yyyy").parse(o2.getCustomerBirthday());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return birthday1.compareTo(birthday2);
        } else {
            return o1.getCustomerName().compareTo(o2.getCustomerName());
        }
    }
}
