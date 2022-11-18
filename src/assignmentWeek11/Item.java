package assignmentWeek11;

public class Item {

	String itemName;
	String itemWeight;

	public Item(String itemName, String itemWeight) {
		this.itemName = itemName;
		this.itemWeight = itemWeight;
	}

	protected void printItemData() {
		System.out.println(this.itemName + "\t" + "\t" + this.itemWeight);
	}
}
