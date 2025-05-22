package introduction;

import java.util.Random;
import java.util.Scanner;

public class MysteryNumber {
  public static void main(String[] args) {
    guessSecretNumber();
  }

  public static void guessSecretNumber() {
    Random rand = new Random();
    int secretNbr = rand.nextInt(100) + 1;
    Scanner scanner = new Scanner(System.in); // Permet de lire ce que l'utilisateur tape dans le terminal
    int tries = 0;

    // Boucle Do...WHILE parce qu'on veut d'abord récupérer une valeur, puis vérifier si elle est bonne
    do {
      if (tries == 0) System.out.print("Guess the secret number: ");
      else System.out.print(" Guess again: ");
      
      tries = scanner.nextInt(); // Demande à l'utilisateur d'entrer un nombre dans le terminal

      if (tries < secretNbr) System.out.print("Higher!");
      else if (tries > secretNbr) System.out.print("Lower!");

    } while (tries != secretNbr);

    System.out.println(
      String.format("- Congratulations! You found the secret number: %s !", secretNbr)
    );

    scanner.close();
  }
}
