import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class NextWordPrediction {
    private static Map<String, List<String>> wordMap = new HashMap<>();

    public static void trainModel(String text) {
        String[] words = text.split("\\s+");
        for (int i = 0; i < words.length - 1; i++) {
            String currentWord = words[i];
            String nextWord = words[i + 1];

            if (!wordMap.containsKey(currentWord)) {
                wordMap.put(currentWord, new ArrayList<>());
            }
            wordMap.get(currentWord).add(nextWord);
        }
    }

    public static String predictNextWord(String prefix) {
        List<String> possibleWords = wordMap.get(prefix);
        if (possibleWords == null || possibleWords.isEmpty()) {
            return null;
        }
        int randomIndex = (int) (Math.random() * possibleWords.size());
        return possibleWords.get(randomIndex);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter training text:");
        String trainingText = scanner.nextLine();
        trainModel(trainingText);

        while (true) {
            System.out.println("Enter a word to get the next predicted word (or type 'exit' to quit):");
            String inputWord = scanner.nextLine();
            if (inputWord.equalsIgnoreCase("exit")) {
                break;
            }

            String predictedWord = predictNextWord(inputWord);
            if (predictedWord != null) {
                System.out.println("Predicted next word: " + predictedWord);
            } else {
                System.out.println("No prediction available for the given word.");
            }
        }
        scanner.close();
    }
}
