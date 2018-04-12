import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * Created by Jordan on 12/04/2018.
 */
public class CheckoutTest {

    Checkout checkout = new Checkout();



    @Test
    public void checkout__twoOrangeOneAppleArray__priceIsRight(){

        double expectedPrice = ProductConstants.ORANGE_PRICE * 2 + ProductConstants.APPLE_PRICE;
        String[] strings = {ProductConstants.ORANGE_NAME, ProductConstants.ORANGE_NAME, ProductConstants.APPLE_NAME};
        double result = checkout.checkout(strings);
        assertEquals(expectedPrice, result);
    }

    @Test
    public void checkout__threeAppleOneOrangeArray__priceIsRight(){

        double expectedPrice = ProductConstants.ORANGE_PRICE + ProductConstants.APPLE_PRICE * 2;
        String[] strings = {ProductConstants.ORANGE_NAME, ProductConstants.APPLE_NAME, ProductConstants.APPLE_NAME, ProductConstants.APPLE_NAME};
        double result = checkout.checkout(strings);
        assertEquals(expectedPrice, result);
    }

    @Test
    public void checkout__fourAppleArray__priceIsRight(){

        double expectedPrice = ProductConstants.APPLE_PRICE *2;
        String[] strings = {ProductConstants.APPLE_NAME, ProductConstants.APPLE_NAME, ProductConstants.APPLE_NAME, ProductConstants.APPLE_NAME};
        double result = checkout.checkout(strings);
        assertEquals(expectedPrice, result);
    }

    @Test
    public void checkout__unknownItemInArray__errorThrown(){
        final String unknownItem = "UNKNOWN";
        String[] strings = {ProductConstants.ORANGE_NAME, unknownItem};
        assertThrows(InvalidParameterException.class, () -> checkout.checkout(strings));
    }


}