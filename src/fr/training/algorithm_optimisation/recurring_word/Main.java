package src.fr.training.algorithm_optimisation.recurring_word;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static DecimalFormat df = new DecimalFormat("###,###,###");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Entrez une phrase : ");
        String phrase = sc.nextLine(); // This is is a sentence

        System.out.print("Entrez le mot à chercher : ");
        String mot = sc.nextLine();


        // Exemple 1 : "This is is a sentence" -> "is"
        // EXemple 2 : "This is a very long sentence that will write the word " sentence "  a few times so I can look for the word " sentence " afterwards." -> "sentence"
        int occurencesDuMot = compteOccurencesMotDansPhrase(phrase, mot);       // 7,152,275 ns      // 9,793,950 ns
        int occurencesDuMotOptimisee = occurencesDuMotOptimisee(phrase, mot);   // 20,769 ns         // 50,825 ns

        System.out.printf("Le mot apparaît %s/%s fois.%n", occurencesDuMot, occurencesDuMotOptimisee);
    }

    public static int compteOccurencesMotDansPhrase (String phrase, String mot) {
        long debut = System.nanoTime();

        int compteur = 0;
        String temp = "";
        for (int i = 0; i < phrase.length(); i++) {
            char c = phrase.charAt(i);
            if (c != ' ') {
                temp += c;
            } else {
                if (temp.equals(mot)) {
                    compteur++;
                }
                temp = "";
            }
        }
        if (temp.equals(mot)) {
            compteur++; // dernier mot
        }

        long fin = System.nanoTime();
        System.out.printf("(old) Temps d'exécution : %s ns %n",df.format((fin - debut)));

        return compteur;
    }

    public static int occurencesDuMotOptimisee (String phrase, String mot) {
        long debut = System.nanoTime();

        int compteur = 0;
        for (String m: phrase.toLowerCase().split(" ")) {
            if (m.equals(mot)) { compteur++; }
        }

        long fin = System.nanoTime();
        System.out.printf("(new) Temps d'exécution : %s ns %n",df.format((fin - debut)));

        return compteur;
    }
}
