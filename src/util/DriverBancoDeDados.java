package util;

public class DriverBancoDeDados {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver carregado com sucesso.");
		} catch (ClassNotFoundException e) {
			System.out.println("DRIVE DO BANCO NÃO ENCONTRADO.");
		}
	}
}
