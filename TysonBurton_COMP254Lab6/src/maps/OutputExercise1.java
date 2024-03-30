package maps;

public class OutputExercise1 {

    public static void main(String[] args) {

        System.out.println("============================================");
        System.out.println("ProbeHashMap");
        System.out.println("============================================");

        // Creating ChainHashMap with a maximum load factor of 0.7
        ChainHashMap<Integer, String> chainHashMap = new ChainHashMap<>(0.7);

        // Adding elements to ChainHashMap
        chainHashMap.put(1, "One");
        chainHashMap.put(2, "Two");
        chainHashMap.put(3, "Three");
        chainHashMap.put(4, "Four");

        // Retrieving elements from ChainHashMap
        System.out.println("Value for key 1: " + chainHashMap.get(1));
        System.out.println("Value for key 3: " + chainHashMap.get(3));

        // Removing an element from ChainHashMap
        chainHashMap.remove(2);
        System.out.println("Size after removing key 2: " + chainHashMap.size());

        System.out.println("============================================");
        System.out.println("ChainHashMap");
        System.out.println("============================================");

        // Creating ProbeHashMap with a maximum load factor of 0.7
        ProbeHashMap<Integer, String> probeHashMap = new ProbeHashMap<>(0.7);

        // Adding elements to ProbeHashMap
        probeHashMap.put(10, "Ten");
        probeHashMap.put(20, "Twenty");
        probeHashMap.put(30, "Thirty");
        probeHashMap.put(40, "Forty");

        // Retrieving elements from ProbeHashMap
        System.out.println("Value for key 20: " + probeHashMap.get(20));
        System.out.println("Value for key 30: " + probeHashMap.get(30));

        // Removing an element from ProbeHashMap
        probeHashMap.remove(20);
        System.out.println("Size after removing key 20: " + probeHashMap.size());
    }
}
