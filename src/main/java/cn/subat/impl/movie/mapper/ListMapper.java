package cn.subat.impl.movie.mapper;

import cn.subat.impl.movie.dto.*;
import cn.subat.impl.movie.entity.ListEntity;
import cn.subat.impl.movie.entity.MovieEntity;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "jsr330")
public interface ListMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ListEntity createDtoToEntity(ListCreateDto dto, @MappingTarget ListEntity entity);


    ListCommonDto entityToCommonDto(ListEntity entity);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ListEntity updateFromDto(ListUpdateDto dto, @MappingTarget ListEntity entity);


}
