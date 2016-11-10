package triangle;

import com.sun.org.apache.bcel.internal.classfile.Node;
import com.sun.org.apache.xerces.internal.impl.dv.DatatypeValidator;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
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
public class ValidatorTest {
    
    private static final String NEGATIVE_DATA = "negativeData";
    private static final String POSITIVE_DATA = "positiveData";
    private static final String INVALID_SIDES = "invalidSides";
    private static final String VALID_SIDES = "validSides";
    private static final String DATA = "side";
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

    @DataProvider(name = "negative data")
    public Object[][] getData() throws Exception {

        Document document = getDocument();

        NodeList nodes = document.getElementsByTagName(NEGATIVE_DATA);
        Object [][] result = new Double[nodes.getLength()][];

        for(int i = 0; i < nodes.getLength(); i++) {
            NamedNodeMap attrs = nodes.item(i).getAttributes();
            result[i] = new Double[] {
                    getValue(attrs.getNamedItem(DATA).getNodeValue())
            };
        }
        return result;
    }

    @DataProvider(name = "invalid sides")
    public Object[][] getData3() throws Exception {

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

    @DataProvider(name = "valid sides")
    public Object[][] getData4() throws Exception {

        Document document = getDocument();

        NodeList nodes = document.getElementsByTagName(VALID_SIDES);
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

    @DataProvider(name = "valid data")
    public Object[][] getData2() throws Exception {

        Document document = getDocument();

        NodeList nodes = document.getElementsByTagName(POSITIVE_DATA);
        Object [][] result = new Double[nodes.getLength()][];

        for(int i = 0; i < nodes.getLength(); i++) {
            NamedNodeMap attrs = nodes.item(i).getAttributes();
            result[i] = new Double[] {
                    getValue(attrs.getNamedItem(DATA).getNodeValue())
            };
        }
        return result;
    }

    @Test (dataProvider = "negative data")
    public void testDataValidatorNegative(double data) throws Exception {
        assertFalse(Validator.dataValidator(data));
    }

    @Test (dataProvider = "valid data")
    public void testDataValidatorPositive(double data) throws Exception {
        assertTrue(Validator.dataValidator(data));
    }

    @Test (dataProvider = "invalid sides")
    public void testTriangleValidatorNegative(double a, double b, double c) throws Exception {
        assertFalse(Validator.triangleValidator(a, b, c));
    }

    @Test (dataProvider = "valid sides")
    public void testTriangleValidatorPositive(double a, double b, double c) throws Exception {
        assertTrue(Validator.triangleValidator(a, b, c));
    }
}
