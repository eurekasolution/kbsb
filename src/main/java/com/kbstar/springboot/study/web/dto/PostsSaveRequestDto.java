package com.kbstar.springboot.study.web.dto;

import com.kbstar.springboot.study.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
    18. 게시글 저장을 위한 데이터 덩어리 만들기
         id, title, content, author
         insert into posts (title, content, author) values (?, ?, ?);


         +-----------------------+   +-----------+
         |    Web Layer          |   |           |
         |   (controllers) (3)   |   |    DTO(1) |
         +-----------------------+   |           |
         +-----------------------+   |           |
         |    Service Layer(2)   |   +-----------+
         |                       |   +-----------+
         +-----------------------+   |  Domain   |
         +-----------------------+   |  Model    |
         |    Repository Layer   |   | (Entity)  |
         |                       |   |  Posts    |
         +-----------------------+   +-----------+
 */
@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author)
    {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity()
    {
        return Posts.builder().title(title).content(content).author(author).build();
    }
}
