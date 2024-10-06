import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/notice-reg")
public class NoticeReg extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // UTF-8의 문자열 데이터를 보낸다.
        resp.setCharacterEncoding("UTF-8");
        // 클라이언트에게 UTF-8로 읽어라고 알려준다.
        resp.setContentType("text/html; charset=UTF-8");
        // 서버에게 요청을 읽기 전에 UTF-8로 읽어라고 알려준다.
        req.setCharacterEncoding("UTF-8");


        PrintWriter out = resp.getWriter();
        
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        out.println(title);
        out.println(content);
    }
}