package Repository.Payment;

import DTOs.Identification;
import DTOs.Payment;
import Repository.RepositoryBase;

import java.util.List;
import java.util.stream.Collectors;

public class PaymentRepository extends RepositoryBase<Payment> implements IPaymentRepository {
    public PaymentRepository(List<Payment> repository) {
        super(repository);
    }

    @Override
    public List<Payment> getByIdentification(Identification identification) {
        return this.repository.stream().filter(x -> x.getIdentification().equals(identification)).collect(Collectors.toList());
    }

    @Override
    public List<Payment> getByIdentificationShopNumber(Identification identification) {
        return this.repository.stream().filter(x -> x.getIdentification().getShopId().equals(identification.getShopId())).collect(Collectors.toList());
    }
}
