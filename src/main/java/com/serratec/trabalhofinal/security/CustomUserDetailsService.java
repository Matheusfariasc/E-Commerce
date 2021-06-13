package com.serratec.trabalhofinal.security;

import java.util.Optional;
import java.util.function.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.serratec.trabalhofinal.model.Cliente;
import com.serratec.trabalhofinal.repository.ClienteRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private ClienteRepository repositorioCliente;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Cliente cliente = getUser(() -> repositorioCliente.findByEmail(email));
		return cliente;
	}
	
	public UserDetails encontrarUsuarioPeloId(Integer id) {
		
		Cliente cliente = getUser(() -> repositorioCliente.findById(id));
		return cliente;
	}
	
	private Cliente getUser(Supplier<Optional<Cliente>> supplier) {
		return supplier.get().orElseThrow(() ->
				new UsernameNotFoundException("Cliente não encontrado."));
	}

}
