package com.managed.src;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Query;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.context.RequestContext;

import com.dao.impl.src.ClienteHibernateDAO;
import com.dao.src.ClienteDAO;
import com.main.resources.HibernateUtil;
import com.main.target.Cliente;
import com.main.target.Usuario;

@ManagedBean
@RequestScoped
public class RegistrarClienteBean {
	private String nombre;
	private String apPaterno;
	private String apMaterno;
	private String direccion;
	private String telefono;
	private String email;
	
	private InputText itNombre;
	private InputText itApPaterno;
	private InputText itApMaterno;
	private InputText itDireccion;
	private InputText itTelefono;
	private InputText itEmail;
	
	public RegistrarClienteBean() {
		itNombre = new InputText();
		itApPaterno = new InputText();
		itApMaterno = new InputText();
		itDireccion = new InputText();
		itTelefono = new InputText();
		itEmail = new InputText();
	}
	
	public String getApMaterno() {
		return apMaterno;
	}
	
	public String getApPaterno() {
		return apPaterno;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public String getEmail() {
		return email;
	}
	
	public InputText getItApMaterno() {
		return itApMaterno;
	}
	
	public InputText getItApPaterno() {
		return itApPaterno;
	}
	
	public InputText getItDireccion() {
		return itDireccion;
	}
	
	public InputText getItEmail() {
		return itEmail;
	}
	
	public InputText getItNombre() {
		return itNombre;
	}
	
	public InputText getItTelefono() {
		return itTelefono;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}
	
	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setItApMaterno(InputText itApMaterno) {
		this.itApMaterno = itApMaterno;
	}
	
	public void setItApPaterno(InputText itApPaterno) {
		this.itApPaterno = itApPaterno;
	}
	
	public void setItDireccion(InputText itDireccion) {
		this.itDireccion = itDireccion;
	}
	
	public void setItEmail(InputText itEmail) {
		this.itEmail = itEmail;
	}
	
	public void setItNombre(InputText itNombre) {
		this.itNombre = itNombre;
	}
	
	public void setItTelefono(InputText itTelefono) {
		this.itTelefono = itTelefono;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public void registra()
	{
		RequestContext context = RequestContext.getCurrentInstance();
		Cliente c = null;
		ClienteDAO cDAO = new ClienteHibernateDAO();
		
		if(this.nombre != "" && this.apPaterno != "" && this.apMaterno != "" && this.direccion != "" && this.telefono != "" && this.email != "")
		{
			c = new Cliente(generaIdCliente(this.nombre, this.apPaterno, this.apMaterno), this.nombre, this.apPaterno, this.apMaterno, this.direccion, this.telefono, this.email);
			Query query = HibernateUtil.getSessionFactory().openSession().createQuery("from Cliente where idCliente = :id and direccion = :dir");
			query.setParameter("id", c.getIdCliente());
			query.setParameter("dir", c.getDireccion());
			List<Cliente> clientes = query.list();
			System.out.println("Tamaño de lista: "+clientes.size());
			if(clientes.size() != 0){
				
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,null, "El cliente ya fue registrado"));
			}
			else
			{	
				cDAO.makePersistent(c);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null, "Registro Exitoso"));  
				limpia();
			}
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,null, "Los datos de registro estan incompletos"));  
		}
	}
	
	public void limpia()
	{
		this.nombre = "";
		this.apPaterno = "";
		this.apMaterno = "";
		this.direccion = "";
		this.telefono = "";
		this.email = "";
		
		this.itNombre.clearInitialState();
		this.itApPaterno.clearInitialState();
		this.itApMaterno.clearInitialState();
		this.itDireccion.clearInitialState();
		this.itTelefono.clearInitialState();
		this.itEmail.clearInitialState();
	}
	
	public String generaIdCliente(String nombre, String apPaterno, String apMaterno)
	{
		String id =  "";
		id = nombre.substring(0, 3)+apPaterno.substring(0,3)+apMaterno.substring(0,3)+nombre.length()+apPaterno.length()+apMaterno.length();
		return id;
	}
}

