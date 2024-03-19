package com.angelt.springboot.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.angelt.springboot.apirest.models.dao.IClienteDao;
import com.angelt.springboot.apirest.models.entity.Cliente;
import com.angelt.springboot.apirest.models.entity.Region;

@Service
public class ClienteServiceImpl implements IclienteService {

	@Autowired
	private IClienteDao clienteDao;

	@Override
	@Transactional(readOnly = true) // Se puede omitir ya que viene implementada desde el repositorio dao
	public List<Cliente> findAll() {

		return (List<Cliente>) clienteDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Cliente> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return clienteDao.findAll(pageable);
	}

	@Override
	public Cliente findById(Long id) {

		return  clienteDao.findById(id).orElse(null); // El metodo findById Retorna un optional, por tanto debemos agregar otros resultado por si no se encuentra el id.
	}

	@Override
	public Cliente save(Cliente cliente) {
	
		return clienteDao.save(cliente);
	}

	@Override
	public void delete(Long id) {
		clienteDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Region> findAllRegiones() {
		
		return clienteDao.findAllRegiones();
	}

}
