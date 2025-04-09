package Modelo;

import java.util.Map;

public interface UserDAO {
	public boolean comprobarUsuario(Cases cases);
	public boolean comprobarCriminal(Criminals criminal);
	public boolean insertarCriminal(Criminals criminal);
	public Map<String, Cases> consultaUsuarios();
	
}

