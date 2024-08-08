package com.proyecto.integral.model.service;

import java.util.List;

import com.proyecto.integral.model.entidad.Producto;

public interface IProductoService {
    public String guardarProducto(Producto producto);
    public List<Producto> cargarProductos();
    public String eliminarProducto(Long id);
}
