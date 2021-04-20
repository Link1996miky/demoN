package com.example.demon.controller;


import com.example.demon.config.AjaxResponse;
import com.example.demon.model.Article;
import com.example.demon.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@Controller
public class ArticleController {


    @Resource
    private ArticleService articleService;

    @GetMapping("/articles/{id}")
    public @ResponseBody
    AjaxResponse getArticle(@PathVariable("id") Long id) {
        Article article = Article.builder()
                .id(1)
                .rPw("mypw")
                .rName("link")
                .build();
        return AjaxResponse.success();
    }

    @PostMapping("/articles")
    public @ResponseBody
    AjaxResponse addArticle(@RequestBody Article article) {
        articleService.savaArticle(article);
        return AjaxResponse.success(article);
    }

    @PutMapping("/articles")
    public @ResponseBody
    AjaxResponse updateArticle(@RequestBody Article article) {

        return AjaxResponse.success();
    }

    @DeleteMapping("/articles/{id}")
    public @ResponseBody
    AjaxResponse deleteArticle(@PathVariable("id") Long id) {

        return AjaxResponse.success();
    }


}
