package presentacion;

import entidades.Elemento;
import entidades.TipoElemento;
import logica.CtrlABMCElemento;
import logica.CtrlABMCTipoElemento;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import util.AppDataException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class FormABMCElementos extends JFrame {
	
	Elemento el;
	CtrlABMCElemento ctrl = new CtrlABMCElemento();
	CtrlABMCTipoElemento ctrltipo = new CtrlABMCTipoElemento();
	
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtiD;
	private JLabel lblResultado;
	private JComboBox cmbbxTipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormABMCElementos frame = new FormABMCElementos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public FormABMCElementos() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 283);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre de Elemento");
		lblNombre.setBounds(10, 84, 135, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(155, 81, 173, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo de Elemento");
		lblTipo.setBounds(10, 130, 99, 14);
		contentPane.add(lblTipo);
		
		lblResultado = new JLabel("");
		lblResultado.setBounds(351, 72, 216, 29);
		contentPane.add(lblResultado);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				agregar();
			}
		});
		btnAgregar.setBounds(30, 177, 89, 23);
		contentPane.add(btnAgregar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				modificar();
			}
		});
		btnModificar.setBounds(155, 177, 89, 23);
		contentPane.add(btnModificar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				buscar();
			}
		});
		btnBuscar.setBounds(274, 177, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				eliminar();
			}
		});
		btnEliminar.setBounds(396, 177, 89, 23);
		contentPane.add(btnEliminar);
		
		JLabel lbliD = new JLabel("iD Elemento");
		lbliD.setBounds(10, 41, 68, 14);
		contentPane.add(lbliD);
		
		txtiD = new JTextField();
		txtiD.setEditable(false);
		txtiD.setBounds(155, 38, 86, 20);
		contentPane.add(txtiD);
		txtiD.setColumns(10);
		
		cmbbxTipo = new JComboBox();				
		cmbbxTipo.setModel(new DefaultComboBoxModel(this.ctrltipo.getAll().toArray()));
		cmbbxTipo.setSelectedIndex(-1);
		cmbbxTipo.setBounds(155, 127, 173, 20);
		contentPane.add(cmbbxTipo);
		
	}
	
	protected void buscar() {								
		Elemento elEncontrado = new Elemento();
		el = new Elemento();
		el.setNombre(txtNombre.getText());
		try{
		elEncontrado = this.ctrl.consulta(el);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		if (elEncontrado == null) {
			this.lblResultado.setText("No encontrado");
			limpiarCampos();
			txtNombre.requestFocusInWindow();			
		}
		else {	
		txtiD.setText(String.valueOf(elEncontrado.getID()));
		if (elEncontrado.getTipo() !=null)
		{
		cmbbxTipo.setSelectedItem(elEncontrado.getTipo());												
		}
		lblResultado.setText("Encontrado");
		}
	}
	
	protected void agregar() {
		el = new Elemento();
		el.setNombre(txtNombre.getText());
		el.setTipo((TipoElemento)cmbbxTipo.getSelectedItem());
		try{
			this.ctrl.add(el);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		this.txtiD.setText(String.valueOf(el.getID()));
		limpiarCampos();
		lblResultado.setText("Agregado");
	}
	
	protected void eliminar() {
		el = new Elemento();
		Elemento elEncontrado = new Elemento();
		el.setNombre(txtNombre.getText());
		try{
		elEncontrado = this.ctrl.consulta(el);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		if (elEncontrado == null) {
			lblResultado.setText("No encontrado");
			limpiarCampos();
			txtNombre.requestFocusInWindow();
		}
		else {
		try{
		this.ctrl.delete(el);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		limpiarCampos();
		lblResultado.setText("Eliminado");
		}
		
	}
	
	protected void modificar() {
		el = new Elemento();
		Elemento elEncontrado = new Elemento();
		el.setNombre(txtNombre.getText());
		try{
		elEncontrado = this.ctrl.consulta(el);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		if (elEncontrado == null) {
			lblResultado.setText("No encontrado");
			limpiarCampos();
			txtNombre.requestFocusInWindow();
		}
		else {
		el = new Elemento();
		el.setNombre(txtNombre.getText());
		el.setTipo((TipoElemento)cmbbxTipo.getSelectedItem());									
		try{
		this.ctrl.update(el);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		limpiarCampos();
		lblResultado.setText("Modificado");
		}
	}
	
	protected void limpiarCampos(){
		txtiD.setText("");
		txtNombre.setText("");
		cmbbxTipo.setSelectedIndex(-1);
	}

}
