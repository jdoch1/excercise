import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Created by Jordan on 12/04/2018.
 */
public class Checkout {

    public double checkout(String[] items) {

        return getCountOfStringsInMap(items)
                .entrySet()
                .stream()
                .mapToDouble(e -> calculateCosts( e.getKey(),  Math.toIntExact(e.getValue()) ))
                .sum();
    }

    private Map<String, Long> getCountOfStringsInMap(String[] items) {

        return Arrays.stream(items)
                .collect(groupingBy(x -> x, counting()));
    }

    private double calculateCosts(String item, int quantity) {

        switch (item) {

            case ProductConstants.APPLE_NAME:
                return MathsUtil.calculateTwoForOne(ProductConstants.APPLE_PRICE, quantity);

            case ProductConstants.ORANGE_NAME:
                return ProductConstants.ORANGE_PRICE * quantity;

            default:
                throw new InvalidParameterException("Invalid item name: " + item);
        }

    }
}
