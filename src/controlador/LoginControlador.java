package controlador;
import Ventanas.VentanaPrincipal;
import clases.Users;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class LoginControlador {
	
	public void visualizarPantalla() {
		VentanaPrincipal ven = new VentanaPrincipal(this);
		ven.setVisible(true);	
	}
	public boolean comprobarUsuario(Users users){
		return dao.comprobarUsuario(users);	
	}
	/*public boolean insertarUsuario(Usuario usuario) {
		return dao.insertarUsuario(usuario);
	}	
	
	public Map<String, Usuario> consultarUsuarios() {
		return dao.consultaUsuarios();
	}

	public boolean borrarUsuario(String nombre) {
		return dao.borrarUsuario(nombre);
	}*/

}