package ua.earthsoft.goit.Java6.module_02.generics;

/**
 * Created by kabysh_ol on 04.07.2017.
 */
public class DAOCustomer<T> implements CRUD<T> {
    private T t;
    @Override
    public void create(T t) {
        System.out.println(t.toString());
    }
}
