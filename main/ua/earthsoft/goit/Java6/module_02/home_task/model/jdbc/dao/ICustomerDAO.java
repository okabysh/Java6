package ua.earthsoft.goit.Java6.module_02.home_task.model.jdbc.dao;

import ua.earthsoft.goit.Java6.module_02.home_task.model.Customer;
import ua.earthsoft.goit.Java6.module_02.home_task.model.Developer;
import ua.earthsoft.goit.Java6.module_02.home_task.model.Project;

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

    public List<Project> getProjects(int projectId);

    public List<Developer> getDevelopers(int customerId);

    public void addProject(int projectId, int customerId);

    public void deleteProject(int projectId, int customerId);

}
