
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class LeerFormato1 {
    public static void main(String[] args) throws Exception {
        try {
            //creamos un documento y le decimos de donde vamos a sacar la informacion(en este caso sera del xml)
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.parse(new File("Formato1.xml"));//aqui le pasamos el nombre del archivo

            //le digo que solo se fije en las etiquetas "llamada"
            NodeList registro = documento.getElementsByTagName("llamada");

            // Recorro las etiquetas
            for (int i = 0; i < registro.getLength(); i++) {
                // agarro la etiqueta actual en la que esta parada nuestro iterador i
                Node nodo = registro.item(i);
                // Compruebo si el nodo/etiqueta es un elemento
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element) nodo;
                    // Obtengo las etiquetas hijas que tiene la etiqueta "llamada"
                    NodeList hijos = e.getChildNodes();
                    //ahora con ayuda de otro for voy a recorrer esas etiquetas hijas
                    for (int j = 0; j < hijos.getLength(); j++) {
                        // Obtengo al hijo actual
                        Node hijo = hijos.item(j);
                        if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                            // Muestros la informacion de las etiquetas, en este caso va imprimir el nombre de la etiqueta y la informacion de la etiqueta
                            System.out.println(hijo.getNodeName() + ": " + hijo.getTextContent());
                        }
                    }
                    //hago un salto de linea para que la informacion de cada etiqueta "llamada quede separa y le de un aspecto visual mas estetico"
                    System.out.println("");
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

