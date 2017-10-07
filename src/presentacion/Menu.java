package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;

public class Menu {

	private JFrame frame;
	private JDesktopPane desktopPane;
	private JMenuItem mnuABMCPersona;
	private JMenu mnuAcciones;
	private JMenuItem nuABMCTipoElemento;
	private JMenuItem nuABMCElemento;
	private JMenuItem nuAReserva;
	private JMenuItem nuCBReserva;
	private JMenuItem nuSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 678, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mnuAcciones = new JMenu("Acciones");
		menuBar.add(mnuAcciones);
		
		mnuABMCPersona = new JMenuItem("ABMC de Personas");
		mnuABMCPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mnuABMCPersonaClick();
			}
		});
		mnuAcciones.add(mnuABMCPersona);
		
		nuABMCTipoElemento = new JMenuItem("ABMC de Tipos de Elemento");
		mnuAcciones.add(nuABMCTipoElemento);
		
		nuABMCElemento = new JMenuItem("ABMC de Elementos");
		mnuAcciones.add(nuABMCElemento);
		
		nuAReserva = new JMenuItem("Hacer una Reserva");
		mnuAcciones.add(nuAReserva);
		
		nuCBReserva = new JMenuItem("Listado de Reservas");
		nuCBReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mnuListadoPersonaClick();
			}
		});
		mnuAcciones.add(nuCBReserva);
		
		nuSalir = new JMenuItem("Salir");
		nuSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salir();
			}
		});
		mnuAcciones.add(nuSalir);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		desktopPane = new JDesktopPane();
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
	}

	protected void mnuABMCPersonaClick() {
		FormABMCPersonas abmPer = new FormABMCPersonas();
		abmPer.show();
		//FormABMCPersonas abmPer = new FormABMCPersonas();
		//desktopPane.add(abmPer);
		//abmPer.setVisible(true);
	}
	
	protected void mnuListadoPersonaClick() {
		FormCBReserva cbRes = new FormCBReserva();
		desktopPane.add(cbRes);
		cbRes.setVisible(true);
	}
	
	protected void salir(){
		System.exit(0);
	}
}