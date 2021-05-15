package Repository.Customer;

import DTOs.Customer;
import DTOs.Identification;
import Repository.IRepositoryBase;

import java.util.List;

public interface ICustomerRepository extends IRepositoryBase<Customer> {
    List<Customer> getByIdentification(Identification identification);
}
