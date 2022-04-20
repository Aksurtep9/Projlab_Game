package src;

/**
 * <b>Test class for the program's prototype</b><br><br>
 * Use this class to run the tests.<br>
 * Automatically calls the method which gives information about the tests' results.
 * @author Martin
 */
public class ProtoTest {
	
	
	
	/**The file that contains the runnable commands.*/
	private String commandsFilePath;
	/**The file that contains the expected output after the run.*/
	private String expectedOutFilePath;
	/**The file that contains the generated output after the run.*/
	private String generatedOutFilePath;
	
	
	/**
	 * Initializes the files' path
	 */
	public void Initialize() {
		//TO-DO: Give the files' path!
	}
	
	
	/**
	 * Runs the tests and gives the results back.
	 */
	public void Run() {
		//TO-DO: Run tests here
		String result = ProtoTest.TestCalculator.Calculate(generatedOutFilePath, expectedOutFilePath);
		System.out.println(result);
	}
	
	
	//TO-DO: Write tests here - each test has a method
	// ------ IDE -----
	//----------------
	
	
	
	
	/**
	 * <b> Class for the tests' results.</b><br><br>
	 * Use this class to see if all the tests have succeeded.
	 * @author Martin
	 */
	private static class TestCalculator{
		
		
		/**
		 * Checks if all the tests have succeeded.
		 * @param generated - the file that contains the generated output
		 * @param expected - the file that contains the expected output
		 * @return the string which contains the results.
		 */
		public static String Calculate(String generated, String expected) {
			int succeededRows = 0;
			int numberOfRows = 0;	// the number of rows that the file contains
			
			//TO-DO: Fájl sorainak összehasonlítása
			
			return "The result: " + succeededRows + "/" + numberOfRows;
		}
	}
}
