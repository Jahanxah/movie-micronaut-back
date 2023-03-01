package cn.subat.impl.movie.mapper;

import cn.subat.impl.movie.dto.*;
import cn.subat.impl.movie.entity.EpisodeEntity;
import cn.subat.impl.movie.entity.MovieEntity;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "jsr330")
public interface EpisodeMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    EpisodeEntity createDtoToEntity(EpisodeCreateDto dto, @MappingTarget EpisodeEntity entity);


    EpisodeCommonDto entityToCommonDto(EpisodeEntity entity);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    EpisodeEntity updateFromDto(EpisodeUpdateDto dto, @MappingTarget EpisodeEntity entity);


}
