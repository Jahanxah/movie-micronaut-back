package cn.subat.impl.movie.dto;

import cn.subat.impl.spdoc.annotation.SPDocField;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import io.micronaut.serde.config.naming.SnakeCaseStrategy;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Introspected
@Serdeable(naming = SnakeCaseStrategy.class)

public class ListCreateDto {
    @SPDocField("创建着id")
    @NotNull(message = "创建着id不能为空")
    private Long userId;
    @SPDocField("合集名称")
    @NotNull(message = "合集标题不能为空")
    private String name;
    @SPDocField("合集描述")
    private String description;
    @SPDocField("合集封面")
    @NotNull(message = "合集封面不能为空")
    private String poster;
    @SPDocField("电影季")
    private Integer type;
}
