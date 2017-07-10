package ua.earthsoft.goit.Java6.Module_02.HomeTask.Model;

import java.util.List;

/**
 * Created by Oleg Kabysh on 02.07.2017.
 */
public interface ICustomerDAO {

    public void create(Customer customer);

    public List<Customer> read();

    public void update(Customer customer);

    public void delete(int id);

    public Customer getById(int id);
}
