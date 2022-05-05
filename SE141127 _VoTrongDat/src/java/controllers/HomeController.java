//SE141127 Vo Trong Dat
package controllers;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Employee;
import models.EmployeeFacade;
@WebServlet(name = "HomeController", urlPatterns = {"/home"})
public class HomeController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getAttribute("action").toString();
        switch (action) {
            case "index":
                index(request, response);
                break;
            case "create":
                create(request, response);
                break;
            case "insert":
                insert(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
            case "update":
                update(request, response);
                break;
            case "confirm":
                confirm(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            default:
                request.setAttribute("action", "error");
        }
        request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
    }

    private void index(HttpServletRequest request, HttpServletResponse response) {
        EmployeeFacade pf = new EmployeeFacade();
        List<Employee> list = pf.readAll();
        request.setAttribute("list", list);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        Employee employee = new Employee();
        request.setAttribute("employee", employee);
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        System.out.println("aaaaaaaa"+id);
        EmployeeFacade pf = new EmployeeFacade();
        Employee employee = pf.read(id);
        request.setAttribute("employee", employee);
    }

    private void insert(HttpServletRequest request, HttpServletResponse response) {
        Employee employee = null;
        String op = request.getParameter("op");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        
        System.out.println(name);
        String sprice = request.getParameter("salary");
        String sexpDate = request.getParameter("DOB");
        request.setAttribute("id", id);
        request.setAttribute("name", name);
        request.setAttribute("salary", sprice);
        request.setAttribute("DOB", sexpDate);
        try {
            if (op.equals("update")) {
                BigDecimal price = new BigDecimal(sprice);
                Date expDate = new SimpleDateFormat("yyyy-MM-dd").parse(sexpDate);
                employee = new Employee(id, name, price, expDate);
                EmployeeFacade pf = new EmployeeFacade();
                pf.create(employee); 
            }
            index(request, response);
            request.setAttribute("action", "index");
        } catch (Exception ex) {
            request.setAttribute("action", "create");
            String msg = ex.getMessage();
            if (msg == null) {
                msg = "";
            }
            request.setAttribute("errorMessage", "Error when inserting this employee. <br/>" + msg);
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        try {
            String op = request.getParameter("op");
            if (op.equals("update")) {
                String id = request.getParameter("id");
                System.out.println("bbbb"+id);
                String name = request.getParameter("name");
                BigDecimal price = new BigDecimal(request.getParameter("salary"));
                Date expDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("DOB"));
                Employee employee = new Employee(id, name, price, expDate);
                EmployeeFacade pf = new EmployeeFacade();
                pf.update(employee);
            }
            index(request, response);
            request.setAttribute("action", "index");
        } catch (Exception ex) {
            request.setAttribute("action", "create");
            String msg = ex.getMessage();
            if (msg == null) {
                msg = "";
            }
            request.setAttribute("errorMessage", "Error when inserting this employee. <br/>" + msg);
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void confirm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        request.setAttribute("id", id);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        try {
            String op = request.getParameter("op");
            if (op.equals("yes")) {
                String id = request.getParameter("id");
                EmployeeFacade pf = new EmployeeFacade();
                pf.delete(id);
            }
            //hien lai view index
            index(request, response);
            request.setAttribute("action", "index");
        } catch (Exception ex) {
            request.setAttribute("action", "confirm");
            String msg = ex.getMessage();
            if (msg == null) {
                msg = "";
            }
            request.setAttribute("errorMessage", "Error when inserting this employee. <br/>" + msg);
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
