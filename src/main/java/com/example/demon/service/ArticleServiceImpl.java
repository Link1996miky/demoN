package com.example.demon.service;


import com.example.demon.Mapper.ArticleDAO;
import com.example.demon.model.Article;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleDAO articleDAO;


    @Override
    @Transactional
    public void savaArticle(Article article) {
        articleDAO.save(article);
    }
}
