package Ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Criminals;
import Modelo.Users;
import controlador.LoginControlador;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JTextPane;

public class InsertWindow extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private LoginControlador cont;
	private JTextField AddDNI;
	private JTextField AddAge;
	private JTextField AddSurname;
	private JTextField AddName;
	private JTextPane AddDescription;
	private JTextPane AddCrimes;
	private JButton BotonInsertar = new JButton("CONFIRM");
	public InsertWindow(JFrame parent, LoginControlador cont) {


		super(parent,true);
		this.cont = cont;
		setBounds(100, 100, 625, 403);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel TitelWindow = new JLabel("ADD CRIMINAL");
		TitelWindow.setBounds(158, 10, 281, 44);
		TitelWindow.setFont(new Font("Times New Roman", Font.BOLD, 20));
		TitelWindow.setForeground(new Color(0, 64, 128));
		TitelWindow.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(TitelWindow);

		JLabel Text_Name = new JLabel("Name:");
		Text_Name.setBounds(20, 93, 77, 32);
		Text_Name.setHorizontalAlignment(SwingConstants.RIGHT);
		Text_Name.setForeground(Color.BLACK);
		Text_Name.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPanel.add(Text_Name);

		AddDNI = new JTextField();
		AddDNI.setBounds(107, 64, 177, 19);
		contentPanel.add(AddDNI);
		AddDNI.setColumns(10);

		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(20, 235, 229, 38);
		lblDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescription.setForeground(Color.BLACK);
		lblDescription.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPanel.add(lblDescription);

		JLabel lblCrimes = new JLabel("Crimes");
		lblCrimes.setBounds(379, 235, 222, 38);
		lblCrimes.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrimes.setForeground(Color.BLACK);
		lblCrimes.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPanel.add(lblCrimes);

		AddDescription = new JTextPane();
		AddDescription.setBounds(20, 271, 229, 85);
		contentPanel.add(AddDescription);

		AddCrimes = new JTextPane();
		AddCrimes.setBounds(382, 271, 219, 85);
		contentPanel.add(AddCrimes);

		AddAge = new JTextField();
		AddAge.setBounds(107, 182, 177, 19);
		AddAge.setColumns(10);
		contentPanel.add(AddAge);

		AddSurname = new JTextField();
		AddSurname.setBounds(107, 143, 177, 19);
		AddSurname.setColumns(10);
		contentPanel.add(AddSurname);

		AddName = new JTextField();
		AddName.setBounds(107, 101, 177, 19);
		AddName.setColumns(10);
		contentPanel.add(AddName);

		JLabel Text_DNI = new JLabel("DNI:");
		Text_DNI.setHorizontalAlignment(SwingConstants.RIGHT);
		Text_DNI.setForeground(Color.BLACK);
		Text_DNI.setFont(new Font("Times New Roman", Font.BOLD, 16));
		Text_DNI.setBounds(20, 56, 77, 32);
		contentPanel.add(Text_DNI);

		JLabel Text_Surname = new JLabel("Surname:");
		Text_Surname.setHorizontalAlignment(SwingConstants.RIGHT);
		Text_Surname.setForeground(Color.BLACK);
		Text_Surname.setFont(new Font("Times New Roman", Font.BOLD, 16));
		Text_Surname.setBounds(20, 132, 77, 32);
		contentPanel.add(Text_Surname);

		JLabel Text_Age = new JLabel("Age:");
		Text_Age.setHorizontalAlignment(SwingConstants.RIGHT);
		Text_Age.setForeground(Color.BLACK);
		Text_Age.setFont(new Font("Times New Roman", Font.BOLD, 16));
		Text_Age.setBounds(20, 174, 77, 32);
		contentPanel.add(Text_Age);

		JLabel lblNewLabelFoto = new JLabel("");
		lblNewLabelFoto.setEnabled(false);
		lblNewLabelFoto.setFont(new Font("Tahoma", Font.PLAIN, 5));
		lblNewLabelFoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabelFoto.setIcon(new ImageIcon("C:\\Users\\koraw_54jmcxu\\eclipse-workspace\\RetoFinal\\Imagenes\\criminal.jpg"));
		lblNewLabelFoto.setBounds(407, 56, 177, 177);
		contentPanel.add(lblNewLabelFoto);

		BotonInsertar.setBounds(259, 297, 113, 44);
		contentPanel.add(BotonInsertar);
		BotonInsertar.addActionListener(this);


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==BotonInsertar) {
			if (AddDNI.getText().length() != 9) {
				JOptionPane.showMessageDialog(InsertWindow.this,
						"The DNI must be 9 characters long",
						"Insert Criminal",
						JOptionPane.INFORMATION_MESSAGE,null);
			} else {
				if (AddDNI.getText().isEmpty() || AddName.getText().isEmpty() || AddSurname.getText().isEmpty() || AddAge.getText().isEmpty() || AddDescription.getText().isEmpty() || AddCrimes.getText().isEmpty()) {
					JOptionPane.showMessageDialog(InsertWindow.this,
							"All fields are required",
							"Insert Criminal",
							JOptionPane.INFORMATION_MESSAGE,null);
				} else {
					if (cont.comprobarCriminal(new Criminals (AddDNI.getText()))) {
						JOptionPane.showMessageDialog(InsertWindow.this,
								"The criminal already exists",
								"Insert Criminal",
								JOptionPane.INFORMATION_MESSAGE,null);
					} else {
						if (cont.insertarCriminal(new Criminals (AddDNI.getText(),AddName.getText(),AddSurname.getText(),Integer.parseInt(AddAge.getText()),AddDescription.getText(),AddCrimes.getText()))) {
							JOptionPane.showMessageDialog(InsertWindow.this,
									"The criminal has been inserted",
									"Insert Criminal",
									JOptionPane.INFORMATION_MESSAGE,null);
						}
					}
				}
			}
		}
	}
}




