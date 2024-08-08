package com.proyecto.integral.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.integral.model.dao.ICategoriaDAO;
import com.proyecto.integral.model.entidad.Categoria;

@Service
public class CategoriaServiceImp implements ICategoriaService {

    //Autowired porque esta hecho con inyeccion de dependencias 
    @Autowired
    private ICategoriaDAO categoriaDAO;

    @Override
    public void guardarCategoria(Categoria categoria) {
        categoriaDAO.save(categoria);
    }

    @Override
    public List<Categoria> cargarCategorias() {
        //se utiliza el metodo findAll que ya esta incluido en el crudrepository
        return (List<Categoria>)categoriaDAO.findAll();
        //return (List<Categoria>)categoriaDAO.findAllByOrderByNombre();
        //return (List<Categoria>)categoriaDAO.findByNombre("Licores");
        //return (List<Categoria>)categoriaDAO.findByIdLessThan(5L);
        //return (List<Categoria>)categoriaDAO.busquedaPersonalizada("A%");
    }

    @Override
    public Categoria buscarCategoria(Long id) {
        return categoriaDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarCategoria(Long id) {
        categoriaDAO.deleteById(id);
    }
}