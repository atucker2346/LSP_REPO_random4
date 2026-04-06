package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Models a mathematical set of integers using an {@link ArrayList}.
 * Elements are unique; set operations return new {@code IntegerSet} instances without
 * modifying the operands.
 *
 * @author Anthony Tucker
 */
public class IntegerSet {

    private final ArrayList<Integer> set;

    /**
     * Constructs an empty integer set.
     */
    public IntegerSet() {
        this.set = new ArrayList<>();
    }

    /**
     * Removes all elements from this set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the number of elements in this set.
     *
     * @return the cardinality of the set
     */
    public int length() {
        return set.size();
    }

    /**
     * Returns whether this set contains exactly the same elements as {@code b},
     * independent of order.
     *
     * @param b the other set to compare; must not be {@code null}
     * @return {@code true} if both sets have the same elements
     */
    public boolean equals(IntegerSet b) {
        if (b == null) {
            return false;
        }
        if (this.length() != b.length()) {
            return false;
        }
        for (int value : set) {
            if (!b.contains(value)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Reports whether {@code value} is in this set.
     *
     * @param value the integer to test
     * @return {@code true} if present
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest element in this set.
     *
     * @return the maximum value
     * @throws IllegalStateException if the set is empty
     */
    public int largest() {
        if (set.isEmpty()) {
            throw new IllegalStateException("Cannot find largest element of an empty set");
        }
        return Collections.max(set);
    }

    /**
     * Returns the smallest element in this set.
     *
     * @return the minimum value
     * @throws IllegalStateException if the set is empty
     */
    public int smallest() {
        if (set.isEmpty()) {
            throw new IllegalStateException("Cannot find smallest element of an empty set");
        }
        return Collections.min(set);
    }

    /**
     * Adds {@code item} to this set if it is not already present.
     *
     * @param item the value to add
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes {@code item} from this set if present.
     *
     * @param item the value to remove
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Returns a new set containing every element that appears in this set or in {@code intSetb}.
     * Neither operand is modified.
     *
     * @param intSetb the other set
     * @return the union as a new {@code IntegerSet}
     */
    public IntegerSet union(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        for (int value : this.set) {
            result.add(value);
        }
        for (int value : intSetb.set) {
            result.add(value);
        }
        return result;
    }

    /**
     * Returns a new set containing only elements present in both this set and {@code intSetb}.
     * Neither operand is modified.
     *
     * @param intSetb the other set
     * @return the intersection as a new {@code IntegerSet}
     */
    public IntegerSet intersect(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        for (int value : this.set) {
            if (intSetb.contains(value)) {
                result.add(value);
            }
        }
        return result;
    }

    /**
     * Returns a new set of elements that are in this set but not in {@code intSetb}
     * (set difference {@code this \ intSetb}). Neither operand is modified.
     *
     * @param intSetb the other set
     * @return the difference as a new {@code IntegerSet}
     */
    public IntegerSet diff(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        for (int value : this.set) {
            if (!intSetb.contains(value)) {
                result.add(value);
            }
        }
        return result;
    }

    /**
     * Returns a new set of elements that are in {@code intSetb} but not in this set
     * (relative complement {@code intSetb \ this}). Neither operand is modified.
     *
     * @param intSetb the universe-relative other set
     * @return the complement as a new {@code IntegerSet}
     */
    public IntegerSet complement(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        for (int value : intSetb.set) {
            if (!this.contains(value)) {
                result.add(value);
            }
        }
        return result;
    }

    /**
     * Returns whether this set has no elements.
     *
     * @return {@code true} if empty
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation with elements in ascending order,
     * formatted as {@code [1, 2, 3]} or {@code []} if empty.
     *
     * @return the formatted string
     */
    @Override
    public String toString() {
        ArrayList<Integer> sorted = new ArrayList<>(set);
        Collections.sort(sorted);
        if (sorted.isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < sorted.size(); i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(sorted.get(i));
        }
        sb.append("]");
        return sb.toString();
    }
}
