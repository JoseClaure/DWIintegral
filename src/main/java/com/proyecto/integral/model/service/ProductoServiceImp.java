package com.proyecto.integral.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.integral.model.dao.IProductoDAO;
import com.proyecto.integral.model.entidad.Producto;

@Service
public class ProductoServiceImp implements IProductoService{

    @Autowired
    private IProductoDAO productoDAO;

    @Override
    public String guardarProducto(Producto producto) {
        String rpta = "";
        try {
            productoDAO.save(producto);
            rpta = "Se guardo el producto correctamente";
        } catch (Exception e) {
            //En un sistema de produccion real para evitar dar mucha informacion
            //se evita usar e.toString() fuera de la etapa de desarrollo
            //se coloca un mensaje generico como: rpta = "Algo salió mal";
            rpta = e.toString();
        }
        return rpta;
    }

    @Override
    public List<Producto> cargarProductos() {
        return (List<Producto>)productoDAO.findAll();
    }

    @Override
    public String eliminarProducto(Long id) {
        String rpta="";
        try {
            productoDAO.deleteById(id);
            rpta = "Producto eliminado";
        } catch (Exception e) {
            rpta = e.getMessage();
        }
        return rpta;
    }

}
