import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static HomeWork6.WorkWithArr.checkArrFor1And4;
import static HomeWork6.WorkWithArr.returnArrAfter4;

@RunWith(Parameterized.class)
public class Test2 {
    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][][] {
                {{true},{1,23, 4,3}},
                {{false},{23,3,67}},
                {{true},{1,23,3,4,5,5}}
        });
    }

    private boolean arrResult;
    private Object[] arr;

    public Test2(Object[] arrResult, Object[] arr) {
        this.arrResult=(boolean) arrResult[0];
        this.arr=arr;
    }



    @Before
    public void init() {

    }

    @Test
    public void massTestAdd() throws Exception {
        Assert.assertEquals(arrResult, checkArrFor1And4(arr));
        System.out.println(arrResult);
    }
}
