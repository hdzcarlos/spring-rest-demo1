package com.chc.apirest.service;

import com.chc.apirest.entity.Usuario;
import com.chc.apirest.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("Gestion")
public class GestionUsuario implements IGestionUsuarios {
@Autowired

    IUsuarioRepository usuarioRepository;
    /**
     * Metodo que nos muestra y almacena una lista de usuarios.
     * @return
     */
    @Override
    public List<String> listaNombre() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<String> nombres = new ArrayList<>();
        for (Usuario u : usuarios){
            nombres.add(u.getNombre());
        }
       return nombres;
        /**
         * Lambda que convierte una lista de usuarios a una lista de String
         */
     /*   return usuarioRepository.findAll()
                .stream()
                .map(usuario -> usuario.getNombre())
                .collect(Collectors.toList());
*/
 /*       List<String> listaNombres = new ArrayList<>();
        return listaNombres;
        // Convertir un array en una lista
    return Arrays.asList(new String[]{"Gustavo", "Carlos", "Miguel", "Oscar", "Pedro"});*/
    }

    /**
     * Creamos un usuario.
     * Le asignamos un nombre.
     * Con la interfaz @usuarioRepository.saveAndFlush(usuario) almacenamos el usuario en base de datos
     * @param nombre
     * @return
     */
    @Override
    public boolean crearUsuarios(String nombre, String surname) {
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellidos(surname);
        usuarioRepository.saveAndFlush(usuario);
        return true;
    }
    @Override
    public boolean actualizarUsuario(Long id) {
      Optional<Usuario> user = usuarioRepository.findById(id);
      if(user.isPresent()) usuarioRepository.save(user.get());
      return true;
    }
    @Override
    public boolean eliminarUsuario(Long id) {

        usuarioRepository.findById(id);
        usuarioRepository.deleteById(id);
        return true;
    }
}
