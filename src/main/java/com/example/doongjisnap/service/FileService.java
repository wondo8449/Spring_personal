package com.example.doongjisnap.service;

import com.example.doongjisnap.domain.vo.FileVO;
import com.example.doongjisnap.repository.FileDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FileService {
    private final FileDAO fileDAO;
    public List<FileVO> showOldFiles() {
        return fileDAO.findOldFiles();
    }
}
