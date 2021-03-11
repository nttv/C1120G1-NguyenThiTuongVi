import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "ServerTimeServlet", urlPatterns = "/index")
public class ServerTimeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Date today = new Date();
        String formattedDate = new SimpleDateFormat("E, dd MMMM yyyy hh:mm:ss aa").format(today);
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
//        writer.println("<h1>" + today + "</h1>");
        writer.println("<h1>" + formattedDate + "</h1>");
        writer.println("</html>");
    }
}
