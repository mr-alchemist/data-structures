package test.storage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import storage.LinkedArray;

class LinkedArrayIteratorTest {
	private LinkedArray<String> la;
	
	@BeforeEach
	void initLinkedArray() {
		la = new LinkedArray<String>();
	}

	@AfterEach
	void clearLinkedArray() {
		la = null;
	}

	@Test
	void listEmptyHasNextIsFalse() {
		Iterator<String> iterator = la.iterator();
		assertFalse(iterator.hasNext());
	}
	
	@Test
	void simpleWalkIsFine() {
		la.add("Item0");
		la.add("Item1");
		la.add("Item2");
		
		Iterator<String> iterator = la.iterator();
		
		assertTrue(iterator.hasNext());
		assertEquals("Item0", iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals("Item1", iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals("Item2", iterator.next());
		assertFalse(iterator.hasNext());
		
		assertThrows(NoSuchElementException.class, () -> iterator.next());
	}
	
	@Test
	void removeBeforeCallNextThowsIllegalStateException() {
		la.add("Item0");
		la.add("Item1");
		la.add("Item2");
		Iterator<String> iterator = la.iterator();
		assertThrows(IllegalStateException.class, () -> iterator.remove());
	}
	
	@Test
	void removeRightAfterRemoveThowsIllegalStateException() {
		la.add("Item0");
		la.add("Item1");
		la.add("Item2");
		Iterator<String> iterator = la.iterator();
		iterator.next();
		iterator.remove();
		assertThrows(IllegalStateException.class, () -> iterator.remove());
	}
	
	@Test
	void removingElementInMiddleIsOk() {
		la.add("Item0");
		la.add("Item1");
		la.add("Item2");
		la.add("Item3");
		la.add("Item4");
		Iterator<String> iterator = la.iterator();
		iterator.next();
		iterator.next();
		iterator.next();
		iterator.remove();
		assertEquals("Item3", la.get(2));
		assertEquals(4, la.size());
		
	}
	
	@Test
	void removingElementInMiddleIsOk2() {
		la.add("Item0");
		la.add("Item1");
		la.add("Item2");
		la.add("Item3");
		la.add("Item4");
		Iterator<String> iterator = la.iterator();
		iterator.next();
		iterator.next();
		iterator.next();
		iterator.remove();
		assertEquals(4, la.size());
		
		iterator = la.iterator();
		assertTrue(iterator.hasNext());
		assertEquals("Item0", iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals("Item1", iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals("Item3", iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals("Item4", iterator.next());
		assertFalse(iterator.hasNext());
		
	}
	
	@Test
	void removingSingleElementIsOk() {
		la.add("Item0");
		Iterator<String> iterator = la.iterator();
		assertTrue(iterator.hasNext());
		assertEquals("Item0", iterator.next());
		iterator.remove();
		assertEquals(0, la.size());
		
		iterator = la.iterator();
		assertFalse(iterator.hasNext());
	}
	
	@Test
	void removingHeadElementFromListSize3IsOk() {
		la.add("Item0");
		la.add("Item1");
		la.add("Item2");
		Iterator<String> iterator = la.iterator();
		iterator.next();
		iterator.remove();
		assertEquals(2, la.size());
		
		iterator = la.iterator();
		assertTrue(iterator.hasNext());
		assertEquals("Item1", iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals("Item2", iterator.next());
		assertFalse(iterator.hasNext());	
	}
	
	@Test
	void removingHeadElementFromListSize2IsOk() {
		la.add("Item0");
		la.add("Item1");
		Iterator<String> iterator = la.iterator();
		iterator.next();
		iterator.remove();
		assertEquals(1, la.size());
		
		iterator = la.iterator();
		assertTrue(iterator.hasNext());
		assertEquals("Item1", iterator.next());
		assertFalse(iterator.hasNext());
	}
	
	@Test
	void removingTailElementFromListSize3IsOk() {
		la.add("Item0");
		la.add("Item1");
		la.add("Item2");
		Iterator<String> iterator = la.iterator();
		iterator.next();
		iterator.next();
		iterator.next();
		iterator.remove();
		assertEquals(2, la.size());
		
		iterator = la.iterator();
		assertTrue(iterator.hasNext());
		assertEquals("Item0", iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals("Item1", iterator.next());
		assertFalse(iterator.hasNext());
	}
	
	@Test
	void removingTailElementFromListSize2IsOk() {
		la.add("Item0");
		la.add("Item1");
		Iterator<String> iterator = la.iterator();
		iterator.next();
		iterator.next();
		iterator.remove();
		assertEquals(1, la.size());
		
		iterator = la.iterator();
		assertTrue(iterator.hasNext());
		assertEquals("Item0", iterator.next());
		assertFalse(iterator.hasNext());
	}
	
	@Test
	void removingAndAddingBigTest() {
		la.add("Item0");
		la.add("Item1");
		la.add("Item2");
		Iterator<String> iterator = la.iterator();
		iterator.next();
		iterator.remove();//
		iterator.next();
		iterator.remove();//
		la.add("Item3");
		la.add("Item4");
		
		iterator = la.iterator();
		assertTrue(iterator.hasNext());
		assertEquals("Item2", iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals("Item3", iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals("Item4", iterator.next());
		assertFalse(iterator.hasNext());
		
		iterator.remove();//
		
		la.add("Item5");
		iterator = la.iterator();
		assertTrue(iterator.hasNext());
		assertEquals("Item2", iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals("Item3", iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals("Item5", iterator.next());
		assertFalse(iterator.hasNext());
		
		la.add("Item6");
		la.add("Item7");
		iterator = la.iterator();
		iterator.next();
		iterator.next();
		iterator.next();
		iterator.remove();
		
		iterator = la.iterator();
		assertTrue(iterator.hasNext());
		assertEquals("Item2", iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals("Item3", iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals("Item6", iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals("Item7", iterator.next());
		assertFalse(iterator.hasNext());
		
		
	}

}
