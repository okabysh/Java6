package earthsoft.goit.Java6.Module_02.Generics;

/**
 * Created by Oleg Kabysh on 03.07.2017.
 */
public class Launch {
    public static void main(String[] args) {
//        String str = "str";
//        Number num = 10;
//        create(str);
//        create(num);
        DAO dao= new DAO();
        DAOCustomer daoCustomer = new DAOCustomer();

        Developer developer = new Developer();
        developer.setName("Vasya");
        developer.setSex("M");

        Customer customer = new Customer();
        customer.setName("FFF corp.");
        customer.setPhone("38044");


        dao.create(developer);
        daoCustomer.create(customer);
    }

//    public static <E> void create() {
//        System.out.println();
//    }
}
