package com.proyecto.integral.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.proyecto.integral.model.entidad.Categoria;

public interface ICategoriaDAO extends CrudRepository<Categoria,Long> {

    //Consultas admitidas por Spring, deben tener las iniciales en mayuscula para
    //implementar ciertas consultas predeterminadas
    public List<Categoria> findAllByOrderByNombre();
    public List<Categoria> findByNombre(String nombre);
    public List<Categoria> findByIdLessThan(Long id);

    //Consultas personalizadas pueden tener cualquier nombre y se debe usar datos
    //a nivel de la base de datos como nombres de tablas
    @Query(value = "SELECT * FROM categorias WHERE cat_nombre LIKE ?1", nativeQuery = true)
    public List<Categoria> busquedaPersonalizada(String nombre);
}