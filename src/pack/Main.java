package pack;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {


        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("file.xml");
            parse.getDocumentElement().normalize();
            System.out.println(parse.getDocumentElement());
            //
            Node node = parse.getDocumentElement().getFirstChild();

            while (node!=null) {
                //System.out.println(node.getTextContent());
                System.out.println(node.getAttributes().getNamedItem("id"));
                Node node2 = node.getFirstChild();
                while (node2!=null) {
                    System.out.println(node2.getTextContent());
                    node2=node2.getNextSibling();
                }

                node=node.getNextSibling();
            }




        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}
