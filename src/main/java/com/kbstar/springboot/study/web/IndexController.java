package com.kbstar.springboot.study.web;
/*
34 IndexController.java
    http://kbstar.com/
 */

import com.kbstar.springboot.study.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {
//    @GetMapping("/")
//    public String index()
//    {
//        return "index";
//    }

    private final PostsService postsService;
    /*
        public IndexController(PostsService postsService)
        {
            this.postsService = postsService;
        }

     */

    @GetMapping("/")
    public String index(Model model)
    {
        model.addAttribute("posts", postsService.findAllDesc() );
        return "index";
    }

    // printWrite
    @GetMapping("/posts/printWrite")
    public String postWrite()
    {
        return "posts-print-write";
    }

}

/*
    http://kbstar.com/
    query가 없으면 index를 리턴한다.
        index.mustache 파일이 있으면 이 파일이 index파일을 대체한다.

    header, tail 분리해서, 구조를 단순화시키기

    resources/templates/layout 폴더
                               /header.mustache
 */
