package com.example.doongjisnap.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class FileVO {
    private Long fileNumber;
    private String fileName;
    private String fileUploadPath;
    private String fileUuid;
    private boolean fileImageCheck;
    private Long fileSize;
    private Long boardNumber;

    public void create(String fileName, String fileUploadPath, String fileUuid, boolean fileImageCheck, Long boardNumber) {
        this.fileName = fileName;
        this.fileUploadPath = fileUploadPath;
        this.fileUuid = fileUuid;
        this.fileImageCheck = fileImageCheck;
        this.boardNumber = boardNumber;
    }

    public void create(String fileName, String fileUploadPath, String fileUuid, boolean fileImageCheck) {
        this.fileName = fileName;
        this.fileUploadPath = fileUploadPath;
        this.fileUuid = fileUuid;
        this.fileImageCheck = fileImageCheck;
    }
}
