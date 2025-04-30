package com.example.login_service.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.login_service.model.Cliente;
import com.example.login_service.Repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getClientes() {
        return clienteRepository.obtenerClientes();
    }

    public Cliente getClientesById(int idCliente) {
        return clienteRepository.buscarClientePorId(idCliente);
    }

    public Cliente saveClientes(Cliente cliente) {
        return clienteRepository.agregarCliente(cliente);
    }

    public Cliente updateCliente(Cliente cliente) {
        return clienteRepository.actualizarCliente(cliente);
    }

    public String deleteCliente(int idCliente) {
        clienteRepository.eliminarCliente(idCliente);
        return "Cliente" + idCliente + "eliminado.";
    }

    //TODO: public boolean validateCliente() {}
}
