package hw01;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Document {

    private String weblink;
    private final Map<String, Integer> wordFreqs;
    private double norm;

    static class EmptyVocabularyException extends IOException {
    }

    public Document(String weblink) throws IOException {
        this.weblink = weblink;
        wordFreqs = new HashMap<>();
        Scanner sc = new Scanner(new URL(weblink).openStream());
        while (sc.hasNext()) {
            String word = sc.next();
            wordFreqs.put(word, wordFreqs.getOrDefault(word, 0) + 1);
        }
        sc.close();
        if (wordFreqs.isEmpty()) throw new EmptyVocabularyException();
        norm = computeNorm();
    }

    Document(String[] words) throws IOException {
        this.weblink = "";
        wordFreqs = new HashMap<>();
        for (String word : words) {
            wordFreqs.put(word, wordFreqs.getOrDefault(word, 0) + 1);
        }
        if (wordFreqs.isEmpty()) throw new EmptyVocabularyException();
        norm = computeNorm();
    }

    private double computeNorm() {
        return sqrt(wordFreqs.values().stream().mapToInt(i -> i * i).sum());
    }

    Map<String, Integer> getWordFreqs() {
        return wordFreqs;
    }

    double getNorm() {
        return norm;
    }

    public double getSimilarity(Document other) {
        int prodSum = 0;
        Map<String, Integer> otherWordFreqs = other.getWordFreqs();
        for (String word : wordFreqs.keySet()) {
            if (otherWordFreqs.containsKey(word)) {
                prodSum += wordFreqs.get(word) * otherWordFreqs.get(word);
            }
        }
        return prodSum / (norm * other.getNorm());
    }

    @Override
    public String toString() {
        return weblink;
    }
}
