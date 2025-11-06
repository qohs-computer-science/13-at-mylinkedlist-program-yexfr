/*
    Name: Nick Griffith
    Period: 6
    Date: 11/6/25
    Description: Tester file for my recreation of the native LinkedList class.
*/

public class MyLLTester {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        System.out.println("Created MyLinkedList instance.");

        list.add("Alpha");
        list.add("Bravo");
        list.add("Charlie");
        list.add("Delta");
        list.add("Echo");
        list.add("Foxtrot");
        list.add("Golf");
        list.add("Hotel");
        list.add("India");
        list.add("Juliet");

        list.addFirst("Zebra"); // add to beginning
        list.addLast("Kilo"); // add to end

        System.out.println("\nAfter initial creation:");
        System.out.println(list);

        System.out.println("\nChanging element at index 3...");
        String oldValue = list.set(3, "Delta (Updated)");
        System.out.println("Replaced \"" + oldValue + "\" with \"Delta (Updated)\"");
        System.out.println("After set(): " + list);

        System.out.println("\nElement at index 5: " + list.get(5));

        System.out.println("\nRemoving first element...");
        String removedFirst = list.removeFirst();
        System.out.println("Removed: " + removedFirst);
        System.out.println("List after removeFirst(): " + list);

        System.out.println("\nRemoving last element...");
        String removedLast = list.removeLast();
        System.out.println("Removed: " + removedLast);
        System.out.println("List after removeLast(): " + list);

        System.out.println("\nRemoving element at index 2...");
        String removedIndex = list.remove(2);
        System.out.println("Removed: " + removedIndex);
        System.out.println("List after remove(index): " + list);

        System.out.println("\nList size: " + list.size());
        System.out.println("Is the list empty? " + list.isEmpty());

        System.out.println("\n--- Testing all methods ---");
        System.out.println("Adding First: Lima -> " + list.addFirst("Lima"));
        System.out.println("Adding Last: Mike -> " + list.addLast("Mike"));
        System.out.println("Adding Normal: November -> " + list.add("November"));
        System.out.println("Set element at index 1 to Tango -> replaced " + list.set(1, "Tango"));
        System.out.println("Get element at index 1: " + list.get(1));
        System.out.println("Remove element at index 0: " + list.remove(0));
        System.out.println("Remove First: " + list.removeFirst());
        System.out.println("Remove Last: " + list.removeLast());
        System.out.println("List Size Now: " + list.size());
        System.out.println("Is Empty? " + list.isEmpty());
        System.out.println("Final List: " + list);

        System.out.println("\n!!! Edge Case Tests !!!");
        while (!list.isEmpty()) {
            System.out.println("Removing: " + list.removeFirst());
        } // end while
        System.out.println("List after removing all: " + list);
        System.out.println("Is list empty? " + list.isEmpty());
    } // end main
} // end class