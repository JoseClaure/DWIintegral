package com.proyecto.integral.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.integral.model.entidad.Producto;

public interface IProductoDAO extends CrudRepository<Producto,Long> {
    
}
