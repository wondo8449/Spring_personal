package com.example.doongjisnap.service;

import com.example.doongjisnap.domain.vo.BoardVO;
import com.example.doongjisnap.domain.vo.Criteria;
import com.example.doongjisnap.repository.BoardDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor @Qualifier("Faq") @Primary
public class FaqBoardService implements BoardService {

    private final BoardDAO boardDAO;
    @Override
    public void register(BoardVO boardVO) {
        boardDAO.save(boardVO);
    }

    @Override
    public void modify(BoardVO boardVO) {
        boardDAO.setBoardVO(boardVO);
    }

    @Override
    public void remove(Long boardNumber) {
        boardDAO.remove(boardNumber);
    }

    @Override
    public BoardVO show(Long boardNumber) {
        return boardDAO.findById(boardNumber);
    }

    @Override
    public List<BoardVO> showAll(Criteria criteria) {
        return boardDAO.findAll(criteria);
    }

    @Override
    public int getTotal() {
        return boardDAO.findCountAll();
    }
}
