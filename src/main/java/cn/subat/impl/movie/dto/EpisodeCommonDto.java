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
public class EpisodeCommonDto {
    @Id
    @GeneratedValue
    @Column(name = "id")
    @SPDocField("电影id")
    private String id;

    @SPDocField("电影id")
    @Column(name = "movie_id", nullable = false)
    private String movieId;


    @Column(name = "title", nullable = false)
    @SPDocField("选集标题")
    @Comment("选集标题")
    private String title;


    @Column(name = "label", nullable = false)
    @SPDocField("选集标记")
    @Comment("选集标记")
    private String label;


    @Column(name = "poster")
    @SPDocField("单集封面")
    @Comment("单集封面")
    private String poster;


    @Column(name = "price")
    @SPDocField("单集价格")
    @Comment("单集价格")
    @ColumnDefault("-100")
    private Long price;


    @Column(name = "play_range")
    @SPDocField("单机试看时长")
    @Comment("单机试看时长")
    @ColumnDefault("0")
    private String playRange;


    @Column(name = "title_range")
    @SPDocField("片头")
    @Comment("片头")
    @ColumnDefault("0")
    private String titleRange;


    @Column(name = "video_file")
    @SPDocField("选集视频文件")
    @Comment("选集视频文件")
    private String videoFile;


    @Column(name = "duration")
    @SPDocField("选集视频时长")
    @Comment("选集视频时长")
    @ColumnDefault("0")
    private String duration;


    @Column(name = "play_count")
    @SPDocField("播放次数")
    @Comment("播放次数")
    @ColumnDefault("0")
    private Long playCount;


    @Column(name = "sale_count")
    @SPDocField("购买次数")
    @Comment("购买次数")
    @ColumnDefault("0")
    private String saleCount;


    @Column(name = "comment_count")
    @SPDocField("评论次数")
    @Comment("评论次数")
    @ColumnDefault("0")
    private Long commentCount;


    @Column(name = "state")
    @SPDocField("状态")
    @Comment("状态")
    @ColumnDefault("1")
    private Integer state;

}
