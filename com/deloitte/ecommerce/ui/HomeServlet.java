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
import java.io.PrintWriter;

@WebServlet("/second")
public class HomeServlet extends HttpServlet {

    private EwalletService service = new EwalletServiceImp(new Ewalletdaoimp());

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession();
        String signedOutVal = req.getParameter("signout");
        boolean sessionDestroyed = false;
        if (signedOutVal != null && signedOutVal.equals("true")) {
            session.invalidate();
            sessionDestroyed = true;
        }
        Object numberObj = null;
        if (!sessionDestroyed) {
            numberObj = session.getAttribute("number");
        }

        if (numberObj == null || numberObj.toString().isEmpty()) {
            resp.getWriter().println("you are not signed in yet");
            String signInLink = "<a href='/html/form.html'>Sign In </a> ";
            writer.println(signInLink);
            return;
        }
        String username = numberObj.toString();

        writer.println("Welcome " + username);
        String signoutLink = "<a href='/second?signout=true'>Sign out </a> ";
        writer.println(signoutLink);

    }


}
