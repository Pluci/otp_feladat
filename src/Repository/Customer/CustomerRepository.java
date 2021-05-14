package Repository.Customer;

import DTOs.Customer;
import DTOs.Identification;
import Repository.RepositoryBase;

import java.util.List;

public class CustomerRepository extends RepositoryBase<Customer> implements ICustomerRepository {
    public CustomerRepository(List<Customer> repository) {
        super(repository);
    }
}
