package com.javamaster.dao;

import com.javamaster.entity.Article;

public interface ArticleDao {

	int createArticle(Article article);
	
	int editArticle(Article article);
	
	void deleteArticle(int id);
	
}
