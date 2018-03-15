package u02lab.code;

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

    public RandomGenerator(int n){

    }

    @Override
    public Optional<Integer> next() {
        return Optional.empty();
    }

    @Override
    public void reset() {

    }

    @Override
    public boolean isOver() {
        return false;
    }

    @Override
    public List<Integer> allRemaining() {
        return null;
    }
}
