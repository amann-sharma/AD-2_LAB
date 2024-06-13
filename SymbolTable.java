import java.util.HashMap;

public class SymbolTable {

    public static void main(String[] args) {
        // Creating a symbol table using HashMap
        HashMap<String, Integer> symbolTable = new HashMap<>();

        // Inserting key-value pairs
        symbolTable.put("apple", 10);
        symbolTable.put("banana", 20);
        symbolTable.put("orange", 15);

        // Accessing values
        System.out.println("Value of apple: " + symbolTable.get("apple"));
        System.out.println("Value of banana: " + symbolTable.get("banana"));
        System.out.println("Value of orange: " + symbolTable.get("orange"));

        // Updating value
        symbolTable.put("apple", 12);
        System.out.println("Updated value of apple: " + symbolTable.get("apple"));

        // Removing a key-value pair
        symbolTable.remove("banana");
        System.out.println("Value of banana after removal: " + symbolTable.get("banana"));
    }
}
