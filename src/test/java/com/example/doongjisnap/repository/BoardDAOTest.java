package com.example.doongjisnap.repository;

import com.example.doongjisnap.domain.vo.BoardVO;
import com.example.doongjisnap.domain.vo.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class BoardDAOTest {

    @Autowired
    private BoardDAO boardDAO;

    @Test
    public void saveTest() {
        BoardVO boardVO = new BoardVO();
        boardVO.create("DAO Test", "김예찬", "DAO 테스트 컨텐츠");
        boardDAO.save(boardVO);
    }

    @Test
    public void findByIdTest() {
        log.info("board : " + boardDAO.findById(1L));
    }

    @Test
    public void setBoardVOTest() {
        BoardVO boardVO = boardDAO.findById(1L);
        boardVO.setBoardTitle("Update Test");
        boardDAO.setBoardVO(boardVO);
    }

    @Test
    public void findAllTest() {
        boardDAO.findAll(new Criteria().create(1, 10)).stream().map(BoardVO::getBoardTitle).forEach(log::info);
    }
}