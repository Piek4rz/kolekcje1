package tb.soft;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.HashSet;

public class Set {
    TreeSet<Person> TreeSetColl = new TreeSet<>(new Person.Compare());
    HashSet<Person> HashSetColl = new HashSet<>();

    public void TreeSetAdd(Person person)
    {
        TreeSetColl.add(person);
        System.out.println("\n***\n");
        System.out.println("Dodano!");
    }

    public void TreeSetRemove(Person person)
    {
        TreeSetColl.remove(person);
        System.out.println("***");
        System.out.println("Usunięto!");
    }

    public void TreeSetPrint()
    {
        System.out.println("\nAktualny Tree Set:");
        for (Person i : TreeSetColl)
        {
            System.out.println(i.getFirstName() + " " + i.getLastName() + " " + i.getBirthYear() + " " + i.getJob());
        }
    }

    public void HashSetAdd(Person person)
    {
        HashSetColl.add(person);
        System.out.println("\n***\n");
        System.out.println("Dodano!");
    }

    public void HashSetRemove(Person person)
    {
        HashSetColl.remove(person);
        System.out.println("***");
        System.out.println("Usunięto!");
    }
    public void HashSetPrint()
    {
        System.out.println("\nAktualny Hash Set:");
        for (Person i : HashSetColl)
        {
            System.out.println(i.getFirstName() + " " + i.getLastName() + " " + i.getBirthYear() + " " + i.getJob());
        }
    }




}
