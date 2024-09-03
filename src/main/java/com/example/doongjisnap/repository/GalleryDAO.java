package com.example.doongjisnap.repository;

import com.example.doongjisnap.domain.vo.GalleryDTO;
import com.example.doongjisnap.domain.vo.GalleryVO;
import com.example.doongjisnap.domain.vo.Criteria;
import com.example.doongjisnap.mapper.GalleryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RequiredArgsConstructor
public class GalleryDAO {
    private final GalleryMapper galleryMapper;
    //  추가
    public void save(GalleryDTO galleryDTO) {galleryMapper.insert(galleryDTO);};
    //  수정
    public void setBoardVO(GalleryDTO galleryDTO) {
        galleryMapper.update(galleryDTO);
    };
    //  삭제
    public void remove(Long boardNumber) {
        galleryMapper.delete(boardNumber);
    };
    //  조회
    public GalleryVO findById(Long boardNumber) {
        return galleryMapper.select(boardNumber);
    };
    //  전체조회
    public List<GalleryVO> findAll(Criteria criteria) {
        return galleryMapper.selectAll(criteria);
    };
    //  전체 개수
    public int findCountAll() {
        return galleryMapper.getTotal();
    }
}
