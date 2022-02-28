package com.MedicalStore;

import java.util.Scanner;
import com.MedicalStore.Medicine.MedicineType;

public class Main {
	Scanner scanner = new Scanner(System.in);
//	MedicineStore medicineStore = MedicineStore.getInstance();
	
	
	
//	UserInterface userInterface = UserInterface.getInstance();

	public void handleUserSelection(int choice) {
		MedicineStore medicineStore = MedicineStore.getInstance();
		UserInterface userInterface = UserInterface.getInstance();

		switch (choice) {
		case 1:
			addMedicine();
			break;
		case 2:
			String userSelection = userInterface.selectMedicine();
			Medicine medicine = medicineStore.getMedicine(userSelection);
			medicineStore.remove(medicine);
			break;
		case 3:
			userInterface.print(medicineStore.getMedicineList());
			break;
		case 4:
			String medicineName = userInterface.selectMedicine();
			Medicine medicineForUpdate = medicineStore.getMedicine(medicineName);

			int updateChoice = userInterface.showUpdateMenu();
			updateMedicine(medicineForUpdate, updateChoice);
			break;
		case 5:
			System.exit(0);
			break;
		default:

		}
	}

	public void updateMedicine(Medicine medicineForUpdate, int updateChoice) {
		UserInterface userInterface = UserInterface.getInstance();

		switch (updateChoice) {
		case 1:
			System.out.println("Current Name is : " + medicineForUpdate.name + ". Enter your new name :");
			String newName = scanner.next();
			if (medicineForUpdate.name == newName) {
				System.out.println("Already Having This Name");
				break;
			}
			medicineForUpdate.name = newName;
			break;
		case 2:
			System.out
					.println("Current Brand Name is : " + medicineForUpdate.brandName + ". Enter your new Brandname :");
			medicineForUpdate.brandName = scanner.next();
			break;
		case 3:
			System.out.println("Current Type is : " + medicineForUpdate.type + ". Enter your new Type :");
//			medicineForUpdate.type = scanner.next();
			int SelectedType = userInterface.showTypeOptions();
			selectTypeForMedicine(SelectedType, medicineForUpdate);
			break;
		case 4:
			System.out.println("Current price is : " + medicineForUpdate.price + ". Enter your new price :");
			medicineForUpdate.price = scanner.nextInt();
			break;
		case 5:
			System.exit(0);
			break;
		}
	}

	public void selectTypeForMedicine(int SelectedType, Medicine medicineForUpdate) {
		if (SelectedType == 1) {
			medicineForUpdate.type = MedicineType.AYURVEDIC;
		} else if (SelectedType == 2) {
			medicineForUpdate.type = MedicineType.ALLOPATHY;

		} else if (SelectedType == 3) {
			medicineForUpdate.type = MedicineType.HOMEOPATHY;
		} else {
			System.out.println("Select Correct option i.e 1, 2 or 3");
		}
	}

	public void addMedicine() {
		MedicineStore medicineStore = MedicineStore.getInstance();

		Alfalfa alfalfa = new Alfalfa();
		alfalfa.price = 120;
		BTrim btrim = new BTrim();
		btrim.price = 60;
		Chawanparas chawanparas = new Chawanparas();
		chawanparas.price = 250;
		Crocin crocin = new Crocin();
		crocin.price = 600;
		Liv52 liv52 = new Liv52();
		liv52.price = 350;
		Vicks vicks = new Vicks();
		vicks.price = 240;

		medicineStore.add(alfalfa);
		medicineStore.add(btrim);
		medicineStore.add(chawanparas);
		medicineStore.add(crocin);
		medicineStore.add(liv52);
		medicineStore.add(vicks);
	}

	public static void main(String[] args) {
		/*
		 * MedicineStore medicineStore = new MedicineStore();
		 * 
		 * Alfalfa alfalfa = new Alfalfa(); alfalfa.price = 120; BTrim btrim = new
		 * BTrim(); btrim.price = 60; Chawanparas chawanparas = new Chawanparas();
		 * chawanparas.price = 250; Crocin crocin = new Crocin(); crocin.price = 600;
		 * Liv52 liv52 = new Liv52(); liv52.price = 350; Vicks vicks = new Vicks();
		 * vicks.price = 240;
		 * 
		 * medicineStore.add(alfalfa); medicineStore.add(btrim);
		 * medicineStore.add(chawanparas); medicineStore.add(crocin);
		 * medicineStore.add(liv52); medicineStore.add(vicks);
		 * 
		 * medicineStore.remove(liv52);
		 * 
		 * UserInterface userinterface = new UserInterface();
		 * userinterface.print(medicineStore.getMedicineList());
		 */
		UserInterface userInterface = UserInterface.getInstance();

		Main main = new Main();

		int choice = 0;
		while (choice != 5) {
			choice = userInterface.showMainMenu();
			main.handleUserSelection(choice);
		}
	}
}
