package No2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "Hot Toilets In My Area",
        urlPatterns = "/home" //TODO: figure out what urlpatterns we want
)
public class MyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO: CHANGE VALUES
        String liquorType = req.getParameter("Type");

        //LiquorService liquorService = new LiquorService();
        //LiquorType l = LiquorType.valueOf(liquorType);

        //List liquorBrands = liquorService.getAvailableBrands(l);

        //req.setAttribute("brands", liquorBrands);
        RequestDispatcher view = req.getRequestDispatcher("result.jsp");
        view.forward(req, resp); // moves request to response

    }
}
