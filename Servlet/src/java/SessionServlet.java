import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Create or get existing session
        HttpSession session = request.getSession(true);
        String sessionValue = (String) session.getAttribute("sessionValue");

        if (sessionValue == null) {
            sessionValue = "This is the first session visit using the HttpServlet!";
            session.setAttribute("sessionValue", sessionValue);
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>HttpServlet Session Management</h2>");
        out.println("<p>Session Value: " + sessionValue + "</p>");
        out.println("</body></html>");
    }
}
