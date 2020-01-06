package com.deloitte.ecommerce.ui;

import com.deloitte.ecommerce.dao.Ewalletdaoimp;
import com.deloitte.ecommerce.entities.CustomerWallet;
import com.deloitte.ecommerce.service.EwalletService;
import com.deloitte.ecommerce.service.EwalletServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/first")
public class LoginCheckServlet extends HttpServlet {

    private EwalletService service = new EwalletServiceImp(new Ewalletdaoimp());

    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        String number = req.getParameter("number");
        String password = req.getParameter("password");
        boolean correct =false;
        CustomerWallet c = service.getUserByUsername(number);
        if(c!= null) {
            if ( c.getPassword().equals(password)) {
                correct = true;
            }
        }
        if(correct) {
            HttpSession session = req.getSession();
            session.setAttribute("number", number);
            resp.sendRedirect("/second");
        }
        else
        {
            resp.sendRedirect("html/form.html");
        }
    }
}
