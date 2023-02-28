package cn.subat.impl.movie.mapper;

import cn.subat.impl.movie.dto.MovieCommonDto;
import cn.subat.impl.movie.dto.MovieCreateDto;
import cn.subat.impl.movie.dto.MovieUpdateDto;
import cn.subat.impl.movie.entity.MovieEntity;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "jsr330")
public interface ListMapper {

    MovieEntity createDtoToEntity(MovieCreateDto dto);


    MovieCommonDto entityToCommonDto(MovieEntity entity);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    MovieEntity updateFromDto(MovieUpdateDto dto, @MappingTarget MovieEntity entity);


}
