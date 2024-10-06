import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/hi")
public class Nana extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // UTF-8의 문자열 데이터를 보낸다.
        resp.setCharacterEncoding("UTF-8");
        // 상대에게 UTF-8로 읽어라고 알려준다.
        resp.setContentType("text/html; charset=UTF-8");
        
        PrintWriter out = resp.getWriter();
        
        // 쿼리스트링
        String cnt_ = req.getParameter("cnt");
        int cnt = 100;
        if(cnt_ != null && !cnt_.equals(""))
            cnt = Integer.parseInt(cnt_);

        for(int i = 0; i < cnt; i++) {
            out.println((i + 1) + ": 안녕 Servlet!!<br/>");
        }
    }
}