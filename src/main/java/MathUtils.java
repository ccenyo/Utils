import java.math.BigDecimal;
import java.util.Objects;

public class MathUtils {

    public static BigDecimal denullify(BigDecimal value) {
        return Objects.requireNonNullElse(value, BigDecimal.ZERO);
    }

    public static double asDoubleValue(BigDecimal bigValue) {
        if (bigValue == null) {
            return 0.0;
        } else {
            return bigValue.doubleValue();
        }
    }

    public static double asDoubleValue(Integer intValue) {
        if (intValue == null) {
            return 0.0;
        } else {
            return intValue.doubleValue();
        }
    }

    public static double denullify(Double doubleValue) {
        return Objects.requireNonNullElse(doubleValue, 0.0);
    }

    public static int denullify(Integer integerValue) {
        return Objects.requireNonNullElse(integerValue, 0);
    }


    public static BigDecimal asBigDecimal(String value) {
        if (value == null ) {
            return  BigDecimal.ZERO;
        } else {
            return new BigDecimal(value.replace(" ",""));
        }
    }

    public static BigDecimal add(BigDecimal... values) {
        BigDecimal result = BigDecimal.ZERO;
        for (BigDecimal value : values) {
            if (value != null) {
                result = result.add(value);
            }
        }
        return result;
    }

    public static BigDecimal multiply(BigDecimal... values) {
        if (values.length == 0) {
            return BigDecimal.ZERO;
        }

        BigDecimal result = BigDecimal.ONE;
        for (BigDecimal v : values) {
            result = result.multiply(denullify(v));
        }
        return result;
    }

    public static BigDecimal subtract(BigDecimal number1, BigDecimal number2) {
        return denullify(number1).subtract(denullify(number2));
    }

}
