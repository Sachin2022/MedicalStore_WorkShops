package com.MedicalStore;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
	Scanner scanner = new Scanner(System.in);
	private static UserInterface instance;
	private UserInterface() {
		
	}

	public static UserInterface getInstance() {
		if (instance == null) {
			instance = new UserInterface();
		}
		return instance;
	}

	public void print(ArrayList<Medicine> medicineList) {
		for (Object medicine : medicineList) {
			System.out.println(medicine);
		}
	}

	public int showMainMenu() {
		System.out.println("Select");
		System.out
				.println("1. Add Medicine \n2. Remove Medicine\n" + "3. Print Medicine\n4. Update Medicine\n5. Exit  ");
		int choice = scanner.nextInt();
		return choice;
	}

	public String selectMedicine() {
		System.out.println("Enter the name of medicine : ");
		String userSelection = scanner.next();
		return userSelection;
	}

	public int showUpdateMenu() {
		System.out.println("Select");
		System.out.println("1. Update Name \n2. Update Brandname\n" + "3. Update Type\n4. Update Price\n5. Exit  ");
		int updateChoice = scanner.nextInt();
		return updateChoice;
	}

	public int showTypeOptions() {
		System.out.println("Select");
		System.out.println("1. AYURVEDIC \n2. ALLOPATHY \n3. HOMEOPATHY ");
		int selectedType = scanner.nextInt();
		return selectedType;
	}
}
