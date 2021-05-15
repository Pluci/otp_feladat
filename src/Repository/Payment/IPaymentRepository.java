package Repository.Payment;

import DTOs.Identification;
import DTOs.Payment;
import Repository.IRepositoryBase;

import java.util.List;

public interface IPaymentRepository extends IRepositoryBase<Payment> {
    List<Payment> getByIdentification(Identification identification);
    List<Payment> getByIdentificationShopNumber(Identification identification);
}
