package tb.soft;

import java.util.HashMap;
import java.util.TreeMap;

public class Map {
    HashMap<Integer, Person> HashMapColl = new HashMap<Integer,Person>();
    TreeMap<Integer, Person> TreeMapColl = new TreeMap<Integer,Person>();



    public void HashMapAdd(int key, Person person)
    {
        HashMapColl.put(key,person);
        System.out.println("\n***\n");
        System.out.println("Dodano!");
    }

    public void HashMapRemove(int key)
    {
        HashMapColl.remove(key);
        System.out.println("***");
        System.out.println("Usunięto!");
    }

    public void HashMapPrint()
    {
        System.out.println("\nAktualny HashMap:");
        for(int i : HashMapColl.keySet())
        {
            System.out.println(i + ". - " + HashMapColl.get(i).getFirstName() + " " + HashMapColl.get(i).getLastName() +
                    " " + HashMapColl.get(i).getBirthYear() + " " + HashMapColl.get(i).getJob());
        }
    }

    public void TreeMapAdd(int key, Person person)
    {
        TreeMapColl.put(key,person);
        System.out.println("\n***\n");
        System.out.println("Dodano!");
    }

    public void TreeMapRemove(int key)
    {
        TreeMapColl.remove(key);
        System.out.println("***");
        System.out.println("Usunięto!");
    }

    public void TreeMapPrint()
    {
        System.out.println("\nAktualny TreeMap:");
        for(int i : TreeMapColl.keySet())
        {
            System.out.println(i + ". - " + TreeMapColl.get(i).getFirstName() + " " + TreeMapColl.get(i).getLastName() +
                    " " + TreeMapColl.get(i).getBirthYear() + " " + TreeMapColl.get(i).getJob());
        }
    }
}
