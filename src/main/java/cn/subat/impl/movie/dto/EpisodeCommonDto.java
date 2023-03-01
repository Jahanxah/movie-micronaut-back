package cn.subat.impl.movie.dto;

import cn.subat.impl.spdoc.annotation.SPDocField;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import io.micronaut.serde.config.naming.SnakeCaseStrategy;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import javax.persistence.Column;

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

    @Comment("状态，1表示未上传，2表示转码中，3表示待发布，4表示已发布")
    private Integer state = 1;


    public Integer getPlayCount() {
        if (playCount <= 10000){
            return playCount;
        }else{
            return playCount/10000;
        }
    }
}
