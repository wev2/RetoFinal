package controlador;
import Ventanas.VentanaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import Modelo.Criminals;
import Modelo.Implementacion;
import Modelo.UserDAO;
import Modelo.Users;

public class LoginControlador {
	Implementacion dao = new Implementacion();
	
	public void visualizarPantalla() {
		VentanaPrincipal ven = new VentanaPrincipal(this);
		ven.setVisible(true);	
	}
	public boolean comprobarCriminal(Criminals criminal){
		return dao.comprobarCriminal(criminal);	
	}
	public Map<String, Users> consultarUsuarios() {
		return dao.consultaUsuarios();
	}
	public boolean insertarCriminal(Criminals criminal) {
		return dao.insertarCriminal(criminal);
	}
	public boolean comprobarUsuario(Users users) {
		return dao.comprobarUsuario(users);
	}
}