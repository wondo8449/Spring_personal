package com.example.doongjisnap.mapper;

import com.example.doongjisnap.domain.vo.BoardVO;
import com.example.doongjisnap.domain.vo.FileVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class FileMapperTest {
    @Autowired
    private FileMapper fileMapper;

    @Test
    public void insertTest() {
        FileVO fileVO = new FileVO();
        fileVO.create("Mapper Test", "2024/04/05", "UUID", true, 3L);
        fileMapper.insert(fileVO);
    }
}