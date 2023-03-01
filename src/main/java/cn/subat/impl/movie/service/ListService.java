package cn.subat.impl.movie.service;

import cn.subat.impl.common.dto.ImplPage;
import cn.subat.impl.common.dto.ImplQuery;
import cn.subat.impl.common.dto.ImplResponse;
import cn.subat.impl.movie.dto.ListCommonDto;
import cn.subat.impl.movie.dto.ListCreateDto;
import cn.subat.impl.movie.dto.ListUpdateDto;
import cn.subat.impl.movie.entity.ListEntity;
import cn.subat.impl.movie.mapper.ListMapper;
import cn.subat.impl.movie.repository.ListRepository;
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
public class ListService {

    ListMapper listMapper;
    ListRepository listRepository;


    @SPDocConsumer(tag = "电影列表", value = "创建电影列表")
    @Queue("movie.admin.list.create")
    public ImplResponse<Boolean> createList(@Body ListCreateDto listCreateDto) {
        listRepository.save(listMapper.createDtoToEntity(listCreateDto));
        return ImplResponse.of(true);
    }

    @SPDocConsumer(tag = "电影列表", value = "删除电影列表")
    @Queue("movie.admin.list.delete")
    public ImplResponse<Boolean> deleteList(@Body Long id) {
        Optional<ListEntity> listOpt = listRepository.findById(id);
        if (listOpt.isEmpty()) {
            return ImplResponse.of(-1, "电影列表不存在");
        } else {
            listRepository.deleteById(id);
            return ImplResponse.of(true);
        }
    }

    @SPDocConsumer(tag = "电影列表", value = "修改电影列表")
    @Queue("movie.admin.list.update")
    public ImplResponse<Boolean> updateList(@Body ListUpdateDto listUpdateDto) {
        Optional<ListEntity> listOpt = listRepository.findById(listUpdateDto.getId());
        if (listOpt.isEmpty()) {
            return ImplResponse.of(-1, "电影列表不存在");
        } else {
            listRepository.update(listMapper.updateFromDto(listUpdateDto, listOpt.get()));
            return ImplResponse.of(true);
        }
    }


    @SPDocConsumer(tag = "电影列表", value = "电影列表")
    @Queue("movie.admin.list")
    public ImplResponse<ImplPage<ListCommonDto>> list(@Body ImplQuery query) {
        Page<ListEntity> listPage = listRepository.findAll(query.getQuerySpecification(), query.getPageable());
        return ImplResponse.of(listPage.map(listMapper::entityToCommonDto));
    }


    @SPDocConsumer(tag = "电影列表", value = "电影列表单个查询")
    @Queue("movie.admin.list.get")
    public ImplResponse<ListCommonDto> one(@Body Long Listid) {
        Optional<ListEntity> listOpt = listRepository.findById(Listid);
        if (listOpt.isEmpty()) {
            return ImplResponse.of(-1, "电影列表不存在");
        } else {
            return ImplResponse.of(listMapper.entityToCommonDto(listOpt.get()));
        }
    }
}
