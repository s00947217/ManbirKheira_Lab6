// Lab 6 - HashMap Implementation
// Your Name: Manbir S Kheira

public class Main {
    public static void main(String[] args) {
        // Step 1: Create a map called creditHours
        MyHashMap<String, Integer> creditHours = new MyHashMap<>();

        // Step 2: Add course codes and credit hours
        creditHours.put("IT-1025", 3);
        creditHours.put("IT-1050", 3);
        creditHours.put("IT-1150", 3);
        creditHours.put("IT-2310", 3);
        creditHours.put("IT-2320", 4);
        creditHours.put("IT-2351", 4);
        creditHours.put("IT-2650", 4);
        creditHours.put("IT-2660", 4);
        creditHours.put("IT-2030", 4);

        // Step 3: Check for specific keys
        System.out.println("Contains IT-1025: " + creditHours.containsKey("IT-1025"));
        System.out.println("Contains IT-2110: " + creditHours.containsKey("IT-2110"));

        // Step 4: Print all entries in the map
        System.out.println("All credit hours:");
        for (int i = 0; i < creditHours.getTable().length; i++) {
            if (creditHours.getTable()[i] != null) {
                for (MyHashMap.Entry<String, Integer> entry : creditHours.getTable()[i]) {
                    System.out.println(entry.key + ": " + entry.value);
                }
            }
        }

        // Step 5: Remove specific keys
        creditHours.remove("IT-2030");
        creditHours.remove("IT-1150");

        // Step 6: Print all entries after removal
        System.out.println("Updated credit hours:");
        for (int i = 0; i < creditHours.getTable().length; i++) {
            if (creditHours.getTable()[i] != null) {
                for (MyHashMap.Entry<String, Integer> entry : creditHours.getTable()[i]) {
                    System.out.println(entry.key + ": " + entry.value);
                }
            }
        }
    }
}
