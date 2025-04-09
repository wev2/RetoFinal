package Ventanas;

import java.awt.BorderLayout;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Modelo.Cases;
import controlador.LoginControlador;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;

public class VentanaVisualizar extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private LoginControlador cont;
	private Map<String, Cases> Cases;
	private JComboBox<String> comboBox;
	private JLabel lblCasos;
	
	public VentanaVisualizar(VentanaElegir ventanaelegir, LoginControlador cont) {
		super(ventanaelegir,true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\win10\\eclipse-workspace\\RetoFinal\\iconoertzaina2.jpg"));
		ventanaelegir.setVisible(false);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Show cases");
		this.isModal();
		this.cont = cont;
		setBounds(100, 100, 467, 417);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		comboBox = new JComboBox<String>();
		comboBox.setBackground(new Color(30, 144, 255));
		comboBox.setBounds(154, 153, 142, 28);
		cargarUsuarios();
		contentPanel.add(comboBox);
		
		lblCasos = new JLabel("Open Cases");
		lblCasos.setFont(new Font("DejaVu Serif", Font.BOLD, 15));
		lblCasos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCasos.setBounds(98, 46, 251, 76);
		contentPanel.add(lblCasos);
	}

	public void cargarUsuarios() {
		Cases = cont.consultarUsuarios();
		if (!Cases.isEmpty()) {
			for (Cases c : Cases.values()) {
				comboBox.addItem(c.getName_c());
			}
		}comboBox.setSelectedIndex(-1);
	}
}