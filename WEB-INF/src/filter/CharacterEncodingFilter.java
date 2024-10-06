package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

// 필터는 어떤 요청이 와도 동작되고, 톰캣이 처음 실행될 때도 동작한다.

@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {

            /* 전처리 작업: doFilter()를 호출하기 전에 수행되는 작업은 요청에 대한 처리 */
            request.setCharacterEncoding("UTF-8");

            // 요청을 다음 필터나 서블릿으로 넘기는 역할
            chain.doFilter(request, response);

            /* 후처리 작업: doFilter()를 호출한 후에는 서블릿이나 다른 필터가 응답을 생성한 뒤 응답에 대한 처리를 수행할 수 있다. */
    }
}