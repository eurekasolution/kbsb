package com.kbstar.springboot.study.web;

import com.kbstar.springboot.study.domain.posts.Posts;
import com.kbstar.springboot.study.domain.posts.PostsRepository;
import com.kbstar.springboot.study.web.dto.PostsSaveRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsApiControllerTest {
    @LocalServerPort
    private int port; // 단위테스트용 port#

    @Autowired
    private PostsRepository postsRepository;

    @Autowired
    private TestRestTemplate restTemplate;

    @AfterEach
    public void cleanup() throws Exception
    {
        postsRepository.deleteAll();
    }

    @Test
    public void postsRegistTest() throws Exception
    {
        String title = "test title";
        String content = "test content";
        String author = "test author";

        //PostsSaveRequestDto requestDto = PostsSaveRequestDto
        //                                    .builder()
        //                                        .title(title)
        //                                        .content(content)
        //                                        .author(author)
        //                                    .build();
        // http://localhost:12345/api/v1/posts
        /*
        21 단위테스트
            HTML Request/Response
            Client -----req---------> Server
                   <-----res -------

          +---------------------------+
          |        HTML Header        |
          +---------------------------+
          |        HTML Body          |
          |         ...               |
          +---------------------------+

         */

        PostsSaveRequestDto requestDto = PostsSaveRequestDto.builder()
                .title(title).content(content).author("author").build();

        System.out.println("-------------- dto title = " + requestDto.getTitle());

        String url = "http://localhost:" + port + "/api/v1/posts";

        System.out.println("------------------- port : " + port);

        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        assertThat(responseEntity.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);
        /*
            float degree = 1.23F;
            long value = 123L;
         */

        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getContent()).isEqualTo(content);
    }

}
