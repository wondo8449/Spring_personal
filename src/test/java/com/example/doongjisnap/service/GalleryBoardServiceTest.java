package com.example.doongjisnap.service;

import com.example.doongjisnap.domain.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class GalleryBoardServiceTest {

    @Autowired
    private GalleryService galleryService;

    @Test
    public void registerTest() {
        GalleryDTO galleryDTO = new GalleryDTO();
        FileVO fileVO1 = new FileVO();
        FileVO fileVO2 = new FileVO();

        fileVO1.create("파일이름1", "2024/04/05", UUID.randomUUID().toString(), true);
        fileVO2.create("파일이름2", "2024/04/04", UUID.randomUUID().toString(), false);

        List<FileVO> files = new ArrayList<>(Arrays.asList(fileVO1, fileVO2));
        galleryDTO.create("첨부파일 테스트", "김예찬", "Mapper 테스트 컨텐츠");
        galleryDTO.setFiles(files);

        galleryService.register(galleryDTO);
    }

    @Test
    public void showTest() {
        log.info("board : " + galleryService.show(1L));
    }

    @Test
    public void modifyTest() {
        GalleryDTO galleryDTO = galleryService.show(3L);
        galleryDTO.setBoardTitle("서비스 단테");
        galleryService.modify(galleryDTO);
    }

    @Test
    public void showAllTest() {
        galleryService.showAll(new Criteria().create(1, 10)).stream().map(GalleryVO::getBoardTitle).forEach(log::info);
    }
}