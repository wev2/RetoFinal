package Modelo;

import java.sql.*;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class Implementacion {

	private Connection con;
	private PreparedStatement stmt;

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

	public boolean comprobarCriminal(Criminals criminal) {
		boolean existe = false;
		openConnection();
		try {
			stmt = con.prepareStatement(SQL_SELECT_BY_ID);
			stmt.setString(1, criminal.getDni());
			ResultSet resultado = stmt.executeQuery();
			existe = resultado.next();
			resultado.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al verificar criminal: " + e.getMessage());
		}
		return existe;
	}

	public boolean insertarCriminal(Criminals criminal) {
		boolean ok = false;
		if (!comprobarCriminal(criminal)) {
			openConnection();
			try {
				stmt = con.prepareStatement(SQL_INSERT);
				stmt.setString(1, criminal.getDni());
				stmt.setString(2, criminal.getCri_name());
				stmt.setString(3, criminal.getCri_surname());
				stmt.setInt(4, criminal.getAge());
				stmt.setString(5, criminal.getCri_decription());
				stmt.setString(6, criminal.getCrimes());
				ok = stmt.executeUpdate() > 0;
				stmt.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al insertar criminal: " + e.getMessage());
			}
		}
		return ok;
	}

	public boolean actualizarUsuario(Users user) {
		boolean ok = false;
		openConnection();
		try {
			stmt = con.prepareStatement(SQL_UPDATE);
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

	public Map<String, Cases> consultaUsuarios() {
		Map<String, Cases> usuarios = new TreeMap<>();
		openConnection();
		try {
			stmt = con.prepareStatement(SQL_SELECT_ALL);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Cases cases = new Cases(rs.getString("name_c"), rs.getString("code_cases"), rs.getString("description"),
						rs.getInt("number_ag"), rs.getInt("number_cr"));
				usuarios.put(cases.getName_c(), cases);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al consultar usuarios: " + e.getMessage());
		}
		return usuarios;
	}

	public boolean borrarUsuario(String user) {
		boolean ok = false;
		openConnection();
		try {
			stmt = con.prepareStatement(SQL_DELETE);
			stmt.setString(1, user);
			ok = stmt.executeUpdate() > 0;
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al borrar usuario: " + e.getMessage());
		}
		return ok;
	}
}
