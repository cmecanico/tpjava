package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FormOpciones extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormOpciones frame = new FormOpciones();
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
	public FormOpciones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 365, 282);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnABMCPersonas = new JButton("ABMC de Personas");
		btnABMCPersonas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				persona();
			}
		});
		
		JButton btnABMCTiposElemento = new JButton("ABMC de Tipos de Elemento");
		btnABMCTiposElemento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tipoelemento();
				
			}
		});
		
		JButton btnABMCElementos = new JButton("ABMC de Elementos");
		btnABMCElementos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					elemento();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		JButton btnAReserva = new JButton("Hacer una Reserva");
		btnAReserva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					aReserva();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		JButton btnCBReserva = new JButton("Consultar / Cancelar Reserva");
		btnCBReserva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cbReserva();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(70)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnCBReserva, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnABMCPersonas, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
						.addComponent(btnABMCTiposElemento, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnABMCElementos, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnAReserva, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(71, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnABMCPersonas)
					.addGap(18)
					.addComponent(btnABMCTiposElemento)
					.addGap(18)
					.addComponent(btnABMCElementos)
					.addGap(18)
					.addComponent(btnAReserva)
					.addGap(18)
					.addComponent(btnCBReserva)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	protected void aReserva() throws Exception{
		FormAReserva formareserva = new FormAReserva();
		formareserva.setVisible(true);
		this.setVisible(false);
	}
		
	protected void cbReserva(){
		FormCBReserva formcbreserva = new FormCBReserva();
		formcbreserva.setVisible(true);
		this.setVisible(false);	
	}
	
	protected void persona(){
		FormABMCPersonas formabmcpersonas = new FormABMCPersonas();
		formabmcpersonas.setVisible(true);
		this.setVisible(false);
	}
	
	protected void elemento() throws Exception{
		FormABMCElementos formabmcelementos = new FormABMCElementos();
		formabmcelementos.setVisible(true);
		this.setVisible(false);
	}
	
	protected void tipoelemento(){
		FormABMCTipoElementos formabmctipoelemento = new FormABMCTipoElementos();
		formabmctipoelemento.setVisible(true);
		this.setVisible(false);
	}
}
