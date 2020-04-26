import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Test1 {
    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][][] {
                {{1,23,3}},
                {{1,23,3,67}},
                {{1,23,3,4,5,5}}
        });
    }

    private Object[] arr;

    public Test1(Object[] arr) {
        this.arr = arr;
    }



    @Before
    public void init() {

    }

    @Test
    public void massTestAdd() {
        System.out.println(arr.length);
    }
}
