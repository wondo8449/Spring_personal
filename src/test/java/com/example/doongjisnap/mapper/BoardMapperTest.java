package com.example.doongjisnap.mapper;

import com.example.doongjisnap.domain.vo.BoardVO;
import com.example.doongjisnap.domain.vo.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class BoardMapperTest {
    @Autowired
    private BoardMapper boardMapper;

    @Test
    public void insertTest() {
        BoardVO boardVO = new BoardVO();
        boardVO.create("Mapper Test", "김예찬", "Mapper 테스트 컨텐츠");
        boardMapper.insert(boardVO);
    }

    @Test
    public void selectTest() {
        log.info("board : " + boardMapper.select(1L));
    }

    @Test
    public void updateTest() {
        BoardVO boardVO = boardMapper.select(1L);
        boardVO.setBoardTitle("Update Test");
        boardMapper.update(boardVO);
    }

    @Test
    public void selectAllTest() {
        boardMapper.selectAll(new Criteria().create(1, 10)).stream().map(BoardVO::getBoardTitle).forEach(log::info);
    }
}
