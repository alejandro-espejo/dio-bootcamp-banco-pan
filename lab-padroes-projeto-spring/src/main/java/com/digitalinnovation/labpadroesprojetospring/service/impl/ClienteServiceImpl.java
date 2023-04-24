package com.digitalinnovation.labpadroesprojetospring.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalinnovation.labpadroesprojetospring.model.Cliente;
import com.digitalinnovation.labpadroesprojetospring.model.ClienteRepository;
import com.digitalinnovation.labpadroesprojetospring.model.Endereco;
import com.digitalinnovation.labpadroesprojetospring.model.EnderecoRepository;
import com.digitalinnovation.labpadroesprojetospring.service.ClienteService;
import com.digitalinnovation.labpadroesprojetospring.service.ViaCepService;

@Service
public class ClienteServiceImpl implements ClienteService {

	// Singleton: Inject the Spring components with @Autowired
	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private ViaCepService viaCepService;

	// Strategy: Implementar os métodos definidos na interface.
	// Facade: Abstrair integrações com subsistemas, provendo uma interface
	// simples.

	@Override
	public Iterable<Cliente> buscarTodos() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
		Optional<Cliente> opt = clienteRepository.findById(id);
		return opt.orElse(null);
	}

	@Override
	public void inserir(Cliente cliente) {
		salvarClienteComCep(cliente);
	}

	@Override
	public void atualizar(Long id, Cliente cliente) {
		// Buscar Cliente por ID, caso exista:
		Cliente clienteDb = buscarPorId(id);
		if (clienteDb != null) {
			salvarClienteComCep(cliente);
		}
	}

	@Override
	public void deletar(Long id) {
		clienteRepository.deleteById(id);
	}

	private void salvarClienteComCep(Cliente cliente) {
		// Verificar se o Endereco do Cliente já existe (pelo CEP).
		String cep = cliente.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			// Caso não exista, integrar com o ViaCEP e pesistir o retorno.
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			if (novoEndereco != null) {
				return enderecoRepository.save(novoEndereco);
			}
			throw new RuntimeException("Endereço não encontrado!");
		});
		cliente.setEndereco(endereco);
		// Inserir Cliente, vinculado o Endereco (novo ou existente).
		clienteRepository.save(cliente);
	}
}
