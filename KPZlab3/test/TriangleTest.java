import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {
    Triangle triangle = new Triangle(20,20,70,70,20,70);
    @Test
    public void measureParties() throws Exception {
        assertEquals("Result:","Довжини сторін: \n" +
                "70.71067811865476\n" +
                "50.0\n" +
                "50.0\n"
                ,triangle.measureParties());
    }

    @Test
    public void measurePerimetry() throws Exception {
        assertEquals("Result:","Периметр:170.71067811865476\n",triangle.measurePerimetry());
    }

    @Test
    public void measureArea() throws Exception {
        assertEquals("Result:","Площа:1250.0\n",triangle.measureArea());
    }

}