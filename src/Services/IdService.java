package Services;

import DTOs.Identification;
import Repository.Identification.IIdentificationRepository;

public class IdService {
    IIdentificationRepository repository;

    public IdService(IIdentificationRepository repository){
        this.repository = repository;
    }

    public Identification getId(){
        return null;
    }

    public Identification setId(String shopId, String customerId){
        Identification identification = new Identification(shopId, customerId);
        return repository.create(identification);
    }

    public Identification generateId(){
        return null;
    }
}
