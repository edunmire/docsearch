import static org.junit.Assert.*;
import org.junit.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.IOException;

public class TestDocSearch {
	@Test 
	public void testIndex() throws URISyntaxException, IOException {
    Handler h = new Handler("./technical/");
    URI rootPath = new URI("http://localhost/");
    assertEquals("There are 1391 total files to search.", h.handleRequest(rootPath));
	}
	@Test 
	public void testSearch() throws URISyntaxException, IOException {
    Handler h = new Handler("./technical/");
    URI rootPath = new URI("http://localhost/search?q=feline");
    String expect = "Found 4 paths:\n.\\technical\\biomed\\1471-2202-4-3.txt\n.\\technical\\government\\Media\\Domestic_violence_aid.txt\n.\\technical\\government\\Media\\Oregon_Poor.txt\n.\\technical\\government\\Media\\fight_domestic_abuse.txt";
    assertEquals(expect, h.handleRequest(rootPath));
	}
}

