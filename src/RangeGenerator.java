import java.util.List;
import java.util.Optional;

/**
 * Step 1
 *
 * Using TDD approach (create small test, create code that pass test, refactor to excellence)
 * implement the below class that represents the sequence of numbers from start to stop included.
 * Be sure to test that:
 * - the produced elements (called using next(), go from start to stop included)
 * - calling next after stop has been produced, lead to a Optional.empty
 * - calling reset after producing some elements brings the object back at the beginning
 * - isOver can actually be called in the middle and gives false, at the end and gives true
 * - can produce the list of remaining elements in one shot
 */
public class RangeGenerator implements SequenceGenerator {

    public RangeGenerator(int start, int stop){

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
