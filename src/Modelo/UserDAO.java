	package Modelo;

import java.util.Map;

public interface UserDAO {
	public boolean comprobarUsuario(Users user);
	public boolean comprobarCriminal(Criminals criminal);
	public boolean insertarCriminal(Criminals criminal);
}