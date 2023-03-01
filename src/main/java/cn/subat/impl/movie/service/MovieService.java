package cn.subat.impl.movie.service;

import cn.subat.impl.common.dto.ImplPage;
import cn.subat.impl.common.dto.ImplQuery;
import cn.subat.impl.movie.dto.MovieCommonDto;
import cn.subat.impl.movie.dto.MovieCreateDto;
import cn.subat.impl.movie.dto.MovieUpdateDto;
import cn.subat.impl.movie.entity.MovieEntity;
import cn.subat.impl.movie.mapper.MovieMapper;
import cn.subat.impl.movie.repository.EpisodeRepository;
import cn.subat.impl.movie.repository.MovieRepository;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.model.Page;
import io.micronaut.http.annotation.Body;
import io.micronaut.rabbitmq.annotation.Queue;
import io.micronaut.rabbitmq.annotation.RabbitListener;
import lombok.AllArgsConstructor;
import cn.subat.impl.common.dto.ImplResponse;
import cn.subat.impl.spdoc.annotation.SPDocConsumer;

import java.util.Optional;

@AllArgsConstructor
@RabbitListener
@Introspected
public class MovieService {

    MovieMapper movieMapper;
    MovieRepository movieRepository;
    EpisodeRepository episodeRepository;

    @SPDocConsumer(tag = "电影-后台", value = "创建电影")
    @Queue("movie.admin.create")
    public ImplResponse<Boolean> createMovie(@Body MovieCreateDto movieCreateDto) {
        movieRepository.save(movieMapper.createDtoToEntity(movieCreateDto, new MovieEntity()));
        return ImplResponse.of(true);
    }

    @SPDocConsumer(tag = "电影-后台", value = "删除电影")
    @Queue("movie.admin.delete")
    public ImplResponse<Boolean> deleteMovie(Long movieId) {
        Optional<MovieEntity> movieOpt = movieRepository.findById(movieId);
        if (movieOpt.isEmpty()) {
            return ImplResponse.of(-1, "电影不存在");
        } else {
            movieRepository.deleteById(movieId);
            return ImplResponse.of(true);
        }
    }

    @SPDocConsumer(tag = "电影-后台", value = "修改电影")
    @Queue("movie.admin.update")
    public ImplResponse<Boolean> updateMovie(@Body MovieUpdateDto movieUpdateDto) {
        Optional<MovieEntity> movieOpt = movieRepository.findById(movieUpdateDto.getId());
        if (movieOpt.isEmpty()) {
            return ImplResponse.of(-1, "电影不存在");
        } else {
            movieRepository.update(movieMapper.updateFromDto(movieUpdateDto, movieOpt.get()));
            return ImplResponse.of(true);
        }
    }

    @SPDocConsumer(tag = "电影-后台", value = "电影列表")
    @Queue("movie.admin.list")
    public ImplResponse<ImplPage<MovieCommonDto>> MovieList(@Body ImplQuery query) {
        Page<MovieEntity> moviePage = movieRepository.findAll(query.getQuerySpecification(), query.getPageable());
        return ImplResponse.of(moviePage.map(movieMapper::entityToCommonDto));
    }

    @SPDocConsumer(tag = "电影-后台", value = "电影单个查询")
    @Queue("movie.admin.one")
    public ImplResponse<MovieCommonDto> one(Long id) {
        Optional<MovieEntity> movieOpt = movieRepository.findById(id);
        if (movieOpt.isEmpty()) {
            return ImplResponse.of(-1, "电影不存在");
        } else {
            return ImplResponse.of(movieMapper.entityToCommonDto(movieOpt.get()));
        }
    }

    @SPDocConsumer(tag = "电影-后台", value = "电影发布")
    @Queue("movie.admin.ispublish")
    public ImplResponse<Integer> isPublish(Long id) {
        Optional<MovieEntity> movieOpt = movieRepository.findById(id);
        if (movieOpt.isEmpty()) {
            return ImplResponse.of(-1, "电影不存在");
        } else {
            MovieEntity movieEntity = movieOpt.get();
            if (movieOpt.get().getIsPublished() == 1) {
                movieEntity.setIsPublished(0);
                movieRepository.update(movieEntity);
                return ImplResponse.of(1, "电影已下架");
            } else {
                movieEntity.setIsPublished(1);
                movieRepository.update(movieEntity);
                return ImplResponse.of(1, "电影已发布");
            }
        }
    }
}
