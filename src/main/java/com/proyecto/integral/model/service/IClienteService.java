package com.proyecto.integral.model.service;

import java.util.List;

import com.proyecto.integral.model.entidad.Cliente;

public interface IClienteService {
    public void guardarCliente(Cliente cliente);
    public List<Cliente> cargarClientes();
    public Cliente buscarCliente(Long id);
    public void eliminarCliente(Long id);
}
