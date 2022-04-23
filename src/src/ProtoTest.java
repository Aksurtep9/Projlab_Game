package src;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * <b>Test class for the program's prototype</b><br><br>
 * Use this class to run the tests.<br>
 * Automatically calls the method which gives information about the tests' results.
 * @author Martin
 */
public class ProtoTest {
	
	public static void main(String[] args) {
		ProtoTest test = new ProtoTest();
		test.Initialize();
		test.Run();
	}
	
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
		proto = new Prototype();
		
		wd = new File(System.getProperty("user.dir"), "src/src");
		commandsFile = new File(wd, "commands.txt");
		expectedOutFile = new File(wd, "expected.txt");
		
		String[] setLog = {"log", "on", "generated.txt"};
		proto.Log(setLog);
		generatedOutFile = proto.GetLogFile();
	}
	
	
	/**
	 * Runs the tests and gives the results back.
	 */
	public void Run() {
		//TO-DO: Run tests here
		TestNewGame();
		
		String result = ProtoTest.TestCalculator.Calculate(generatedOutFile, expectedOutFile);
		System.out.println(result);
	}
	
	
	//TO-DO: Write tests here - each test has a method
	// ------ IDE -----
	//----------------
	//public void Method() { ... Tesztet tartalmazó algoritmust ... }
	public void TestNewGame() {
		String[] cmd = {"newgame", "mapFile.txt"};
		proto.NewGame(cmd);
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
