package com.proyecto.integral.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyecto.integral.model.entidad.Categoria;

@Service
public interface ICategoriaService {
    public void guardarCategoria(Categoria categoria);
    public List<Categoria> cargarCategorias();
    public Categoria buscarCategoria(Long id);
    public void eliminarCategoria(Long id);
}
