package pe.com.pablo.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pe.com.pablo.service.*;
import pe.com.pablo.service.impl.*;
import pe.com.pablo.entity.*;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class Prueba extends JFrame {
	
	FacturaService facturaService=new FacturaServiceImpl();
	ClienteService clienteService=new ClienteServiceImpl();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTotal;
	private JTextField txtEstado;
	private JTextArea textArea ;
	JComboBox cboClientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prueba frame = new Prueba();
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
	public Prueba() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cliente");
		lblNewLabel.setBounds(26, 11, 60, 17);
		contentPane.add(lblNewLabel);
		
		cboClientes = new JComboBox();
		cboClientes.setBounds(80, 11, 168, 26);
		contentPane.add(cboClientes);
		
		JLabel lblNewLabel_1 = new JLabel("Total");
		lblNewLabel_1.setBounds(26, 51, 48, 17);
		contentPane.add(lblNewLabel_1);
		
		txtTotal = new JTextField();
		txtTotal.setColumns(10);
		txtTotal.setBounds(80, 49, 168, 21);
		contentPane.add(txtTotal);
		
		JLabel lblNewLabel_2 = new JLabel("Estado");
		lblNewLabel_2.setBounds(26, 84, 48, 17);
		contentPane.add(lblNewLabel_2);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(80, 82, 168, 21);
		contentPane.add(txtEstado);
		
		JButton btnGrabar_1 = new JButton("Grabar");
		btnGrabar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnGrabar_1ActionPerformed(e);
			}
		});
		btnGrabar_1.setBounds(80, 113, 106, 27);
		contentPane.add(btnGrabar_1);
		
		JButton btnListar_1 = new JButton("Listar");
		btnListar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnListar_1ActionPerformed(e);
			}
		});
		btnListar_1.setBounds(198, 115, 106, 27);
		contentPane.add(btnListar_1);
		
		textArea = new JTextArea();
		textArea.setBounds(26, 175, 489, 225);
		contentPane.add(textArea);
		
		llenaCombos();
	}
	
	protected void btnGrabar_1ActionPerformed(ActionEvent e) {
		grabar();
	}
	protected void btnListar_1ActionPerformed(ActionEvent e) {
		listar();
	}
	
	void listar() {
		facturaService.ListarTodo().forEach(f -> {
			textArea.append("Factura: " + f.getNumfactura() + ", Cliente: " + f.getCliente().getNombre() + ", Total: " + f.getTotal() + ", Estado: " + f.getEstado() + "\n");
			//System.out.println("Factura: " + f.getNumfactura() + ", Cliente: " + f.getCliente().getNombre() + ", Total: " + f.getTotal() + ", Estado: " + f.getEstado());
		});
		
	}
	
	void llenaCombos() {
		
		 List<Cliente> clientes = clienteService.ListarTodo();
		 
		// System.out.print("Clientes: "+clientes.size());
		//System.out.print("Cargando combos");
		 
		 DefaultComboBoxModel<Cliente> modelCli = new DefaultComboBoxModel<>(clientes.toArray(new Cliente[0]));
		 cboClientes.setModel(modelCli);
		
	}
	
	void grabar() {
		// TODO Auto-generated method stub
		  Factura fc=new Factura();
		  fc.setNumfactura(0);
		  fc.setEstado(txtEstado.getText());
		  fc.setTotal(Double.parseDouble(txtTotal.getText()));
		  fc.setCliente((Cliente) cboClientes.getSelectedItem());
		  //
		  //Cliente clientSeleccionado= (Cliente)  cboClientes.getSelectedItem();
		  //System.out.println("Cliente seleccionado: " + clientSeleccionado.getIdCliente());

		  
		  
		  
		//  facturaService.create(null);
		  facturaService.Crear(fc);

	}
}
