package sort;

/**
 * class for sorting an array in 
 * multi-threaded way 
 * and measuring the sorting time
 * @author VladMakarevich
 *
 */

public class MultiMerger extends Thread {

    private int[] unsorted, sorted;
    private  int maxThreads;
    
    /**
     * initialization constructor
     * @param unsorted array
     * @param maxThreads
     */

    public MultiMerger(int[] unsorted, int maxThreads) {
        this.unsorted = unsorted;
        this.maxThreads = maxThreads;
    }
    
    /**
     * initialization constructor
     * @param unsorted array
     */

    public MultiMerger(int[] unsorted) {
        this.unsorted = unsorted;
        maxThreads = 8;
    }
    
    /**
     * method starts multithreading sorting
     */

    public void run() {
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

            if ( activeCount() < maxThreads) {
            	createNewThread(left, right);
            } else {  
            	sequentialSorting(left, right);
            }
        }
    }
    
    /**
     * method creates a new threads for two arrays
     * @param left part of the array
     * @param right part of the array
     */
    
    public void createNewThread(int[] left, int[] right) {
    	MultiMerger leftSort = new MultiMerger( left );
        MultiMerger rightSort = new MultiMerger( right );

        leftSort.start();
        rightSort.start();

        try {
            leftSort.join();
            rightSort.join();

            sorted = SimpleMerger.merge( leftSort.getSorted(), rightSort.getSorted() );
        } catch ( Exception e ) {

        }
    }
    
    /**
     * the method continues to sort 
     * the unsorted part of the array
     * @param left
     * @param right
     */
    
    public void sequentialSorting(int[] left, int[] right) {
    	SimpleMerger leftSort = new SimpleMerger( left );
        SimpleMerger rightSort = new SimpleMerger( right );

        leftSort.sort();
        rightSort.sort();

        sorted = SimpleMerger.merge( leftSort.getSorted(), rightSort.getSorted() );
    }

    public int[] getSorted() {
        return sorted;
    }

	public int getMaxThreads() {
		return maxThreads;
	}

	public void setMaxThreads(int maxThreads) {
		this.maxThreads = maxThreads;
	}
}
