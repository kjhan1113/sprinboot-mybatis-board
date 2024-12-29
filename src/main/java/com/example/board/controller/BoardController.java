package com.example.board.controller;

import com.example.board.entity.BoardEntity;
import com.example.board.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BoardController {

    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/save")
    public String save() {
        return "save";
    }

    @PostMapping("/save")
    public String save(BoardEntity boardEntity) {
        boardService.save(boardEntity);
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String findAll(Model model) {
        List<BoardEntity> boardEntityList = boardService.findAll();
        model.addAttribute("boardList", boardEntityList);
        return "list";
    }

    @GetMapping("/list/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {
        // Update Views
        boardService.updateViews(id);

        // Detail Page by ID
        BoardEntity boardEntity = boardService.findById(id);
        model.addAttribute("board", boardEntity);
        return "detail";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        BoardEntity boardEntity = boardService.findById(id);
        model.addAttribute("board", boardEntity);
        return "update";
    }
}
