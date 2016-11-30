package concepts.algorithms;

import org.junit.Test;

import static concepts.algorithms.JosephusProblem.*;

/**
 * Author: ddubson
 */
public class JosephusProblemTest {
    @Test
    public void josephusProblemTest() throws Exception {
        String[ ] a1 = {"Alice", "Bob", "Cindy", "Doug", "Ed", "Fred"};
        String[ ] a2 = {"Gene", "Hope", "Irene", "Jack", "Kim", "Lance"};
        String[ ] a3 = {"Mike", "Roberto"};
        System.out.println("First winner is " + josephus(buildQueue(a1), 3));
        System.out.println("Second winner is " + josephus(buildQueue(a2), 10));
        System.out.println("Third winner is " + josephus(buildQueue(a3), 7));
    }
}