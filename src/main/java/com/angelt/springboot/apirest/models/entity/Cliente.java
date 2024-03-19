package com.angelt.springboot.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="clientes") //si tienee el mismo nombre de la clase se puede omitir, en este caso no porque es plural
public class Cliente implements Serializable{
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	//@Column(name=nombre)  Cuando las columnas tienen el mismo nombre se puede omitir
	@NotEmpty(message = "no puede estar vacío")
	@Size(min = 4, max = 20, message = "el tamaño tiene que estar entre 4 y 12")
	@Column(nullable = false)
	private String nombre;
	
	@NotEmpty(message = "no puede estar vacío")
	private String apellido;
	
	
	@Column(nullable = false, unique = false) //unique debe ser true, este false es solo de prueba para que deje insertar datois duplicados en email
	@NotEmpty(message = "no puede estar vacío")
	@Email(message = "no es una dirección de correo electrónico válida.")
	private String email;
	
	@NotNull(message = "No puede estar vacio")
	@Temporal(TemporalType.DATE) //Indica que la propiedad de fecha debe mapearse como una fecha  (día, mes y año) sin incluir la información de la hora y la zona horaria
	private Date fecha;
	
	private String foto;
	
	@NotNull(message = "La region no puede estar vacia")
	@ManyToOne(fetch=FetchType.LAZY) // Averiguar anti patrón open in view,  y podría quitar el LAZY Ya que utiliza este patrón-
	//Fetch es obtener o busar, en este caso obitene datos de una bd.  lazy es un tipo de busqueda para obtener dichos datos o un tipo de carga
	// Otra alternativa es utilizar JOIN FETCH o EAGER
	@JoinColumn(name="region_id") //Este @JoinColumn se puede omitir y funciona iguall, ya que por defecto toma el campo de llave id(region_id en este caso)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	// Cuando mapeamos el LAZY, De forma automática trae otros atributos y los envía al json, con esta anotación decimos que los ignore.
	private Region region;

	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	//@PrePersist   Este metodo ccrea una nueva fecha en la BD  de forma automática Cada vez que se envíe un nuevo registro. con la anotaciín @PrePersist
	//lo comentmos porque vamos a tabajar esta parte desde el frontend
	public void prePersist(){ 
		fecha = new Date();
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	private static final long serialVersionUID = 1L;

}
