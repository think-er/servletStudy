import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add2")
public class addCalc2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // UTF-8의 문자열 데이터를 보낸다.
        resp.setCharacterEncoding("UTF-8");
        // 상대에게 UTF-8로 읽어라고 알려준다.
        resp.setContentType("text/html; charset=UTF-8");

        String[] num_ = req.getParameterValues("num");
        int sum = 0;
        
        for(int i = 0; i < num_.length; i++) {
            if(!CheckBlank.isBlank(num_[i]))
                sum += Integer.parseInt(num_[i]);
        }

        int result = sum;

        req.setAttribute("result", result);
        req.getRequestDispatcher("/add2.jsp").forward(req, resp);
    }
}
