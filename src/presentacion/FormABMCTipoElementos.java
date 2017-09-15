package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;

import logica.CtrlABMCTipoElemento;

import entidades.Persona;
import entidades.TipoElemento;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FormABMCTipoElementos extends JFrame {
	
	TipoElemento te;
	CtrlABMCTipoElemento ctrl = new CtrlABMCTipoElemento();

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtCantidad;
	private JTextField txtiD;
	private JLabel lblResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormABMCTipoElementos frame = new FormABMCTipoElementos();
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
	public FormABMCTipoElementos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre de Tipo de elemento");
		lblNombre.setBounds(45, 93, 196, 14);
		contentPane.add(lblNombre);
		
		JLabel lblCantMaxResPend = new JLabel("Cantidad maxima de\r\n reservas pendientes ");
		lblCantMaxResPend.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantMaxResPend.setToolTipText("");
		lblCantMaxResPend.setBounds(45, 133, 207, 14);
		contentPane.add(lblCantMaxResPend);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(263, 90, 196, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(263, 130, 86, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		lblResultado = new JLabel("");
		lblResultado.setBounds(374, 127, 196, 23);
		contentPane.add(lblResultado);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				agregar();
			}
		});
		btnAgregar.setBounds(45, 181, 89, 23);
		contentPane.add(btnAgregar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				modificar();
			}
		});
		btnModificar.setBounds(163, 181, 89, 23);
		contentPane.add(btnModificar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				buscar();
			}
		});
		btnConsultar.setBounds(281, 181, 89, 23);
		contentPane.add(btnConsultar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				eliminar();
			}
		});
		btnEliminar.setBounds(400, 181, 89, 23);
		contentPane.add(btnEliminar);
		
		JLabel lbliD = new JLabel("ID Tipo de elemento");
		lbliD.setBounds(45, 53, 136, 14);
		contentPane.add(lbliD);
		
		txtiD = new JTextField();
		txtiD.setEditable(false);
		txtiD.setBounds(263, 53, 86, 20);
		contentPane.add(txtiD);
		txtiD.setColumns(10);
	}
	
	protected void buscar() {								
		TipoElemento teEncontrada = new TipoElemento();
		te = new TipoElemento();
		te.setNombre(txtNombre.getText());
		try{
		teEncontrada = this.ctrl.consulta(te);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		if (teEncontrada == null) {
			this.lblResultado.setText("No encontrado");
			limpiarCampos();
			txtNombre.requestFocusInWindow();			
		}
		else {
		txtCantidad.setText(String.valueOf(teEncontrada.getCantMaxReservasPendientes()));
		txtiD.setText(String.valueOf(teEncontrada.getID()));
				
		this.lblResultado.setText("Encontrado");
		}
	}
	
	protected void agregar() {
		
		te = new TipoElemento();
		te.setNombre(txtNombre.getText());
		te.setCantMaxReservasPendientes(Integer.parseInt(txtCantidad.getText()));
		try{
			this.ctrl.add(te);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		this.txtiD.setText(String.valueOf(te.getID()));
		limpiarCampos();
		this.lblResultado.setText("Agregado");
		}
	
	
	protected void eliminar() {
		te = new TipoElemento();
		TipoElemento teEncontrada = new TipoElemento();
		te.setNombre(txtNombre.getText());
		try{
		teEncontrada = this.ctrl.consulta(te);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		if (teEncontrada == null) {
			this.lblResultado.setText("No encontrado");
			limpiarCampos();
			txtNombre.requestFocusInWindow();
		}
		else {
		try{
		this.ctrl.delete(te);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		limpiarCampos();
		this.lblResultado.setText("Eliminado");
		}
		
	}
	
	protected void modificar() {
		te = new TipoElemento();
		TipoElemento teEncontrada = new TipoElemento();
		te.setNombre(txtNombre.getText());
		try{
		teEncontrada = this.ctrl.consulta(te);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		if (teEncontrada == null) {
			this.lblResultado.setText("No encontrado");
			limpiarCampos();
			txtNombre.requestFocusInWindow();
		}
		else {
		te = new TipoElemento();
		te.setNombre(txtNombre.getText());
		te.setCantMaxReservasPendientes(Integer.parseInt(txtCantidad.getText()));
		try{
		this.ctrl.update(te);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		limpiarCampos();
		this.lblResultado.setText("Modificado");
		}
		
	}
	
	protected void limpiarCampos(){
		txtNombre.setText("");
		txtCantidad.setText("");
	}

}
