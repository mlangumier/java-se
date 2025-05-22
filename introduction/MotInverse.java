package introduction;

public class MotInverse {

  public static void main(String[] args) {
    String wordToReverse = "Learning java!";

    String motInverse = inverseMot(wordToReverse);
    System.out.println(
      String.format("- Mot inversé 1: '%s' -> '%s'", wordToReverse, motInverse)
    );

    String reversedWord = reverseWord(wordToReverse);
    System.out.println(
      String.format("- Mot inversé 2: '%s' -> '%s' (string-builder)", wordToReverse, reversedWord)
    );
  }
  
  /**
   * Inverse une chaîne de caractères
   * @param word
   * @return Une chaîne de caractères inversée.
   */
  public static String inverseMot (String word) {
    String reversedWord = "";

    //*--- Méthode 1 (ok): boucle FOR qui incrémente jusqu'à la longueur du mot, puis on cherche la dernière lettre 
    // for(int i = 0; i < word.length(); i++) {
    //   reversedWord += word.charAt(word.length() - (i + 1));
    // }

    //*--- Méthode 2 (best) : boucle FOR qui décrémente à partir de la longueur du mot, puis on prend la lettre qui correspond à l'index actuel
    for(int i = word.length() - 1; i >= 0; i--) {
      reversedWord += word.charAt(i);
    }

    return reversedWord;
  }

  /**
   * Inverse une chaîne de caractères en utilisant le query builder
   * @param word
   * @return Une chaîne de caractères inversée.
   */
  public static String reverseWord(String word) {
    char[] arrayWord = word.toCharArray();
    StringBuilder stringBuilder = new StringBuilder();

    for(int i = word.length() - 1; i >= 0; i--) {
      stringBuilder.append(arrayWord[i]);
    }

    return stringBuilder.toString();
  }
}
