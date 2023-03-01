package cn.subat.impl.movie.dto;

import cn.subat.impl.spdoc.annotation.SPDocField;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import io.micronaut.serde.config.naming.SnakeCaseStrategy;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Introspected
@Serdeable(naming = SnakeCaseStrategy.class)
public class EpisodeCommonDto extends EpisodeUpdateDto {

    @SPDocField("播放次数")
    private Integer playCount;

    @SPDocField("购买次数")
    private Integer saleCount;

    @SPDocField("评论次数")
    private Integer commentCount;
}
