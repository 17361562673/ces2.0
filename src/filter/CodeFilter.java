/**
 * Company: ALIBABA
 * Author： ZHOUZHIQIANG
 * FileName:CodeFilter
 * Time:2019/10/1815:54
 * Description:
 */
package filter;

import com.mysql.jdbc.StringUtils;

import javax.servlet.*;
import java.io.IOException;

public class CodeFilter implements Filter {
    private String encode;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String codeFilter = filterConfig.getInitParameter("codeFilter");
        if (null!=codeFilter && !"".equals(codeFilter)) {
            this.encode=codeFilter.trim();
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(this.encode);
        servletResponse.setCharacterEncoding(this.encode);
        servletResponse.setContentType("text/html;charset="+this.encode);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
