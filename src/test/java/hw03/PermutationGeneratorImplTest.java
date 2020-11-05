package hw03;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by hao on 6/19/17.
 */
public class PermutationGeneratorImplTest {

    private PermutationInterface per;

    public PermutationGeneratorImplTest() {
        char[] inputs = new char[]{'A', 'B', 'C', 'D'};
        per = new PermutationGenerator(inputs);
    }

    @Test
    public void getPermutation() throws Exception {
        ArrayList<String> res = per.getPermutation();
        for (String str : res) {
            System.out.println(str);
        }
        Assert.assertEquals(res.size(), 24);
    }

}