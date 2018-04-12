import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Created by Jordan on 12/04/2018.
 */
public class CheckoutTest {

    Checkout checkout = new Checkout();

    @Test
    public void checkout__twoOrangeOneAppleArray__MapContainsTwoOrangeOneApple(){

        String[] strings = {ProductConstants.ORANGE_NAME, ProductConstants.ORANGE_NAME, ProductConstants.APPLE_NAME};
        Map<String, Long> result = checkout.checkout(strings);

        int orangeCount = Math.toIntExact(result.get(ProductConstants.ORANGE_NAME));
        int appleCount = Math.toIntExact(result.get(ProductConstants.APPLE_NAME));

        assertEquals(orangeCount, 2);
        assertEquals(appleCount, 1);

    }

}