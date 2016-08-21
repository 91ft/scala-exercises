package std_lib.tuples;

/**
 * Created by karellen on 2016. 8. 22..
 */
public class Case {

    interface Link {}
    class Facebook implements Link {
        public String getID() { return "아이디"; }
    }
    class Kakao implements Link {
        public String getName() { return "본명"; }
    }
    class KakaoStrory implements Link {
        public String getNickName() { return "닉네임"; }
    }

    public static String getName(Link link) {
        if (link instanceof Facebook) {
            return ((Facebook)link).getID();
        } else if (link instanceof Kakao) {
            return ((Kakao)link).getName();
        } else if (link instanceof KakaoStrory) {
            return ((KakaoStrory)link).getNickName();
        } else {
            return null;
        }
    }

}
