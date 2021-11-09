import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class MathUtilsTest {

    @Test
    public void testAllDenullify() {
        BigDecimal decimal = new BigDecimal(10);
        BigDecimal decimalDenullified = MathUtils.denullify(decimal);

        Assert.assertEquals(decimalDenullified, decimal);

        BigDecimal decimal2 = null;
        BigDecimal decimalDenullified2 = MathUtils.denullify(decimal2);

        Assert.assertEquals(decimalDenullified2, BigDecimal.ZERO);

        Double nullDouble = null;
        Assert.assertEquals(0.0, MathUtils.denullify(nullDouble));

        Integer nullInt = null;
        Assert.assertEquals(0, MathUtils.denullify(nullInt));
    }

    @Test
    public void testAsDouble() {
        Assert.assertEquals(1.0, MathUtils.asDoubleValue(1));
        Assert.assertEquals(1.0, MathUtils.asDoubleValue(new BigDecimal(1)));
    }

    @Test
    public void testAsBigDecimal() {
        Assert.assertEquals(new BigDecimal(1), MathUtils.asBigDecimal("1"));
    }

    @Test
    public void testOperationBigDecimal() {
        BigDecimal bigDecimal1 = new BigDecimal(5);
        BigDecimal bigDecimal2 = new BigDecimal(5);
        BigDecimal bigDecimal3 = new BigDecimal(5);
        Assert.assertEquals(BigDecimal.valueOf(125), MathUtils.multiply(bigDecimal1, bigDecimal2, bigDecimal3));
        Assert.assertEquals(BigDecimal.valueOf(15), MathUtils.add(bigDecimal1, bigDecimal2, bigDecimal3));
        Assert.assertEquals(BigDecimal.valueOf(0), MathUtils.subtract(bigDecimal1, bigDecimal2));
    }
}
