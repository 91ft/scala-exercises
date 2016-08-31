package std_lib.tuples;

/**
 * Created by karellen on 2016. 8. 29..
 */
class JPerson {
    public Integer id;
    public String name;

    public JPerson(Integer id, String name){
        this.id = id;
        this.name = name;
    }
}

public class CaseClass {

    public static void main(String[] arg) {
        JPerson person = new JPerson(1, "박보검");
        Integer id = person.id;
    }
}
