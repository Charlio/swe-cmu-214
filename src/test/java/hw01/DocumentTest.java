package hw01;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class DocumentTest {
    private Document doc;
    private String weblink;
    private String invalidWeblink;

    @Before
    public void setUp() {
        weblink = "https://github.com";
        invalidWeblink = "https://helloworld.cm";
        try {
            doc = new Document(weblink);
        } catch (IOException ignored) {
            System.out.println("Failed to load " + weblink);
        }
    }

    @Test
    public void testValidLink() {
        try {
            doc = new Document(weblink);
        } catch (IOException e) {
            fail();
        }
    }

    @Test
    public void testInvalidLink() {
        try {
            doc = new Document(invalidWeblink);
        } catch (IOException e) {
            return;
        }
        fail();
    }

    @Test
    public void testToString() {
        assertEquals(weblink, doc.toString());
    }

    @Test
    public void testSimilarityOfTwoSimpleSentences() throws IOException {
        String[] sen1 = "if it is to be it is up to me to do it".split(" ");
        String[] sen2 = "let it be".split(" ");
        Document doc1 = new Document(sen1);
        Document doc2 = new Document(sen2);
        assertEquals(0.44, doc1.getSimilarity(doc2), 0.01);
        assertEquals(0.44, doc2.getSimilarity(doc1), 0.01);
    }

    @Test
    public void testEmptyContent(){
        try {
            doc = new Document(new String[]{});
        } catch (IOException e) {
            return;
        }
        fail();
    }
}
