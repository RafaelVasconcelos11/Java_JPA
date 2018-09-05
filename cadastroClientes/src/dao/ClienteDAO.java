package dao;

import javax.persistence.EntityManager;

import connection.Conexao;
import model.Cliente;

public class ClienteDAO {
	
	public Cliente adicionarCliente(Cliente cliente) {
		
		EntityManager em = new Conexao().getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(cliente);
			em.getTransaction().commit();
		}catch (Exception e) {
			System.out.println(e);
		}finally {
			em.close();
		}
		
		return cliente;
	}
	
	public Cliente BuscaClientePorIdEager(Long id){
		
		EntityManager em = new Conexao().getEntityManager();
		
		return em.find(Cliente.class, id);
	}
	
	public Cliente BuscaClientePorIdLazy(Long id){
		
		EntityManager em = new Conexao().getEntityManager();
		
		return em.getReference(Cliente.class, id);
	}
	
	public Cliente AtualizarCliente(Cliente cliente) {
		
		EntityManager em = new Conexao().getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(cliente);
			em.getTransaction().commit();
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return cliente;
	}
	
	public Cliente DesvincularCliente(Cliente cliente) {
		EntityManager em = new Conexao().getEntityManager();
		
		em.detach(cliente);
		
		return cliente;
	}
	
	public Cliente RemoverCliente(Long id) {
		
		EntityManager em = new Conexao().getEntityManager();
		Cliente cliente = null;
		
		try {
			
			cliente = em.find(Cliente.class, id);
			if(cliente != null) {
				
				em.getTransaction().begin();
				em.remove(cliente);
				em.getTransaction().commit();
			}else{
				
				System.out.println("O cliente referente ao código '"+ id + "' não está cadastrado!");
				
			}
			
		}catch (Exception e) {
			System.out.println("Erro: " + e);
		}finally {
			em.close();
		}
		
		return cliente;
		
	}
	
	public Cliente Refresh(Cliente cliente) {
		
		EntityManager em = new Conexao().getEntityManager();
		try {
			em.getTransaction().begin();
			em.refresh(cliente);
			em.getTransaction().commit();
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return cliente;
		
	}

}
