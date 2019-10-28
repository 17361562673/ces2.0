/**
 * Company: ALIBABA
 * Author： ZHOUZHIQIANG
 * FileName:UpdateServlet
 * Time:2019/10/821:01
 * Description:
 */
package controller;

import model.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.UserService;
import service.serviceImple.UserServiceImple;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class UpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService service=new UserServiceImple();
        String user_id=null;
        String pic=null;
        String username=null;
        String password=null;
        String gender=null;
        String birthday=null;
        String address=null;
        String sal=null;
        DiskFileItemFactory itemFactory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(itemFactory);
        fileUpload.setSizeMax(1024*1024);
        try {
            List<String> cList=new ArrayList<>();
            cList.add(".jpg");
            cList.add(".png");
            cList.add(".gif");
            List<FileItem> list = fileUpload.parseRequest(req);
            for (FileItem item : list) {
                String name = item.getName();
                String fieldName = item.getFieldName();
                boolean formField = item.isFormField();
                if (formField&&fieldName!=null&&!"".equals(fieldName)) {
                    String content = item.getString();
                    content = new String(content.getBytes("ISO-8859-1"),"UTF-8" );
                    switch (fieldName) {
                        case "userId":user_id=content;break;
                        case "username":username=content;break;
                        case "pic":pic=content;break;
                        case "password":password=content;break;
                        case "gender":gender=content;break;
                        case "birthday":birthday=content;break;
                        case "address":address=content;break;
                        case "sal":sal=content;break;
                    }
                }
                if (!formField&&fieldName!=null&&!"".equals(fieldName)) {
                    String oPath = req.getSession().getServletContext().getRealPath("/upload/");
                    String uuid= UUID.randomUUID().toString();
                    if (name!=null&&!"".equals(name)) {
                        String oName = name.substring(name.indexOf("."));
                        if (cList.contains(oName)) {
                            String path = "/upload/" + uuid + oName;
                            pic = path;
                            File file = new File(oPath, uuid + oName);
                            item.write(file);
                        } else {
                            resp.getWriter().write("<font color='red'>文件格式不对请重新上传</font>");
                        }
                    }
                }
            }
            Integer useId=null;
            Integer genderInt=null;
            Date birthdayString=null;
            BigDecimal salInt=null;
            if (user_id != null) {
                useId=new Integer(user_id);
            }
            if (gender != null) {
                genderInt=new Integer(gender);
            }
            if (birthday != null) {
                birthdayString=new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
            }
            if (sal != null) {
                salInt=new BigDecimal(sal);
            }
            User user = new User();
            user.setUser_id(useId);
            user.setUsername(username);
            user.setPic(pic);
            user.setPassword(password);
            user.setGender(genderInt);
            user.setBirthday(birthdayString);
            user.setAddress(address);
            user.setSal(salInt);
            service.updateUser(user);
            resp.sendRedirect(req.getContextPath()+"/query");
        } catch (Exception e) {
            if (e instanceof FileUploadBase.SizeLimitExceededException) {
                resp.getWriter().write("<font color='red'>文件过大无法上传，请选择1MB大小的文件</font>");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
