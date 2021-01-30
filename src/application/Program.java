package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		findAlldepartment();
		
		System.out.print("Enter id to search: ");
		int id = sc.nextInt();
		departmentById(id);
		
	}
	
	public static void seller() {
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: Seller findyById ===");
		Seller seller = sellerDao.findByid(3);
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: Seller findyByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		
		for(Seller sel : list) {
			System.out.println(sel);
		}
		

		System.out.println("\n=== TEST 3: Seller findAll ===");
		list = sellerDao.findAll();
		
		for(Seller sel : list) {
			System.out.println(sel);
		}
		
		System.out.println("\n=== TEST 4: Seller insert ===");
		Seller newSeller = new Seller("Greg","greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! new id = " + newSeller.getId());
		
		System.out.println("\n=== TEST 5: Seller update ===");
		seller = sellerDao.findByid(1);
		seller.setName("Marta Waine");
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 6: Seller delete ===");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}
	public static void findAlldepartment() {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		List<Department> list = departmentDao.findAll();
	
		
		System.out.println("List department: ");
		
		for(Department department : list) {
			System.out.println(department);
		}
		
	}
	public static void departmentById(int id) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		Department department = departmentDao.findByid(id);
		System.out.println(department);
	}
}
