import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static HomeWork6.WorkWithArr.returnArrAfter4;

@RunWith(Parameterized.class)
public class Test1 {
    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new int[][][] {
                {{3},{1,23, 4,3}},
                {{},{1,23,3,67}},
                {{5,5},{1,23,3,4,5,5}}
        });
    }

    private int[] arrResult;
    private int[] arr;

    public Test1(int[] arrResult, int[] arr) {
        this.arrResult=arrResult;
        this.arr = arr;
    }



    @Before
    public void init() {

    }

    @Test
    public void massTestAdd() throws Exception {
        Assert.assertArrayEquals(arrResult,returnArrAfter4(arr));
        //System.out.println(arr.length);
    }
}
