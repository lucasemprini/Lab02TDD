package u02lab.code;

import java.util.*;

/**
 * Step 1
 *
 * Using TDD approach (create small test, create code that pass test, refactor to excellence)
 * implement the below class that represents the sequence of numbers from start to stop included.
 * Be sure to test that:
 * - the produced elements (called using next(), go from start to stop included)
 * - calling next after stop leads to a Optional.empty
 * - calling reset after producing some elements brings the object back at the beginning
 * - isOver can actually be called in the middle and should give false, at the end it gives true
 * - can produce the list of remaining elements in one shot
 */
public class RangeGenerator implements SequenceGenerator {

    private final List<Integer> range = new ArrayList<>();
    private int currentIndex = 0;

    public RangeGenerator(int start, int stop){
        for(int i = start; i <= stop; i++) {
            range.add(i);
        }
    }

    @Override
    public Optional<Integer> next() {
            if(isOver()) {
                return Optional.empty();
            } else {
                final Integer toReturn = range.get(currentIndex);
                currentIndex++;
                return Optional.of(toReturn);
            }
    }

    @Override
    public void reset() {
        currentIndex = 0;
    }

    @Override
    public boolean isOver() {
        return currentIndex >= range.size();
    }

    @Override
    public List<Integer> allRemaining() {
        if(isOver()) {
            return Collections.unmodifiableList(new ArrayList<>());
        } else {
            final List<Integer> remaining = range.subList(currentIndex, range.size());
            currentIndex = range.size();
            return Collections.unmodifiableList(remaining);
        }
    }
}
