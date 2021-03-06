package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("\n=== TEST 0: department findByName =====");
		Department dep = departmentDao.findByName("Sports");
		if (dep != null) {
			System.out.println("Found: " + dep);
		} else {
			System.out.println("Department not found!");
		}
		
		System.out.println("\n=== TEST 1: department insert =====");
		if (dep == null) {
			dep = new Department(null, "Sports");
			departmentDao.insert(dep);
			System.out.println("Inserted! New id: " + dep.getId());
		} else {
			System.out.println("Department already exists!");
		}

		System.out.println("\n=== TEST 2: department findById =====");
		System.out.print("Type de id to be retrieved: ");
		int id = sc.nextInt();
		sc.nextLine();
		dep = departmentDao.findById(id);
		System.out.println(dep);
		
		System.out.println("\n=== TEST 3: department update =====");
		System.out.print("Type a department id to be updated: ");
		id = sc.nextInt();
		sc.nextLine();
		dep = departmentDao.findById(id);
		dep.setName("Auto");
		departmentDao.update(dep);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 4: department deleteById =====");
		System.out.print("Type an id to be deleted: ");
		id = sc.nextInt();
		sc.nextLine();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		
		System.out.println("\n=== TEST 5: department findAll =====");
		List<Department> list = departmentDao.findAll();
		list.stream().forEach(System.out::println);
		
		sc.close();
	}
}
