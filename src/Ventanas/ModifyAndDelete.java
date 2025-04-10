package Ventanas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Criminals;
import controlador.LoginControlador;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class ModifyAndDelete extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private LoginControlador cont;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtDNI_Primario;
	private JButton btnDelete = new JButton("");
	private JButton btnModify = new JButton("");
	private JLabel TextBackground2;	
	public String DNIGuardado;

	public ModifyAndDelete(JFrame parent, LoginControlador cont) {
		setBounds(100, 100, 625, 403);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			txtDNI_Primario = new JTextField();
			txtDNI_Primario.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txtDNI_Primario.setText("DNI");
			txtDNI_Primario.setBounds(248, 299, 127, 30);
			contentPanel.add(txtDNI_Primario);
			txtDNI_Primario.setColumns(10);
		}
		{
			JLabel lblTextHelp = new JLabel("Introduzca el DNI");
			lblTextHelp.setForeground(new Color(128, 255, 255));
			lblTextHelp.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblTextHelp.setHorizontalAlignment(SwingConstants.CENTER);
			lblTextHelp.setBounds(248, 326, 127, 30);
			contentPanel.add(lblTextHelp);
		}


		btnDelete.setIcon(new ImageIcon("C:\\Users\\1dami\\eclipse-workspace\\RetoFinal\\Imagenes\\Delete Criminal.png"));
		btnDelete.setBounds(457, 248, 93, 93);
		contentPanel.add(btnDelete);
		btnDelete.addActionListener(this);

		btnModify.setIcon(new ImageIcon("C:\\Users\\1dami\\eclipse-workspace\\RetoFinal\\Imagenes\\modificar.jpg"));
		btnModify.setBounds(68, 248, 93, 93);
		contentPanel.add(btnModify);
		btnModify.addActionListener(this);

		TextBackground2 = new JLabel("");
		TextBackground2.setIcon(new ImageIcon("C:\\Users\\1dami\\eclipse-workspace\\RetoFinal\\Imagenes\\EscudoV2.png"));
		TextBackground2.setHorizontalAlignment(SwingConstants.CENTER);
		TextBackground2.setForeground(Color.BLACK);
		TextBackground2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		TextBackground2.setBounds(0, 3, 611, 366);
		contentPanel.add(TextBackground2);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub		
		if (e.getSource()==btnModify) {
			cont = new LoginControlador();
			if (txtDNI_Primario.getText().isEmpty() || txtDNI_Primario.getText().equals("DNI")) {
				JOptionPane.showMessageDialog(ModifyAndDelete.this,
						"Please enter a DNI",
						"Modify Criminal",
						JOptionPane.INFORMATION_MESSAGE,null); }
			else {
				if (txtDNI_Primario.getText().length() != 9) {
					JOptionPane.showMessageDialog(ModifyAndDelete.this,
							"The DNI must be 9 characters long",
							"Modify Criminal",
							JOptionPane.INFORMATION_MESSAGE,null);
				} else {
					if (cont.comprobarCriminal(new Criminals (txtDNI_Primario.getText()))) {				
						DNIGuardado = txtDNI_Primario.getText();
						Modify v=new  Modify();
						v.setVisible(true);
						v.TextDNIMOD.setText(DNIGuardado);
					}else {
						JOptionPane.showMessageDialog(ModifyAndDelete.this,
								"The criminal does not exist",
								"Modify Criminal",
								JOptionPane.INFORMATION_MESSAGE,null);
					}
				}
			}
		}
		if (e.getSource()==btnDelete) {
			cont = new LoginControlador();
			if (txtDNI_Primario.getText().isEmpty() || txtDNI_Primario.getText().equals("DNI")) {
				JOptionPane.showMessageDialog(ModifyAndDelete.this,
						"Please enter a DNI",
						"Delete Criminal",
						JOptionPane.INFORMATION_MESSAGE,null);
			}else {		
				if (txtDNI_Primario.getText().length() != 9) {
					JOptionPane.showMessageDialog(ModifyAndDelete.this,
							"The DNI must be 9 characters long",
							"Insert Criminal",
							JOptionPane.INFORMATION_MESSAGE,null);
				} else {
					if (cont.DeleteCriminal(new Criminals (txtDNI_Primario.getText()))) {				
						JOptionPane.showMessageDialog(ModifyAndDelete.this,
								"The criminal has been deleted",
								"Delete Criminal",
								JOptionPane.INFORMATION_MESSAGE,null);
					}else {
						JOptionPane.showMessageDialog(ModifyAndDelete.this,
								"The criminal does not exist",
								"Delete Criminal",
								JOptionPane.INFORMATION_MESSAGE,null);
					}
				}
			}
		}
	}
}
