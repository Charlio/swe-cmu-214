package hw01;


import java.io.IOException;

/**
 * Given a collection of weblinks, find the two closest matches based on their cosine similarity scores
 */
public class ClosestMatches {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println("Please enter at least two weblinks");
            return;
        }
        Document[] docs = new Document[args.length];
        for (int i = 0; i < args.length; i++) {
            docs[i] = new Document(args[i]);
        }
        double maxScore = 0;
        String docs1 = "";
        String docs2 = "";
        for (int i = 0; i < docs.length; i++) {
            for (int j = i + 1; j < docs.length; j++) {
                double score = docs[i].getSimilarity(docs[j]);
                if (score > maxScore) {
                    maxScore = score;
                    docs1 = docs[i].toString();
                    docs2 = docs[j].toString();
                }
            }
        }
        System.out.println("The most similar two webpages are");
        System.out.println(docs1);
        System.out.println(docs2);
    }
}
