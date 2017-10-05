package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import datos.*;

public class FormLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormLogin frame = new FormLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 365, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		JLabel lblPresentacion = new JLabel("\u00A1\u00A1 Bienvenido al Sistema de Reservas !!");
		lblPresentacion.setBounds(70, 38, 231, 14);
		contentPane.add(lblPresentacion);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(70, 117, 86, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContraseña = new JLabel("Contrase\u00F1a");
		lblContraseña.setBounds(70, 180, 86, 14);
		contentPane.add(lblContraseña);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(166, 114, 86, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setBounds(166, 177, 86, 20);
		contentPane.add(txtContraseña);
		txtContraseña.setColumns(10);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ingresar();
			}
		});
		btnIngresar.setBounds(166, 234, 89, 23);
		contentPane.add(btnIngresar);
		
		
	}
	
		protected void ingresar() {
			Cuenta cuenta = new Cuenta();
			if (!cuenta.validarUsuario(txtUsuario.getText(), new String(txtContraseña.getPassword()))) {
				JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrecto");
				txtUsuario.setText("");
				txtContraseña.setText("");
				txtUsuario.requestFocusInWindow();
				return;
			}
			FormOpciones formopciones = new FormOpciones();
			formopciones.setVisible(true);
			this.setVisible(false);
		}
	}
