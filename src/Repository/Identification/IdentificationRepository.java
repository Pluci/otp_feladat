package Repository.Identification;

import DTOs.Identification;
import Repository.RepositoryBase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class IdentificationRepository extends RepositoryBase<Identification> implements IIdentificationRepository {
    public IdentificationRepository(List<Identification> repository) {
        super(repository);
    }

    @Override
    public List<Identification> getAll() {
        return this.repository.stream().toList();
    }

    @Override
    public List<Identification> getAllByShopNumber() {
        var mapped = this.repository.stream().collect(Collectors.groupingBy(x -> new ArrayList<String>(Collections.singleton(x.getShopId()))));
        ArrayList<Identification> identifications = new ArrayList<>();
        for (var key : mapped.keySet()){
            identifications.add(new Identification(key.get(0), ""));
        }
        return identifications;
    }

    @Override
    public Identification create(Identification entity) {
        return this.repository.stream().anyMatch(x -> x.equals(entity)) ?
                this.repository.stream().filter(x -> x.equals(entity)).findFirst().get() : super.create(entity);
    }
}
