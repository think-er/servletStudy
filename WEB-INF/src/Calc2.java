import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Application 저장소
        ServletContext application = req.getServletContext();
        // Session
        HttpSession session = req.getSession();

        Cookie[] cookies = req.getCookies();

        // UTF-8의 문자열 데이터를 보낸다.
        resp.setCharacterEncoding("UTF-8");
        // 상대에게 UTF-8로 읽어라고 알려준다.
        resp.setContentType("text/html; charset=UTF-8");

        String v_ = req.getParameter("v");
        String op = req.getParameter("operator");

        int v = 0;
        int result = 0;

        if(!CheckBlank.isBlank(v_))
            v = Integer.parseInt(v_);


        // 계산
        if(op.equals("=")) {
            // int x = (Integer)application.getAttribute("value");
            // int x = (Integer)session.getAttribute("value");
            int x = 0;
            for(Cookie c : cookies) {
                if(c.getName().equals("value")) {
                    x = Integer.parseInt(c.getValue());
                    break;
                }
            }
            int y = v;
            // String operator = (String)application.getAttribute("op");
            // String operator = (String)session.getAttribute("op");
            
            String operator = "";
            for(Cookie c : cookies) {
                if(c.getName().equals("op")) {
                    operator = c.getValue();
                    break;
                }
            }
            if(operator.equals("+"))
                result = x + y;
            else
                result = x - y;

            req.setAttribute("result", result);
            req.getRequestDispatcher("/calc2.jsp").forward(req, resp);            
        }
        else {
            // application.setAttribute("value", v);
            // application.setAttribute("op", op);
            // session.setAttribute("value", v);
            // session.setAttribute("op", op);

            Cookie valueCookie = new Cookie("value", String.valueOf(v));
            Cookie opCookie = new Cookie("op", op);
            resp.addCookie(valueCookie);
            resp.addCookie(opCookie);

            req.getRequestDispatcher("/calc2.jsp").forward(req, resp);            
        }

    }
}
