package com.example.pagedemo.persistence;

import com.example.pagedemo.domain.ArticleVO;

import java.util.List;

public interface ArticleDAO {

    void create(ArticleVO articleVO) throws Exception;
    ArticleVO read(Integer article_no) throws Exception;
    void update(ArticleVO articleVO) throws Exception;
    void delete(Integer article_no) throws  Exception;
    List<ArticleVO> listAll() throws Exception;
}
