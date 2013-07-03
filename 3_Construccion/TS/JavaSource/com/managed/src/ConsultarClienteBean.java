package com.managed.src;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Query;
import org.primefaces.component.inputtext.InputText;

import com.main.resources.HibernateUtil;
import com.main.target.Cliente;

@ManagedBean
@RequestScoped
public class ConsultarClienteBean {
	private String nombre;
	private String apPaterno;
	
	private InputText itNombre;
	private InputText itApPaterno;
	
	private List<Cliente> clientes;
	
	public ConsultarClienteBean() {
		this.itNombre = new InputText();
		this.itApPaterno = new InputText();
		this.clientes = new ArrayList<Cliente>();
	}
	
	public String getApPaterno() {
		return apPaterno;
	}
	
	public InputText getItApPaterno() {
		return itApPaterno;
	}
	
	public InputText getItNombre() {
		return itNombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}
	
	public void setItApPaterno(InputText itApPaterno) {
		this.itApPaterno = itApPaterno;
	}
	
	public void setItNombre(InputText itNombre) {
		this.itNombre = itNombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Cliente> getClientes() {
		return clientes;
	}
	
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public void consulta()
	{
		if(this.nombre != "" || this.apPaterno != "")
		{
			Query query = null;
			if(this.nombre != "" && this.apPaterno != "")
			{
				//Busqueda Normal
				query = HibernateUtil.getSessionFactory().openSession().createQuery("from Cliente where nombre = :nombre and apellidoPaterno = :apPaterno");
				query.setParameter("nombre", this.nombre);
				query.setParameter("apPaterno", this.apPaterno);
			}
			else if(this.nombre != "" && this.apPaterno == "")
			{
				//Busqueda por Nombre
				query = HibernateUtil.getSessionFactory().openSession().createQuery("from Cliente where nombre = :nombre");
				query.setParameter("nombre", this.nombre);
			}
			else if(this.nombre == "" && this.apPaterno != "")
			{
				//Busqueda por Apellido
				query = HibernateUtil.getSessionFactory().openSession().createQuery("from Cliente where apellidoPaterno = :apPaterno");
				query.setParameter("apPaterno", this.apPaterno);
			}
			
			
			if(query.list().size() > 0)
			{
				this.clientes = (List<Cliente>)query.list();
			}
			else
			{
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,null,"El cliente no existe"));
			}
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,null,"Se necesita por lo menos un dato de busqueda"));
		}
	}
	
	public void limpia()
	{
		this.nombre = "";
		this.apPaterno = "";
		
		this.itNombre.clearInitialState();
		this.itApPaterno.clearInitialState();
		
		this.clientes.clear();
	}
}
