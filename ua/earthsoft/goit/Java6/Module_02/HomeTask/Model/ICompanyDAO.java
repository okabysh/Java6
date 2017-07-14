package ua.earthsoft.goit.Java6.Module_02.HomeTask.Model;

import java.util.List;

/**
 * Created by Oleg Kabysh on 29.06.2017.
 */
public interface ICompanyDAO {

    public void create(Company company);

    public List<Company> read();

    public void update(Company company);

    public void delete(int id);

    public Company getById(int id);

    public List<Customer> getCustomers(int companyId);

    public void addCustomer(int customerId, int companyId);

    public void deleteCustomer(int customerId, int companyId);
}
