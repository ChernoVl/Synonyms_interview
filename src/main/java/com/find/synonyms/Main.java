package com.find.synonyms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    //    private final static String fileName = "src/main/resources/input/example.in";
    private final static String fileName = "src/main/resources/input/example_big.in";
    //    private final static String fileName = "src/main/resources/input/test.in";
    private final static String path = "result.out";

    public static void main(String[] args) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            StringBuilder output = new StringBuilder();

            int numberOfTestCase = Integer.parseInt(scanner.nextLine().trim());

            while (scanner.hasNextLine()) {
                Map<String, Set<String>> synonymsMap = new HashMap<>();

                // 1. read the dictionary
                int n = Integer.parseInt(scanner.nextLine().trim());
                if (n < 0 || n > 100) {
                    throw new IllegalArgumentException("expected range <0;100> for N");
                }
                for (int i = 0; i < n; i++) {
                    String[] pair = scanner.nextLine()
                            .toLowerCase(Locale.ROOT)
                            .split("\\s");
                    String firstWord = pair[0];
                    String secWord = pair[1];

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

                // 2. define synonyms
                int q = Integer.parseInt(scanner.nextLine().trim());
                if (q < 0 || q > 100) {
                    throw new IllegalArgumentException("expected range <0;100> for Q");
                }
                for (int i = 0; i < q; i++) {
                    String[] pair = scanner.nextLine()
                            .toLowerCase(Locale.ROOT)
                            .split("\\s");
                    String firstWord = pair[0];
                    String secWord = pair[1];

                    if (firstWord.equals(secWord) ||
                            (synonymsMap.get(firstWord) != null && synonymsMap.get(firstWord).contains(secWord))) {
                        output.append("synonyms");
                    } else {
                        output.append("different");
                    }
                    output.append(System.lineSeparator());
                }
            }
            write(output.toString());
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

    static public void write(String src) {
        try (FileWriter writer = new FileWriter(path, false)) {
            writer.write(src);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
