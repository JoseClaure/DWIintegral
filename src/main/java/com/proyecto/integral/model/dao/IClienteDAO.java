package com.proyecto.integral.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.integral.model.entidad.Cliente;

public interface IClienteDAO extends CrudRepository<Cliente,Long> {
    
}
