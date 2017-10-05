
package presentacion;

import entidades.Persona;			
import logica.CtrlABMCPersona;	

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.xml.bind.ParseConversionEvent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.event.MouseAdapter;	//1 no estaban
import java.io.Console;

import org.omg.CosNaming.IstringHelper;
import org.w3c.dom.events.MouseEvent; //2

public class FormABMCPersonas extends JFrame {
	
	Persona p;
	CtrlABMCPersona ctrl = new CtrlABMCPersona();

	private JPanel contentPane;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellido;
	
	JLabel lblResultado = new JLabel("");
	private JRadioButton rdbtnH;
	private JRadioButton rdbtnNH;
	private JTextField txtUsuario;
	private JPasswordField txtContraseña;
	private JPasswordField txtConfirmacion;
	private JTextField txtiD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormABMCPersonas frame = new FormABMCPersonas();
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
	public FormABMCPersonas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(25, 79, 124, 14);
		
		txtDni = new JTextField();
		txtDni.setBounds(169, 76, 218, 20);
		txtDni.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(25, 119, 124, 14);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(169, 116, 219, 20);
		txtNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(25, 161, 124, 14);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(170, 158, 217, 20);
		txtApellido.setColumns(10);
		
		
		
		rdbtnH = new JRadioButton("Habilitado");
		rdbtnH.setBounds(169, 317, 95, 23);
		rdbtnH.setSelected(true);
		
		rdbtnNH = new JRadioButton("No habilitado");
		rdbtnNH.setBounds(279, 317, 108, 23);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNH);
		bg.add(rdbtnH);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(169, 369, 108, 23);
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent arg0) {
				buscar();
			}
		});
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(25, 355, 110, 50);
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent arg0) {
				agregar();
			}
		});
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(448, 369, 109, 23);
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent arg0) {
				eliminar();
			}
		});
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(308, 369, 108, 23);
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent arg0) {
				modificar();
			}
		});
		
		JLabel lblUusario = new JLabel("Uusario");
		lblUusario.setBounds(25, 203, 124, 14);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(25, 244, 124, 14);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(169, 200, 218, 20);
		txtUsuario.setColumns(10);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setBounds(169, 241, 218, 20);
		txtContraseña.setColumns(10);
		
		JLabel lblConfirmacion = new JLabel("Confirme Contrase\u00F1a");
		lblConfirmacion.setBounds(25, 282, 124, 14);
		
		txtConfirmacion = new JPasswordField();
		txtConfirmacion.setBounds(169, 279, 218, 20);
		txtConfirmacion.setColumns(10);
		contentPane.setLayout(null);
		contentPane.add(btnBuscar);
		contentPane.add(btnModificar);
		contentPane.add(lblConfirmacion);
		contentPane.add(txtConfirmacion);
		contentPane.add(rdbtnNH);
		contentPane.add(lblContrasea);
		contentPane.add(txtContraseña);
		contentPane.add(lblUusario);
		contentPane.add(txtUsuario);
		contentPane.add(lblApellido);
		contentPane.add(txtApellido);
		contentPane.add(lblNombre);
		contentPane.add(txtNombre);
		contentPane.add(lblDni);
		contentPane.add(txtDni);
		contentPane.add(rdbtnH);
		contentPane.add(btnAgregar);
		lblResultado.setBounds(432, 260, 227, 36);
		contentPane.add(lblResultado);
		contentPane.add(btnEliminar);
		
		JLabel lbliD = new JLabel("i D");
		lbliD.setBounds(104, 36, 46, 14);
		contentPane.add(lbliD);
		
		txtiD = new JTextField();
		txtiD.setEditable(false);
		txtiD.setBounds(169, 33, 86, 20);
		contentPane.add(txtiD);
		txtiD.setColumns(10);
	}
	
	
	protected void buscar() {								
		Persona pEncontrada = new Persona();
		p = new Persona();
		p.setDni(Integer.parseInt(txtDni.getText()));
		try{
		pEncontrada = ctrl.consulta(p);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		if (pEncontrada == null) {
			lblResultado.setText("No encontrado");
			limpiarCampos();
			txtDni.requestFocusInWindow();			
		}
		else {
		txtApellido.setText(pEncontrada.getApellido());
		txtNombre.setText(pEncontrada.getNombre());
		txtUsuario.setText(pEncontrada.getUsuario());
		txtiD.setText(String.valueOf(pEncontrada.getID()));
		if (pEncontrada.isHabilitado()) {					
			this.rdbtnH.setSelected(true);
		}
		else {
			this.rdbtnNH.setSelected(true);
		}
		
		lblResultado.setText("Encontrado");
		}
	}
	
	protected void agregar() {
		if (txtContraseña.getText().compareTo(txtConfirmacion.getText()) != 0) {
			txtContraseña.setText("");
			txtConfirmacion.setText("");
			lblResultado.setText("Contraseñas no coinciden");
		}
		else {
		p = new Persona();
		p.setDni(Integer.parseInt(txtDni.getText()));
		p.setNombre(txtNombre.getText());
		p.setApellido(txtApellido.getText());
		p.setUsuario(txtUsuario.getText());
		p.setContraseña(txtContraseña.getText());
		p.setHabilitado(this.rdbtnH.isSelected());
		try{
			ctrl.add(p);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		this.txtiD.setText(String.valueOf(p.getID()));
		limpiarCampos();
		lblResultado.setText("Agregado");
		}
	}
	
	protected void eliminar() {
		p = new Persona();
		Persona pEncontrada = new Persona();
		p.setDni(Integer.parseInt(txtDni.getText()));
		try{
		pEncontrada = ctrl.consulta(p);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		if (pEncontrada == null) {
			lblResultado.setText("No encontrado");
			limpiarCampos();
			txtDni.requestFocusInWindow();
		}
		else {
		try{
		ctrl.delete(p);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		limpiarCampos();
		lblResultado.setText("Eliminado");
		}
		
	}
	
	protected void modificar() {
		p = new Persona();
		Persona pEncontrada = new Persona();
		p.setDni(Integer.parseInt(txtDni.getText()));
		try{
		pEncontrada = ctrl.consulta(p);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		if (pEncontrada == null) {
			lblResultado.setText("No encontrado");
			limpiarCampos();
			txtDni.requestFocusInWindow();
		}
		else {
		if (txtContraseña.getText().compareTo(txtConfirmacion.getText()) != 0) {
			txtContraseña.setText("");
			txtConfirmacion.setText("");
			lblResultado.setText("Contraseñas no coinciden");
		}
		else {
		p = new Persona();
		p.setDni(Integer.parseInt(txtDni.getText()));
		p.setNombre(txtNombre.getText());
		p.setApellido(txtApellido.getText());
		p.setUsuario(txtUsuario.getText());
		p.setContraseña(txtContraseña.getText());
		p.setHabilitado(this.rdbtnH.isSelected());
		try{
		ctrl.update(p);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		limpiarCampos();
		lblResultado.setText("Modificado");
		}
		}
	}
	
	protected void limpiarCampos(){
		txtApellido.setText("");
		txtDni.setText("");
		txtNombre.setText("");
		txtContraseña.setText("");
		txtConfirmacion.setText("");
		txtUsuario.setText("");
	}
}