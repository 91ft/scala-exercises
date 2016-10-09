package std_lib.partial_functions;

/**
 * Created by karellen on 2016. 10. 10..
 */
public class PartialFunction2 {

    class isSmall implements MyIfFunc {
        public boolean check(int num) {
            return num < 10;
        }
        public String get() {
            return "작다";
        }
    }

    class isBigger implements MyIfFunc {
        public boolean check(int num) {
            return num > 10;
        }
        public String get() {
            return "크다";
        }
    }

    interface MyIfFunc {
        boolean check(int num);
        String get();
    }

    public String get(int num) {
        //isSmall.get(num).else(isBigger(num))
        return null;
    }

    public static void main(String[] args) {
        PartialFunction2 func = new PartialFunction2();
        System.out.println(func.get(5));
    }
}
