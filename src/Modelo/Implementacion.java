package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	final String sql1 = "SELECT * FROM users WHERE ID = ?";
	final String sql2 = "SELECT * FROM criminals WHERE DNI = ?";
	final String sqlInsert = "INSERT INTO criminals VALUES 	(?,?,?,?,?,?)";
	final String SQLCONSULTA = "SELECT * FROM users";
	final String SQLBORRAR = "DELETE FROM criminals WHERE DNI=?";
	final String SQLMODIFICAR = "UPDATE criminals SET NAME_CRIMINAL = ?, SURNAME_CRIMINAL = ?, EDAD = ?, DESCRIPTION_CRIMINAL = ?, CRIMES = ? WHERE DNI = ?";

	// Para la conexi n utilizamos un fichero de configuaraci n, config que
	// guardamos en el paquete control:
	public Implementacion() {
		this.configFile = ResourceBundle.getBundle("modelo.configClase");
		this.driverBD = this.configFile.getString("Driver");
		this.urlBD = this.configFile.getString("Conn");
		this.userBD = this.configFile.getString("DBUser");
		this.passwordBD = this.configFile.getString("DBPass");
	}

	private void openConnection() {
		try {
			con = DriverManager.getConnection(urlBD, this.userBD, this.passwordBD);
		} catch (SQLException e) {
			System.out.println("Error al intentar abrir la BD");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean comprobarUsuario(Users user) {
		// Abrimos la conexion
		boolean existe = false;
		this.openConnection();
		try {
			stmt = con.prepareStatement(SQL);
			stmt.setString(1, user.getName_users());
			stmt.setString(2, user.getPassword());
			ResultSet resultado = stmt.executeQuery();
			// Si hay un resultado, el usuario existe
			if (resultado.next()) {
				existe = true;
			}
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
			System.out.println("Error al verificar credenciales: " + e.getMessage());
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
				System.out.println("Error al verificar credenciales: " + e.getMessage());
			}
		}
		return ok;

	}

	public boolean actualizarUsuario(Users user) {
		// TODO Auto-generated method stub
		boolean ok = false;

		this.openConnection();
		try {
			// Preparamos la sentencia stmt con la conexion y sentencia sql correspondiente

			stmt = con.prepareStatement(SQLMODIFICAR);
			stmt.setString(2, user.getName());
			stmt.setString(1, user.getPassword());
			if (stmt.executeUpdate() > 0) {
				ok = true;
			}

			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al verificar credenciales: " + e.getMessage());
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
				user = new Users(SQL, SQL);
				user.setName(rs.getString("nombre"));
				user.setPassword(rs.getString("contrasena"));
				equipos.put(user.getName(), user);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		}
		return equipos;
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