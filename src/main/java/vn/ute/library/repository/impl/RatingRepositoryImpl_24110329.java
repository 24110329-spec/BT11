package vn.ute.library.repository.impl;

import jakarta.persistence.EntityManager;
import vn.ute.library.model.RatingId_24110329;
import vn.ute.library.model.Rating_24110329;
import vn.ute.library.repository.RatingRepository_24110329;
import vn.ute.library.util.JPAUtil_24110329;

import java.util.List;

public class RatingRepositoryImpl_24110329 implements RatingRepository_24110329 {

    @Override
    public List<Rating_24110329> findByBook(Long bookId) {
        EntityManager em = JPAUtil_24110329.getEntityManager();
        try {
            return em.createQuery(
                    "SELECT r FROM Rating_24110329 r " +
                    "JOIN FETCH r.user " +
                    "WHERE r.book.bookid = :bookId " +
                    "ORDER BY r.id.userid",
                    Rating_24110329.class)
                .setParameter("bookId", bookId)
                .getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public double average(Long bookId) {
        EntityManager em = JPAUtil_24110329.getEntityManager();
        try {
            Double result = em.createQuery(
                    "SELECT AVG(r.rating) FROM Rating_24110329 r " +
                    "WHERE r.book.bookid = :bookId",
                    Double.class)
                .setParameter("bookId", bookId)
                .getSingleResult();

            return result != null ? result : 0.0;
        } finally {
            em.close();
        }
    }

    @Override
    public void save(Rating_24110329 rating) {
        if (rating == null || rating.getUser() == null || rating.getBook() == null) {
            throw new IllegalArgumentException("Rating, User và Book không được null");
        }

        if (rating.getRating() < 1 || rating.getRating() > 10) {
            throw new IllegalArgumentException("Rating phải nằm trong khoảng 1 đến 10");
        }

        EntityManager em = JPAUtil_24110329.getEntityManager();
        try {
            Long userId = rating.getUser().getId();
            Long bookId = rating.getBook().getBookid();

            if (userId == null || bookId == null) {
                throw new IllegalArgumentException("User ID và Book ID không được null");
            }

            RatingId_24110329 id = new RatingId_24110329(userId, bookId);
            rating.setId(id);

            em.getTransaction().begin();
            em.merge(rating);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }
}
