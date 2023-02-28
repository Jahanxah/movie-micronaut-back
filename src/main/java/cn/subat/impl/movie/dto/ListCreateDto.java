package cn.subat.impl.movie.dto;

import cn.subat.impl.spdoc.annotation.SPDocField;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import io.micronaut.serde.config.naming.SnakeCaseStrategy;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Introspected
@Serdeable(naming = SnakeCaseStrategy.class)

public class ListCreateDto {


    @Column(name = "user_id", nullable = false)
    @SPDocField("创建着id")
    @Comment("创建着id")
    private Long userId;


    @Column(name = "name", nullable = false)
    @SPDocField("合集名称")
    @Comment("合集名称")
    private String name;


    @Column(name = "description")
    @SPDocField("合集描述")
    @Comment("合集描述")
    private String description;


    @Column(name = "poster", nullable = false)
    @SPDocField("合集封面")
    @Comment("合集封面")
    private String poster;


    @Column(name = "like_count")
    @SPDocField("喜欢次数")
    @ColumnDefault("0")
    @Comment("喜欢次数")
    private Long likeCount;


    @Column(name = "item_count")
    @SPDocField("合集包含的电影数量")
    @Comment("合集包含的电影数量")
    @ColumnDefault("0")
    private Long itemCount;


    @Column(name = "is_published")
    @SPDocField("是否发布")
    @Comment("是否发布")
    @ColumnDefault("0")
    private Boolean isPublished;


    @Column(name = "type")
    @SPDocField("电影季")
    @Comment("电影季")
    @ColumnDefault("0")
    private Integer type;

}
