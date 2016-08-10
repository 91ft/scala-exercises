package std_lib.tuples;

/**
 * Created by karellen on 2016. 8. 3..
 */

class MyTuple2<T1, T2> {
    public T1 _1;
    public T2 _2;

    public MyTuple2(T1 a, T2 b) {
        this._1 = a;
        this._2 = b;
    }
}

class MyTuple3<T1, T2, T3> {
    public T1 _1;
    public T2 _2;
    public T3 _3;

    public MyTuple3(T1 a, T2 b, T3 c) {
        this._1 = a;
        this._2 = b;
        this._3 = c;
    }
}

public class Tuples {
    public static void main(String[] args) {
       MyTuple2 t2 = new MyTuple2("b", 1);
       System.out.println(t2._1);
       System.out.println(t2._2);

        MyTuple3 t3 = new MyTuple3("b", 1, true);
        System.out.println(t3._1);
        System.out.println(t3._2);
        System.out.println(t3._3);
    }
}
