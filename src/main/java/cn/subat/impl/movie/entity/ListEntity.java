package cn.subat.impl.movie.entity;

import cn.subat.impl.spdoc.annotation.SPDocField;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "movie_list")
public class ListEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;


    @Column(name = "user_id", nullable = false)
    @Comment("创建着id")
    private Long userId;


    @Column(name = "name", nullable = false)
    @Comment("合集名称")
    private String name;


    @Column(name = "description")
    @Comment("合集描述")
    private String description;


    @Column(name = "poster", nullable = false)
    @Comment("合集封面")
    private String poster;


    @Column(name = "like_count")
    @Comment("喜欢次数")
    private Integer likeCount = 0;


    @Column(name = "item_count")
    @Comment("合集包含的电影数量")
    private Integer itemCount = 0;


    @Column(name = "is_published")
    @Comment("是否发布")
    private Integer isPublished = 0;


    @Column(name = "type")
    @Comment("电影季")
    private Integer type;
}
