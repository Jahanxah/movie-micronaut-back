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

public class ListCreateDto {
    @SPDocField("创建着id")
    private Long userId;
    @SPDocField("合集名称")
    private String name;
    @SPDocField("合集描述")
    private String description;
    @SPDocField("合集封面")
    private String poster;
    @SPDocField("电影季")
    private Integer type;
    @SPDocField("合集包含的电影数量")
    private Integer itemCount;
}
