/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import names.Person;

/**
 *
 * @author Khandaa
 */
@WebServlet(urlPatterns = {"/RemoveNamesServlet"})
public class RemoveNamesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        if (request.getParameter("removeKey") != null) {
            if (session.getAttribute("names") == null)
                session.setAttribute("names", new HashMap());
            Map<String, Person> map = (Map<String, Person>) session.getAttribute("names");
            if(map.get(request.getParameter("removeKey")) != null) {
                map.remove(request.getParameter("removeKey"));
            }
        }
        response.sendRedirect("AllNamesServlet");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
