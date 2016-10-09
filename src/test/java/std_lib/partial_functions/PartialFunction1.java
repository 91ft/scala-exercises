package std_lib.partial_functions;

/**
 * Created by karellen on 2016. 10. 10..
 */
public class PartialFunction1 {

    public String get(int num) {
        if (num < 10) {
            // 많은 로직
            return "적다";
        } else {
            // 많은 로직
            return "크다";
        }
    }

    public static void main(String[] args) {
        PartialFunction1 func = new PartialFunction1();
        System.out.println(func.get(5));
    }
}
