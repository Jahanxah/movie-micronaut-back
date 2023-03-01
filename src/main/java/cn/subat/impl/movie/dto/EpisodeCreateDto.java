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
public class EpisodeCreateDto {

    @SPDocField("电影id")
    private Long movieId;

    @SPDocField("选集标题")
    private String title;

    @SPDocField("选集标记")
    private String label;

    @SPDocField("单集封面")
    private String poster;

    @SPDocField("单集价格")
    private Long price;

    @SPDocField("单机试看时长")
    private Integer playRange;

    @SPDocField("片头")
    private Integer titleRange;

    @SPDocField("选集视频文件")
    private String videoFile;

    @SPDocField("选集视频时长")
    private Integer duration;

}
