package controller;

import model.Room;
import service.RoomService;
import service.RoomServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Servlet", urlPatterns = {"", "/room"})
public class RoomServlet extends HttpServlet {
    private RoomService roomService = new RoomServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                addRoom(request, response);
                break;
            case "delete":
                deleteRoom(request, response);
                break;
            case "view":
                showDetails(request, response);
                break;
            case "search":
                search(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                addRoom(request, response);
                break;
            case "delete":
                deleteRoom(request, response);
                break;
            case "view":
                showDetails(request, response);
                break;
            case "search":
                search(request, response);
                break;
            default:
                listRooms(request, response);
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("customer/create.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addRoom(HttpServletRequest request, HttpServletResponse response) {
//        String customerId = request.getParameter("id");
//        CustomerType customerType = customerTypeService.findById(Integer.parseInt(request.getParameter("type")));
//        String customerName = request.getParameter("name");
//        String birthday = request.getParameter("birthday");
//        Date customerBirthday = null;
//        try {
//            customerBirthday = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(birthday).getTime());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        boolean customerGender = Boolean.parseBoolean(request.getParameter("gender"));
//        String customerIdCard = request.getParameter("idCard");
//        String customerPhone = request.getParameter("phone");
//        String customerEmail = request.getParameter("email");
//        String customerAddress = request.getParameter("address");
//
//        Customer customer = new Customer(customerId, customerType, customerName, customerBirthday, customerGender,
//                customerIdCard, customerPhone, customerEmail, customerAddress);
//        customerService.save(customer);
//        listRooms(request, response);
    }

    private void deleteRoom(HttpServletRequest request, HttpServletResponse response) {
//        String customerId = request.getParameter("id");
//        customerService.remove(customerId);
//        listRooms(request, response);
    }

    private void showDetails(HttpServletRequest request, HttpServletResponse response) {
//        String customerId = request.getParameter("id");
//        Customer customer = customerService.findById(customerId);
//        request.setAttribute("customer", customer);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/view.jsp");
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException | IOException e) {
//            e.printStackTrace();
//        }
    }

    private void listRooms(HttpServletRequest request, HttpServletResponse response) {
        List<Room> roomList = roomService.findAll();
        request.setAttribute("number", 0);
        request.setAttribute("roomList", roomList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String key = request.getParameter("key");
        if (key == null) {
            listRooms(request, response);
        } else {
            request.setAttribute("roomList", roomService.findByKey(key));
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}