package com.angelt.springboot.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.angelt.springboot.apirest.models.entity.Cliente;
import com.angelt.springboot.apirest.models.entity.Region;

public interface IClienteDao extends JpaRepository<Cliente, Long>{
	
	/*Vamos a crear un método para las consultas de la regio´no en esta misma interfaz, ya que solo haremos una sola consulta. 
	 * Si tuvieramos más consultas o un crud completo para la región lo correcto es hacer otra interfaz IRegionDao por separado e inyectarla al servicio
	 */
	
	//Ahora debemos mapear este método a una consulta en JPA. mediante la anotación Query
	@Query("from Region") //Region hace referencia al nombre de la clase ya que trabajamos con objetos.
	public List<Region> findAllRegiones();

}
