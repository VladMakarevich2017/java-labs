package sort;

/**
 * class for sorting an array in 
 * single-threaded way 
 * and measuring the sorting time
 * @author VladMakarevich
 *
 */

public class SimpleMerger {

    private int[] unsorted;
    private int[] sorted;
    
    /**
     * initialization constructor
     * @param unsorted array
     */

    public SimpleMerger( int[] unsorted ) {
        this.unsorted = unsorted;
    }

    /**
     * method that breaks the input array in a recursive way
     */
    
    public void sort() {
        int middle;
        int[] left, right;

        if ( unsorted.length <= 1 ) {
            sorted = unsorted;
        } else {
            middle = unsorted.length / 2;

            left = new int[middle];
            right = new int[unsorted.length - middle];

            System.arraycopy( unsorted, 0, left, 0, middle );
            System.arraycopy( unsorted, middle, right, 0, unsorted.length - middle );

            SimpleMerger leftSort = new SimpleMerger( left );
            SimpleMerger rightSort = new SimpleMerger( right );

            leftSort.sort();
            rightSort.sort();

            sorted = merge(leftSort.getSorted(), rightSort.getSorted() );
        }
    }

    /**
     * static method. Merge two sorted arrays
     */
    
    public static int[] merge( int[] leftPart, int[] rightPart ) {
        int cursorLeft = 0;
        int cursorRight = 0;
        int counter = 0;
        int[] merged = new int[leftPart.length + rightPart.length];

        while ( cursorLeft < leftPart.length && cursorRight < rightPart.length ) {
            if ( leftPart[cursorLeft] <= rightPart[cursorRight] ) {
                merged[counter] = leftPart[cursorLeft];
                cursorLeft++;
            } else {
                merged[counter] = rightPart[cursorRight];
                cursorRight++;
            }
            counter++;
        }

        if ( cursorLeft < leftPart.length ) {
            System.arraycopy( leftPart, cursorLeft, merged, counter, merged.length - counter );
        }
        if ( cursorRight < rightPart.length ) {
            System.arraycopy( rightPart, cursorRight, merged, counter, merged.length - counter );
        }

        return merged;
    }

    public int[] getSorted() {
        return sorted;
    }
}
