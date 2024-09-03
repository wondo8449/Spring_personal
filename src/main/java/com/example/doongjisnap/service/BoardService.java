package com.example.doongjisnap.service;

import com.example.doongjisnap.domain.vo.BoardVO;
import com.example.doongjisnap.domain.vo.Criteria;
import com.example.doongjisnap.domain.vo.GalleryVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService {
    //  추가
    public void register(BoardVO boardVO);

    //  수정
    public void modify(BoardVO boardVO);
    //  삭제
    public void remove(Long boardNumber);
    //  조회
    public BoardVO show(Long boardNumber);
    //  전체조회
    public List<BoardVO> showAll(Criteria criteria);
    //  전체 개수
    public int getTotal();
}
