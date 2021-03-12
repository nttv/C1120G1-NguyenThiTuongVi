import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DiscountCalculatorServlet", urlPatterns = "/calculate")
public class DiscountCalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product = request.getParameter("product");
        int price = Integer.parseInt(request.getParameter("price"));
        float discount = Float.parseFloat(request.getParameter("discount"));

        float discountAmount = price * discount / 100;
        float discountPrice = price - discountAmount;

        request.setAttribute("product", product);
        request.setAttribute("price", price);
        request.setAttribute("discount", discount);
        request.setAttribute("discountAmount", discountAmount);
        request.setAttribute("discountPrice", discountPrice);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/display-discount.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product = request.getParameter("product");
        int price = Integer.parseInt(request.getParameter("price"));
        float discount = Float.parseFloat(request.getParameter("discount"));

        float discountAmount = price * discount / 100;
        float discountPrice = price - discountAmount;

        request.setAttribute("product", product);
        request.setAttribute("price", price);
        request.setAttribute("discount", discount);
        request.setAttribute("discountAmount", discountAmount);
        request.setAttribute("discountPrice", discountPrice);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/display-discount.jsp");
        dispatcher.forward(request, response);
    }
}
