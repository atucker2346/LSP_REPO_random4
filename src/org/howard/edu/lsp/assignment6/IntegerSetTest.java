package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * JUnit 5 tests for {@link IntegerSet}.
 */
public class IntegerSetTest {

    @Test
    void testClearNormalAndEdge() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.clear();
        assertTrue(set.isEmpty());

        set.clear();
        assertTrue(set.isEmpty());
    }

    @Test
    void testLengthNormalAndEdge() {
        IntegerSet set = new IntegerSet();
        set.add(5);
        set.add(10);
        assertEquals(2, set.length());

        IntegerSet empty = new IntegerSet();
        assertEquals(0, empty.length());
    }

    @Test
    void testEqualsSameElementsDifferentOrderEdge() {
        IntegerSet a = new IntegerSet();
        a.add(1);
        a.add(2);
        a.add(3);

        IntegerSet b = new IntegerSet();
        b.add(3);
        b.add(1);
        b.add(2);

        assertTrue(a.equals(b));
    }

    @Test
    void testEqualsMismatchNormal() {
        IntegerSet a = new IntegerSet();
        a.add(1);
        a.add(2);

        IntegerSet b = new IntegerSet();
        b.add(1);
        b.add(3);

        assertFalse(a.equals(b));
    }

    @Test
    void testContainsPresentAndAbsent() {
        IntegerSet set = new IntegerSet();
        set.add(7);
        set.add(9);

        assertTrue(set.contains(7));
        assertFalse(set.contains(100));
    }

    @Test
    void testLargestSingleElementAndNormal() {
        IntegerSet single = new IntegerSet();
        single.add(42);
        assertEquals(42, single.largest());

        IntegerSet set = new IntegerSet();
        set.add(4);
        set.add(10);
        set.add(6);
        assertEquals(10, set.largest());
    }

    @Test
    void testLargestThrowsOnEmpty() {
        IntegerSet empty = new IntegerSet();
        assertThrows(IllegalStateException.class, empty::largest);
    }

    @Test
    void testSmallestSingleElementAndNormal() {
        IntegerSet single = new IntegerSet();
        single.add(17);
        assertEquals(17, single.smallest());

        IntegerSet set = new IntegerSet();
        set.add(4);
        set.add(10);
        set.add(6);
        assertEquals(4, set.smallest());
    }

    @Test
    void testSmallestThrowsOnEmpty() {
        IntegerSet empty = new IntegerSet();
        assertThrows(IllegalStateException.class, empty::smallest);
    }

    @Test
    void testAddNormalAndDuplicateEdge() {
        IntegerSet set = new IntegerSet();
        set.add(3);
        set.add(8);
        assertEquals(2, set.length());

        set.add(3);
        assertEquals(2, set.length());
    }

    @Test
    void testRemoveNormalAndMissingEdge() {
        IntegerSet set = new IntegerSet();
        set.add(11);
        set.add(22);
        set.remove(11);
        assertFalse(set.contains(11));
        assertEquals(1, set.length());

        set.remove(99);
        assertEquals(1, set.length());
        assertTrue(set.contains(22));
    }

    @Test
    void testUnionNormalAndWithEmptyEdge() {
        IntegerSet a = new IntegerSet();
        a.add(1);
        a.add(2);
        IntegerSet b = new IntegerSet();
        b.add(2);
        b.add(3);

        IntegerSet union = a.union(b);
        assertEquals("[1, 2, 3]", union.toString());

        IntegerSet empty = new IntegerSet();
        IntegerSet unionWithEmpty = a.union(empty);
        assertEquals("[1, 2]", unionWithEmpty.toString());
    }

    @Test
    void testIntersectNormalAndNoCommonElementsEdge() {
        IntegerSet a = new IntegerSet();
        a.add(1);
        a.add(2);
        a.add(3);
        IntegerSet b = new IntegerSet();
        b.add(2);
        b.add(4);

        IntegerSet intersection = a.intersect(b);
        assertEquals("[2]", intersection.toString());

        IntegerSet c = new IntegerSet();
        c.add(8);
        c.add(9);
        IntegerSet noOverlap = a.intersect(c);
        assertTrue(noOverlap.isEmpty());
    }

    @Test
    void testDiffNormalAndIdenticalSetsEdge() {
        IntegerSet a = new IntegerSet();
        a.add(1);
        a.add(2);
        a.add(3);
        IntegerSet b = new IntegerSet();
        b.add(2);

        IntegerSet difference = a.diff(b);
        assertEquals("[1, 3]", difference.toString());

        IntegerSet identicalA = new IntegerSet();
        identicalA.add(5);
        identicalA.add(6);
        IntegerSet identicalB = new IntegerSet();
        identicalB.add(5);
        identicalB.add(6);
        IntegerSet identicalDiff = identicalA.diff(identicalB);
        assertTrue(identicalDiff.isEmpty());
    }

    @Test
    void testComplementNormalAndDisjointEdge() {
        IntegerSet a = new IntegerSet();
        a.add(1);
        a.add(2);
        IntegerSet b = new IntegerSet();
        b.add(2);
        b.add(3);
        b.add(4);

        IntegerSet complement = a.complement(b);
        assertEquals("[3, 4]", complement.toString());

        IntegerSet c = new IntegerSet();
        c.add(10);
        c.add(11);
        IntegerSet disjointComplement = a.complement(c);
        assertEquals("[10, 11]", disjointComplement.toString());
    }

    @Test
    void testIsEmptyEmptyAndNonEmpty() {
        IntegerSet empty = new IntegerSet();
        assertTrue(empty.isEmpty());

        empty.add(99);
        assertFalse(empty.isEmpty());
    }

    @Test
    void testToStringNormalAndEmpty() {
        IntegerSet set = new IntegerSet();
        set.add(3);
        set.add(1);
        set.add(2);
        assertEquals("[1, 2, 3]", set.toString());

        IntegerSet empty = new IntegerSet();
        assertEquals("[]", empty.toString());
    }
}
