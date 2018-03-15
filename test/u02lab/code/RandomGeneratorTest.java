package u02lab.code;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class RandomGeneratorTest {

    private final int N = 30;
    private SequenceGenerator testgen;

    private void myLoop(final int start, final int stop, final IntConsumer consumer) {
        IntStream.range(start, stop).forEach(consumer);
    }

    private boolean isZeroOrOne(Integer i) {
        return i.equals(0) || i.equals(1);
    }

    @Before
    public void setup() {
        testgen = new RandomGenerator(N);
    }

    @Test
    public void nextReturns() {
        myLoop(0, N, i -> assertTrue(testgen.next().isPresent()));
    }

    @Test
    public void nextReturnsValue() {
        myLoop(0, N, i -> assertTrue(isZeroOrOne(testgen.next().get())));
    }

    @Test
    public void nextAfterStop() {
        myLoop(0, N, i -> testgen.next());
        assertEquals(testgen.next(), Optional.empty());
    }

    @Test
    public void reset() {
        myLoop(0, N, i -> testgen.next());
        testgen.reset();
        assertTrue(testgen.next().isPresent());
    }

    @Test
    public void isOver() {
        myLoop(0, N, i -> testgen.next());
        assertTrue(testgen.isOver());
    }

    @Test
    public void isNotOver() {
        myLoop(0, N - 1, i -> testgen.next());
        assertFalse(testgen.isOver());
    }

    @Test
    public void allRemaining() {
        final int middle = 22;
        myLoop(0, middle, i -> testgen.next());
        final List<Integer> remaining = testgen.allRemaining();
        myLoop(middle, N - 1, i -> remaining.forEach(integer -> assertTrue(isZeroOrOne(integer))));
    }

    @Test
    public void allRemainingFull() {
        myLoop(0, N, i -> testgen.next());
        final List<Integer> remaining = testgen.allRemaining();
        assertEquals(remaining, new ArrayList());
    }

    @Test
    public void allRemainingEmpty() {
        final List<Integer> remaining = testgen.allRemaining();
        myLoop(0, N, i -> remaining.forEach(integer -> assertTrue(isZeroOrOne(integer))));
    }
}