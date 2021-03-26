package controller;

import common.Validation;
import model.Product;
import service.ProductService;
import service.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = {"", "/product"})
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                addProduct(request, response);
                break;

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "view-top":
                listTopProducts(request, response);
                break;
            case "view-in-range":
                listProductsInRange(request, response);
            default:
                listProducts(request, response);
        }
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = productService.findAll();
        request.setAttribute("number", 0);
        request.setAttribute("products", products);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response) {
        String messageName = null;
        String messagePrice = null;
        String messageStock = null;
        String name = request.getParameter("name");
        messageName = Validation.validateProductName(name);

        int price = 0;
        try {
            price = Integer.parseInt(request.getParameter("price"));
            messagePrice = Validation.validatePrice(price);
        } catch (NumberFormatException e) {
            messagePrice = "Gia phai la dinh dang so.";
        }

        int discount = Integer.parseInt(request.getParameter("discount"));

        int stock = 0;
        try {
            stock = Integer.parseInt(request.getParameter("stock"));
            messageStock = Validation.validateStock(stock);
        } catch (NumberFormatException e) {
            messageStock = "Ton kho phai la dinh dang so.";
        }

        Product product = new Product(name, price, discount, stock);
        if (messageName == null && messagePrice == null && messageStock == null) {
            productService.save(product);
            product = null;
        }

        List<Product> products = productService.findAll();
        request.setAttribute("number", 0);
        request.setAttribute("products", products);
        request.setAttribute("product", product);
        request.setAttribute("messageName", messageName);
        request.setAttribute("messagePrice", messagePrice);
        request.setAttribute("messageStock", messageStock);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listTopProducts(HttpServletRequest request, HttpServletResponse response) {
        int top = Integer.parseInt(request.getParameter("top"));
        List<Product> products = productService.findTop(top);
        request.setAttribute("number", 0);
        request.setAttribute("products", products);
        request.setAttribute("top", top);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listProductsInRange(HttpServletRequest request, HttpServletResponse response) {
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("startDate")).getTime());
            endDate = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("endDate")).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<Product> products = productService.findInRange(startDate, endDate);
        request.setAttribute("number", 0);
        request.setAttribute("products", products);
        request.setAttribute("startDate", startDate);
        request.setAttribute("endDate", endDate);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
