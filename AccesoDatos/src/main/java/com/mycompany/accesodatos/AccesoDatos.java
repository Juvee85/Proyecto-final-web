package com.mycompany.accesodatos;

import daos.MunicipioDAO;
import daos.UsuarioDAO;
import entidades.Municipio;
import entidades.Usuario;
import java.time.LocalDate;

/**
 *
 * @author juventino
 */
public class AccesoDatos {

    public static void main(String[] args) {
        // Initialize DAOs
        MunicipioDAO municipioDAO = MunicipioDAO.getInstance();
        UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();

        Municipio municipio = new Municipio();
        municipio.setNombre("Ciudad 1");
        // Create a Usuario object
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan Pérez");
        usuario.setCorreo("juan.perez@example.com");
        usuario.setContrasenha("password123");
        usuario.setTelefono("1234567890");
        usuario.setMunicipio(municipio);
        usuario.setUrlAvatar("uploads/avatar.jpg"); // Example URL
        usuario.setFechaNacimiento(LocalDate.of(1990, 5, 15));
        usuario.setGenero("Masculino");
        usuario.setEsAdmin(false);

        // Add the Usuario to the database
        usuarioDAO.agregarUsuario(usuario);

        System.out.println("Usuario agregado exitosamente.");
    }
}
