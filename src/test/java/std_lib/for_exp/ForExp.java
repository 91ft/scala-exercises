package std_lib.for_exp;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by karellen on 2016. 10. 12..
 */
public class ForExp {

    public static List<Integer> doubled() {
        List<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        List<Integer> doubled = new LinkedList<Integer>();
        for (Integer num : list) {
            doubled.add(num * num);
        }

        return doubled;
    }

    public static List<Integer> doubled2() {
        List<Integer> one = new LinkedList<Integer>();
        one.add(1);
        one.add(2);
        one.add(3);

        List<Integer> two = new LinkedList<Integer>();
        two.add(2);
        two.add(3);

        // 2,4,6,3,6,9
        List<Integer> result = new LinkedList<Integer>();
        for (Integer m : one) {
            for (Integer n : two) {
                result.add(m * n);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(doubled2());
    }
}
