package com.codekata.bloomfilters.impl;

import com.codekata.bloomfilters.HashFunction;
import com.codekata.util.MD5Utils;

public class MD5HashFunction implements HashFunction {

	private static final int HASH_LEN = 3;
	
	private int m_startIndex;
	
	public MD5HashFunction(int startIndex) {
		m_startIndex = startIndex;
	}
	
	@Override
	public int hash(String word) {
		String hashCode = MD5Utils.hash(word);
		
		String hex = hashCode.substring(m_startIndex, m_startIndex + HASH_LEN);
		int ret = Integer.parseInt(hex, 16);
//		System.out.println(word + " : " + hashCode + " : " + hex + " : " + ret);
		return ret;
	}
}
