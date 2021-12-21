import java.util.Scanner;
import java.io.*;

class Main {
  public static void main(String[] args) {
    
    char choice; 
    String filename = "book.txt";

    Scanner scan = new Scanner(System.in);
    //Prompt the user to pick from the menu below
    System.out.print("Please choose from the menu below\n");
    System.out.print("1. Add to the address book\n");
    System.out.print("2. User contact info\n"); 
    choice = scan.next().charAt(0);

    System.out.print("\033[H\033[2J");  
    System.out.flush();  

    if (choice == '1'){
      //Prompt the user to add their info into the address book 
      System.out.print("Name: ");
      String name = scan.next();

      System.out.print("Phone Number: "); 
      String number = scan.next();

      System.out.print("Email: ");
      String email = scan.next();

      try {
      // Assume default decoding
      FileWriter fileWriter =
      new FileWriter(filename, true);
      // Always wrap FileWriter in BufferedWriter
      BufferedWriter bufferedWriter =
      new BufferedWriter(fileWriter);
      // Note that write() does not automatically
      // append a new line character
      bufferedWriter.write(name + " ");
      bufferedWriter.write(number + " ");
      //bufferedWriter.newLine();
      bufferedWriter.write(email + " ");
      bufferedWriter.write("\n");
      // Always close files
      bufferedWriter.close();
      System.out.print(name + " added to the address book.");
    }
    catch(IOException ex) {
      System.out.println(
      "Error writing to file '" + filename + "'");
      }
    
    } else {
      String line = null;

      try {
      // FileReader reads text files in the default encoding
      FileReader fileReader = new FileReader(filename);
      // Always wrap FileReader in BufferedReader
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      while((line = bufferedReader.readLine()) != null) {
        System.out.println(line);
      }
      // Always close files
      bufferedReader.close();
    }
    catch(FileNotFoundException ex) {
      System.out.println("Unable to open file '" + filename + "'");
    }
    catch(IOException ex) {
      System.out.println("Error reading file '" + filename + "'");
      }
    }
  }
}
//Zachary Sweet
//12/1/2021