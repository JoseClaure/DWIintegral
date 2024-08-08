package com.proyecto.integral.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.integral.model.entidad.Producto;
import com.proyecto.integral.model.service.ICategoriaService;
import com.proyecto.integral.model.service.IProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ICategoriaService categoriaService;

    @Autowired
    private IProductoService productoService;

    @RequestMapping("/")
    public String inicio( Model model){
        Producto producto = new Producto();
        model.addAttribute("producto", producto);
        model.addAttribute("listaCategorias", categoriaService.cargarCategorias());
        model.addAttribute("listaProductos", productoService.cargarProductos());
        return "producto/inicio";
    }

    //El redirectAttributes nos ayuda a mandar de forma temporal el mensaje a la vista
    //Mediante su metodo addFlashAttribute
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid Producto producto, BindingResult result, Model model, RedirectAttributes flash){
        if(result.hasErrors()){ 
            model.addAttribute("listaCategorias", categoriaService.cargarCategorias());
            model.addAttribute("listaProductos", productoService.cargarProductos());
            return "producto/inicio";
        }
        String rpta = productoService.guardarProducto(producto);
        flash.addFlashAttribute("mensaje", rpta);
        return "redirect:/producto/";
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash){
        String rpta =productoService.eliminarProducto(id);
        flash.addFlashAttribute("mensaje", rpta);
        return "redirect:/producto/";
    }
}