package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Program2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DepartmentDao departmenDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: FindById ===");
        Department dep = departmenDao.findById(1);
        System.out.println(dep);


        System.out.println("\n=== TEST 2: FindAll ===");
        List<Department> list = departmenDao.findAll();
        for (Department d : list) {
            System.out.println(d);
        }

        System.out.println("\n=== TEST 3: Insert ===");
        Department newDepartment = new Department(null, "Music");
        departmenDao.insert(newDepartment);
        System.out.println("Inserted! new id: " + newDepartment.getId());

        System.out.println("\n=== TEST 4: Update ===");
        Department dep2 = departmenDao.findById(1);
        dep2.setName("Food");
        departmenDao.update(dep2);
        System.out.println("Update completed!");

        System.out.println("\n=== TEST 5: Delete ===");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        departmenDao.deleteById(id);
        System.out.println("Delete completed!");

        sc.close();
    }
}
