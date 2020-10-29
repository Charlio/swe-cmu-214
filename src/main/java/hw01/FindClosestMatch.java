package hw01;


import java.io.IOException;

/**
 * Given a collection of weblinks, find the closest match with the collection for each of the weblinks
 */
public class FindClosestMatch {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println("Please enter at least two weblinks");
            return;
        }
        Document[] docs = new Document[args.length];
        double[] scores = new double[args.length];
        Document[] pairedDocs = new Document[args.length];
        for (int i = 0; i < args.length; i++) {
            docs[i] = new Document(args[i]);
            scores[i] = 0;
        }
        for (int i = 0; i < args.length; i++) {
            for (int j = i + 1; j < args.length; j++) {
                double score = docs[i].getSimilarity(docs[j]);
                if (score > scores[i]) {
                    scores[i] = score;
                    pairedDocs[i] = docs[j];
                }
                if (score > scores[j]) {
                    scores[j] = score;
                    pairedDocs[j] = docs[i];
                }
            }
        }
        for (int i = 0; i < args.length; i++) {
            System.out.println(docs[i] + " -> " + pairedDocs[i]);
        }
    }
}