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
public class MovieCreateDto {
    @SPDocField("绑定用户id")
    private Long userId;

    @SPDocField("电影名称")
    private String name;

    @SPDocField("电影描述")
    private String description;
    @SPDocField("电影封面")
    private String poster;
    @SPDocField("电影封面16:9")
    private String poster_16_9;
    @SPDocField("价格")
    private Long price;
    @SPDocField("评分")
    private Long score;
    @SPDocField("总集数")
    private Integer totalEpisode;
    @SPDocField("更新集数")
    private Integer updatedEpisode;
    @SPDocField("上映日期")
    private Integer releaseDate;
    @SPDocField("电影分成比例")
    private Long profitRatio;
    @SPDocField("电影分享比例")
    private Long shareRatio;
    @SPDocField("内容提供商id")
    private Long provideId;
    @SPDocField("电影预览地址")
    private String previewUrl;


    public Long getPrice() {
        return price * 100;
    }
}
