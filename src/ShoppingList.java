import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;


public class ShoppingList
{
    public static void main(String[] args)
    {
        // Read Data
        ArrayList<String> myList = readData();
        printList(myList);
        
        // Add an item
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter an item: ");
        myList.add(input.nextLine());
        
        // Save data
        writeData(myList);
    }
    
    private static ArrayList<String> readData(){
        ArrayList<String> list = new ArrayList<String>();
        try {
            // Create the Scanner with the data file
            Scanner fileIn = new Scanner(new File("data.txt"));
            while (fileIn.hasNext()) {
                // Add to the ArrayList
                list.add(fileIn.nextLine()); 
            }
            fileIn.close();
        }
        catch (IOException e) {
            System.out.println("No List Exists.");
        }
        return list;
    }
    
    private static void writeData(ArrayList<String> list) {
        try {
            PrintWriter fileOut = new PrintWriter("data.txt");
            for (String item : list) {
                fileOut.println(item);
            }
            fileOut.close();
        }
        catch (IOException e) {
            System.out.println("Unable to write");
        }        
    }
    
    private static void printList(ArrayList<String> l) {
        if (l.size() > 0) {
            System.out.println("Current Shopping List: ");
            for (String item : l) {
                System.out.println(item);
            }
            System.out.println();
        }
        
    }
}