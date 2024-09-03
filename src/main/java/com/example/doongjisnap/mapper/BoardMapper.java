package com.example.doongjisnap.mapper;

import com.example.doongjisnap.domain.vo.BoardVO;
import com.example.doongjisnap.domain.vo.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
//  추가
    public void insert(BoardVO boardVO);
//  수정
    public void update(BoardVO boardVO);
//  삭제
    public void delete(Long boardNumber);
//  조회
    public BoardVO select(Long boardNumber);
//  전체조회
    public List<BoardVO> selectAll(Criteria criteria);
//  전체 개수
    public int getTotal();

}
