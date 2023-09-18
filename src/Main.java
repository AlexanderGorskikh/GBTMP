
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		ToyStore test = new ToyStore();
		test.addToys(new Toys(0, "Самолет", 20, 20));
		test.addToys(new Toys(1, "Гидра", 20, 20));
		test.addToys(new Toys(2, "Автомат", 20, 20));
		test.addToys(new Toys(3, "Конструктор", 20, 20));
		test.choiceToy();
		try {
			test.getToy();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
