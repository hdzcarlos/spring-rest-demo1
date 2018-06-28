package com.chc.apirest.repository;

import com.chc.apirest.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuarioRepository  extends JpaRepository<Usuario, Long>{
}
