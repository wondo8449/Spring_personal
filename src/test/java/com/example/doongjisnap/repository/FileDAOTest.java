package com.example.doongjisnap.repository;

import com.example.doongjisnap.domain.vo.BoardVO;
import com.example.doongjisnap.domain.vo.FileVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@SpringBootTest
class FileDAOTest {

    @Autowired
    private FileDAO fileDAO;

    @Test
    public void saveTest() {
        FileVO fileVO = new FileVO();
        fileVO.create("DAO Test", "김예찬", "UUID", true, 3L);
        fileDAO.save(fileVO);
    }
}