package Ventanas;

import java.awt.BorderLayout;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Modelo.Users;
import controlador.LoginControlador;

import javax.swing.JComboBox;

public class VentanaVisualizar extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private LoginControlador cont;
	private Map<String, Users> Users;
	private JComboBox<String> comboBox;
	
	public VentanaVisualizar(VentanaElegir ventanaelegir, LoginControlador cont) {
		super(ventanaelegir,true);
		this.cont = cont;
		setBounds(100, 100, 623, 422);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setBounds(241, 169, 142, 28);
		contentPanel.add(comboBox);
	}

	public void cargarUsuarios() {
		Users = cont.consultarUsuarios();
		if (!Users.isEmpty()) {
			for (Users u : Users.values()) {
				comboBox.addItem(u.getName());
			}
		}comboBox.setSelectedIndex(-1);
	}
}
