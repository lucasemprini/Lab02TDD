package u02lab.code;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class RangeGeneratorTest {

    private final static Integer START = 5;
    private final static Integer STOP = 100;
    private final static int MIDDLEINDEX = 44;
    private SequenceGenerator testgen = new RangeGenerator(START, STOP);

    private void myLoop(final int start, final int stop, final IntConsumer consumer) {
        IntStream.rangeClosed(start, stop).forEach(consumer);
    }
    @Test
    public void nextReturns() {
        myLoop(START, STOP, i -> assertTrue(testgen.next().isPresent()));
    }

    @Test
    public void nextNumbers() {
        myLoop(START, STOP, i -> assertEquals(testgen.next().get(), new Integer(i)));
    }

    @Test
    public void nextAfterStop() {
        myLoop(START, STOP, i -> testgen.next());
        assertEquals(testgen.next(), Optional.empty());
    }


    @Test
    public void reset() {
        myLoop(START, STOP, i -> testgen.next());
        testgen.reset();
        assertEquals(testgen.next().get(), START);
    }

    @Test
    public void isOverMiddle() {
        myLoop(START, MIDDLEINDEX, i -> testgen.next());
        assertFalse(testgen.isOver());
    }

    @Test
    public void isOverEnd() {
        myLoop(START, STOP, i -> testgen.next());
        assertTrue(testgen.isOver());
    }

    @Test
    public void allRemaining() {
        myLoop(START, MIDDLEINDEX, i -> testgen.next());
        final List<Integer> remaining = testgen.allRemaining();
        myLoop(MIDDLEINDEX, STOP - 1, i ->
                assertEquals(remaining.get(i - MIDDLEINDEX), new Integer(i + 1)));
    }

    @Test
    public void allRemainingFull() {
        myLoop(START, STOP, i -> testgen.next());
        final List<Integer> remaining = testgen.allRemaining();
        assertEquals(remaining, new ArrayList());
    }

    @Test
    public void allRemainingEmpty() {
        final List<Integer> remaining = testgen.allRemaining();
        myLoop(START, STOP, i -> assertEquals(remaining.get(i - START), new Integer(i)));
    }
}