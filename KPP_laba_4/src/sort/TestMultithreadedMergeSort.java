package sort;

import java.util.Random;

/**
 * class for sorting an array in 
 * single-threaded and multithreaded way 
 * and measuring the sorting time
 * @author VladMakarevich
 *
 */

public class TestMultithreadedMergeSort {
	
	private int arrSize;
	private int numberOfThreads;
	private double singleSortTime;
	private double multiSortTime;
	public final int MAX_ARRAY_SIZE = 50_000_000;
	
	/**
	 * default constructor
	 */
	
	public TestMultithreadedMergeSort() {
		arrSize = 10_000_000;
		numberOfThreads = 5;
	}
	
	/**
	 * initialization constructor
	 * @param arrSize
	 * @param numberOfThreads
	 */
	
	public TestMultithreadedMergeSort(int arrSize, int numberOfThreads) {
		this.arrSize = arrSize;
		this.numberOfThreads = numberOfThreads;
		checkArraySize();
	}
	
	/**
	 * method starts sorting
	 */

    public  void run() {
        int[] unsorted = new int[arrSize];
        Random randomizer = new Random();
        for ( int i = 0; i < arrSize; i++ ) {
            unsorted[i] = randomizer.nextInt( 10_000 );
        }
        singleSortTime = runSingleSort(unsorted);
        multiSortTime = runMultiSort(unsorted);
    }
    
    /**
     * method starts single-thread sorting
     * @param unsorted array
     * @return sorting time
     */
    
    public double runSingleSort(int[] unsorted) {
        long startTime = System.nanoTime();
        SimpleMerger sorter = new SimpleMerger( unsorted );
        sorter.sort();
        long endTime = System.nanoTime();
        return (double)( endTime - startTime ) / 1_000_000_000 ;
    }
    
    /**
     * method starts multi-thread sorting
     * @param unsorted array
     * @return sorting time
     */
    
    public double runMultiSort(int[] unsorted) {
        long startTime = System.nanoTime();
        MultiMerger multiMerger = new MultiMerger( unsorted, numberOfThreads);
        multiMerger.start();

        try {
            multiMerger.join();
        } catch ( Exception e ) {

        }
        long endTime = System.nanoTime();
        return (double)( endTime - startTime ) / 1_000_000_000;
    }
    
    public void checkArraySize() {
		if(arrSize > MAX_ARRAY_SIZE) {
			try {
				throw new Exception();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
    }

	public int getArrSize() {
		return arrSize;
	}

	public void setArrSize(int arrSize) {
		this.arrSize = arrSize;
		checkArraySize();
	}
	
	public int getNumberOfThreads() {
		return numberOfThreads;
	}

	public void setNumberOfThreads(int numberOfThreads) {
		this.numberOfThreads = numberOfThreads;
	}

	public double getSingleSortTime() {
		return singleSortTime;
	}

	public void setSingleSortTime(double singleSortTime) {
		this.singleSortTime = singleSortTime;
	}

	public double getMultiSortTime() {
		return multiSortTime;
	}

	public void setMultiSortTime(double multiSortTime) {
		this.multiSortTime = multiSortTime;
	}
}
