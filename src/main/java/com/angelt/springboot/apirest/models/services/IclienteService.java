package com.angelt.springboot.apirest.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.angelt.springboot.apirest.models.entity.Cliente;
import com.angelt.springboot.apirest.models.entity.Region;

public interface IclienteService {
	
	public List<Cliente> findAll();
	
	public Page<Cliente> findAll(Pageable pageable);
	
	public Cliente findById(Long id);
	
	public Cliente save(Cliente cliente);
	
	public void delete(Long id);
	
	public List<Region> findAllRegiones();
	
	// public List<Cliente> update(Cliente cliente, Long id);

}
