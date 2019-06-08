package com.ystu.web_first.servlets;

import com.ystu.web_first.Model.Data;
import com.ystu.web_first.Model.Order;
import com.ystu.web_first.spring.SpringConfigContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class HelloServlet extends HttpServlet {

    ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigContext.class);
    List<Long> ArrayIdPrd = new ArrayList<Long>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List list = context.getBean(List.class);
        req.setAttribute("list", list);

        Long id =  (Long) req.getSession().getAttribute("idUser");

        if (id == null) {
            resp.sendRedirect("login");
        }
        else {
            ArrayList<Order> or = new ArrayList<Order>();
            if (req.getSession().getAttribute("ArrayIdPrd2") == null){
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            }
            else{
                List<Long> CartAdd=  (List) req.getSession().getAttribute("ArrayIdPrd2");
                req.getSession().setAttribute("ArrayIdPrd2",CartAdd);
                long id2 = id;
                or.add(new Order(1,id2,12,CartAdd));
                Data.getInstance().setOrders(or);
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            }
        }
    }

   @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List list = context.getBean(List.class);
        req.setAttribute("list", list);

        ArrayList<Order> or = new ArrayList<Order>();
        List<Long> Cart = new ArrayList<Long>();

        Long id =  (Long) req.getSession().getAttribute("idUser");
        long id2 = id;

        Cart = Data.getInstance().getOrderByCustomer(id).getProducts();

        if (req.getSession().getAttribute("ArrayIdPrd2") == null && Cart.size()==0){
            List<Long> CartPust = new ArrayList<Long>();
            String name = req.getParameter("button");
            CartPust.add(Long.parseLong(name));
            req.getSession().setAttribute("ArrayIdPrd2",CartPust);
            Cart = CartPust;
        }
        else{
            if (req.getSession().getAttribute("ArrayIdPrd2") == null) {
                List<Long> CartAdd=Cart;
                String name = req.getParameter("button");
                CartAdd.add(Long.parseLong(name));
                req.getSession().setAttribute("ArrayIdPrd2",CartAdd);
                Cart = CartAdd;
            }
            else{
            List<Long> CartAdd=  (List) req.getSession().getAttribute("ArrayIdPrd2");
            String name = req.getParameter("button");
            CartAdd.add(Long.parseLong(name));
            req.getSession().setAttribute("ArrayIdPrd2",CartAdd);
            Cart = CartAdd;
            }
        }

        or.add(new Order(1,id2,12,Cart));
        Data.getInstance().setOrders(or);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

}
