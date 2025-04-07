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
	final String sqlInsert = "INSERT INTO users VALUES (?,?,?,?,?,?)";
	final String SQLCONSULTA = "SELECT * FROM users";
	final String SQLBORRAR = "DELETE FROM users WHERE Nam_USERS=?";
	final String SQLMODIFICAR = "UPDATE users SET passwords=? WHERE Nam_USERS=?";

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

<<<<<<< HEAD
	public boolean comprobarCriminal(Criminals criminal) {
// Abrimos la conexion
=======
	public boolean comprobarUsuario1(Users user) {
		// Abrimos la conexion
>>>>>>> nueva
		boolean existe = false;
		this.openConnection();

		try {
			stmt = con.prepareStatement(sql1);
			stmt.setString(1, criminal.getDni());
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

<<<<<<< HEAD
	public boolean insertarCriminal(Criminals criminal) {
// TODO Auto-generated method stub
		boolean ok = false;	
		if (!comprobarCriminal(criminal)) {
=======
	public boolean insertarUsuario(Users user) {
		// TODO Auto-generated method stub
		boolean ok = false;
		if (!comprobarUsuario1(user)) {
>>>>>>> nueva
			this.openConnection();
			try {
				// Preparamos la sentencia stmt con la conexion y sentencia sql correspondiente

				stmt = con.prepareStatement(sqlInsert);
<<<<<<< HEAD
				stmt.setString(1, criminal.getDni());
			    stmt.setString(2, criminal.getCri_name());
			    stmt.setString(3, criminal.getCri_surname());
			    stmt.setInt(4, criminal.getAge());
			    stmt.setString(5, criminal.getCri_decription());
			    stmt.setString(6, criminal.getCrimes());
=======
				stmt.setString(1, user.getName());
				stmt.setString(2, user.getPassword());
>>>>>>> nueva
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
				user.setName(rs.getString("name_users"));
				user.setPassword(rs.getString("password"));
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

	public boolean borrarUsuario(String user) {
		// TODO Auto-generated method stub
		boolean ok = false;

		this.openConnection();
		try {
			// Preparamos la sentencia stmt con la conexion y sentencia sql correspondiente

			stmt = con.prepareStatement(SQLBORRAR);
			stmt.setString(1, user);
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
}