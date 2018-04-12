import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * Created by Jordan on 12/04/2018.
 */
public class CheckoutTest {

    private Checkout checkout = new Checkout();



    @Test
    void checkout__twoOrangeOneAppleArray__priceIsRight(){

        double expectedPrice = ProductConstants.ORANGE_PRICE * 2 + ProductConstants.APPLE_PRICE;
        String[] strings = {ProductConstants.ORANGE_NAME, ProductConstants.ORANGE_NAME, ProductConstants.APPLE_NAME};
        double result = checkout.checkout(strings);
        assertEquals(expectedPrice, result);
    }

    @Test
    void checkout__threeAppleOneOrangeArray__priceIsRight(){

        double expectedPrice = ProductConstants.ORANGE_PRICE + ProductConstants.APPLE_PRICE * 2;
        String[] strings = {ProductConstants.ORANGE_NAME, ProductConstants.APPLE_NAME, ProductConstants.APPLE_NAME, ProductConstants.APPLE_NAME};
        double result = checkout.checkout(strings);
        assertEquals(expectedPrice, result);
    }

    @Test
    void checkout__fourAppleArray__priceIsRight(){

        double expectedPrice = ProductConstants.APPLE_PRICE *2;
        String[] strings = {ProductConstants.APPLE_NAME, ProductConstants.APPLE_NAME, ProductConstants.APPLE_NAME, ProductConstants.APPLE_NAME};
        double result = checkout.checkout(strings);
        assertEquals(expectedPrice, result);
    }

    @Test
    void checkout__oneOrangeArray__priceIsRight(){

        double expectedPrice = ProductConstants.ORANGE_PRICE;
        String[] strings = {ProductConstants.ORANGE_NAME};
        double result = checkout.checkout(strings);
        assertEquals(expectedPrice, result);
    }

    @Test
    void checkout__twoOrangeArray__priceIsRight(){

        double expectedPrice = ProductConstants.ORANGE_PRICE * 2;
        String[] strings = {ProductConstants.ORANGE_NAME, ProductConstants.ORANGE_NAME};
        double result = checkout.checkout(strings);
        assertEquals(expectedPrice, result);
    }

    @Test
    void checkout__threeOrangeArray__priceIsRight(){

        double expectedPrice = ProductConstants.ORANGE_PRICE * 2;
        String[] strings = {ProductConstants.ORANGE_NAME, ProductConstants.ORANGE_NAME, ProductConstants.ORANGE_NAME};
        double result = checkout.checkout(strings);
        assertEquals(expectedPrice, result);
    }

    @Test
    void checkout__fourOrangeArray__priceIsRight(){

        double expectedPrice = ProductConstants.ORANGE_PRICE * 3;
        String[] strings = {ProductConstants.ORANGE_NAME, ProductConstants.ORANGE_NAME, ProductConstants.ORANGE_NAME, ProductConstants.ORANGE_NAME};
        double result = checkout.checkout(strings);
        assertEquals(expectedPrice, result);
    }

    @Test
    void checkout__unknownItemInArray__errorThrown(){
        final String unknownItem = "UNKNOWN";
        String[] strings = {ProductConstants.ORANGE_NAME, unknownItem};
        assertThrows(InvalidParameterException.class, () -> checkout.checkout(strings));
    }


}