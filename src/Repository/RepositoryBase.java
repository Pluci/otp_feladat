package Repository;
import java.io.ObjectStreamException;
import java.util.List;

public abstract class RepositoryBase<T> implements IRepositoryBase<T> {
    protected List<T> repository;

    protected RepositoryBase(List<T> repository){
        this.repository = repository;
    }

    @Override
    public T create(T entity) {
        this.repository.add(entity);
        return this.repository.get(repository.indexOf(entity));
    }

    @Override
    public T get(Object id) {
        return this.repository.get((int)id);
    }

    @Override
    public T update(T entity) {
        T entityInDb = repository.get(repository.indexOf(entity));
        entityInDb = entity;
        return entityInDb;
    }

    @Override
    public void delete(T item) {
        this.repository.remove(item);
    }
}
