/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.CommandeCRUD;
import DAO.OptionCRUD;
import Models.Commande;
import Models.Option;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AK
 */
public class CommandeServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
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
         CommandeCRUD comObject = new CommandeCRUD();
                int id = Integer.parseInt(request.getParameter("idc"));
                comObject.delete(id);
                request.setAttribute("success", "La demande a ete bien supprimer");
            request.getRequestDispatcher("admin/demandes.jsp").forward(request, response);
   
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
        
            HttpSession session = request.getSession(true);
        String email = ( String) session.getAttribute("email");
        int uid = (int)session.getAttribute("id");
            if(email == null){
                request.getRequestDispatcher("/login.jsp").forward(request, response);

            }else{

         
        String nom = request.getParameter("name");
        String details = request.getParameter("details");
        double prix = Double.parseDouble(request.getParameter("prix"));
        OptionCRUD opc = new OptionCRUD();
        int[] selected_options = new int[100];
        int i = 0;
        List<Option> options = opc.getOptionsByService(Integer.parseInt(request.getParameter("service_id")));
        for(Option o : options){
           if(request.getParameter("op_"+o.getId_op()) != null){
               selected_options[i] = o.getId_op();
               i++;
           }
        }
        String cdc = request.getParameter("cdc");
        Calendar cal = Calendar.getInstance();
        String today = cal.get(Calendar.DATE) + "-" + (cal.get(Calendar.MONTH)+1)+"-" + cal.get(Calendar.YEAR)+" " +cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE);
        Commande com = new Commande();
        com.setNom_c(nom);
        com.setDetails(details);
        com.setCdc(cdc);
        com.setDate(today);
        com.setPrix(prix);
        com.setUser_id(uid);
        CommandeCRUD commandeObj = new CommandeCRUD();
        commandeObj.addCommande(com , selected_options);
         request.setAttribute("msg", "Votre commande a ete envoyeé");
        request.getRequestDispatcher("/solution.jsp?id_serv="+request.getParameter("service_id")).forward(request, response);
        
            }
        
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
