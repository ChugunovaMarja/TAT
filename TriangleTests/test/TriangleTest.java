package triangle;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Maria on 07.11.2016.
 */
public class TriangleTest {
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


    @Test(dataProvider = "invalid sides")
    public void testGetTypeNegative(double a, double b, double c) throws Exception {
        Triangle triangle = new Triangle(a, b, c);
        assertTrue(triangle.getType().equals("Triangle doesnt exist"));
    }

    @Test
    public void testGetTypeEquilateral() throws Exception {
        Triangle triangle = new Triangle(3, 3, 3);
        assertTrue(triangle.getType().equals("Equilateral"));
    }

    @Test
    public void testGetTypeIsosceles() throws Exception {
        Triangle triangle = new Triangle(2, 2, 3);
        assertTrue(triangle.getType().equals("Isosceles"));
    }

    @Test
    public void testGetTypeOrdinary() throws Exception {
        Triangle triangle = new Triangle(7, 3, 6);
        assertTrue(triangle.getType().equals("Ordinary"));
    }

}
