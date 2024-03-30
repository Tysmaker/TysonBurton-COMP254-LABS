package maps;

public class OutputExercise2
{
    public static void main(String[] args) {
        SortedTableMap<Integer, String> map = new SortedTableMap<>();

        // Insert some key-value pairs
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        // Check if map contains a specific key
        System.out.println("Does map contain key 2? " + map.containKey(2));
        System.out.println("Does map contain key 4? " + map.containKey(4));
        System.out.println("");

        // Retrieve values for the keys
        System.out.println("Value for key 1: " + map.get(1));
        System.out.println("Value for key 2: " + map.get(2));
        System.out.println("");
        // Key does not exist, so null should be returned
        System.out.println("Value for key 4: " + map.get(4));
        System.out.println("");
        // Remove a key-value pair
        System.out.println("Removing key 2");
        map.remove(2);
        System.out.println("");
        // Should return false
        System.out.println("Does map contain key 2 after removal? " + map.containKey(2));
    }
}
