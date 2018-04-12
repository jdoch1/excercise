/**
 * Created by Jordan on 12/04/2018.
 */
public class MathsUtil {

    public static double calculateTwoForOne(double price, int quantity){

        if(quantity % 2 == 0){
            return (quantity * price) / 2;
        } else {
            return price + ((quantity - 1) * price) /2;
        }
    }


}
