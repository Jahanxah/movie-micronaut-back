package cn.subat.impl.movie.repository;

import cn.subat.impl.movie.entity.MovieEntity;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.criteria.Specification;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Repository
public interface MovieRepository extends CrudRepository<MovieEntity, Long> {

    @Transactional
    Page<MovieEntity> findAll(Specification<MovieEntity> specification, Pageable pageable);


}
