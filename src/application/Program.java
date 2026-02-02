package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== Teste 1: seller findById ===========");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== Teste 2: seller findByDepartment ===========");
		Department department = new Department(2,null);
		List<Seller> sellers = sellerDao.findByDepartment(department);
		for(Seller sell : sellers) {
			System.out.println(sell);
		}
		
		System.out.println("\n=== Teste 3: seller findAll ===========");
		sellers = sellerDao.findAll();
		for(Seller sell : sellers) {
			System.out.println(sell);
		}
		
		System.out.println("\n=== Teste 4: seller insert ===========");
		//Seller newSeller = new Seller(null,"Greg","greg@gmail.com",new Date(),4000.0,department);
		//sellerDao.insert(newSeller);
		//System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("\n=== Teste 5: seller update ===========");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update Completed");
		
		System.out.println("\n=== Teste 6: seller Delete ===========");
		System.out.println("Enter id for delete teste:");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
		sc.close();
	}

}
