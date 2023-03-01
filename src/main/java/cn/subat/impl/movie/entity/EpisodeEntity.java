package cn.subat.impl.movie.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "movie_episode")
public class EpisodeEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "movie_id", nullable = false)
    private Long movieId;


    @Column(name = "title", nullable = false)
    @Comment("选集标题")
    private String title;


    @Column(name = "label", nullable = false)
    @Comment("选集标记")
    private String label;


    @Column(name = "poster")
    @Comment("单集封面")
    private String poster;


    @Column(name = "price")
    @Comment("单集价格")
    private Long price = -100L;


    @Column(name = "play_range")
    @Comment("单机试看时长")
    private Integer playRange = 0;


    @Column(name = "title_range")
    @Comment("片头")
    private Integer titleRange = 0;


    @Column(name = "video_file")
    @Comment("选集视频文件")
    private String videoFile;


    @Column(name = "duration")
    @Comment("选集视频时长")
    private Integer duration = 0;


    @Column(name = "play_count")
    @Comment("播放次数")
    private Integer playCount = 0;


    @Column(name = "sale_count")
    @Comment("购买次数")
    private Integer saleCount = 0;


    @Column(name = "comment_count")
    @Comment("评论次数")
    private Integer commentCount = 0;


    @Column(name = "state")
    @Comment("状态")
    private Integer state = 1;
}
