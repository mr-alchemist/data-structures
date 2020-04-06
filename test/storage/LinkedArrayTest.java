package test.storage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import storage.LinkedArray;

class LinkedArrayTest {
	private LinkedArray<String> la;
	
	@BeforeEach
	void initLinkedArray() {
		la = new LinkedArray<String>();
		//System.out.println("@BeforeEach initLinkedArray()");
	}
	
	@AfterEach
	void clearLinkedArray() {
		la = null;
		//System.out.println("@AfterEach clearLinkedArray()");
	}
	
	@Test
	void add3ElementsSizeIs3() {
		la.add("Item0");
		la.add("Item1");
		la.add("Item2");
		assertEquals(3, la.size());
	}
	
	@Test
	void add0ElementsSizeIs0() {
		assertEquals(0, la.size());
	}
	
	@Test
	void addNElementsGetNElements() {
		int n = 10;
		for(int i = 0; i < n; i++) 
			la.add("Item" + i);
		
		for(int i = 0; i < n; i++) {
			String s = la.get(i);
			assertEquals("Item" + i, s);
		}
	}
	
	@Test
	void tryGetSizethElemGotNull() {
		String s = la.get(0);
		assertNull(s);
		la.add("Item0");
		la.add("Item1");
		la.add("Item3");
		s = la.get(3);
		assertNull(s);
	}
	
	@Test
	void tryGetElementNegativeIndexGotNull() {
		la.add("Item0");
		la.add("Item1");
		la.add("Item3");
		String s = la.get(-1);
		assertNull(s);
		s = la.get(-3);
		assertNull(s);
	}
}
