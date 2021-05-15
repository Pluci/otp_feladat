package Repository.Identification;

import DTOs.Identification;
import Repository.IRepositoryBase;

import java.util.List;

public interface IIdentificationRepository extends IRepositoryBase<Identification> {
    List<Identification> getAll();
    List<Identification> getAllByShopNumber();
}
