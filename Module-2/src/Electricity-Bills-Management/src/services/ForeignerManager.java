//package services;
//
//import commons.FuncReadAndWrite;
//import models.Customer;
//import models.Foreigner;
//import models.Vietnamese;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ForeignerManager {
//    FuncReadAndWrite<Foreigner> funcReadAndWrite = new FuncReadAndWrite<>();
//
//    public Foreigner findForeignerById(String customerId) {
//        List<String[]> list = FuncReadAndWrite.readFile("customer.csv");
//        for (String[] line : list) {
//            String signal = line[0].substring(2, 4);
//            Customer customer;
//            if (signal.equals("VN")) {
//                customer = new Vietnamese(line);
//            } else {
//                customer = new Foreigner(line);
//            }
//            System.out.print(i + ". ");
//            customer.showInfo();
//            i++;
//        }
//    }
//}
