package com.kbstar.springboot.study.service;

import com.kbstar.springboot.study.domain.posts.Posts;
import com.kbstar.springboot.study.domain.posts.PostsRepository;
import com.kbstar.springboot.study.web.dto.PostsListResponseDto;
import com.kbstar.springboot.study.web.dto.PostsResponseDto;
import com.kbstar.springboot.study.web.dto.PostsSaveRequestDto;
import com.kbstar.springboot.study.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import java.util.List;
import java.util.stream.Collectors;


/*
    19. Service 등록

    자동으로 만들어지는 생성

    public PostsService(PostsRepository postsRepository)
    {
        this.postsRepository=postsRepository;
    }

    Transaction : All or Nothing
 */
@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;


    @Transactional
    public Long save(PostsSaveRequestDto requestDto)
    {
        System.out.println("------------------ Post Service");
        System.out.println("title = " + requestDto.getTitle());
        System.out.println("content = " + requestDto.getContent());
        System.out.println("author = " + requestDto.getAuthor());
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    /*
        25. 업데이트를 위한 매핑 (객체랑 DB)

        등록 : /api/v1/posts    <--- 새글 등록록
       수정 : /api/v1/posts/3  <--- 3번글을 수정해

       1. DTO --> Service --> Controller
     */
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto )
    {
        Posts posts = postsRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("No id for Post indById(id).o: " + id)
        );

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional
    public int updateView(Long id)
    {
        return postsRepository.updateView(id);
    }

    @Transactional
    public int increaseRecommend(Long id)
    {
        return postsRepository.increaseRecommend(id);
    }

    @Transactional(readOnly = true)
    public Page<Posts> pageList(Pageable pageable)
    {
        return postsRepository.findAll(pageable);
    }



    @Transactional
    public void delete(Long id)
    {
        Posts posts = postsRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("No id for Post indById(id).o: " + id)
        );

        postsRepository.delete(posts);
    }

    public PostsResponseDto findById(Long id)
    {
        Posts posts = postsRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("No id for Post idById(id).o: " + id)
        );

        return new PostsResponseDto(posts);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc()
    {
        return postsRepository
                .findAllDesc()
                .stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    //public List<Posts> search(String keyword)
    public Page<Posts> search(String keyword, Pageable pageable)
    {
        //List<Posts> postsList = postsRepository.findByTitleContaining(keyword);
        //return postsList;

        Page<Posts> postsList = postsRepository.findByTitleContaining(keyword, pageable);
        return postsList;
    }

    /*
    .map(PostListResponseDto::new)
    = .map(posts->new PostListResponseDto(posts))
     */

}
