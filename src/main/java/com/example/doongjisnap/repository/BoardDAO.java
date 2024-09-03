package com.example.doongjisnap.repository;

import com.example.doongjisnap.domain.vo.BoardVO;
import com.example.doongjisnap.domain.vo.Criteria;
import com.example.doongjisnap.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardDAO {
    private final BoardMapper boardMapper;
    //  추가
    public void save(BoardVO boardVO) {
        boardMapper.insert(boardVO);
    };
    //  수정
    public void setBoardVO(BoardVO boardVO) {
        boardMapper.update(boardVO);
    };
    //  삭제
    public void remove(Long boardNumber) {
        boardMapper.delete(boardNumber);
    };
    //  조회
    public BoardVO findById(Long boardNumber) {
        return boardMapper.select(boardNumber);
    };
    //  전체조회
    public List<BoardVO> findAll(Criteria criteria) {
        return boardMapper.selectAll(criteria);
    };
    //  전체 개수
    public int findCountAll() {
        return boardMapper.getTotal();
    }

}
