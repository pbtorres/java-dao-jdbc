package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Menu {
	
	private static SellerDao sellerDao = DaoFactory.createSellerDao();
	private static DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public static void menu() {
		System.out.println("==============MENU===============\n");
		System.out.println("O- Exit");
		System.out.println("1- Find Seller by id");
		System.out.println("2- Find all Sellers");
		System.out.println("3- Delete Seller");
		System.out.println("4- Find seller by Department id");
		System.out.println("5- Insert new Seller");
		System.out.println("6- Update Seller");
		System.out.println("7- Find Department by id");
		System.out.println("8- Find all Departments");
		System.out.println("9- Insert new Department");
		System.out.println("10- Update Department");
		System.out.println("11- Delete Department");
		System.out.println("\n===============================\n");

		System.out.print("WHAT DO YOU WANT TO DO? ");
	}
	
	public static void findSellerById(Scanner sc) {
		System.out.println("====== Seller findById ======\n");
		System.out.print("Enter seller id: ");
		int id = sc.nextInt();
		
		Seller seller = sellerDao.findById(id);
		System.out.println(seller);
		System.out.println("\n=============================\n");
	}
	
	public static void findAllSeller() {
		System.out.println("\n====== Seller findAll ======\n");
		List<Seller> list = sellerDao.findAll();
		
		for (Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println("\n=============================\n");
	}
	
	public static void deleteSeller(Scanner sc) {
		System.out.println("\n====== Seller Delete ======\n");
		System.out.println("Enter id for delete: ");
		int id = sc.nextInt();
		sellerDao.deleteByID(id);
		
		System.out.println("Delete completed!");
		System.out.println("\n=============================\n");
	}
	
	public static void findSellerByDepartment(Scanner sc) {
		System.out.println("\n====== Seller findByDepartment ======\n");
		System.out.println("Enter Department id: ");
		int id = sc.nextInt();
		Department department = new Department(id, null);
		
		List<Seller> list = sellerDao.findByDepartment(department);
		
		for (Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println("\n=============================\n");
	}
	
	public static void insertSeller(Scanner sc) throws ParseException {
		System.out.println("\n===== Seller insert ======\n");
		System.out.print("Enter seller name: ");
		String name = sc.nextLine();
		
		System.out.print("Enter email: ");
		String email = sc.nextLine();

		System.out.print("Enter birth date (dd/MM/yyyy): ");
		Date birthDate = sdf.parse(sc.next());

		System.out.print("Enter base salary: ");
		Double baseSalary = sc.nextDouble();

		System.out.print("Enter department name: ");
		String department = sc.next();

		Department dep = new Department(null, department);
		departmentDao.insert(dep);
		
		Seller seller = new Seller(null, name, email, birthDate, baseSalary, dep);
		
		sellerDao.insert(seller);
		
		System.out.println("\nInserted! [id=" + seller.getId() + " name=" + seller.getName() + "]");
		System.out.println("\n=============================\n");
	}
	
	public static void updateSeller(Scanner sc) throws ParseException {
		System.out.println("\n====== Seller update ======\n");
		System.out.print("Enter seller id for update: ");
		int id = sc.nextInt();
		sc.nextLine();
		Seller seller = sellerDao.findById(id);
		
		System.out.print("Enter seller name: ");
		seller.setName(sc.nextLine());
		
		System.out.print("Enter seller email: ");
		seller.setEmail(sc.nextLine());
		
		System.out.print("Enter birth date: ");
		seller.setBirthDate(sdf.parse(sc.nextLine()));
		
		System.out.print("Enter salary base: ");
		seller.setSalary(sc.nextDouble());
		sc.nextLine();
		
		System.out.print("Enter department id: ");
		Department dep = departmentDao.findById(sc.nextInt());
		seller.setDepartment(dep);
		
		sellerDao.update(seller);
	
		System.out.println("\nUpdate completed!");
		System.out.println("\n=============================\n");
	}
	
	public static void findDepartmentById(Scanner sc) {
		System.out.println("\n====== Department findById ======\n");
		System.out.print("Enter department id: ");
		Department dep = departmentDao.findById(sc.nextInt());

		System.out.println(dep);
		System.out.println("\n=============================\n");
	}
	
	public static void findAllDepartment() {
		System.out.println("\n====== Department findAll ======\n");
		List<Department> listDep = departmentDao.findall();
		
		for (Department obj : listDep) {
			System.out.println(obj);
		}
		System.out.println("\n=============================\n");
	}
	
	public static void insertDepartment(Scanner sc) {
		System.out.println("\n====== Department Insert ======\n");
		System.out.print("enter department name: ");
		Department dep = new Department(null, sc.nextLine());
		
		departmentDao.insert(dep);

		System.out.println("\n" + dep);
		System.out.println("\n=============================\n");
	}
	
	public static void updateDepartment(Scanner sc) {
		System.out.println("\n====== Department update ======\n");
		System.out.print("Enter department id: ");
		Department dep = departmentDao.findById(sc.nextInt());
		sc.nextLine();

		System.out.print("Enter department name: ");
		dep.setName(sc.nextLine());
		
		departmentDao.update(dep);
		
		System.out.println("Update completed!");
		System.out.println("\n=============================\n");
	}
	
	public static void deleteDepartment(Scanner sc) {
		System.out.println("\n====== Department delete ======\n");
		System.out.println("Enter id for delete: ");
		departmentDao.deleteByID(sc.nextInt());
		
		System.out.println("Delete completed!");
		System.out.println("\n=============================\n");
	}
	
}
