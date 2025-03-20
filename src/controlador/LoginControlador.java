package controlador;
import Ventanas.VentanaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class LoginControlador {
	
	public void visualizarPantalla() {
		VentanaPrincipal ven = new VentanaPrincipal();
		ven.setVisible(true);	
	}
	/*public boolean comprobarUsuario(Usuario usuario){
		return dao.comprobarUsuario(usuario);	
	}
	public boolean insertarUsuario(Usuario usuario) {
		return dao.insertarUsuario(usuario);
	}	
	
	public Map<String, Usuario> consultarUsuarios() {
		return dao.consultaUsuarios();
	}

	public boolean borrarUsuario(String nombre) {
		return dao.borrarUsuario(nombre);
	}*/

}