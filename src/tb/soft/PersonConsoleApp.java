package tb.soft;

import java.util.Arrays;

public class PersonConsoleApp {

	private static final String GREETING_MESSAGE =
			"Program Person - wersja konsolowa\n";

	private static final String MENU =
			"M E N U   G Ł Ó W N E				\n\n" +
					"Wybierz rodzaj kolekcji: 	\n" +
					"1 - SET 					\n" +
					"2 - LIST					\n" +
					"3 - MAP					\n";

	private static final String SetMenu =
			"S E T   M E N U					\n" +
					"1 - Dodaj do TreeSet		\n" +
					"2 - Usuń z TreeSet			\n" +
					"3 - Wyświetl TreeSet		\n" +
					"4 - Dodaj do HashSet		\n" +
					"5 - Usuń z HashSet			\n" +
					"6 - Wyświetl HashSet		\n" +
					"0 - Zakończ program		\n";
	private static final String ListMenu =
			"L I S T   M E N U					\n" +
					"1 - Dodaj do ArrayList		\n" +
					"2 - Usuń z ArrayList		\n" +
					"3 - Wyświetl ArrayList		\n" +
					"4 - Dodaj do LinkedList	\n" +
					"5 - Usuń z LinkedList		\n" +
					"6 - Wyświetl LinkedList		\n" +
					"0 - Zakończ program		\n";
	private static final String MapMenu =
			"M A P   M E N U					\n" +
					"1 - Dodaj do TreeMap		\n" +
					"2 - Usuń z TreeMap			\n" +
					"3 - Wyświetl TreeMap		\n" +
					"4 - Dodaj do HashMap		\n" +
					"5 - Usuń z HashMap			\n" +
					"6 - Wyświetl HashMap		\n" +
					"0 - Zakończ program		\n";



	private static final ConsoleUserDialog UI = new ConsoleUserDialog();


	public static void main(String[] args) throws PersonException{
		PersonConsoleApp application = new PersonConsoleApp();
		application.runMainLoop();
	}



	private Person currentPerson = null;


	public void runMainLoop() throws PersonException{
		Set set = new Set();
		List list = new List();
		Map map = new Map();
		int HashIndex = 1;
		int TreeIndex = 1;

		UI.printMessage(GREETING_MESSAGE);

		while (true) {
			UI.clearConsole();


			switch (UI.enterInt(MENU + "==>> ")) {
				case 1:
					switch (UI.enterInt(SetMenu + "(SET)==>> ")) {
						case 1:
							int equal = UI.enterInt("Czy chcesz użyć funkcji equals? Tak - 1, Nie - 0 ==>>  ");
							currentPerson = createNewPerson(equal);
							set.TreeSetAdd(currentPerson);
							break;
						case 2:
							equal = UI.enterInt("Czy chcesz użyć funkcji equals? Tak - 1, Nie - 0 ==>>  ");
							currentPerson = createNewPerson(equal);
							set.TreeSetRemove(currentPerson);
							break;
						case 3:
							set.TreeSetPrint();
							break;
						case 4:
							equal = UI.enterInt("Czy chcesz użyć funkcji equals? Tak - 1, Nie - 0 ==>>  ");
							currentPerson = createNewPerson(equal);
							set.HashSetAdd(currentPerson);
							break;
						case 5:
							equal = UI.enterInt("Czy chcesz użyć funkcji equals? Tak - 1, Nie - 0 ==>>  ");
							currentPerson = createNewPerson(equal);
							set.HashSetRemove(currentPerson);
							break;
						case 6:
							set.HashSetPrint();
							break;
						case 0:
							UI.printInfoMessage("\nProgram zakończył działanie!");
							System.exit(0);
					} break;
				case 2:
					switch (UI.enterInt(ListMenu + "(LIST)==>> ")) {
						case 1:
							int equal = UI.enterInt("Czy chcesz użyć funkcji equals? Tak - 1, Nie - 0 ==>>  ");
							currentPerson = createNewPerson(equal);
							list.ArrayListAdd(currentPerson);
							break;
						case 2:
							int ArrayListIndex = UI.enterInt("Podaj pozycję do usunięcia z ArrayList ==>> ");
							list.ArrayListRemove(ArrayListIndex);
							break;
						case 3:
							list.ArrayListPrint();
							break;
						case 4:
							equal = UI.enterInt("Czy chcesz użyć funkcji equals? Tak - 1, Nie - 0 ==>>  ");
							list.ShowLinkedListSize();
							int LinkedListIndex = UI.enterInt("==>> ");
							currentPerson = createNewPerson(equal);
							list.LinkedListAdd(LinkedListIndex, currentPerson);
							break;
						case 5:
							int LinkedListIndex2 = UI.enterInt("Podaj pozycję do usunięcia z LinkedList ==>> ");
							list.LinkedListRemove(LinkedListIndex2);
							break;
						case 6:
							list.LinkedListPrint();
							break;
						case 0:
							UI.printInfoMessage("\nProgram zakończył działanie!");
							System.exit(0);
					} break;
				case 3:
					switch (UI.enterInt(MapMenu + "(MAP)==>> ")) {
						case 1:
							int equal = UI.enterInt("Czy chcesz użyć funkcji equals? Tak - 1, Nie - 0 ==>>  ");
							currentPerson = createNewPerson(equal);
							map.TreeMapAdd(TreeIndex,currentPerson);
							TreeIndex++;
							break;
						case 2:
							int key = UI.enterInt("Podaj klucz (indeks) do usunięcia ==>> ");
							map.TreeMapRemove(key);
							break;
						case 3:
							map.TreeMapPrint();
							break;
						case 4:
							equal = UI.enterInt("Czy chcesz użyć funkcji equals? Tak - 1, Nie - 0 ==>>  ");
							currentPerson = createNewPerson(equal);
							map.HashMapAdd(HashIndex,currentPerson);
							HashIndex++;
							break;
						case 5:
							int HashKey = UI.enterInt("Podaj klucz (indeks) do usunięcia ==>> ");
							map.HashMapRemove(HashKey);
							break;
						case 6:
							map.HashMapPrint();
							break;
						case 0:
							UI.printInfoMessage("\nProgram zakończył działanie!");
							System.exit(0);
					}


			}
		}
	}

	static void showPerson(Person person) {
		StringBuilder sb = new StringBuilder();

		if (person != null) {
			sb.append("Aktualna osoba: \n")
					.append("      Imię: ").append(person.getFirstName()).append("\n")
					.append("  Nazwisko: ").append(person.getLastName()).append("\n")
					.append("   Rok ur.: ").append(person.getBirthYear()).append("\n")
					.append("Stanowisko: ").append(person.getJob()).append("\n");
		} else
			sb.append("Brak danych osoby\n");
		UI.printMessage(sb.toString());
	}

	static Person createNewPerson(int equal) {
		String first_name = UI.enterString("Podaj imię: ");
		String last_name = UI.enterString("Podaj nazwisko: ");
		String birth_year = UI.enterString("Podaj rok ur.: ");
		UI.printMessage("Dozwolone stanowiska:" + Arrays.deepToString(PersonJob.values()));
		String job_name = UI.enterString("Podaj stanowisko: ");
		Person person;
		try {
			person = new Person(first_name, last_name);
			person.setBirthYear(birth_year);
			person.setJob(job_name);
		} catch (PersonException e) {
			UI.printErrorMessage(e.getMessage());
			return null;
		}
		return person;
	}

}
