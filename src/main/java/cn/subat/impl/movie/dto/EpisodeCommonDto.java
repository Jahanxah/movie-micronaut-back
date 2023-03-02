package cn.subat.impl.movie.dto;

import cn.subat.impl.spdoc.annotation.SPDocField;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import io.micronaut.serde.config.naming.SnakeCaseStrategy;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

@Getter
@Setter
@Introspected
@Serdeable(naming = SnakeCaseStrategy.class)
public class EpisodeCommonDto extends EpisodeUpdateDto {

    @SPDocField("播放次数")
    private Long playCount;

    @SPDocField("购买次数")
    private Long saleCount;

    @SPDocField("评论次数")
    private Long commentCount;
    @SPDocField("状态，1表示未上传，2表示转码中，3表示待发布，4表示已发布")
    private Integer state;

    @SPDocField("是否发布")
    private Integer isPublished;
}
