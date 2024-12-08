/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import convertidores.ConvertidorMunicipio;
import convertidores.ConvertidorUsuario;
import daos.MunicipioDAO;
import daos.UsuarioDAO;
import entidades.Municipio;
import entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.time.LocalDate;

/**
 *
 * @author juventino
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet("/registro")
public class RegistroServlet extends HttpServlet {

    private final UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
    private final MunicipioDAO municipioDAO = MunicipioDAO.getInstance();

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
        System.setProperty("java.io.tmpdir", "C:\\temp");
        String uploadPath = System.getProperty("java.io.tmpdir");
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String contrasenha = request.getParameter("contrasenha");
        String telefono = request.getParameter("telefono");
        String municipioNombre = request.getParameter("ciudad");
        LocalDate fechaNacimiento = LocalDate.parse(request.getParameter("fechaNacimiento"));
        String genero = request.getParameter("genero");

        String filePath = null;
        for (Part part : request.getParts()) {
            if (part.getSubmittedFileName() != null && !part.getSubmittedFileName().isEmpty()) {
                String fileName = part.getSubmittedFileName();
                filePath = uploadPath + File.separator + fileName;
                part.write(filePath);
            }
        }

        Municipio municipio = municipioDAO.obtenerMunicipioPorNombre(municipioNombre);

        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setCorreo(correo);
        usuario.setContrasenha(contrasenha);
        usuario.setTelefono(telefono);
        usuario.setUrlAvatar(filePath);
        usuario.setMunicipio(municipio);
        usuario.setFechaNacimiento(fechaNacimiento);
        usuario.setGenero(genero);
        usuario.setEsAdmin(false);

        usuarioDAO.agregarUsuario(usuario);

        usuario.setUrlAvatar(filePath);
        request.getAttribute("");

        getServletContext()
                .getRequestDispatcher("/principal.html")
                .forward(request, response);
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
