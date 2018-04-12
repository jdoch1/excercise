import java.math.BigDecimal;
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

        double cost = getCountOfStringsInMap(items)
                .entrySet()
                .stream()
                .mapToDouble(e -> calculateCosts(e.getKey(), Math.toIntExact(e.getValue())))
                .sum();

        BigDecimal poundsPennies = new BigDecimal(Double.toString(cost));
        poundsPennies = poundsPennies.setScale(2, BigDecimal.ROUND_CEILING);
        System.out.println("Total price: £" + poundsPennies);

        return cost;
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
                return MathsUtil.calculateThreeForTwo(ProductConstants.ORANGE_PRICE, quantity);

            default:
                throw new InvalidParameterException("Invalid item name: " + item);
        }

    }
}
