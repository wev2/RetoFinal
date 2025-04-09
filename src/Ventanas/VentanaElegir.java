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
import javax.swing.JTextField;
import java.awt.Color;

public class VentanaElegir extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnInsertarUsuario;
	private JButton btnModify;
	private JButton btnShowCases;
	private LoginControlador cont;
	private JLabel lblImagen;
	private JTextField txtAddCriminal;
	private JTextField txtModifyDelete;
	private JTextField txtShowCases;
	
	public VentanaElegir(VentanaPrincipal ventanaPrincipal, LoginControlador cont) {
		this.cont = cont;
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\win10\\eclipse-workspace\\RetoFinal\\iconoertzaina2.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnInsertarUsuario = new JButton("");
		btnInsertarUsuario.setIcon(new ImageIcon("C:\\Users\\1dami\\eclipse-workspace\\RetoFinal\\Imagenes\\añadir criminal.png"));
		btnInsertarUsuario.setBounds(47, 136, 103, 103);
		btnInsertarUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnInsertarUsuario);
		
		btnShowCases = new JButton("");
		btnShowCases.setIcon(new ImageIcon("C:\\Users\\1dami\\eclipse-workspace\\RetoFinal\\Imagenes\\mostrar.jpg"));
		btnShowCases.setBounds(445, 136, 103, 103);
		btnShowCases.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnShowCases);
		
		btnModify = new JButton("");
		btnModify.setIcon(new ImageIcon("C:\\Users\\1dami\\eclipse-workspace\\RetoFinal\\Imagenes\\modificar.jpg"));
		btnModify.setBounds(245, 136, 103, 103);
		btnModify.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(btnModify);
        
        txtAddCriminal = new JTextField();
        txtAddCriminal.setEditable(false);
        txtAddCriminal.setHorizontalAlignment(SwingConstants.CENTER);
        txtAddCriminal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtAddCriminal.setText("Add Criminal");
        txtAddCriminal.setBounds(34, 249, 131, 31);
        contentPane.add(txtAddCriminal);
        txtAddCriminal.setColumns(10);
      
        txtModifyDelete = new JTextField();
        txtModifyDelete.setEditable(false);
        txtModifyDelete.setText("Modify/Delete");
        txtModifyDelete.setHorizontalAlignment(SwingConstants.CENTER);
        txtModifyDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtModifyDelete.setColumns(10);
        txtModifyDelete.setBounds(230, 249, 131, 31);
        contentPane.add(txtModifyDelete);
        
        txtShowCases = new JTextField();
        txtShowCases.setEditable(false);
        txtShowCases.setText("Show Cases");
        txtShowCases.setHorizontalAlignment(SwingConstants.CENTER);
        txtShowCases.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtShowCases.setColumns(10);
        txtShowCases.setBounds(429, 249, 131, 31);
        contentPane.add(txtShowCases);
        
        ImageIcon imagenFondo = new ImageIcon("C:\\Users\\1dami\\eclipse-workspace\\RetoFinal\\Imagenes\\ertzaina.jpg");
		//ruta de la imagen
		
        lblImagen = new JLabel(imagenFondo);
        lblImagen.setBounds(0, 0, 604, 938);
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
			InsertWindow v=new  InsertWindow(this, cont);
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
