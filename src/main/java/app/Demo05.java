package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo05 {
	// listado de los usuarios
	public static void main(String[] args) {
		// llamar a la conexión
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager manager = fabrica.createEntityManager();
		// select * from tb_XXX
		
		String sql = "select u from Usuario u";
		List<Usuario> lsUsuarios = manager.createQuery(sql, Usuario.class).getResultList();
		
		//recorre el listado y lo muetra
		for (Usuario u : lsUsuarios) {
			System.out.println("Codigo.....:"+ u.getCod_usua());
			System.out.println("Nombre.....:"+ u.getNom_usua() + " " + u.getApe_usua());
			System.out.println("Tipo.......:"+ u.getIdtipo() + " " + u.getObjTipo().getDescripcion());
			System.out.println("----------------------------");
		}
		
		manager.close();
		
		
	}
}
