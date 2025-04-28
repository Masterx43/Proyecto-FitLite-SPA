package com.example.login_service.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.login_service.Model.Cliente;

@Repository
public class ClienteRepository {
    private List<Cliente> listaClientes = new ArrayList<>();

    public List<Cliente> obtenerClientes() {
        return listaClientes;
    }

    public Cliente buscarClientePorId(int clienteId) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getClienteId() == clienteId) {
                return cliente;
            }
        }
        return null;
    }

    public Cliente agregarCliente(Cliente cliente) {
        listaClientes.add(cliente);
        return cliente;
    }

    public Cliente actualizarCliente(Cliente cliente) {
        int clienteId = 0;
        int idPosicionCliente = 0;

        for (int c = 0; c < listaClientes.size(); c++) {
            if (listaClientes.get(c).getClienteId() == cliente.getClienteId()) {
                clienteId = cliente.getClienteId();
                idPosicionCliente = c;
            }
        }

        Cliente cliente1 = new Cliente();
        cliente1.setClienteId(clienteId);
        cliente1.setPnombre(cliente.getPnombre());
        cliente1.setSnombre(cliente.getSnombre());
        cliente1.setAppaterno(cliente.getAppaterno());
        cliente1.setApmaterno(cliente.getApmaterno());
        cliente1.setEmail(cliente.getEmail());
        cliente1.setPassword(cliente.getPassword());
        cliente1.setTelefono(cliente.getTelefono());
        cliente1.setDireccion(cliente.getDireccion());
        cliente1.setFechaRegistro(cliente.getFechaRegistro());
        cliente1.setTelefonoCliente(cliente.getTelefonoCliente());
        cliente1.setDireccionCliente(cliente.getDireccionCliente());

        listaClientes.set(idPosicionCliente, cliente1);
        return cliente1;
    }

    public String eliminarCliente(int idCliente) {
        listaClientes.removeIf(x -> x.getClienteId() == idCliente);
        return "Cliente de id: " + idCliente + " eliminado.";
    }


}
