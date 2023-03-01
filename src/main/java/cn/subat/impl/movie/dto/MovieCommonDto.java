package cn.subat.impl.movie.dto;

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
public class MovieCommonDto {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;


    @Column(name = "user_id", nullable = false)
    @Comment("绑定用户id")
    private Long userId;

    @Column(name = "name", nullable = false)
    @Comment("电影名称")
    private String name;


    @Column(name = "description")
    @Comment("电影描述")
    private String description;


    @Column(name = "poster", nullable = false)
    @Comment("电影封面")
    private String poster;


    @Column(name = "poster_16_9", nullable = false)
    @Comment("电影封面16:9")
    private String poster_16_9;


    @Column(name = "like_count")
    @ColumnDefault("0")
    @Comment("喜欢次数")
    private Long likeCount;


    @Column(name = "view_count")
    @ColumnDefault("0")
    @Comment("观看次数")
    private Long viewCount;


    @Column(name = "sale_count")
    @ColumnDefault("0")
    @Comment("购买次数")
    private Long saleCount;


    @Column(name = "is_published")
    @Comment("是否发布")
    @ColumnDefault("0")
    private Long isPublished;


    @Column(name = "price")
    @Comment("价格")
    @ColumnDefault("0")
    private Long price;


    @Column(name = "coin")
    @Comment("金币价格")
    @ColumnDefault("0")
    private Long coin;


    @Column(name = "score")
    @ColumnDefault("0")
    @Comment("评分")
    private Long score;


    @Column(name = "total_episode")
    @ColumnDefault("0")
    @Comment("总集数")
    private Long totalEpisode;


    @Column(name = "updated_episode")
    @ColumnDefault("0")
    @Comment("更新集数")
    private Long updatedEpisode;


    @Column(name = "release_date")
    @Comment("上映日期")
    private Long releaseDate;


    @Column(name = "update_state")
    @ColumnDefault("0")
    @Comment("电影更新状态  0:更新中 1:已完结")
    private Long updateState;


    @Column(name = "profit_ratio")
    @ColumnDefault("60")
    @Comment("电影分成比例")
    private Long profitRatio;

    @Column(name = "share_ratio")
    @ColumnDefault("40")
    @Comment("电影分享比例")
    private Long shareRatio;


    @Column(name = "provide_id")
    @ColumnDefault("0")
    @Comment("内容提供商id")
    private Long provideId;


    @Column(name = "preview_url")
    @Comment("电影预览地址")
    private String previewUrl;
}
