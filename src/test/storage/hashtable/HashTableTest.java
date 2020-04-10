package test.storage.hashtable;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import storage.hashtable.*;

class HashTableTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		HashTable<String> ht = new HashTable<String>(5000);
		int n = 1_000_000;
		for(int i = 0; i < n; i++)
			ht.insert(i, "Item" + i);
		
		for(int i = 0; i < n; i++)
			assertEquals("Item"+i, ht.find(i));
			
		for(int i = 0; i < n; i++)
			assertEquals("Item"+i, ht.remove(i));
		
		for(int i = 0; i < n; i++)
			assertNull(ht.remove(i));
			
	}

}
