import java.util.List;
import java.util.Optional;

/**
 * An interface modelling a generator for a finite sequence of integers
 */
public interface SequenceGenerator {

    /**
     * @return the next numbers to generate, as an Optional
     */
    Optional<Integer> next();

    /**
     * resets the generation: the next number is the first one to generate
     */
    void reset();

    /**
     * @return whether the sequence has been entirely produced
     */
    boolean isOver();

    /**
     * @return the whole list of numbers that remain to be produced
     */
    List<Integer> allRemaining();
}
