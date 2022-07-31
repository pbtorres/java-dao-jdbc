package aplication;

import java.text.ParseException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		int x;
		
		do {
			Menu.menu();
			x = sc.nextInt();
			sc.nextLine();
			
			switch (x) {
			case 0:
				System.out.println("End Program!");
				System.exit(x);
			case 1:
				Menu.findSellerById(sc);
				break;
			case 2:
				Menu.findAllSeller();
				break;
			case 3:
				Menu.deleteSeller(sc);
				break;
			case 4:
				Menu.findSellerByDepartment(sc);
				break;
			case 5:
				Menu.insertSeller(sc);
				break;
			case 6:
				Menu.updateSeller(sc);
				break;
			case 7:
				Menu.findDepartmentById(sc);
				break;
			case 8:
				Menu.findAllDepartment();
				break;
			case 9:
				Menu.insertDepartment(sc);
				break;
			case 10:
				Menu.updateDepartment(sc);
				break;
			case 11:
				Menu.deleteDepartment(sc);
				break;

			default:
				System.out.println("Invalid option!");
			}

		} while (x != 0);
		
		sc.close();
	}

}