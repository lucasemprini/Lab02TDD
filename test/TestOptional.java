import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class TestOptional {

    @Test
    public void testPresentValue() {
        Optional<Integer> myOptional = Optional.of(10);
        Assert.assertTrue(myOptional.isPresent());
    }

    @Test
    public void testNotPresentValue() {
        Optional<Integer> myOptional = Optional.empty();
        Assert.assertFalse(myOptional.isPresent());
    }
}
