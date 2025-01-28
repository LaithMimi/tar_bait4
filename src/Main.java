public class Main {
    public static void main(String[] args) {
        // Initialize two groups
        Group group1 = new Group();
        Group group2 = new Group();

        // Test add method
        System.out.println("Adding elements to group1:");
        System.out.println("Add 5: " + group1.add(5));    // true
        System.out.println("Add 5 again: " + group1.add(5)); // false
        System.out.println("Add 3: " + group1.add(3));    // true
        group1.add(7);
        group1.add(9);

        // Add to group2
        group2.add(3);
        group2.add(5);
        group2.add(8);

        // Test remove method
        System.out.println("\nRemoving from group1:");
        System.out.println("Remove 3: " + group1.remove(3)); // true
        System.out.println("Remove 99: " + group1.remove(99)); // false

        // Test search method
        System.out.println("\nSearching in group1:");
        System.out.println("Search 5: " + group1.search(5)); // true
        System.out.println("Search 3: " + group1.search(3)); // false

        // Test containsElement
        System.out.println("\nContains check:");
        System.out.println("group1 contains 7: " + group1.containsElement(7)); // true
        System.out.println("group1 contains 2: " + group1.containsElement(2)); // false

        // Test intersection
        Group intersection = group1.intersection(group2);
        System.out.println("\nIntersection elements:");
        for(int num : intersection.elements) {
            System.out.println(num); // Should print 5
        }

        // Test union
        Group union = group1.union(group2);
        System.out.println("\nUnion elements:");
        for(int num : union.elements) {
            System.out.println(num); // Should print 5,7,9,3,8
        }

        // Test iterator explicitly
        System.out.println("\nManual iterator usage:");
        Group.GroupIterator iterator = group1.new GroupIterator();
        while(iterator.hasNext()) {
            System.out.println("Next element: " + iterator.next());
        }

        // Test empty set operations
        Group emptyGroup = new Group();
        System.out.println("\nEmpty group intersection:");
        Group emptyIntersection = group1.intersection(emptyGroup);
        System.out.println("Empty intersection size (using iterator):");
        for(int num : emptyIntersection.elements) {
            System.out.println(num); // Should print nothing
        }
    }
}