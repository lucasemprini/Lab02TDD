package u02lab.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Step 2
 *
 * Now consider a RandomGenerator. Using TDD approach (create small test, create code that pass test, refactor
 * to excellence) implement the below class that represents a sequence of n random bits (0 or 1). Recall
 * that math.random() gives a double in [0,1]..
 * Be sure to test all that is needed, as before
 *
 * When you are done:
 * A) try to refactor the code according to DRY (RandomGenerator vs RangeGenerator), using patterns as needed
 * - be sure tests still pass
 * - refactor the test code as well
 * B) create an abstract factory for these two classes, and implement it
 */
public class RandomGenerator implements SequenceGenerator {

    private final List<Integer> range = new ArrayList<>();
    private int currentIndex = 0;
    private static final double RANDOMFACTOR = 0.5;

    public RandomGenerator(int n){
        for(int i = 0; i < n; i++) {
            range.add(Math.random() > RANDOMFACTOR ? 1 : 0);
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
            final List<Integer> toReturn = range.subList(currentIndex, range.size());
            currentIndex = range.size();
            return Collections.unmodifiableList(toReturn);
        }
    }
}
