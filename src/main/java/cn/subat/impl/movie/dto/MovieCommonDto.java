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
public class MovieCommonDto extends MovieUpdateDto {

    @SPDocField("喜欢次数")
    private Integer likeCount;
    @SPDocField("是否发布")
    private Integer isPublished;
    @SPDocField("购买次数")
    private Integer saleCount;
    @SPDocField("浏览次数")
    private Integer viewCount;

}
