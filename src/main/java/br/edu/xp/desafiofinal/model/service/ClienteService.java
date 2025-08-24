package br.edu.xp.desafiofinal.model.service;

import br.edu.xp.desafiofinal.model.entity.Cliente;
import br.edu.xp.desafiofinal.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente createClient(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente getClienteById(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElse(null);
    }

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente updateCliente(Long id, Cliente cliente) {
        Optional<Cliente> existing = clienteRepository.findById(id);
        if (existing.isPresent()) {
            Cliente toUpdate = existing.get();
            toUpdate.setNome(cliente.getNome());
            toUpdate.setUsuario(cliente.getUsuario());
            return clienteRepository.save(toUpdate);
        } else {
            return null;
        }
    }

    public boolean deleteCliente(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public long countClientes() {
        return clienteRepository.count();
    }

    public List<Cliente> findByNome(String nome) {
        return clienteRepository.findByNome(nome);
    }
}
