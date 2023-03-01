package cn.subat.impl.movie.service;

import cn.subat.impl.common.dto.ImplPage;
import cn.subat.impl.common.dto.ImplQuery;
import cn.subat.impl.common.dto.ImplResponse;
import cn.subat.impl.movie.dto.ListCommonDto;
import cn.subat.impl.movie.dto.ListCreateDto;
import cn.subat.impl.movie.dto.ListUpdateDto;
import cn.subat.impl.movie.entity.ListEntity;
import cn.subat.impl.movie.entity.MovieEntity;
import cn.subat.impl.movie.mapper.ListMapper;
import cn.subat.impl.movie.repository.ListRepository;
import cn.subat.impl.spdoc.annotation.SPDocConsumer;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.query.QueryModel;
import io.micronaut.http.annotation.Body;
import io.micronaut.rabbitmq.annotation.Queue;
import io.micronaut.rabbitmq.annotation.RabbitListener;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
@RabbitListener
@Introspected
public class ListService {

    ListMapper listMapper;
    ListRepository listRepository;


    @SPDocConsumer(tag = "电影合集-后台", value = "创建电影合集")
    @Queue("movie.list.admin.create")
    public ImplResponse<Boolean> createList(@Body ListCreateDto listCreateDto) {
        listRepository.save(listMapper.createDtoToEntity(listCreateDto, new ListEntity()));
        return ImplResponse.of(true);
    }

    @SPDocConsumer(tag = "电影合集-后台", value = "删除电影合集")
    @Queue("movie.list.admin.delete")
    public ImplResponse<Boolean> deleteList(Long id) {
        Optional<ListEntity> listOpt = listRepository.findById(id);
        if (listOpt.isEmpty()) {
            return ImplResponse.of(-1, "电影合集不存在");
        } else {
            listRepository.deleteById(id);
            return ImplResponse.of(true);
        }
    }

    @SPDocConsumer(tag = "电影合集-后台", value = "修改电影合集")
    @Queue("movie.list.admin.update")
    public ImplResponse<Boolean> updateList(@Body ListUpdateDto listUpdateDto) {
        Optional<ListEntity> listOpt = listRepository.findById(listUpdateDto.getId());
        if (listOpt.isEmpty()) {
            return ImplResponse.of(-1, "电影合集不存在");
        } else {
            listRepository.update(listMapper.updateFromDto(listUpdateDto, listOpt.get()));
            return ImplResponse.of(true);
        }
    }


    @SPDocConsumer(tag = "电影合集-后台", value = "电影合集")
    @Queue("movie.list.admin.list")
    public ImplResponse<ImplPage<ListCommonDto>> list(@Body ImplQuery query) {
        Page<ListEntity> listPage = listRepository.findAll(query.getQuerySpecification(), query.getPageable());
        return ImplResponse.of(listPage.map(listMapper::entityToCommonDto));
    }


    @SPDocConsumer(tag = "电影合集-后台", value = "电影合集单个查询")
    @Queue("movie.list.admin.one")
    public ImplResponse<ListCommonDto> one(Long listId) {
        Optional<ListEntity> listOpt = listRepository.findById(listId);
        if (listOpt.isEmpty()) {
            return ImplResponse.of(-1, "电影合集不存在");
        } else {
            return ImplResponse.of(listMapper.entityToCommonDto(listOpt.get()));
        }
    }

    @SPDocConsumer(tag = "电影合集-后台", value = "电影合集发布")
    @Queue("movie.list.admin.ispublish")
    public ImplResponse<Integer> isPublish(Long listId) {
        Optional<ListEntity> listOpt = listRepository.findById(listId);
        if (listOpt.isEmpty()) {
            return ImplResponse.of(-1, "电影合集不存在");
        } else {
            ListEntity listEntity = listOpt.get();
            if (listOpt.get().getIsPublished() == 1) {
                listEntity.setIsPublished(0);
                listRepository.update(listEntity);
                return ImplResponse.of(0, "电影合集已下架");
            } else {
                listEntity.setIsPublished(1);
                listRepository.update(listEntity);
                return ImplResponse.of(1, "电影合集已发布");
            }
        }
    }
}
