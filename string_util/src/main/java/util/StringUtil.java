package util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StringUtil {

    public static Map<Character, Integer> countOfAllCharacters(String data) {
        Map<Character, Integer> result = new HashMap<>();
        Character ch;
        int countOfCh;

        for (int i = 0; i < data.length(); i++) {
            ch = data.charAt(i);
            if (result.containsKey(ch)) {
                countOfCh = result.get(ch);
                result.put(ch, countOfCh + 1);
            } else
                result.put(ch, 1);
        }

        Map<Character, Integer> sortedResult = new LinkedHashMap<>();
        result.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> sortedResult.put(x.getKey(), x.getValue()));
        return sortedResult;
    }

    public static Map<String, Integer> countOfAllWords(String data) {
        int countOfWord;
        Map<String, Integer> result = new HashMap<>();

        for (String str : data.split("\\P{L}+")) {
            str = str.toLowerCase();
            if (result.containsKey(str)) {
                countOfWord = result.get(str);
                result.put(str, countOfWord + 1);
            } else
            {
                result.put(str, 1);
            }
        }

        Map<String, Integer> sortedResult = new LinkedHashMap<>();
        result.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> sortedResult.put(x.getKey(), x.getValue()));
        return sortedResult;
    }

    public static String reverseWords(String data) {
        StringBuilder result = new StringBuilder();
        String[] sentences = data.split("[.!?](\\s)*");

        for (String sent: sentences)
        {
            String[] words = sent.split("\\P{L}+");
            String temp;

            for (int i = 0; i < words.length / 2; i++)
            {
                temp = words[i];
                words[i] = words[words.length - i - 1];
                words[words.length - i - 1] = temp;
            }

            for (int i = 0; i < words.length; i++)
            {
                if (i + 1 == words.length) {
                    result.append(words[i]).append(". ");
                } else
                {
                    result.append(words[i]).append(" ");
                }
            }
        }

        return result.toString();
    }
}
