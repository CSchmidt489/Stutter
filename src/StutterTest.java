import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

public class StutterTest {
	Stutter s = new Stutter();
	@Test
	public void testIsDelimitNull(){
		boolean result = Stutter.isDelimit((char)0);
		assertFalse(result);
		
	}
	
	@Test
	public void testIsDelimitChar(){
		
		boolean result = Stutter.isDelimit('-');
		assertTrue(result);
		
	}
	
	@Test
	public void testMainNoInfile() throws IOException{
		String in = "infile.txt";
		InputStream buf = new ByteArrayInputStream(in.getBytes());
		System.setIn(buf);
		Stutter.main(new String[] {});
		//assertTrue(true);
		
	}
	
	@Test
	public void testMainNullInput() throws IOException{
		String in = "repeat repeat - - repeat";
		InputStream buf = new ByteArrayInputStream(in.getBytes());
		System.setIn(buf);
		Stutter.main(new String[] {null});
		//assertTrue(true);
	}
	
	@Test
	public void testMainFileInput() throws IOException{
		//String in = "infile.txt";
		//InputStream buf = new ByteArrayInputStream(in.getBytes());
		//System.setIn(buf);
		String currentdir = System.getProperty("user.dir");
		Stutter.main(new String[] {currentdir + "/src/infile.txt"});
		assertTrue(true);
	}


}
