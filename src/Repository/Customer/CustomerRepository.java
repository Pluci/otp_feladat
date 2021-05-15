package Repository.Customer;

import DTOs.Customer;
import DTOs.Identification;
import Repository.RepositoryBase;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerRepository extends RepositoryBase<Customer> implements ICustomerRepository {
    public CustomerRepository(List<Customer> repository) {
        super(repository);
    }

    @Override
    public List<Customer> getByIdentification(Identification identification) {
        return this.repository.stream().filter(x -> x.getIdentification().equals(identification)).collect(Collectors.toList());
    }
}
