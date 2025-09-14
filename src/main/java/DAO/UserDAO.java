package DAO;


import java.util.Optional;

public interface UserDAO<T> {

    Optional<T> read(int id);

    T create(T user);

    T update(T user);

    void delete(T user);
}
