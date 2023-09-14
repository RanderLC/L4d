package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import model.Usuario;

public class Demo08 {
	// listado de los usuarios
	public static void main(String[] args) {
		// llamar a la conexión
		String usuario = JOptionPane.showInputDialog("Ingrese su usuario:");
		String clave = JOptionPane.showInputDialog("Ingrese su clave");
		
		
		
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
				System.out.println("Codigo.....:"+ u.getCod_usua());
				System.out.println("Nombre.....:"+ u.getNom_usua() + " " + u.getApe_usua());
				System.out.println("Tipo.......:"+ u.getIdtipo() + " " + u.getObjTipo().getDescripcion());
				System.out.println("----------------------------");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Usuario o clave incorrecta.");
		}
		
		manager.close();
		
		
	}
}
