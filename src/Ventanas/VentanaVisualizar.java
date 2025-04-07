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
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class VentanaVisualizar extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private LoginControlador cont;
	private Map<String, Users> Users;
	private JComboBox<String> comboBox;
	private JLabel lblCasos;
	
	public VentanaVisualizar(VentanaElegir ventanaelegir, LoginControlador cont) {
		super(ventanaelegir,true);
		this.isModal();
		this.cont = cont;
		setBounds(100, 100, 623, 422);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setBackground(new Color(30, 144, 255));
		comboBox.setBounds(241, 169, 142, 28);
		cargarUsuarios();
		contentPanel.add(comboBox);
		
		lblCasos = new JLabel("Open Cases");
		lblCasos.setFont(new Font("DejaVu Serif", Font.BOLD, 15));
		lblCasos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCasos.setBounds(184, 53, 251, 76);
		contentPanel.add(lblCasos);
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