package earthsoft.goit.Java6.Module_02.Generics;

/**
 * Created by Oleg Kabysh on 03.07.2017.
 */
public class Launch {
    public static void main(String[] args) {
        String str = "str";
        Number num = 10;
        create(str);
        create(num);
    }

    public static <E> void create() {
        System.out.println();
    }
}
