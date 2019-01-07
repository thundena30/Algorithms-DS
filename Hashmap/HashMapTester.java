/*Pratyusha Thundena
October 30, 2018
Lab 9*/
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * This is the tester Java class. Putting all the super heroes into the hashmap
 * in three different ways, 1. standard put, 2. LinaerProbe 3. Quadratic Probe.
 * The first basicTester just proves that it works. The second does a
 * linaerprobe, quadratic, and linaersearch and quadratic.
 */
public class HashMapTester {
	public static void main(String[] args) {
		System.out.println("Starting the basic test");
		basicTester();
		System.out.println("\n\n\n");
		System.out.println("Starting the full Comparsion");
		fullComparsion();
	}

	// This tester is for the 1-4
	public static void basicTester() {

		HashMap hashmap = new HashMap();

		hashmap.put(1, "Bruce Wayne");
		hashmap.put(4, "Clark Kent");
		hashmap.put(3, "Peter Parker");
		hashmap.put(2, "Steve Rogers");
		hashmap.put(5, "Alan Scott");
		hashmap.put(8, "Tony Stark");
		hashmap.put(7, "David Bruce Banner");
		hashmap.put(6, "Britt Reid");
		hashmap.put(0, "Billy Batson");
		hashmap.put(105, "Barry Allen");
		hashmap.put(55, "Scott Summers");
		hashmap.put(410, "Reed Richards");

		System.out.println("");

		System.out.println("Calling Linear Probe On keys and values: ");
		hashmap.linearProbing(555, "Stanley Beamish");
		hashmap.linearProbing(413, "Kit Walker Jr.");

		System.out.println("");

		System.out.println("Calling Quadratic Probe On keys and values: ");
		hashmap.quadraticProbing(435, "Steve Austin");
		hashmap.quadraticProbing(413, "Barbara Gordon");

		System.out.println("");
		System.out.println("Calling get On two keys: ");
		System.out.println("Key 0 found, String: " + hashmap.get(0));
		System.out.println("Key 2 found, String: " + hashmap.get(2));
	}

	// this is for question 5.
	public static void fullComparsion() {

		final int TABLE_SIZE = 225555;
		final int SEARCH_SIZE = 17;
		int inputSize = 0;
		int collision = 0;
		String[] inputArray = new String[TABLE_SIZE];
		String[] searchArray = new String[SEARCH_SIZE];
		HashMap hashmap = new HashMap();

		try {
			// Files to be used to create has table and search it
			String inputFile = "input.dat";
			String UPCFile = "UPC.csv";
			String line;

			// Search file array creation
			FileInputStream fileInput = new FileInputStream(inputFile);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInput));

			// Loop through and add the strings to the search Array.
			for (int i = 0; (line = bufferedReader.readLine()) != null; i++) {
				searchArray[i] = line;
			}
			// set the input to the UPC File.
			fileInput = new FileInputStream(UPCFile);
			// buffered reader of the UPC
			bufferedReader = new BufferedReader(new InputStreamReader(fileInput));
			// Loop through as long as next line isn't null.
			for (inputSize = 0; (line = bufferedReader.readLine()) != null; inputSize++) {
				// add line to inputarray at each increment
				inputArray[inputSize] = line;
			}
			// Close the reader and file input.
			bufferedReader.close();
			fileInput.close();

		} catch (Exception e) {
			System.out.print("Error when loading the files, please check stack and try again. ");
			System.out.println(e.toString());
		}
		// Make sure collision is zero
		// now create a new hashmap.
		collision = 0;
		hashmap = new HashMap(TABLE_SIZE);
		// start the clock, using nano seconds to give accurate timing as miliseconds is
		// not accurate enough to give results.
		long linearProbingStart = System.nanoTime();
		// Loop through the input file, and add the string and value to it.
		for (int i = 0; i < inputSize; i++) {

			String[] str = inputArray[i].split(",");
			long key = Long.parseLong(str[0]);
			String value = str[2] + ", " + str[1];
			// add collisions up.
			collision += hashmap.linearProbing(key, value);

		}
		// Finish.
		long linearProbingDone = System.nanoTime();

		// Linear Probing Search
		// Start the clock for search.
		long linearProbingSearchBegin = System.nanoTime();
		// loop through the searchArray and find the key.
		for (int i = 0; i < searchArray.length; i++) {
			// split the array on the comma, and use position 0 to pass to the search.
			String[] str = searchArray[i].split(",");
			long key = Long.parseLong(str[0]);
			// Print out when we actually find a key.
			System.out.println("Found key " + key + ": " + hashmap.linearProbingSearch(key));
		}
		// end
		long linearProbingSearchEnd = System.nanoTime();

		System.out.println("Linear Probing and Searching is complete");
		System.out.println(
				"Time to create using linearProbing : " + (linearProbingDone - linearProbingStart) + " Nano seconds");
		System.out.println("Collisisons: " + collision);
		System.out.println("Time to Search Using Linear Probing Search : "
				+ (linearProbingSearchEnd - linearProbingSearchBegin) + " Nano seconds");

		// Quadratic Probing
		// Reset collision to 0 because we need to start the count again and create a
		// new hashmap.
		collision = 0;
		hashmap = new HashMap(TABLE_SIZE);
		// Start the timer.
		long quadraticProbingStart = System.nanoTime();
		// loop through and pass the key and string to the quadratic probe.
		for (int i = 0; i < inputSize; i++) {

			String[] str = inputArray[i].split(",");
			long key = Long.parseLong(str[0]);
			String value = str[2] + ", " + str[1];

			collision += hashmap.quadraticProbing(key, value);

		}
		// we are done end the time.
		long quadraticProbingEnd = System.nanoTime();

		// Quadratic Probing Search

		long quadraticProbingSearchStart = System.nanoTime();
		for (int i = 0; i < searchArray.length; i++) {
			// Parse search line and add to hash map
			String[] str = searchArray[i].split(",");
			long key = Long.parseLong(str[0]);
			// Print when the key is found.
			System.out.println("Found key " + key + ": " + hashmap.quadraticProbingSearch(key));
		}
		long quadraticProbingSearchEnd = System.nanoTime();
		System.out.println("Quadratic Probing and Searching is complete");
		System.out.println("Time to create using Quadratic Probing " + (quadraticProbingEnd - quadraticProbingStart)
				+ " Nano seconds");
		System.out.println("Creation collisisons: " + collision);
		System.out.println("Time to search using Quadratic Probing Search "
				+ (quadraticProbingSearchEnd - quadraticProbingSearchStart) + " Nano seconds");
	}
}
