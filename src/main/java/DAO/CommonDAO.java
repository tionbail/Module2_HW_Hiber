package DAO;


public interface CommonDAO<T> {

    T read(int id);

    T create(T user);

    T update(T user);

    void delete(T user);
}
