package tb.soft;
import java.util.LinkedList;
import java.util.ArrayList;


public class List {
    ArrayList<Person> ArrayListColl = new ArrayList<>();
    LinkedList<Person> LinkedListColl = new LinkedList<>();

    public void ArrayListAdd(Person person)
    {
        ArrayListColl.add(person);
        System.out.println("\n***\n");
        System.out.println("Dodano!");
    }

    public void ArrayListRemove(int i)
    {
        ArrayListColl.remove(i - 1);
        System.out.println("***");
        System.out.println("Usunięto!");
    }

    public void ArrayListPrint()
    {
        System.out.println("\nAktualny Array List:");
        int j = 1;
        for (Person i : ArrayListColl)
        {
            System.out.println(j + ". - " + i.getFirstName() + " " + i.getLastName() + " " + i.getBirthYear() + " " + i.getJob());
            j++;
        }
    }
    public void ShowLinkedListSize()
    {
        System.out.println("Podaj pozycję w przedziale <1;" + (LinkedListColl.size()+1) + ">");
    }

    public void LinkedListAdd(int i,Person person)
    {
        LinkedListColl.add(i - 1, person);
        System.out.println("\n***\n");
        System.out.println("Dodano!");
    }

    public void LinkedListRemove(int i)
    {
        LinkedListColl.remove(i - 1);
        System.out.println("***");
        System.out.println("Usunięto!");
    }

    public void LinkedListPrint()
    {
        System.out.println("\nAktualny Linked List:");
        int j = 1;
        for (Person i : LinkedListColl)
        {
            System.out.println(j + ". - " + i.getFirstName() + " " + i.getLastName() + " " + i.getBirthYear() + " " + i.getJob());
            j++;
        }
    }
}
