package com.example.pagedemo.persistence;

import com.example.pagedemo.domain.ArticleVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class ArticleDAOImpl implements ArticleDAO {

    private static final String NAMESPACE = "com.example.pagedemo.mappers.article.ArticleMapper";
    private final SqlSession sqlSession;

//    @Autoweired?
    @Inject
    public ArticleDAOImpl(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }

    @Override
    public void create(ArticleVO articleVO) throws Exception {
        sqlSession.insert(NAMESPACE + ".create", articleVO);
    }

    @Override
    public ArticleVO read(Integer article_no) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".read", article_no);
    }

    @Override
    public void update(ArticleVO articleVO) throws Exception {
        sqlSession.update(NAMESPACE + ".update", articleVO);
    }

    @Override
    public void delete(Integer article_no) throws Exception {
        sqlSession.delete(NAMESPACE + ".delete", article_no);
    }

    @Override
    public List<ArticleVO> listAll() throws Exception {
        return sqlSession.selectList(NAMESPACE + ".listAll");
    }
}
