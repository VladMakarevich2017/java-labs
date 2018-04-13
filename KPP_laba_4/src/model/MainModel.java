package model;

import sort.TestMultithreadedMergeSort;

/**
 * The class that is responsible for the logic of the program
 * @author VladMakarevich
 *
 */

public class MainModel {
	
	private TestMultithreadedMergeSort sort;
	
	/**
	 * initialization constructor
	 * @param sort
	 */
	
	public MainModel(TestMultithreadedMergeSort sort) {
		this.setSort(sort);
	}
	
	/**
	 * default  constructor
	 */
	
	public MainModel() {
		sort = new TestMultithreadedMergeSort();
	}
	
	/**
	 * sorting start
	 */
	
	public void startSort() {
		sort.run();
	}

	public TestMultithreadedMergeSort getSort() {
		return sort;
	}

	public void setSort(TestMultithreadedMergeSort sort) {
		this.sort = sort;
	}

	

	
	
}
