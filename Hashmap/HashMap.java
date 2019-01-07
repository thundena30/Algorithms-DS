/*Pratyusha Thundena
October 30, 2018
Lab 9*/



public class HashMap {
	private int TABLE_SIZE = 100;
	HashEntry[] table;

	// Create the new Hashmap by taking the size (100) and setting each int to null.
	HashMap() {
		table = new HashEntry[TABLE_SIZE];
		for (int i = 0; i < TABLE_SIZE; i++)
			table[i] = null;
	}

	// Create the new Hashmap by taking the size from the file or user and setting
	// each int to null.
	HashMap(int size) {
		TABLE_SIZE = size;
		table = new HashEntry[TABLE_SIZE];
		for (int i = 0; i < TABLE_SIZE; i++)
			table[i] = null;
	}

	/**
	 * 
	 * @param key
	 * @return value of the index.
	 */
	public String get(long key) {
		// set the table index to key by using Modulus which will always return the
		// remainder.
		int tableIndex = (int) (key % TABLE_SIZE);
		// loop through the table using the index until we find the key.
		while (table[tableIndex].getKey() != key)
			tableIndex = (7 * tableIndex + 1) % TABLE_SIZE;
		// Return the value once found.
		return table[tableIndex].getValue();
	}

	/**
	 * 
	 * @param key
	 * @param value
	 * @return collision
	 */
	public int put(long key, String value) {
		// set the table index to key by using Modulus which will always return the
		// remainder.
		int tableIndex = (int) (key % TABLE_SIZE);
		// set collision to 0;
		int collision = 0;
		// while the table index has a value and doesn't equal the key. we have a
		// collision.
		while (table[tableIndex] != null && table[tableIndex].getKey() != key) {
			// System.out.println("Collision detected at tableIndex " + tableIndex);
			// add one to the collision
			collision++;
			// set the index.
			tableIndex = (7 * tableIndex + 1) % TABLE_SIZE;
		}
		// if it equals null. just place the key and value at the index.
		if (table[tableIndex] == null) {
			System.out.println("Key " + key + " placed at tableIndex " + tableIndex);
			table[tableIndex] = new HashEntry(key, value);
		} else {
			// else we found the key so we can update it.
			System.out.println("Updated value at key " + key);
			table[tableIndex].setValue(value);
		}
		return collision;
	}

	/**
	 * 
	 * @param key
	 * @param value
	 * @return collisions
	 */
	public int linearProbing(long key, String value) {
		// set the table index to key by using Modulus which will always return the
		// remainder.
		int tableIndex = (int) (key % TABLE_SIZE);
		// set collisions to zero.
		int collision = 0;
		// loop through if the index != null.
		for (int i = 0; table[tableIndex] != null; i++) {
			// Update collision.
			collision++;
			// set the table index.
			tableIndex = (tableIndex + i) % TABLE_SIZE;
		}

		table[tableIndex] = new HashEntry(key, value);
		return collision;
	}

	/**
	 * 
	 * @param key
	 * @return value of table at current index
	 */
	public String linearProbingSearch(long key) {
		// set the table index to key by using Modulus which will always return the
		// remainder.
		int tableIndex = (int) (key % TABLE_SIZE);
		// Loop through the keys.
		for (int i = 0; table[tableIndex].getKey() != key; i++)
			// add one i to index and do modulus on it again.
			tableIndex = (tableIndex + i) % TABLE_SIZE;
		// return value.
		return table[tableIndex].getValue();
	}

	/**
	 * 
	 * @param key
	 * @param value
	 * @return collision
	 */
	public int quadraticProbing(long key, String value) {
		// set the table index to key by using Modulus which will always return the
		// remainder.
		int tableIndex = (int) (key % TABLE_SIZE);
		// set collisions to zero.
		int collision = 0;
		// loop through as long as index isn't null.
		for (int i = 0; table[tableIndex] != null; i++) {
			// up the collisons because we know its there
			collision++;
			// table index now becomes tableIndex + i ** 2 % Table size.
			tableIndex = (tableIndex + (int) Math.pow(i, 2)) % TABLE_SIZE;
		}
		// found a spot to put this index.
		table[tableIndex] = new HashEntry(key, value);
		return collision;
	}

	/**
	 * 
	 * @param key
	 * @return value at index.
	 */
	public String quadraticProbingSearch(long key) {
		// set the tableIndex using modulus on key sent, always be remainder.
		int tableIndex = (int) (key % TABLE_SIZE);
		// loop through the keys
		for (int i = 0; table[tableIndex].getKey() != key; i++)
			// set tableIndex to index i ** modulus TABLE_SIZE.
			tableIndex = (tableIndex + (int) Math.pow(i, 2)) % TABLE_SIZE;
		// return the value.
		return table[tableIndex].getValue();
	}
}
