import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CurrencyConverterServlet", urlPatterns = "/convert")
public class CurrencyConverterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/converter.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int rate = Integer.parseInt(request.getParameter("rate"));
        int usd = Integer.parseInt(request.getParameter("usd"));
        int vnd = rate * usd;

        request.setAttribute("rate", rate);
        request.setAttribute("usd", usd);
        request.setAttribute("vnd", vnd);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/converter.jsp");
        dispatcher.forward(request, response);
    }
}
