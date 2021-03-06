package gr.codehub.advecommerce.repository.impl;

import gr.codehub.advecommerce.repository.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public abstract class RepositoryImpl<T, K> implements Repository<T, K> {

    private final EntityManager entityManager;

    public RepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<T> findById(K id) {
        T t = entityManager.find(getEntityClass(), id);
        return t != null ? Optional.of(t) : Optional.empty();
    }

    /**
     * The same method is used for insert and update
     *
     * @param t entity to be saved
     * @return the saved entity
     */
    @Override
    public Optional<T> save(T t) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(t);
            entityManager.getTransaction().commit();
            return Optional.of(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<T> findAll() {
        return entityManager.createQuery("from " + getEntityClassName()).getResultList();
    }



    public abstract Class<T> getEntityClass();

    public abstract String getEntityClassName();

    /**
     * Deleting a persistent instance
     *
     * @param id
     * @return success
     */
    @Override
    public boolean deleteById(K id) {
        T persistentInstance = entityManager.find(getEntityClass(), id);
        if (persistentInstance != null) {

            try {
                entityManager.getTransaction().begin();
                entityManager.remove(persistentInstance);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                //e.printStackTrace();
                return false;
            }
            return true;
        }
        return false;
    }

}
