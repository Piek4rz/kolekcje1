package tb.soft;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;


enum PersonJob {
	UNKNOWN("-------"), 
	GUEST("Gość"), 
	STUDENT("Student"), 
	TEACHER("Nauczyciel"), 
	MANAGER("Kierownik"), 
	DIRECTOR("Dyrektor");

	String jobName;

	private PersonJob(String job_name) {
		jobName = job_name;
	}

	
	@Override
	public String toString() {
		return jobName;
	}
	
}


class PersonException extends Exception {

	private static final long serialVersionUID = 1L;

	public PersonException(String message) {
		super(message);
	}
	
}

public class Person {
	
	private String firstName;
	private String lastName;
	private int birthYear;
	private PersonJob job;
 	int equal;
	
	public Person(String first_name, String last_name) throws PersonException {
		setFirstName(first_name);
		setLastName(last_name);
		job = PersonJob.UNKNOWN;
		equal = 0;
	}

	
	public String getFirstName() {
		return firstName;
	}

	
	public void setFirstName(String first_name) throws PersonException {
		if ((first_name == null) || first_name.equals(""))
			throw new PersonException("Pole <Imię> musi być wypełnione.");
		this.firstName = first_name;
	}

	
	public String getLastName() {
		return lastName;
	}

	
	public void setLastName(String last_name) throws PersonException {
		if ((last_name == null) || last_name.equals(""))
			throw new PersonException("Pole <Nazwisko> musi być wypełnione.");
		this.lastName = last_name;
	}

	
	public int getBirthYear() {
		return birthYear;
	}

	
	public void setBirthYear(int birth_year) throws PersonException {
		if ((birth_year!=0) && (birth_year < 1900 || birth_year > 2030))
			throw new PersonException("Rok urodzenia musi być w przedziale [1900 - 2030].");
		this.birthYear = birth_year;
	}
	
	
	public void setBirthYear(String birth_year) throws PersonException {
		if (birth_year == null || birth_year.equals("")){  // pusty łańcuch znaków oznacza rok niezdefiniowany
			setBirthYear(0);
			return;
		}
		try { 
			setBirthYear(Integer.parseInt(birth_year));
		} catch (NumberFormatException e) {
			throw new PersonException("Rok urodzenia musi być liczbą całkowitą.");
		}
	}


	public PersonJob getJob() {
		return job;
	}

	
	public void setJob(PersonJob job){
		this.job = job;
	}
	
	
	public void setJob(String job_name) throws PersonException {
		if (job_name == null || job_name.equals("")) {  // pusty łańcuch znaków oznacza stanowisko niezdefiniowane
			this.job = PersonJob.UNKNOWN;
			return;
		}
		for(PersonJob job : PersonJob.values()){
			if (job.jobName.equals(job_name)) {
				this.job = job;
				return;
			}
		}
		throw new PersonException("Nie ma takiego stanowiska.");
	}

	
	@Override
	public String toString() {  
		return firstName + " " + lastName;
	}
	
	
	public static void printToFile(PrintWriter writer, Person person){
		writer.println(person.firstName + "#" + person.lastName + 
				"#" + person.birthYear + "#" + person.job);
	}
	
	
	public static void printToFile(String file_name, Person person) throws PersonException {
		try (PrintWriter writer = new PrintWriter(file_name)) {
			printToFile(writer, person);
		} catch (FileNotFoundException e){
			throw new PersonException("Nie odnaleziono pliku " + file_name);
		}
	}
	
	
	public static Person readFromFile(BufferedReader reader) throws PersonException{
		try {
			String line = reader.readLine();
			String[] txt = line.split("#");
			Person person = new Person(txt[0], txt[1]);
			person.setBirthYear(txt[2]);
			person.setJob(txt[3]);	
			return person;
		} catch(IOException e){
			throw new PersonException("Wystąpił błąd podczas odczytu danych z pliku.");
		}	
	}
	
	
	public static Person readFromFile(String file_name) throws PersonException {
		try (BufferedReader reader = new BufferedReader(new FileReader(new File(file_name)))) {
			return Person.readFromFile(reader);
		} catch (FileNotFoundException e){
			throw new PersonException("Nie odnaleziono pliku " + file_name);
		} catch(IOException e){
			throw new PersonException("Wystąpił błąd podczas odczytu danych z pliku.");
		}	
	}
	static class Compare implements Comparator<Person>
	{
		public int compare(Person p1, Person p2)
		{
			return p1.getFirstName().compareTo(p2.getFirstName());
		}
	}

	@Override
	public boolean equals(Object o) {
		if (equal == 1) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Person person = (Person) o;
			return birthYear == person.birthYear && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && job == person.job;
		}
		else{
			return false;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, birthYear, job);
	}
}
