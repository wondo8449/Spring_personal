package com.example.doongjisnap.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class GalleryDTO {
    private Long boardNumber;
    private String boardTitle;
    private String boardWriter;
    private String boardContent;
    private String boardRegisterDate;
    private String boardUpdateDate;

    private List<FileVO> files;

    public void create(GalleryVO galleryVO) {
        this.boardNumber = galleryVO.getBoardNumber();
        this.boardTitle = galleryVO.getBoardTitle();
        this.boardWriter = galleryVO.getBoardWriter();
        this.boardContent = galleryVO.getBoardContent();
        this.boardRegisterDate = galleryVO.getBoardRegisterDate();
        this.boardUpdateDate = galleryVO.getBoardUpdateDate();
    }

    public void create(String boardTitle, String boardWriter, String boardContent) {
        this.boardTitle = boardTitle;
        this.boardWriter = boardWriter;
        this.boardContent = boardContent;
    }

    public void create(Long boardNumber, String boardTitle, String boardWriter, String boardContent, List<FileVO> files) {
        this.boardNumber = boardNumber;
        this.boardTitle = boardTitle;
        this.boardWriter = boardWriter;
        this.boardContent = boardContent;
        this.files = files;
    }
}
