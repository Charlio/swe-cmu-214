package hw01;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.Math.sqrt;

/**
 * A Document class read the website from a weblink, and compute a cosine similarity score with
 * another document instance.
 */
public class Document {

    private final String weblink;
    private final Map<String, Integer> wordFreqs;
    private final double norm;

    static class EmptyVocabularyException extends IOException {
    }

    /**
     * Document Constructor reads a weblink string, and process its website content, it IOException if it fails
     * to parse the url link or read its content.
     * @param weblink a url string of a website
     * @throws IOException either MalformedURLException, or a general IOException
     */
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

    /**
     * A package-private constructor to read an array of word strings instead of from a weblink,
     * for testing purpose only.
     * @param words a string array of words
     * @throws IOException if words is empty
     */
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
        // compute the L2 norm of the word frequency table
        return sqrt(wordFreqs.values().stream().mapToInt(i -> i * i).sum());
    }

    /**
     * package-privately get the word frequency map for use by another Document class to compute the similarity score
     * @return word frequency map
     */
    Map<String, Integer> getWordFreqs() {
        return wordFreqs;
    }

    /**
     * package-privately get the norm of word frequencies for use by another Document instance to compute
     * the similarity score
     * @return double L2 norm
     */
    double getNorm() {
        return norm;
    }

    /**
     * Compute the cosine similarity score with another Document instance.
     * @param other a Document class instance
     * @return double the cosine similarity score
     */
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
