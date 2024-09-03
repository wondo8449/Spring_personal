package com.example.doongjisnap.mapper;

import com.example.doongjisnap.domain.vo.FileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileMapper {
//  파일추가
    public void insert(FileVO fileVO);
//  파일 삭제
    public void delete(Long boardNumber);
//  파일 조회
    public List<FileVO> selectAll(Long boardNumber);
//  지난 날 파일 조회
    public List<FileVO> selectOldFiles();
}
