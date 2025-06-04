package src.fr.training.introduction;

import java.util.Scanner;

public class Voyelles {
  public static void main (String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter a word: ");
    String word = scanner.nextLine();

    System.out.println("-- Vowels: " + countVowels(word));
    
    scanner.close();
  }


  public static int countVowels(String word) {
    String lowerWord = word.toLowerCase();
    
    int count = 0;
    for(char letter : lowerWord.toCharArray()) {
      if ("aeiouy".indexOf(letter) != -1) count++; //-- Increment counter everytime a letter is found in the vowels string
    }

    return count;
  }
}
