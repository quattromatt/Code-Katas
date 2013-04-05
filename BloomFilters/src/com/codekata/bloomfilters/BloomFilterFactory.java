package com.codekata.bloomfilters;


public class BloomFilterFactory {

	private static BloomFilter m_bloomFilter;
	
	/**
	 * Returns a bloom filter
	 * @return
	 */
	public static BloomFilter getBloomFilter() {
		if (m_bloomFilter == null) {
			m_bloomFilter = new BloomFilter();
		}
		
		return m_bloomFilter;
	}
}
