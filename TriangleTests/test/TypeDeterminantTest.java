package triangle;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

import static org.testng.Assert.*;


/**
 * Created by Maria on 07.11.2016.
 */
public class TypeDeterminantTest {

    private static final String INVALID_SIDES = "invalidSides";
    private static final String SIDE_A = "side_a";
    private static final String SIDE_B = "side_b";
    private static final String SIDE_C = "side_c";

    public Document getDocument() throws ParserConfigurationException, IOException, SAXException {
        File inputFile = new File("./data.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(inputFile);

        return document;
    }

    public double getValue(String stringValue) {

        if(stringValue.equals("Double.MinValue")) {
            return Double.MIN_VALUE;
        }
        if(stringValue.equals("Double.MaxValue")) {
            return Double.MAX_VALUE;
        }
        return Double.parseDouble(stringValue);
    }

    @DataProvider(name = "invalid sides")
    public Object[][] getData() throws Exception {

        Document document = getDocument();

        NodeList nodes = document.getElementsByTagName(INVALID_SIDES);
        Object [][] result = new Double[nodes.getLength()][];

        for(int i = 0; i < nodes.getLength(); i++) {
            NamedNodeMap attrs = nodes.item(i).getAttributes();
            result[i] = new Double[] {
                    getValue(attrs.getNamedItem(SIDE_A).getNodeValue()),
                    getValue(attrs.getNamedItem(SIDE_B).getNodeValue()),
                    getValue(attrs.getNamedItem(SIDE_C).getNodeValue())
            };
        }
        return result;
    }

    @Test (dataProvider = "invalid sides")
    public void testDeterminateTypeNegative(double a, double b, double c) throws Exception {
        assertTrue(TypeDeterminant.determinateType(a, b, c).equals("Triangle doesnt exist"));
    }
    @Test
    public void testDeterminateTypeEquilateral() throws Exception {
        assertTrue(TypeDeterminant.determinateType(3, 3, 3).equals("Equilateral"));
    }

    @Test
    public void testDeterminateTypeIsosceles() throws Exception {
        assertTrue(TypeDeterminant.determinateType(2, 2, 3).equals("Isosceles"));
    }

    @Test
    public void testDeterminateTypeOrdinary() throws Exception {
        assertTrue(TypeDeterminant.determinateType(7, 3, 6).equals("Ordinary"));
    }
}
