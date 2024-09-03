package com.example.doongjisnap.mapper;

import com.example.doongjisnap.domain.vo.BoardVO;
import com.example.doongjisnap.domain.vo.Criteria;
import com.example.doongjisnap.domain.vo.GalleryDTO;
import com.example.doongjisnap.domain.vo.GalleryVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface GalleryMapper {
    public void insert(GalleryDTO galleryDTO);
    //  수정
    public void update(GalleryDTO galleryDTO);
    //  삭제
    public void delete(Long boardNumber);
    //  조회
    public GalleryVO select(Long boardNumber);
    //  전체조회
    public List<GalleryVO> selectAll(Criteria criteria);
    //  전체 개수
    public int getTotal();
}
