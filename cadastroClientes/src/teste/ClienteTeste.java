package teste;

import dao.ClienteDAO;
import model.Cliente;

public class ClienteTeste {
	
	public static void main(String[] args) {
		
		Cliente c = new Cliente();
		ClienteDAO dao = new ClienteDAO();
		
		//c = dao.RemoverCliente((long) 4);
		
		c = dao.BuscaClientePorIdLazy((long) 1);
		
		System.out.println("Código: " + c.getId() + "\nNome: " + c.getNome());
		
	}

}
