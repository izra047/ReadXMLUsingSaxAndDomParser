
package readxmlusingsax.domparser;
/*import para el Sax-Parser*/
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

public class SaxAndDomParse {

    
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
       /*Dom-Parser*/ 
        DomParser dp = new DomParser("PaisesSudamerica.xml");
        try {
                    System.out.println("DOM - PARSER \n");
                    dp.parse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        /*Sax-Parser*/
        
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        File file = new File("PaisesSudamerica.xml");
        PaisesSudamericanosHandler handler = new PaisesSudamericanosHandler();   
        saxParser.parse(file, handler);
        
        ArrayList <Filas> filas = handler.getFilas();
        int total = 0;
        System.out.println("\n SAX - PARSER \n");
        for(Filas f : filas){
            System.out.println(f);
            
        }
    }
}
