package com.proyecto.integral.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.integral.model.entidad.Usuario;

public interface IUsuarioDAO extends CrudRepository<Usuario, Long>{
    public Usuario findByUsername(String username);
}
