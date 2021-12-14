
package readxmlusingsax.domparser;

import readxmlusingsax.domparser.Filas;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class PaisesSudamericanosHandler  extends DefaultHandler{
    private ArrayList <Filas> filas = new ArrayList();
    private Filas fila;
    private StringBuffer buffer = new StringBuffer();

    public ArrayList<Filas> getFilas() {
        return filas;
    }
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        buffer.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        switch(qName){
            case "country":
                fila.setCountry(buffer.toString());
                break;
            case "female":
                fila.setFemale(Integer.parseInt(buffer.toString()));
                break;
            case "male":
                fila.setMale(Integer.parseInt(buffer.toString()));
                break;
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        switch(qName){
            case "fila":
                fila = new Filas(); 
                filas.add(fila);
                fila.setId(Double.parseDouble(attributes.getValue("id")));
                break;
            case "country":
                buffer.delete(0, buffer.length());
            case "female":
                buffer.delete(0, buffer.length());
                break;
            case "male":
                buffer.delete(0, buffer.length());
                   break;
        }
    }
    
}
