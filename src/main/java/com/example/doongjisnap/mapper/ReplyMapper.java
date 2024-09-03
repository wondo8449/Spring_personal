package com.example.doongjisnap.mapper;

import com.example.doongjisnap.domain.vo.Criteria;
import com.example.doongjisnap.domain.vo.ReplyVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReplyMapper {
    public void insert(ReplyVO replyVO);
    public List<ReplyVO> selectAll(@Param("boardNumber") Long boardNumber, @Param("criteria") Criteria criteria);
    public void update(ReplyVO replyVO);
    public void delete(Long boardNumber);
    public ReplyVO select(Long replyNumber);
    public int getTotal(Long boardNumber);
}
