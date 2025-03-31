package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controlador.LoginControlador;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class VentanaElegir extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblBienvenida;
	private JButton btnInsertarUsuario;
	private JButton btnModify;
	private JButton btnShowCases;
	private LoginControlador cont;
	private JLabel lblImagen;
	
	public VentanaElegir(VentanaPrincipal ventanaPrincipal, LoginControlador cont) {
		this.cont = cont;
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\win10\\eclipse-workspace\\RetoFinal\\iconoertzaina2.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblBienvenida = new JLabel(" ");
		lblBienvenida.setBounds(62, 10, 477, 48);
		lblBienvenida.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblBienvenida);
		
		btnInsertarUsuario = new JButton("Add new criminal");
		btnInsertarUsuario.setBounds(83, 235, 149, 62);
		btnInsertarUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnInsertarUsuario);
		
		btnShowCases = new JButton("Show cases");
		btnShowCases.setBounds(372, 235, 149, 62);
		btnShowCases.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnShowCases);
		
		btnModify = new JButton("Update/Modify cases");
		btnModify.setBounds(229, 130, 149, 62);
		btnModify.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(btnModify);
		
		
		
		ImageIcon imagenFondo = new ImageIcon("C:\\Users\\win10\\eclipse-workspace\\RetoFinal\\ertzaina.jpg");
		//ruta de la imagen
		


        lblImagen = new JLabel(imagenFondo);
        lblImagen.setBounds(10, 0, 594, 938);
        contentPane.add(lblImagen);
        contentPane.add(lblImagen); // Establecer el fondo después de los botones
        
        btnInsertarUsuario.addActionListener(this);
        btnShowCases.addActionListener(this);
        btnModify.addActionListener(this);

        contentPane.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnInsertarUsuario) {
			VentanaInsertar v=new  VentanaInsertar(this, cont);
			v.setVisible(true);
		}
		if (e.getSource() == btnShowCases) {
			VentanaVisualizar v = new VentanaVisualizar(this, cont);
			v.setVisible(true);
		}
		if (e.getSource() == btnModify) {
			VentanaBorrar v = new VentanaBorrar(this, cont);
			v.setVisible(true);
		}
	}
}
