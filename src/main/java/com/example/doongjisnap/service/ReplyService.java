package com.example.doongjisnap.service;

import com.example.doongjisnap.domain.vo.Criteria;
import com.example.doongjisnap.domain.vo.ReplyVO;
import com.example.doongjisnap.repository.ReplyDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyDAO replyDAO;

    public void register(ReplyVO replyVO) {replyDAO.save(replyVO);}

    public List<ReplyVO> showAll(Long boardNumber, Criteria criteria) {return replyDAO.findAll(boardNumber, criteria);}

    public void modify(ReplyVO replyVO) {replyDAO.setRelyVO(replyVO);}

    public void remove(Long replyNumber) {replyDAO.remove(replyNumber);}

    public ReplyVO show(Long replyNumber) {return replyDAO.findById(replyNumber);}

    public int count(Long boardNumber) {return replyDAO.getTotal(boardNumber);}
}
