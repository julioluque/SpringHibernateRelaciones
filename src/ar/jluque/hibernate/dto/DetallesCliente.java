package ar.jluque.hibernate.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalles_cliente")
public class DetallesCliente {

	@Id
	@Column(name = "DET_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "DET_WEB")
	private String web;

	@Column(name = "DET_TELEFONO")
	private String telefono;

	@Column(name = "DET_COMENTARIOS")
	private String comentarios;

	@OneToOne(mappedBy="detallesCliente", cascade=CascadeType.ALL)
	@JoinColumn(name = "DET_ID")
	private Cliente cliente;

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public DetallesCliente() {
		// TODO Auto-generated constructor stub
	}

	public DetallesCliente(String web, String telefono, String comentarios) {
		this.web = web;
		this.telefono = telefono;
		this.comentarios = comentarios;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public String toString() {
		return "Detalles [id=" + id + ", web=" + web + ", telefono=" + telefono + ", comentarios=" + comentarios + "]";
	}

}
