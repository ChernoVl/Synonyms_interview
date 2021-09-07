package com.find.synonyms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
//        private final static String fileName = "src/main/resources/input/example.in";
    private final static String fileName = "src/main/resources/input/example_big.in";

    public static void main(String[] args) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            int testCase = Integer.parseInt(scanner.nextLine().trim());
            System.out.println("Test case: " + testCase);

            int count = 0;
            while (scanner.hasNextLine()) {
                Map<String, Set<String>> synonymsMap = new HashMap<>();
                // 1. dictionary
                int n = Integer.parseInt(scanner.nextLine().trim());
                for (int i = 0; i < n; i++) {
                    String data = scanner.nextLine().toLowerCase(Locale.ROOT);
                    String firstWord = data.split(" ")[0];
                    String secWord = data.split(" ")[1];

                    if (synonymsMap.get(firstWord) != null) {
                        addToMap(synonymsMap, firstWord, secWord);
                    } else if (synonymsMap.get(secWord) != null) {
                        addToMap(synonymsMap, secWord, firstWord);
                    } else {
                        Set<String> setSynonyms = new HashSet<>();
                        setSynonyms.add(firstWord);
                        setSynonyms.add(secWord);

                        synonymsMap.put(firstWord, setSynonyms);
                        synonymsMap.put(secWord, setSynonyms);
                    }
                }

                // 2. words
                n = Integer.parseInt(scanner.nextLine().trim());
                for (int i = 0; i < n; i++) {
                    String data = scanner.nextLine().toLowerCase(Locale.ROOT);
                    String firstWord = data.split(" ")[0];
                    String secWord = data.split(" ")[1];
                    System.out.print((++count) + ": " + data);
                    if (firstWord.equals(secWord) ||
                            (synonymsMap.get(firstWord) != null && synonymsMap.get(firstWord).contains(secWord))) {
                        System.out.println("\t\tare synonyms;");
                    } else {
                        System.out.println("\t\tare different;");
                    }
                }
                System.out.println();
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    static void addToMap(Map<String, Set<String>> synonymsMap, String firstWord, String secWord) {
        synonymsMap.get(firstWord).add(secWord);
        if (synonymsMap.get(secWord) != null) {
            synonymsMap.get(firstWord).addAll(synonymsMap.get(secWord));
            for (String word : synonymsMap.get(secWord)) {
                synonymsMap.put(word, synonymsMap.get(firstWord));
            }
        }
        synonymsMap.put(secWord, synonymsMap.get(firstWord));
    }
}
