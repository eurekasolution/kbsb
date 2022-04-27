package com.kbstar.springboot.study.web.dto;

import com.kbstar.springboot.study.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsListResponseDto {
    private Long id;
    private String title;
    //private String content;
    private String author;
    //private LocalDateTime modifiedDate;
    private String modifiedDate;

    public PostsListResponseDto(Posts entity)
    {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }
}
