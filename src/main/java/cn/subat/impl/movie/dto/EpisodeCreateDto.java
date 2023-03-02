package cn.subat.impl.movie.dto;

import cn.subat.impl.spdoc.annotation.SPDocField;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import io.micronaut.serde.config.naming.SnakeCaseStrategy;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Introspected
@Serdeable(naming = SnakeCaseStrategy.class)
public class EpisodeCreateDto {

    @SPDocField("电影id")
    @NotNull(message = "电影id不能为空")
    private Long movieId;
    @SPDocField("选集标题")
    @NotNull(message = "电影标题不能为空")
    private String title;
    @SPDocField("选集标记")
    @NotNull(message = "电影标题不能为空")
    private String label;
    @SPDocField("单集封面")
    private String poster;
    @SPDocField("单集价格")
    private Integer price;
    @SPDocField("单机试看时长")
    private Integer playRange;

    @SPDocField("片头")
    private Integer titleRange;
    @SPDocField("选集视频文件")
    private String videoFile;
    @SPDocField("选集视频时长")
    private Integer duration;
    @Column(name = "resolution", columnDefinition = "longtext")
    @Comment("分辨率")
    private String resolution;

    @Column(name = "thrid_party")
    @Comment("第三方视频源")
    private String thridParty;

}
