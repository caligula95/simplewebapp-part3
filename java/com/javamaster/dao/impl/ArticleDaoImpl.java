package com.javamaster.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.javamaster.dao.ArticleDao;
import com.javamaster.entity.Article;
import com.javamaster.entity.Category;

public class ArticleDaoImpl implements ArticleDao {
	
	private Connection getConnection(){
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/simpleapp", "root", "root");
		System.out.println("Got our connection");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public int createArticle(Article article) {
		Connection con = getConnection();
		try {
			PreparedStatement pr = con.prepareStatement("insert into "
					+ "article(title, body, category_id, users_id) values(?,?,?,?)");
			pr.setString(1, article.getTitle());
			pr.setString(2, article.getBody());
			pr.setInt(3, article.getCategory().getId());
			pr.setInt(4, 1);
			pr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return 0;
			
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}

	public int editArticle(Article article) {
		
		return 0;
	}

	public void deleteArticle(int id) {
		
		
	}
	
	public static void main(String[] args){
		ArticleDao art = new ArticleDaoImpl();
		Article article = new Article();
		Category category = new Category();
		category.setId(1);
		article.setBody("my body of the article");
		article.setCategory(category);
		article.setTitle("my title");
		System.out.println(art.createArticle(article));
		
	}

}
