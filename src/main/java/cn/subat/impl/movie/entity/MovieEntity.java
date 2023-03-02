package cn.subat.impl.movie.entity;

import cn.subat.impl.spdoc.annotation.SPDocField;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "movie")
public class MovieEntity {
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
    @Comment("喜欢次数")
    private Integer likeCount = 0;


    @Column(name = "view_count")
    @Comment("观看次数")
    private Integer viewCount = 0;


    @Column(name = "sale_count")
    @Comment("购买次数")
    private Integer saleCount = 0;


    @Column(name = "is_published")
    @Comment("是否发布")
    private Integer isPublished = 0;


    @Column(name = "price")
    @Comment("价格")
    private Integer price = 0;


    @Column(name = "score")
    @Comment("评分")
    private Long score;


    @Column(name = "total_episode")
    @Comment("总集数")
    private Integer totalEpisode;


    @Column(name = "updated_episode")
    @Comment("更新集数")
    private Integer updatedEpisode;


    @Column(name = "release_date")
    @Comment("上映日期")
    private Integer releaseDate;


    @Column(name = "profit_ratio")
    @SPDocField("分成比例")
    @Comment("电影分成比例")
    private Long profitRatio = 60L;

    @Column(name = "share_ratio")
    @SPDocField("分享分成比例")
    @Comment("电影分享比例")
    private Long shareRatio = 40L;


    @Column(name = "provide_id")
    @SPDocField("内容提供商id")
    @Comment("内容提供商id")
    private Long provideId = 0L;


    @Column(name = "preview_url")
    @SPDocField("电影预览地址")
    @Comment("电影预览地址")
    private String previewUrl;
}
