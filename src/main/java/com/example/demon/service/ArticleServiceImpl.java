package com.example.demon.service;


import com.example.demon.Mapper.ArticleDAO;
import com.example.demon.model.Article;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleDAO articleDAO;


    @Override
    public void savaArticle(Article article) {
        articleDAO.save(article);
    }
}
