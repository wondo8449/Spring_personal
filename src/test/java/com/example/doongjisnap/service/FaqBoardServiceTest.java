package com.example.doongjisnap.service;

import com.example.doongjisnap.domain.vo.BoardVO;
import com.example.doongjisnap.domain.vo.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@SpringBootTest
class FaqBoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Test
    public void registerTest() {
        BoardVO boardVO = new BoardVO();
        boardVO.create("Mapper Test", "김예찬", "Mapper 테스트 컨텐츠");
        boardService.register(boardVO);
    }

    @Test
    public void showTest() {
        log.info("board : " + boardService.show(1L));
    }

    @Test
    public void modifyTest() {
        BoardVO boardVO = boardService.show(2L);
        boardVO.setBoardTitle("Update Test2");
        boardService.modify(boardVO);
    }

    @Test
    public void showAllTest() {
        boardService.showAll(new Criteria().create(1, 10)).stream().map(BoardVO::getBoardTitle).forEach(log::info);
    }
}