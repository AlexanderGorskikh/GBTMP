
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class ToyStore {
	private List<Toys> toysList = new ArrayList<Toys>();
	private Queue<Toys> toysQueue = new LinkedList<Toys>();
	public void addToys(Toys toys) {
		toysList.add(toys);
	}

	public void choiceToy() {
		Random rnd = new Random();
		int maxWeight = 0;
		for (Toys t : toysList) {
			maxWeight += t.getWeight();
		}
		int randWeight = rnd.nextInt(maxWeight);
		for (int i = 0; i < toysList.size(); i++) {
			randWeight -= toysList.get(i).getWeight();
			if (randWeight <= 0) {
				toysQueue.add(toysList.get(i));
			}
		}
	}

	public void getToy() throws IOException {
		FileWriter writer = new FileWriter("log.md",true);
		
		if (!toysQueue.isEmpty()) {
			writer.write(toysQueue.poll().toString() + LocalDateTime.now());
		} 
		writer.flush();
		writer.close();
	}
	public boolean changeWeight(int ID, int currentWeight) {
		for (Toys t: toysList) {
			if (t.getID()==ID) {
				t.setWeight(currentWeight);
				return true;
			}
		}
		return false;
	}
	public void getInfo() {
		System.out.println(toysList);
	}
}
