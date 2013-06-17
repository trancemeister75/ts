package com.managed.src;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.context.RequestContext;

/*import com.dao.impl.src.DatosUsuarioDAOHibernate;
import com.dao.impl.src.UsuarioDAOHibernate;
import com.dao.src.DatosUsuarioDAO;
import com.dao.src.UsuarioDAO;
import com.main.resources.HibernateUtil;
import com.main.target.DatosUsuario;
import com.main.target.Usuario;*/

@ManagedBean
@RequestScoped
public class RegistrarUsuarioBean {
	private String idUsuario;
	private String password;
	private String nombre;
	private String apPaterno;
	private String apMaterno;
	private String direccion;
	private String telefono;
	private String EMail;
	private InputText itIdUsuario;
	private InputText itPassword;
	private InputText itNombre;
	private InputText itApPaterno;
	private InputText itApMaterno;
	private InputText itDireccion;
	private InputText itTelefono;
	private InputText itEMail;
	
	
	public RegistrarUsuarioBean() {
		itIdUsuario = new InputText();
		itPassword = new InputText();
		itNombre = new InputText();
		itApPaterno = new InputText();
		itApMaterno = new InputText();
		itDireccion = new InputText();
		itTelefono = new InputText();
		itEMail = new InputText();
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
	
	public InputText getItEMail() {
		return itEMail;
	}
	
	public InputText getItIdUsuario() {
		return itIdUsuario;
	}
	
	public InputText getItNombre() {
		return itNombre;
	}
	
	public InputText getItPassword() {
		return itPassword;
	}
	
	public InputText getItTelefono() {
		return itTelefono;
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
	
	public void setItEMail(InputText itEMail) {
		this.itEMail = itEMail;
	}
	
	public void setItIdUsuario(InputText itIdUsuario) {
		this.itIdUsuario = itIdUsuario;
	}
	
	public void setItNombre(InputText itNombre) {
		this.itNombre = itNombre;
	}
	
	public void setItPassword(InputText itPassword) {
		this.itPassword = itPassword;
	}
	
	public void setItTelefono(InputText itTelefono) {
		this.itTelefono = itTelefono;
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
	
	public String getEMail() {
		return EMail;
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
	
	public void setEMail(String eMail) {
		EMail = eMail;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public void registraUsuario()
	{
		RequestContext context = RequestContext.getCurrentInstance();
		boolean registro = false;
		boolean existe = false;
		//Usuario u = null;
		//DatosUsuario du = null;
		//UsuarioDAO uDAO = new UsuarioDAOHibernate();
		//DatosUsuarioDAO duDAO = new DatosUsuarioDAOHibernate();
		if(this.nombre != "" && this.apPaterno != "" && this.apMaterno != "" && this.direccion != "" && this.telefono != "" && this.EMail != "" && this.idUsuario != "")
		{
			
			//Se crea el usuario
			//u = new Usuario(this.idUsuario,this.nombre+" "+this.apPaterno+" "+this.apMaterno,1,this.password);
			//Se crean los datos completos del usuario
			//du = new DatosUsuario(u, this.nombre, this.apPaterno, this.apMaterno, this.direccion, this.telefono, this.EMail, new Date()); 
			//Query query = HibernateUtil.getSessionFactory().openSession().createQuery("from Usuario where idUsuario = :user ");
			//query.setParameter("user", u.getIdUsuario());
			//List<Usuario> usuarios = query.list();
			//System.out.println("Tamaño de lista: "+usuarios.size());
			//if(usuarios.size() != 0){
				//registro = false;
				//addError();
			//}
			//else
			//{
				//Se persisten los objetos Usuario y Datos Usuario
				//uDAO.makePersistent(u);
				//duDAO.makePersistent(du);
				//registro = true;
				//limpiaDialogRegistro();
			//}
			registro = true;
		}
		else
		{
			registro = false;
		}
		context.addCallbackParam("loggedIn", registro);
	}
	
	public void addError() {  
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,null, "El usuario ya existe"));  
    }  
	
	public void limpiaDialogRegistro() {
		this.idUsuario = "";
		this.password = "";
		this.nombre = "";
		this.apPaterno = "";
		this.apMaterno = "";
		this.direccion = "";
		this.telefono = "";
		this.EMail = "";
		
		itIdUsuario.clearInitialState();
		itPassword.clearInitialState();
		itNombre.clearInitialState();
		itApPaterno.clearInitialState();
		itApMaterno.clearInitialState();
		itDireccion.clearInitialState();
		itTelefono.clearInitialState();
		itEMail.clearInitialState();
	}
}
