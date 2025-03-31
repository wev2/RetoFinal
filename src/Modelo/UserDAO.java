package Modelo;

import java.util.Map;

public interface UserDAO {
public boolean comprobarUsuario(Users user);
public boolean insertarUsuario(Users user);
public boolean actualizarUsuario(Users user);
}

