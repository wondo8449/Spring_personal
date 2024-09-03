package com.example.doongjisnap.service;

import com.example.doongjisnap.domain.vo.Criteria;
import com.example.doongjisnap.domain.vo.GalleryDTO;
import com.example.doongjisnap.domain.vo.GalleryVO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface GalleryService {
    public void register(GalleryDTO galleryDTO);
    //  수정
    public void modify(GalleryDTO galleryDTO);
    //  삭제
    public void remove(Long boardNumber);
    //  조회
    public GalleryDTO show(Long boardNumber);
    //  전체조회
    public List<GalleryVO> showAll(Criteria criteria);
    //  전체 개수
    public int getTotal();
}
