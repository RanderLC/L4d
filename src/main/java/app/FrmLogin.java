package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Categoria;
import model.Productos;
import model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class FrmLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtClave;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin frame = new FrmLogin();
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
	public FrmLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 146);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// llamar a la conexión
				String usuario = txtUsuario.getText();
				String clave = txtClave.getText();
				
				
				
				EntityManagerFactory fabrica = 
						Persistence.createEntityManagerFactory("jpa_sesion01");
				EntityManager manager = fabrica.createEntityManager();
				// select * from tb_XXX
				
				String sql = "select u from Usuario u where u.usr_usua = :xusr and cla_usua = :xcla";
				
				try {
					Usuario u = manager.createQuery(sql, Usuario.class)
							.setParameter("xusr", usuario)
							.setParameter("xcla", clave).getSingleResult();
					
					//recorre el listado y lo muetra
					FrmManteProd mante = new FrmManteProd();
					mante.setVisible(true);
				} catch (Exception p) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Usuario o clave incorrecta.");
				}
				
				manager.close();
				
			}
		});
		btnIngresar.setBounds(324, 29, 89, 23);
		contentPane.add(btnIngresar);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(122, 30, 161, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario :");
		lblUsuario.setBounds(10, 33, 102, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblClave = new JLabel("Clave :");
		lblClave.setBounds(10, 64, 102, 14);
		contentPane.add(lblClave);
		
		txtClave = new JTextField();
		txtClave.setColumns(10);
		txtClave.setBounds(122, 61, 161, 20);
		contentPane.add(txtClave);
		
	}

	
	
	
	
	
}
