package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;

import java.sql.Time;
import java.util.Date;
import util.DateLabelFormatter;

import entidades.Elemento;
import entidades.Persona;
import entidades.Reserva;
import entidades.TipoElemento;
import logica.*;
import datos.Cuenta;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.io.Console;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.SpringLayout;
import javax.swing.JTextField;

public class FormAReserva extends JFrame {
	
	
	CtrlReserva ctrlres = new CtrlReserva();
	CtrlABMCTipoElemento ctrltipo = new CtrlABMCTipoElemento();
	Cuenta cuenta = new Cuenta();

	private JPanel contentPane;
	private JComboBox cbbxTipoElemento;
	private JComboBox cbbxElemento;
	private JTextArea txtDetalle;
	private SpringLayout sl_dtpkrFecha;
	private JComboBox cbbxHora;
	private JLabel lblResultado;
	private JTextField txtFecha;
	private JButton btnReservar;
	private JLabel lblId;
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormAReserva frame = new FormAReserva();
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
	public FormAReserva() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 447, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cbbxTipoElemento = new JComboBox();
		cbbxTipoElemento.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				try {
					listarElementos();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		cbbxTipoElemento.setModel(new DefaultComboBoxModel(this.ctrltipo.getAll().toArray()));
		cbbxTipoElemento.setSelectedIndex(-1);
		cbbxTipoElemento.setBounds(36, 48, 147, 20);
		contentPane.add(cbbxTipoElemento);
		
		cbbxElemento = new JComboBox();
		cbbxElemento.setBounds(234, 48, 147, 20);
		contentPane.add(cbbxElemento);
		
		txtDetalle = new JTextArea();
		txtDetalle.setBounds(36, 203, 345, 123);
		contentPane.add(txtDetalle);
		
		btnReservar = new JButton("Reservar");
		btnReservar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					reservar();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnReservar.setBounds(36, 345, 123, 23);
		contentPane.add(btnReservar);
		
		JLabel lblTipoElemento = new JLabel("Seleccione Tipo Elemento");
		lblTipoElemento.setBounds(36, 21, 164, 14);
		contentPane.add(lblTipoElemento);
		
		JLabel lblElemento = new JLabel("Seleccione Elemento");
		lblElemento.setBounds(234, 21, 147, 14);
		contentPane.add(lblElemento);
		
		/*UtilDateModel model = new UtilDateModel();
		//model.setDate(20,04,2014);
		// Need this...
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		// Don't know about the formatter, but there it is...
		JDatePickerImpl dtpkrFecha = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		//springLayout.putConstraint(SpringLayout.NORTH, datePicker.getJFormattedTextField(), 0, SpringLayout.NORTH, datePicker);
		//springLayout.putConstraint(SpringLayout.WEST, datePicker.getJFormattedTextField(), 0, SpringLayout.WEST, datePicker);
		//springLayout.putConstraint(SpringLayout.EAST, datePicker.getJFormattedTextField(), 200, SpringLayout.WEST, datePicker);
		sl_dtpkrFecha = (SpringLayout) dtpkrFecha.getLayout();
		
		dtpkrFecha.setBounds(36, 114, 202, 42);

		contentPane.add(dtpkrFecha);*/
		
		JLabel lblFecha = new JLabel("Fecha en formato yyyy-MM-dd");
		lblFecha.setBounds(36, 89, 189, 14);
		contentPane.add(lblFecha);
		
		JLabel lblDescripcion = new JLabel("Ingrese texto descriptivo para la Reserva");
		lblDescripcion.setBounds(36, 167, 345, 14);
		contentPane.add(lblDescripcion);
		
		lblResultado = new JLabel("");
		lblResultado.setBounds(192, 349, 189, 14);
		contentPane.add(lblResultado);
		
		JLabel lblHora = new JLabel("Seleccione Hora");
		lblHora.setBounds(262, 89, 119, 14);
		contentPane.add(lblHora);
		
		cbbxHora = new JComboBox();
		cbbxHora.setModel(new DefaultComboBoxModel(new String[] {"12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		cbbxHora.setSelectedIndex(-1);
		cbbxHora.setBounds(262, 114, 119, 20);
		contentPane.add(cbbxHora);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(36, 114, 178, 20);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);
		
		lblId = new JLabel("ID Reserva");
		lblId.setEnabled(false);
		lblId.setBounds(36, 379, 90, 14);
		contentPane.add(lblId);
		
		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setEditable(false);
		txtId.setBounds(128, 379, 86, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		
	}
	
	private void listarElementos() throws Exception{
		TipoElemento tipoelemento = (TipoElemento)cbbxTipoElemento.getSelectedItem();
		if (tipoelemento != null) {
			ArrayList<Elemento> elesvalidos = buscaElementosValidos(tipoelemento.getID());
			this.cbbxElemento.setModel(new DefaultComboBoxModel(elesvalidos.toArray()));
			cbbxElemento.setSelectedIndex(-1);
		}
	}
	
	private ArrayList<Elemento> buscaElementosValidos(int idtipo) throws Exception{
		CtrlABMCElemento ctrl = new CtrlABMCElemento();
		ArrayList<Elemento> eles = new ArrayList<Elemento>();
		ArrayList<Elemento> elesvalidos = new ArrayList<Elemento>();
		eles = ctrl.getall();
		for (Elemento elemento : eles) {
			if (elemento.getTipo().getID() == idtipo) {
				elesvalidos.add(elemento);
			}			
		}
		return elesvalidos;
	}
	
	private void reservar() throws Exception{
		Reserva reserva = new Reserva();
		reserva.setTipoelemento((TipoElemento)cbbxTipoElemento.getSelectedItem());
		reserva.setElemento((Elemento)cbbxElemento.getSelectedItem());
		reserva.setPersona(cuenta.getPersonaPrueba());
		reserva.setDetalle(txtDetalle.getText());
		reserva.setFecha(txtFecha.getText());
		reserva.setHora((String)cbbxHora.getSelectedItem());
		//reserva.setFecha(java.sql.Date.valueOf(txtFecha.getText()));
		//reserva.setHora(java.sql.Time.valueOf((String)cbbxHora.getSelectedItem()));
		if (btnReservar.getText()== "Reservar") {
		ctrlres.add(reserva);
		this.limpiarCampos();
		lblResultado.setText("Reservado");
		}
		else if (btnReservar.getText() == "Borrar"){
		reserva.setId(Integer.parseInt(txtId.getText()));
		ctrlres.delete(reserva);
		this.limpiarCampos();
		lblResultado.setText("Eliminado");
		}
	}
	
	private void limpiarCampos(){
		cbbxTipoElemento.setSelectedIndex(-1);
		cbbxElemento.setModel(new DefaultComboBoxModel(new String[] {""}));
		txtFecha.setText("");
		cbbxHora.setSelectedIndex(-1);
		txtDetalle.setText("");
		
	}
	
	public void mostrarReserva(Reserva r){
		this.mapearAform(r);
		btnReservar.setText("Borrar");
		this.show();
	}
	
	public void mapearAform(Reserva r){
		this.cbbxTipoElemento.setSelectedItem(r.getTipoelemento());
		this.cbbxElemento.setSelectedItem(r.getElemento());
		this.txtFecha.setText(r.getFecha());
		this.cbbxHora.setSelectedItem(r.getHora());
		this.txtDetalle.setText(r.getDetalle());
		this.lblId.enable(true);
		this.txtId.enable(true);
		this.txtId.setText(String.valueOf(r.getId()));
	}
}
