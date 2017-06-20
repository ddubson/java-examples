import domain.Book;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EquivalenceTestingTest {
    Book b1, b2, b3, b4;

    @Before
    public void setUp() throws Exception {
        b1 = new Book();
        b1.name = "name1";
        b2 = new Book();
        b2.name = "name1";
        b3 = new Book();
        b3.name = "name3";
        b4 = new Book();
        b4.name = "name1";
    }

    /**
     * Treatment of null: For any nonnull reference variable x, the call x.equals(null)
     * should return false (that is, nothing equals null except null).
     **/
    @Test
    public void equivalence_compareNullsMustReturnFalse() throws Exception {
        assertFalse(b1.equals(null));
    }

    /**
     * Reflexivity: For any nonnull reference variable x, the call x.equals(x) should
     * return true (that is, an object should equal itself).
     **/
    @Test
    public void equivalence_compareObjectWithItselfMustReturnTrue() throws Exception {
        assertTrue(b1.equals(b1));
    }

    /**
     * Symmetry: For any nonnull reference variables x and y, the calls x.equals(y)
     * and y.equals(x) should return the same value.
     **/
    @Test
    public void equivalance_twoObjectsOfSameTypeMustReturnTrueBidirectionally() throws Exception {
        assertTrue(b1.equals(b2) == b2.equals(b1));
    }

    /**
     * Transitivity: For any nonnull reference variables x, y, and z, if both calls
     * x.equals(y) and y.equals(z) return true, then call x.equals(z)
     * must return true as well
     */
    @Test
    public void equivalence_transitivePropertyOfComparisons() throws Exception {
        boolean equals = b1.equals(b2);
        boolean equals2 = b2.equals(b4);
        boolean equals3 = equals == equals2;
        assertTrue(b1.equals(b4) == equals3);

    }

    @Test
    public void equivalence_twoObjectsOfSameDataShouldBeTrue() throws Exception {
        assertTrue(b1.equals(b2));
    }

    @Test
    public void equivalence_compareTwoObjectsWithDifferentData() throws Exception {
        assertFalse(b1.equals(b3));
    }

    @Test
    public void equivalence_compareTwoObjectsOfDifferentType() throws Exception {
        assertFalse(b1.equals(""));
    }
}