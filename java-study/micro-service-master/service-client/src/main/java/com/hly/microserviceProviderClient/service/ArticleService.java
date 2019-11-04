package com.hly.microserviceProviderClient.service;


import com.hly.microserviceProviderClient.domain.Article;

import java.util.List;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/10/29
 */
public interface ArticleService {
    List<Article> getArticles();
    void deleteArticle(int id);
}
