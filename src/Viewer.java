
import java.util.Scanner;

public class Viewer {
	static ToyStore test;

	public Viewer() {
		test = new ToyStore();
	}

	static void start() {
		Scanner scanner = new Scanner(System.in);
		boolean close = true;
		do {
			menu();
			switch (scanner.nextLine()) {
			case "add" -> addToys();
			case "see" -> test.getInfo();
			case "choice" -> test.choiceToy();
			case "change" -> changeWeight();
			case "q" -> close = false;
			default -> System.out.println("Команда не распознана");
			}
		} while (close);
		scanner.close();
	}

	static void addToys() {
		Scanner s = new Scanner(System.in);
		System.out.println("Введите строку формата: \"ID toyName count weight\"");
		String input = s.nextLine();
		String[] toy = input.split(" ");
		try {
			int ID = Integer.parseInt(toy[0]);
			String name = toy[1];
			int count = Integer.parseInt(toy[2]);
			int weight = Integer.parseInt(toy[3]);
			test.addToys(new Toys(ID, name, count, weight));
		} catch (Exception e) {
			System.out.println("Ошибка, несовместимый формат, или недостаточно аргументов");
		}
		s.close();
	}
	static void changeWeight() {
		Scanner s = new Scanner(System.in);
		System.out.println("Введите строку формата: <ID игрушки> <Новый шанс выпадения>");
		String [] st = s.nextLine().split(" ");
		try {
			int id = Integer.parseInt(st[0]);
			int chance = Integer.parseInt(st[1]);
			test.changeWeight(id, chance);
		} catch (Exception e) {
			System.out.println("Ошибка, несовместимый формат, или недостаточно аргументов");
		}
	}

	static void menu() {
		System.out.println("""
				Меню команд:
				1. Добавить игрушку - add
				2. Посмотреть все игрушки - see
				3. Разыграть игрушку - choice
				4. Изменить шанс выпадения игрушки - change  (<ID игрушки> <Новый шанс выпадения>)
				выход - q
				""");
	}

//	public static void main(String[] args) throws FileNotFoundException {
//
//		test.addToys(new Toys(0, "Самолет", 20, 20));
//		test.addToys(new Toys(1, "Гидра", 20, 20));
//		test.addToys(new Toys(2, "Автомат", 20, 20));
//		test.addToys(new Toys(3, "Конструктор", 20, 20));
//		test.choiceToy();
//		try {
//			test.getToy();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

}
