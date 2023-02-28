package cn.subat.impl.movie.repository;

import cn.subat.impl.movie.entity.MovieEntity;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface EpisodeRepository extends CrudRepository<MovieEntity, Long> {

}
