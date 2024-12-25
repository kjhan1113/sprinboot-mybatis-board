package com.example.board.repository;

import com.example.board.entity.BoardEntity;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardRepository {

    private final SqlSessionTemplate sqlTemplate;

    public BoardRepository(SqlSessionTemplate sqlTemplate) {
        this.sqlTemplate = sqlTemplate;
    }

    public void save(BoardEntity boardEntity) {
        sqlTemplate.insert("Board.save", boardEntity);
    }

    public List<BoardEntity> findAll() {
        return sqlTemplate.selectList("Board.findAll");
    }

    public void updateViews(Long id) {
        sqlTemplate.update("Board.updateViews", id);
    }
}
