package Repository.Identification;

import DTOs.Identification;
import Repository.RepositoryBase;

import java.util.List;

public class IdentificationRepository extends RepositoryBase<Identification> implements IIdentificationRepository {
    public IdentificationRepository(List<Identification> repository) {
        super(repository);
    }
}
