/**
 * Company: ALIBABA
 * Author： ZHOUZHIQIANG
 * FileName:LoginFilter
 * Time:2019/10/2110:14
 * Description:
 */
package filter;

import model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            String cpath = request.getContextPath();
            response.sendRedirect(cpath + "/login.jsp");
        } else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
}
