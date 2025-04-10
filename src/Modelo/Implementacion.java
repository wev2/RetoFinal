package Modelo;

import java.sql.*;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class Implementacion {
	// Atributos
	private Connection con;
	private PreparedStatement stmt;

	// Los siguientes atributos se utilizan para recoger los valores del fich de
	// configuraci n
	private ResourceBundle configFile;
	private String driverBD;
	private String urlBD;
	private String userBD;
	private String passwordBD;

	// Sentencias SQL
	final String SQL = "SELECT * FROM users WHERE Nam_USERS = ? AND passwords = ?";
	final String SQL_INSERT = "INSERT INTO users VALUES (?, ?, ?, ?, ?, ?)";
	final String SQL_SELECT_BY_ID = "SELECT * FROM users WHERE ID = ?";
	final String SQL_SELECT_ALL = "SELECT * FROM users";
	final String SQL_DELETE = "DELETE FROM users WHERE Nam_USERS=?";
	final String SQL_UPDATE = "UPDATE users SET passwords=? WHERE Nam_USERS=?";

	public Implementacion() {
		this.configFile = ResourceBundle.getBundle("modelo.configClase");
		this.driverBD = this.configFile.getString("Driver");
		this.urlBD = this.configFile.getString("Conn");
		this.userBD = this.configFile.getString("DBUser");
		this.passwordBD = this.configFile.getString("DBPass");
	}

	private void openConnection() {
		try {
			con = DriverManager.getConnection(urlBD, userBD, passwordBD);
		} catch (SQLException e) {
			System.out.println("Error al intentar abrir la BD");
			e.printStackTrace();
		}
	}

	public boolean comprobarUsuario(Users user) {
		boolean existe = false;
		openConnection();
		try {
			stmt = con.prepareStatement(SQL);
			stmt.setString(1, user.getName_users());
			stmt.setString(2, user.getPassword());
			ResultSet resultado = stmt.executeQuery();
			existe = resultado.next();
			resultado.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al verificar credenciales: " + e.getMessage());
		}
		return existe;
	}

	public boolean comprobarCriminal(Criminals criminals) {
		// Abrimos la conexion
		boolean yaexiste = false;
		this.openConnection();

		try {
			stmt = con.prepareStatement(sql2);
			stmt.setString(1, criminals.getDni());
			ResultSet resultado = stmt.executeQuery();

			// Si hay un resultado, el usuario existe
			if (resultado.next()) {
				yaexiste = true;
			}

			resultado.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al verificar criminal: " + e.getMessage());
		}

		return yaexiste;
	}

	public boolean insertarCriminal(Criminals criminals) {
		// TODO Auto-generated method stub
		boolean ok = false;	
		if (!comprobarCriminal(criminals)) {
			this.openConnection();
			try {
				// Preparamos la sentencia stmt con la conexion y sentencia sql correspondiente

				stmt = con.prepareStatement(sqlInsert);
				stmt.setString(1, criminals.getDni());
				stmt.setString(2, criminals.getCri_name());
				stmt.setString(3, criminals.getCri_surname());
				stmt.setInt(4, criminals.getAge());
				stmt.setString(5, criminals.getCri_decription());
				stmt.setString(6, criminals.getCrimes());
				if (stmt.executeUpdate() > 0) {
					ok = true;
				}
				stmt.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al insertar criminal: " + e.getMessage());
			}
		}
		return ok;
	}

	public boolean actualizarUsuario(Users user) {
		// TODO Auto-generated method stub
		boolean ok = false;
		openConnection();
		try {
			// Preparamos la sentencia stmt con la conexion y sentencia sql correspondiente

			stmt = con.prepareStatement(SQLMODIFICAR);
			stmt.setString(2, user.getName());
			stmt.setString(1, user.getPassword());
			stmt.setString(2, user.getName());
			ok = stmt.executeUpdate() > 0;
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al actualizar usuario: " + e.getMessage());
		}
		return ok;
	}

	public Map<String, Users> consultaUsuarios() {
		// TODO Auto-generated method stub

		ResultSet rs = null;
		Users user;
		Map<String, Users> equipos = new TreeMap<>();

		// Abrimos la conexi n
		this.openConnection();

		try {
			stmt = con.prepareStatement(SQLCONSULTA);

			rs = stmt.executeQuery();

			// Leemos de uno en uno
			while (rs.next()) {
				Users user = new Users(rs.getString("name_users"), rs.getString("password"));
				usuarios.put(user.getName(), user);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al consultar usuarios: " + e.getMessage());
		}
		return usuarios;
	}

	public boolean DeleteCriminal(Criminals criminals) {
		// TODO Auto-generated method stub
		boolean ok = false;	
		if (comprobarCriminal(criminals)) {
			this.openConnection();
			try {
				// Preparamos la sentencia stmt con la conexion y sentencia sql correspondiente

				stmt = con.prepareStatement(SQLBORRAR);
				stmt.setString(1, criminals.getDni());
				if (stmt.executeUpdate() > 0) {
					ok = true;
				}

				stmt.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al verificar credenciales: " + e.getMessage());
			}

		}
		return ok;
	}
	
	public boolean ModifyCriminal(Criminals criminals) {
		// TODO Auto-generated method stub
		boolean ok = false;	
		if (comprobarCriminal(criminals)) {
			this.openConnection();
			try {
				// Preparamos la sentencia stmt con la conexion y sentencia sql correspondiente

				stmt = con.prepareStatement(SQLMODIFICAR);
				stmt.setString(1, criminals.getDni());
				stmt.setString(2, criminals.getCri_name());
				stmt.setString(3, criminals.getCri_surname());
				stmt.setInt(4, criminals.getAge());
				stmt.setString(5, criminals.getCri_decription());
				stmt.setString(6, criminals.getCrimes());
				if (stmt.executeUpdate() > 0) {
					ok = true;
				}

				stmt.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al verificar credenciales: " + e.getMessage());
			}

		}
		return ok;
	}
}
