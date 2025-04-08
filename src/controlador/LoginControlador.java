package controlador;
import Ventanas.VentanaPrincipal;
import java.awt.Component;
import java.util.Map;
import Modelo.Cases;
import Modelo.Criminals;
import Modelo.Implementacion;
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
	public Map<String, Cases> consultarUsuarios() {
		return dao.consultaUsuarios();
	}
	public boolean insertarCriminal(Criminals criminal) {
		return dao.insertarCriminal(criminal);
	}
	public boolean comprobarUsuario(Users users) {
		return dao.comprobarUsuario(users);
	}
	public Component getUsuario() {
		// TODO Auto-generated method stub
		return null;
	}
	
}