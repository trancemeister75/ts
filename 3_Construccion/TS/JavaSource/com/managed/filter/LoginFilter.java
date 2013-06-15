package com.managed.filter;

import java.io.IOException;

import javax.el.ELContext;
import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.managed.src.LoginBean;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		LoginBean loginBean = (LoginBean) req.getSession().getAttribute(
				"loginBean");
		HttpSession sesion = req.getSession();
		final String FLAG = "FLAG"; 
		// Proceso la URL que está requiriendo el cliente
				
		String urlStr = req.getRequestURL().toString().toLowerCase();
				boolean noProteger = noProteger(urlStr);
				System.out.println(urlStr + " - desprotegido=[" + noProteger + "]");

				// Si no requiere protección continúo normalmente.
				if (noProteger(urlStr)) {
					chain.doFilter(request, response);
					return;
				}
				
				// El usuario no está logueado
				if (loginBean == null || !loginBean.isLoggedIn()) {
					res.sendRedirect(req.getContextPath() + "/login.jsf");
					System.out.println("No logueado");
					return;
				}

				if(sesion.getAttribute(FLAG) == null)
				{
					// El recurso requiere protección, pero el usuario ya está logueado.
					
					System.out.println("Logueado");
					sesion.setAttribute(FLAG,"FLAG");
				}
				chain.doFilter(request, response);
				
	}
	
	private boolean noProteger(String urlStr) {
		/*
		 * Este es un buen lugar para colocar y programar todos los patrones que
		 * creamos convenientes para determinar cuales de los recursos no
		 * requieren protección. Sin duda que habría que crear un mecanizmo tal
		 * que se obtengan de un archivo de configuración o algo que no requiera
		 * compilación.
		 */
		if (urlStr.indexOf("/login.jsf") != -1)
			return true;
		if (urlStr.indexOf("/javax.faces.resource/") != -1)
			return true;
		return false;
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
