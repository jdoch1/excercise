import java.util.Arrays;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Created by Jordan on 12/04/2018.
 */
public class Checkout {

    public Map<String, Long> checkout(String[] items) {

        //TODO: return the value

        return getCountOfStringsInMap(items);
    }

    private Map<String, Long> getCountOfStringsInMap(String[] items) {

        return Arrays.stream(items)
                .collect(groupingBy(x -> x, counting()));
    }
}
