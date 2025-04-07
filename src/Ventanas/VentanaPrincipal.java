package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Users;
import controlador.LoginControlador;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;

public class VentanaPrincipal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUsername;
	private JPasswordField passwordField;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblReply;
	private JLabel labelFondo;
	private JButton btnCheck;
	private LoginControlador cont = new LoginControlador();

	public VentanaPrincipal(LoginControlador cont) {
		setFont(new Font("Dialog", Font.BOLD, 12));
		setTitle("Ertzaintza Login");
		this.cont = cont;
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\win10\\eclipse-workspace\\RetoFinal\\iconoertzaina2.jpg"));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblUsername = new JLabel("Username:");
		lblUsername.setBounds(148, 120, 89, 27);
		lblUsername.setForeground(new Color(255, 255, 0));
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblUsername);

		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(148, 183, 89, 27);
		lblPassword.setForeground(new Color(255, 255, 0));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblPassword);

		textUsername = new JTextField();
		textUsername.setForeground(Color.BLACK);
		textUsername.setBackground(new Color(230, 230, 250));
		textUsername.setBounds(247, 122, 153, 27);
		contentPane.add(textUsername);
		textUsername.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setForeground(Color.BLACK);
		passwordField.setBackground(new Color(230, 230, 250));
		passwordField.setBounds(247, 185, 153, 27);
		contentPane.add(passwordField);

		lblReply = new JLabel(" ");
		lblReply.setBounds(198, 320, 236, 23);
		lblReply.setForeground(new Color(0, 0, 0));
		lblReply.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblReply.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblReply);

		ImageIcon imagenFondo = new ImageIcon("C:\\Users\\win10\\eclipse-workspace\\RetoFinal\\ertzaina.jpg");

		labelFondo = new JLabel(imagenFondo);
		labelFondo.setBounds(10, 0, 594, 938);
		contentPane.add(labelFondo);

		btnCheck = new JButton("Check");
		btnCheck.setForeground(Color.YELLOW);
		btnCheck.setBounds(198, 275, 236, 23);
		btnCheck.setOpaque(false);
		btnCheck.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCheck.setContentAreaFilled(false);
		btnCheck.setBorderPainted(true);
		btnCheck.addActionListener(this);
		contentPane.add(btnCheck);

		contentPane.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCheck) {
			if (cont.comprobarUsuario(new Users(textUsername.getText(), new String(passwordField.getPassword())))) {
				lblReply.setText("User logged");
				VentanaElegir v = new VentanaElegir(this, cont);
				v.setVisible(true);
				dispose();
			} else {
				lblReply.setText("User not found");
			}
		}
	}
}
