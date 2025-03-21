package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class VentanaElegir extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblBienvenida;
	private JButton btnInsertarUsuario;
	private JButton btnModify;
	private JButton btnShowCases;
	
	public VentanaElegir() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblBienvenida = new JLabel(" ");
		lblBienvenida.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenida.setBounds(63, 10, 477, 48);
		contentPane.add(lblBienvenida);
		
		btnInsertarUsuario = new JButton("Add new criminal");
		btnInsertarUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnInsertarUsuario.setBounds(83, 235, 149, 62);
		contentPane.add(btnInsertarUsuario);
		
		btnModify = new JButton("Update/Modify cases");
		btnModify.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnModify.setBounds(229, 130, 149, 62);
		contentPane.add(btnModify);
		
		btnShowCases = new JButton("Show cases");
		btnShowCases.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnShowCases.setBounds(372, 235, 149, 62);
		contentPane.add(btnShowCases);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
