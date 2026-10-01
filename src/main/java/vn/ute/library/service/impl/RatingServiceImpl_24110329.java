package vn.ute.library.service.impl;

import vn.ute.library.model.Rating_24110329;
import vn.ute.library.repository.RatingRepository_24110329;
import vn.ute.library.repository.impl.RatingRepositoryImpl_24110329;
import vn.ute.library.service.RatingService_24110329;

import java.util.List;

public class RatingServiceImpl_24110329 implements RatingService_24110329 {

    private final RatingRepository_24110329 repository =
            new RatingRepositoryImpl_24110329();

    @Override
    public List<Rating_24110329> findByBook(Long bookId) {
        return repository.findByBook(bookId);
    }

    @Override
    public double average(Long bookId) {
        return repository.average(bookId);
    }

    @Override
    public void save(Rating_24110329 rating) {
        repository.save(rating);
    }
}
