package furama_resort.services;

import furama_resort.commons.FuncReadAndWrite;
import furama_resort.models.Customer;
import furama_resort.models.Service;

import java.util.ArrayList;
import java.util.List;

public class ServiceManager {
    public Service findServiceById(String serviceId) {
        try {
            String serviceType = serviceId.substring(2, 4);
            Service service = null;
            switch (serviceType) {
                case "VL":
                    service = new VillaManager().findById(serviceId);
                    break;
                case "HO":
                    service = new HouseManager().findById(serviceId);
                    break;
                case "RO":
                    service = new RoomManager().findById(serviceId);
                    break;
            }
            return service;
        } catch (Exception e) {
            return null;
        }
    }

    public void addNewBooking(Customer customer, String serviceId, String externalServices) {
        Service service = findServiceById(serviceId);
        customer.setService(service);
        List<String> list = new ArrayList<>();
        String bookingData = customer.toString();
        if (externalServices != null) {
            bookingData += "," + externalServices;
        }
        list.add(bookingData);
        new FuncReadAndWrite<String>().writeFile("Booking.csv", list, true);
    }
}
