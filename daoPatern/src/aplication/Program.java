package aplication;

import java.util.Date;
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
		
		System.out.println("====== Seller findById ======\n");
		Seller seller = sellerDao.findById(5);
		System.out.println(seller);
		System.out.println("\n=============================\n");

		
		System.out.println("\n====== Seller findByDepartment ======\n");
		Department department = new Department(2, null);
		
		List<Seller> list = sellerDao.findByDepartment(department);
		
		for (Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println("\n=============================\n");

		System.out.println("\n====== Seller findAll ======\n");
		list = sellerDao.findAll();
		
		for (Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println("\n=============================\n");
		
		System.out.println("\n====== Seller insert ======\n");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		
		sellerDao.insert(newSeller);
		
		System.out.println("Inserted! [id=" + newSeller.getId() + ", name=" + newSeller.getName() + "]");
		System.out.println("\n=============================\n");
		
		System.out.println("\n====== Seller update ======\n");
		seller = sellerDao.findById(2);
		seller.setName("Maria");
		seller.setEmail("maria@gmail.com");
		sellerDao.update(seller);
		
		System.out.println("Update completed!");
		System.out.println("\n=============================\n");
		
		System.out.println("\n====== Seller Delete ======\n");
		System.out.println("Enter id for delete: ");
		int id = sc.nextInt();
		sellerDao.deleteByID(id);
		
		System.out.println("Delete completed!");
		System.out.println("\n=============================\n");

		sc.close();
	}

}
