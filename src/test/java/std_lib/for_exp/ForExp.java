package std_lib.for_exp;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by karellen on 2016. 10. 12..
 */
public class ForExp {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        List<Integer> doubled = new LinkedList<Integer>();
        for (Integer num : list) {
            doubled.add(num * num);
        }
    }
}
