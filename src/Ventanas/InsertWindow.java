package Ventanas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Modelo.Criminals;
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
	private JButton BotonInsertar = new JButton("CONFIRMAR");
	private JLabel lblDescription;
	private JLabel lblCrimes;
	private JLabel lblNewLabel;
	private JLabel Text_Name;
	private JLabel Text_DNI;
	private JLabel Text_Surname;
	private JLabel Text_Age;
	private JLabel Text_Image;
	private JLabel TitelWindow;
	

	public InsertWindow(JFrame parent, LoginControlador cont) {
		
		super(parent,true);
		setResizable(false);
		setTitle("Insert Criminal");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\win10\\eclipse-workspace\\RetoFinal\\iconoertzaina2.jpg"));
		this.cont = cont;
		setBounds(100, 100, 625, 403);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		TitelWindow = new JLabel("ADD CRIMINAL");
		TitelWindow.setBounds(158, 10, 281, 44);
		TitelWindow.setFont(new Font("Times New Roman", Font.BOLD, 20));
		TitelWindow.setForeground(new Color(0, 64, 128));
		TitelWindow.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(TitelWindow);
		
		Text_Name = new JLabel("Name:");
		Text_Name.setBounds(20, 93, 77, 32);
		Text_Name.setHorizontalAlignment(SwingConstants.RIGHT);
		Text_Name.setForeground(Color.BLACK);
		Text_Name.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPanel.add(Text_Name);
		
		AddDNI = new JTextField();
		AddDNI.setBounds(107, 64, 177, 19);
		contentPanel.add(AddDNI);
		AddDNI.setColumns(10);
		
		lblDescription = new JLabel("Description");
		lblDescription.setBounds(20, 235, 229, 38);
		lblDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescription.setForeground(Color.BLACK);
		lblDescription.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPanel.add(lblDescription);
		
		lblCrimes = new JLabel("Crimes");
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
		
		Text_DNI = new JLabel("DNI:");
		Text_DNI.setHorizontalAlignment(SwingConstants.RIGHT);
		Text_DNI.setForeground(Color.BLACK);
		Text_DNI.setFont(new Font("Times New Roman", Font.BOLD, 16));
		Text_DNI.setBounds(20, 56, 77, 32);
		contentPanel.add(Text_DNI);
		
		Text_Surname = new JLabel("Surname:");
		Text_Surname.setHorizontalAlignment(SwingConstants.RIGHT);
		Text_Surname.setForeground(Color.BLACK);
		Text_Surname.setFont(new Font("Times New Roman", Font.BOLD, 16));
		Text_Surname.setBounds(20, 132, 77, 32);
		contentPanel.add(Text_Surname);
		
		Text_Age = new JLabel("Age:");
		Text_Age.setHorizontalAlignment(SwingConstants.RIGHT);
		Text_Age.setForeground(Color.BLACK);
		Text_Age.setFont(new Font("Times New Roman", Font.BOLD, 16));
		Text_Age.setBounds(20, 174, 77, 32);
		contentPanel.add(Text_Age);
		
		Text_Image = new JLabel("Image");
		Text_Image.setHorizontalAlignment(SwingConstants.CENTER);
		Text_Image.setForeground(Color.BLACK);
		Text_Image.setFont(new Font("Times New Roman", Font.BOLD, 16));
		Text_Image.setBounds(434, 56, 95, 32);
		contentPanel.add(Text_Image);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\1dami\\eclipse-workspace\\RetoFinal\\Imagenes\\fotocriminal1.jpg"));
		lblNewLabel.setBounds(398, 93, 174, 148);
		contentPanel.add(lblNewLabel);
		
		BotonInsertar = new JButton("CONFIRMAR");
		BotonInsertar.setBounds(259, 297, 113, 44);
		contentPanel.add(BotonInsertar);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==BotonInsertar) {
			if (cont.insertarCriminal(new Criminals (AddDNI.getText(),AddName.getText(),AddSurname.getText(),Integer.parseInt(AddAge.getText()),AddDescription.getText(),AddCrimes.getText()))) {
		    	int opcion = JOptionPane.showConfirmDialog(InsertWindow.this,
		            	"Has insertado un criminal correctamente",
		            	"Insertar Criminal",
		            	JOptionPane.INFORMATION_MESSAGE,JOptionPane.INFORMATION_MESSAGE,null);

			}
		}
	}
}
