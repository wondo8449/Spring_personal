package com.example.doongjisnap.repository;

import com.example.doongjisnap.domain.vo.Criteria;
import com.example.doongjisnap.domain.vo.ReplyVO;
import com.example.doongjisnap.mapper.ReplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReplyDAO {
    private final ReplyMapper replyMapper;

    public void save(ReplyVO replyVO) {replyMapper.insert(replyVO);}

    public List<ReplyVO> findAll(Long boardNumber, Criteria criteria) {return replyMapper.selectAll(boardNumber, criteria);}

    public void setRelyVO(ReplyVO replyVO) {replyMapper.update(replyVO);}

    public void remove(Long replyNumber) {replyMapper.delete(replyNumber);}

    public ReplyVO findById(Long replyNumber) {
        return replyMapper.select(replyNumber);
    }

    public int getTotal(Long boardNumber){
        return replyMapper.getTotal(boardNumber);
    }
}
