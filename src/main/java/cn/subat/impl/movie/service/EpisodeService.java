package cn.subat.impl.movie.service;

import cn.subat.impl.common.dto.ImplPage;
import cn.subat.impl.common.dto.ImplQuery;
import cn.subat.impl.common.dto.ImplResponse;
import cn.subat.impl.movie.dto.EpisodeCommonDto;
import cn.subat.impl.movie.dto.EpisodeCreateDto;
import cn.subat.impl.movie.dto.EpisodeUpdateDto;
import cn.subat.impl.movie.entity.EpisodeEntity;
import cn.subat.impl.movie.mapper.EpisodeMapper;
import cn.subat.impl.movie.repository.EpisodeRepository;
import cn.subat.impl.spdoc.annotation.SPDocConsumer;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.model.Page;
import io.micronaut.http.annotation.Body;
import io.micronaut.rabbitmq.annotation.Queue;
import io.micronaut.rabbitmq.annotation.RabbitListener;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
@RabbitListener
@Introspected
public class EpisodeService {


    EpisodeMapper episodeMapper;
    EpisodeRepository episodeRepository;


    @SPDocConsumer(tag = "电影选集-后台", value = "创建电影选集")
    @Queue("movie.episode.admin.create")
    public ImplResponse<Boolean> createEpisode(@Body EpisodeCreateDto episodeCreateDto) {
        episodeRepository.save(episodeMapper.createDtoToEntity(episodeCreateDto, new EpisodeEntity()));
        return ImplResponse.of(true);
    }

    @SPDocConsumer(tag = "电影选集-后台", value = "删除电影选集")
    @Queue("movie.episode.admin.delete")
    public ImplResponse<Boolean> deleteEpisode(Long episodeId) {
        Optional<EpisodeEntity> entityOpt = episodeRepository.findById(episodeId);
        if (entityOpt.isEmpty()) {
            return ImplResponse.of(-1, "电影选集不存在");
        } else {
            episodeRepository.deleteById(episodeId);
            return ImplResponse.of(true);
        }
    }


    @SPDocConsumer(tag = "电影选集-后台", value = "更新电影选集")
    @Queue("movie.episode.admin.update")
    public ImplResponse<Boolean> updateEpisode(@Body EpisodeUpdateDto episodeUpdateDto) {
        Optional<EpisodeEntity> episodeOpt = episodeRepository.findById(episodeUpdateDto.getId());
        if (episodeOpt.isEmpty()) {
            return ImplResponse.of(-1, "电影选集不存在");
        } else {
            episodeRepository.update(episodeMapper.updateFromDto(episodeUpdateDto, episodeOpt.get()));
            return ImplResponse.of(true);
        }
    }


    @SPDocConsumer(tag = "电影选集-后台", value = "电影选集列表")
    @Queue("movie.episode.admin.list")
    public ImplResponse<ImplPage<EpisodeCommonDto>> episodeList(@Body ImplQuery query) {
        Page<EpisodeEntity> episodePage = episodeRepository.findAll(query.getQuerySpecification(), query.getPageable());
        return ImplResponse.of(episodePage.map(episodeMapper::entityToCommonDto));
    }


    @SPDocConsumer(tag = "电影选集-后台", value = "电影选集单个查询")
    @Queue("movie.episode.admin.one")
    public ImplResponse<EpisodeCommonDto> one(Long id) {
        Optional<EpisodeEntity> episodeOpt = episodeRepository.findById(id);
        if (episodeOpt.isEmpty()) {
            return ImplResponse.of(-1, "电影选集不存在");
        } else {
            return ImplResponse.of(episodeMapper.entityToCommonDto(episodeOpt.get()));
        }
    }


    @SPDocConsumer(tag = "电影选集-后台", value = "电影选集发布")
    @Queue("movie.episode.admin.publish")
    public ImplResponse<Boolean> publish(Long id) {
        Optional<EpisodeEntity> episodeOpt = episodeRepository.findById(id);
        if (episodeOpt.isEmpty()) {
            return ImplResponse.of(-1, "电影选集不存在");
        } else {
            EpisodeEntity episodeEntity = episodeOpt.get();
            if (episodeEntity.getIsPublish() == 1) {
                episodeEntity.setIsPublish(0);
            } else {
                episodeEntity.setIsPublish(1);
            }
            episodeRepository.update(episodeEntity);
            return ImplResponse.of(true);
        }
    }


    @SPDocConsumer(tag = "电影选集-后台", value = "电影选集状态")
    @Queue("movie.episode.admin.set.state")
    public ImplResponse<EpisodeCommonDto> setState(Long id) {
        Optional<EpisodeEntity> episodeOpt = episodeRepository.findById(id);
        if (episodeOpt.isEmpty()) {
            return ImplResponse.of(-1, "电影选集不存在");
        } else {
            EpisodeEntity episodeEntity = episodeOpt.get();
            if (episodeEntity.getState() == 1) {
                return ImplResponse.of(1, "电影选集未上传");
            } else if (episodeEntity.getState() == 2) {
                return ImplResponse.of(1, "电影选集转码中");
            } else if (episodeEntity.getState() == 3) {
                return ImplResponse.of(1, "电影选集待发布");
            } else if (episodeEntity.getState() == 4) {
                return ImplResponse.of(1, "电影选集已发布");
            }
            return ImplResponse.of(1, "请耐心等待。。。。。");
        }
    }
}
