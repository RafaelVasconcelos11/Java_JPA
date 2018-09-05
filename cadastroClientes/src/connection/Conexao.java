package connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {

private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("cadastro");
	
	public EntityManager getEntityManager() {
		
		return emf.createEntityManager();
	}
	
}
