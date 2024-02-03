package com.verystrong.car_loan_project.controller;

import com.verystrong.car_loan_project.dto.BoardDto;
import com.verystrong.car_loan_project.entity.BoardEntity;
import com.verystrong.car_loan_project.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/api")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/board/list")
    public List<BoardDto> boardList() {
        return boardService.getBoardList(); }

    @GetMapping("/board/{id}")
    public BoardDto getBoard(@PathVariable Long id) {
        return boardService.getBoard(id);
    }

    @PostMapping("/board")
    public BoardEntity create(@RequestBody BoardDto boardDto) {
        return boardService.create(boardDto);
    }

    @PatchMapping("/board")
    public BoardEntity update(@RequestBody BoardDto boardDto) {
        return boardService.update(boardDto);
    }

    @DeleteMapping("/board/{id}")
    public void delete(@PathVariable Long id) {
        boardService.delete(id);
    }
}
