package com.chc.apirest.web.rest;

import com.chc.apirest.entity.Usuario;
import com.chc.apirest.service.IGestionUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Definimos que esta clase es un rest controler que esta mapeada sobre la ruta /saludo.
 * ASi conseguimos que esta clase sea un servlet
 */
@RestController("/usuario")

public class UserResource {
    /**
     * recuperamos el saludo, con un metodo GET. Lo podemos llamar desde el navegador. Teniene que ser public para que exista el metodo
     * @return
     */
    //Con esta instancia no funcionaria bien spring porque estariamos creando un objeto por  cada maquina que hace uso del metodo, para ello se usa la inyeccion de dependencias.

   // IGestionUsuarios gestionUsuarios = new GestionUsuario();
    @Autowired
    @Qualifier("Gestion")

    IGestionUsuarios gestionUsuarios;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<String>>getUsuarios() {
        gestionUsuarios.listaNombre();
    return new ResponseEntity<>(gestionUsuarios.listaNombre(), HttpStatus.ACCEPTED);



   /* public String getUsuarios() {
        return "Hola Clase";*/
    }

    /**
     * Este metodo que es el post necesitamos un sitio donde enviar los datos , usaremos POSTMAN.
     * @param nombre
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public void crearUsuarios (@PathParam(value = "nombre") String nombre,
                               @PathParam(value = "surname")String surname) {
       gestionUsuarios.crearUsuarios(nombre,surname);

    }
    @RequestMapping(method = RequestMethod.PUT )
    public void actualizarUsuarios(@PathParam(value = "id") Long id){
        gestionUsuarios.actualizarUsuario(id);


    }
    @RequestMapping( method = RequestMethod.DELETE)
    public void deletUsuario(@PathParam(value = "id") Long id){
        gestionUsuarios.eliminarUsuario(id);

    }
}
