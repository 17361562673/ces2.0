/**
 * Company: ALIBABA
 * Author： ZHOUZHIQIANG
 * FileName:QuitServlet
 * Time:2019/10/2114:57
 * Description:
 */
package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class QuitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String cpath=req.getContextPath();
        //销毁session退出系统
        session.invalidate();
        resp.sendRedirect(cpath+"/login.jsp");
    }
}
