package com.ystu.web_first.servlets;
import com.ystu.web_first.Model.Data;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccountsServlet extends HttpServlet {

    Long IdCust = null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nameLog = req.getParameter("login");
        String pass = req.getParameter("pass");
        IdCust = Data.getInstance().getIdCustomerByLogPas(nameLog,pass);

        Long id =  (Long) req.getSession().getAttribute("idUser");
        if (id != null) {
            resp.sendRedirect("hello");
        }
        else {
            if (!Data.getInstance().getLogin(nameLog, pass)) {
                req.getSession().setAttribute("idUser",IdCust);
                req.getSession().setAttribute("name",nameLog);
                getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
            }
            else {
                if (nameLog != null && pass != null){
                    req.setAttribute("msgAut","Данные введены неверно! Повторите попытку!");
                }
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Message;
        String nameLog = req.getParameter("loginReg");
        String pass = req.getParameter("passReg");
        String email = req.getParameter("emailReg");
        long id = Data.getInstance().getSizeCustomers();

        if(nameLog != "" && pass !="" && email != ""){
            id++;
            Message = Data.getInstance().addCustomers(id,nameLog,pass,email);
            req.setAttribute("msgReg",Message);
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
        else{
            req.setAttribute("msgReg","Заполните все поля!");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

}
