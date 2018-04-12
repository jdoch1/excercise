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

    public static double calculateThreeForTwo(double price, int quantity){

        if(quantity == 2){
            return price * 2;
        }

        if(quantity % 3 == 0){
            return ((quantity * price) *2) / 3;
        } else {
            return price + (((quantity -1) * price) * 2) / 3;
        }
    }


}
