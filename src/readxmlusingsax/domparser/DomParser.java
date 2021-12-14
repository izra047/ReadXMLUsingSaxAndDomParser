
package readxmlusingsax.domparser;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomParser {
   
    private String fileName;
	
    public DomParser(String fileName) {
		this.fileName = fileName;
    }
    
    public void parse() throws Exception {
   float TOTAL; 
	File inputDataFile = new File(fileName);
	DocumentBuilderFactory dbldrFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder docBuilder = dbldrFactory.newDocumentBuilder();
	Document docmt = docBuilder.parse(inputDataFile);
	docmt.getDocumentElement().normalize();
	System.out.println("Name of the Root element:" + docmt.getDocumentElement().getNodeName());

	NodeList ndList = docmt.getElementsByTagName("fila");
 
	   for (int tempval = 0; tempval < (ndList.getLength()); tempval++) {
		   TOTAL=0; 
	       Node nd = ndList.item(tempval);
	       System.out.println("\n Name of the current element :" + nd.getNodeName());
	       if (nd.getNodeType() == Node.ELEMENT_NODE) {
	           Element elemnt = (Element) nd;
	           System.out.println("Fila  ID : " + elemnt.getAttribute("id"));
	           
	           System.out.println("Country: " + elemnt
	                  .getElementsByTagName("country").item(0).getTextContent());
	      
	           System.out.println("Female: " + elemnt
	                  .getElementsByTagName("female").item(0).getTextContent());
	           System.out.println("Male: " + elemnt
	                  .getElementsByTagName("male").item(0).getTextContent());
	           TOTAL = Float.parseFloat(elemnt.getElementsByTagName("female").item(0).getTextContent())+Float.parseFloat(elemnt.getElementsByTagName("male").item(0).getTextContent());
	           System.out.println("TOTAL:"+ TOTAL  );
	        }
       }
   }
}  
