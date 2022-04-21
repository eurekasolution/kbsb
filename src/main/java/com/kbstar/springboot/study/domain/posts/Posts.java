package com.kbstar.springboot.study.domain.posts;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


/*
13. 게시글 관련 클래스 정의
    <form method='post' enctype='multipart/form-data' action='a.jsp'>
        <input type='file' name='upfile'>
    </form>

@Entity : JPA에서 필요한 annotation
    테이블과 클래스를 매핑해준다.
    Posts.java  -> posts 데이터베이스 테이블 매핑
        myFamilyCount
        my_family_count
 */
@Getter
@NoArgsConstructor
@Entity
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable=false)
    private String content;

    private String author;

    // 복제생성자, Copy Constructor
    @Builder
    public Posts(String title, String content, String author)
    {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
