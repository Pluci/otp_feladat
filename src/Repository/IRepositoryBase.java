package Repository;

public interface IRepositoryBase<T> {
    // Create
    T create(T entity);

    // Read
    T get(Object id);

    // Update
    T update(T entity);

    // Delete
    void delete(T entity);
}
