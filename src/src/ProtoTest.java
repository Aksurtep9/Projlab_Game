package src;

import java.io.File;

/**
 * <b>Test class for the program's prototype</b><br><br>
 * Use this class to run the tests.<br>
 * Automatically calls the method which gives information about the tests' results.
 * @author Martin
 */
public class ProtoTest {
	
	
	
	/**The file that contains the runnable commands.*/
	private File commandsFile;
	/**The file that contains the expected output after the run.*/
	private File expectedOutFile;
	/**The file that contains the generated output after the run.*/
	private File generatedOutFile;
	/**Proto class*/
	private Prototype proto;
	
	private static File wd;
	
	/**
	 * Initializes the files' path
	 */
	public void Initialize() {
		//TO-DO: Give the files' path!
		wd = new File(System.getProperty("user.dir"), "src/src");
		commandsFile = new File(wd, "commands.txt");
		expectedOutFile = new File(wd, "expected.txt");
		generatedOutFile = new File(wd, "generated.txt");
	}
	
	
	/**
	 * Runs the tests and gives the results back.
	 */
	public void Run() {
		//TO-DO: Run tests here
		//String resultMain = " ";
		//resultMain += Method();
		//resultMain kiírása a generatedOut
		String result = ProtoTest.TestCalculator.Calculate(generatedOutFile, expectedOutFile);
		System.out.println(result);
	}
	
	
	//TO-DO: Write tests here - each test has a method
	// ------ IDE -----
	//----------------
	//public String Method() { ... Tesztet tartalmazó algoritmust ... }
	public String Method() {
		String[] cmd = {"exit"};
		proto.NewGame(cmd);
		return "";
	}
	
	
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
		public static String Calculate(File generated, File expected) {
			int succeededRows = 0;
			int numberOfRows = 0;	// the number of rows that the file contains
			
			//TO-DO: Fájl sorainak összehasonlítása ---> az elsõ hibás sorig ellenõrzése
			
			return "The result: " + succeededRows + "/" + numberOfRows;
		}
	}
}
