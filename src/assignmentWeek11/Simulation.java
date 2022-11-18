package assignmentWeek11;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;

public class Simulation {

	private String itemName;
	private String itemWeight;
	private int countR1 = 1, countR2 = 1;

	ArrayList<Item> arrayList = new ArrayList<>();

	ArrayList<Item> loadItems(String fileName) throws IOException {
		try (BufferedReader bufReader = new BufferedReader(new FileReader(fileName))) {
			System.out.println("NAME \t\t        WEIGHT");
			String line = bufReader.readLine();
			while (line != null) {
				Item item = new Item(itemName, itemWeight);
				int pos = line.indexOf("=");
				item.itemName = line.substring(0, pos);
				item.itemWeight = line.substring(pos + 1);
				arrayList.add(item);
				item.printItemData();
				line = bufReader.readLine();
			}
			return arrayList;
		}
	}

	ArrayList<Rocket> loadU1(ArrayList<Item> arrayList) {
		R1 r1 = new R1();
		ArrayList<Rocket> rocketsR1 = new ArrayList<Rocket>();
		rocketsR1.add(r1);
		for (int i = 0; i < arrayList.size(); i++) {
			if (r1.canCarry(arrayList.get(i))) {
				if (i == 0) {
					System.out.println("R1 object" + countR1 + ":");
				}
				r1.carry(arrayList.get(i));
			} else {
				countR1++;
				System.out.println("\nR1 object" + countR1 + ":");
				r1 = new R1();
				rocketsR1.add(r1);
				r1.carry(arrayList.get(i));
			}
		}
		return rocketsR1;
	}

	ArrayList<Rocket> loadU2(ArrayList<Item> arrayList) {
		R2 r2 = new R2();
		ArrayList<Rocket> rocketsR2 = new ArrayList<Rocket>();
		rocketsR2.add(r2);
		for (int i = 0; i < arrayList.size(); i++) {
			if (r2.canCarry(arrayList.get(i))) {
				if (i == 0) {
					System.out.println("R2 object" + countR2 + ":");
				}
				r2.carry(arrayList.get(i));
			} else {
				countR2++;
				System.out.println("\nR2 object" + countR2 + ":");
				r2 = new R2();
				rocketsR2.add(r2);
				r2.carry(arrayList.get(i));
			}
		}
		return rocketsR2;
	}

	int runSimulation(ArrayList<Rocket> rockets) {
		int totalCost = 0;
		for (int i = 0; i < rockets.size(); i++) {
			while (!(rockets.get(i).launch() && rockets.get(i).land())) {
				totalCost += rockets.get(i).rocketCost;
				if (!(rockets.get(i).launch())) {
					System.out.println("Object " + (i + 1) + " EXPLODED!!Try launching again.");
				} else {
					System.out.println("Object " + (i + 1) + " CRASHED!!Try launching again.");
				}
			}
			totalCost += rockets.get(i).rocketCost;
			System.out.println("Object " + (i + 1) + " SUCCESSFULLY LAUNCHED AND LANDED BACK");
		}
		return totalCost;
	}
}
