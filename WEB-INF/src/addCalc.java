import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class addCalc extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // UTF-8의 문자열 데이터를 보낸다.
        resp.setCharacterEncoding("UTF-8");
        // 상대에게 UTF-8로 읽어라고 알려준다.
        resp.setContentType("text/html; charset=UTF-8");

        String x_ = req.getParameter("x");
        String y_ = req.getParameter("y");
        int x = 0;
        int y = 0;

        if(!CheckBlank.isBlank(x_))
            x = Integer.parseInt(x_);
        if(!CheckBlank.isBlank(y_))
            y = Integer.parseInt(y_);
        int result = x + y;

        req.setAttribute("result", result);
        req.getRequestDispatcher("/add.jsp").forward(req, resp);
    }
}
