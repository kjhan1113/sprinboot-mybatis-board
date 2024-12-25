package com.example.board.service;

import com.example.board.entity.BoardEntity;
import com.example.board.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public void save(BoardEntity boardEntity) {
        boardRepository.save(boardEntity);
    }

    public List<BoardEntity> findAll() {
        return boardRepository.findAll();
    }

    public void updateViews(Long id) {
        boardRepository.updateViews(id);
    }
}
