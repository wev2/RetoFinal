package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Modelo.Criminals;
import controlador.LoginControlador;

public class Modify<TextDNIMOD> extends JDialog implements ActionListener {
	public String DNIGuardado;
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textNAME;
	private JTextField textSURNAME;
	private JTextField textAGE;
	private JTextPane AddDescription;
	private JTextPane AddCrimes;
	private JButton btnOK = new JButton("");
	private LoginControlador cont;
	JLabel TextDNIMOD;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Modify dialog = new Modify();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Modify() {
		setBounds(100, 100, 625, 403);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel TextNewName = new JLabel("Name:");
		TextNewName.setHorizontalAlignment(SwingConstants.RIGHT);
		TextNewName.setForeground(Color.BLACK);
		TextNewName.setFont(new Font("Times New Roman", Font.BOLD, 16));
		TextNewName.setBounds(25, 74, 115, 30);
		contentPanel.add(TextNewName);

		JLabel TextNewSurname = new JLabel("Surname:");
		TextNewSurname.setHorizontalAlignment(SwingConstants.RIGHT);
		TextNewSurname.setForeground(Color.BLACK);
		TextNewSurname.setFont(new Font("Times New Roman", Font.BOLD, 16));
		TextNewSurname.setBounds(25, 115, 115, 30);
		contentPanel.add(TextNewSurname);

		JLabel TextNewAge = new JLabel("Age:");
		TextNewAge.setHorizontalAlignment(SwingConstants.RIGHT);
		TextNewAge.setForeground(Color.BLACK);
		TextNewAge.setFont(new Font("Times New Roman", Font.BOLD, 16));
		TextNewAge.setBounds(25, 156, 115, 30);
		contentPanel.add(TextNewAge);

		textNAME = new JTextField();
		textNAME.setColumns(10);
		textNAME.setBounds(150, 80, 160, 19);
		contentPanel.add(textNAME);

		textSURNAME = new JTextField();
		textSURNAME.setColumns(10);
		textSURNAME.setBounds(150, 121, 160, 19);
		contentPanel.add(textSURNAME);

		textAGE = new JTextField();
		textAGE.setColumns(10);
		textAGE.setBounds(150, 162, 160, 19);
		contentPanel.add(textAGE);

		JTextPane AddDescription = new JTextPane();
		AddDescription.setBounds(370, 267, 229, 77);
		contentPanel.add(AddDescription);

		JTextPane AddCrimes = new JTextPane();
		AddCrimes.setBounds(25, 267, 229, 77);
		contentPanel.add(AddCrimes);

		JLabel TextNewDescription = new JLabel("Modify Description");
		TextNewDescription.setHorizontalAlignment(SwingConstants.CENTER);
		TextNewDescription.setForeground(Color.BLACK);
		TextNewDescription.setFont(new Font("Times New Roman", Font.BOLD, 16));
		TextNewDescription.setBounds(25, 225, 229, 30);
		contentPanel.add(TextNewDescription);

		JLabel TextNewCrimes = new JLabel("Modify Crimes");
		TextNewCrimes.setHorizontalAlignment(SwingConstants.CENTER);
		TextNewCrimes.setForeground(Color.BLACK);
		TextNewCrimes.setFont(new Font("Times New Roman", Font.BOLD, 16));
		TextNewCrimes.setBounds(370, 226, 229, 30);
		contentPanel.add(TextNewCrimes);

		JLabel Text_NewDNI_1 = new JLabel("");
		Text_NewDNI_1.setIcon(new ImageIcon("C:\\Users\\koraw_54jmcxu\\eclipse-workspace\\RetoFinal\\Imagenes\\Modify V2.jpg"));
		Text_NewDNI_1.setHorizontalAlignment(SwingConstants.CENTER);
		Text_NewDNI_1.setForeground(Color.BLACK);
		Text_NewDNI_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		Text_NewDNI_1.setBounds(391, 74, 140, 140);
		contentPanel.add(Text_NewDNI_1);

		JButton btnOK = new JButton("CONFIRM");
		btnOK.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnOK.setBounds(264, 285, 96, 46);
		contentPanel.add(btnOK);

		JLabel lblTopText = new JLabel("The DNI of the user that you are modifying it is:");
		lblTopText.setHorizontalAlignment(SwingConstants.LEFT);
		lblTopText.setForeground(Color.BLACK);
		lblTopText.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblTopText.setBounds(88, 11, 328, 30);
		contentPanel.add(lblTopText);
			
		JLabel TextDNIMOD = new JLabel();
		TextDNIMOD.setHorizontalAlignment(SwingConstants.LEFT);
		TextDNIMOD.setForeground(new Color(0, 255, 64));
		TextDNIMOD.setFont(new Font("Times New Roman", Font.BOLD, 16));
		TextDNIMOD.setBounds(416, 11, 140, 30);
		contentPanel.add(TextDNIMOD);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		TextDNIMOD.setText(DNIGuardado);
		if (e.getSource()==btnOK) {
			if (textNAME.getText().isEmpty() || textSURNAME.getText().isEmpty() || textAGE.getText().isEmpty() || AddDescription.getText().isEmpty() || AddCrimes.getText().isEmpty()) {
				JOptionPane.showMessageDialog(Modify.this,
						"All fields are required",
						"Modify Criminal",
						JOptionPane.INFORMATION_MESSAGE,null);
			} else {
				if (textNAME.getText().isEmpty() || textSURNAME.getText().isEmpty() || textAGE.getText().isEmpty() || AddDescription.getText().isEmpty() || AddCrimes.getText().isEmpty()) {
					JOptionPane.showMessageDialog(Modify.this,
							"The criminal has been modified",
							"Modify Criminal",
							JOptionPane.INFORMATION_MESSAGE,null);
				}
			}
		}
	}
}
