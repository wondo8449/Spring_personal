package com.example.doongjisnap.service;

import com.example.doongjisnap.domain.vo.Criteria;
import com.example.doongjisnap.domain.vo.FileVO;
import com.example.doongjisnap.domain.vo.GalleryDTO;
import com.example.doongjisnap.domain.vo.GalleryVO;
import com.example.doongjisnap.repository.FileDAO;
import com.example.doongjisnap.repository.GalleryDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor @Qualifier("Gallery") @Primary
public class GalleryBoardService implements GalleryService {

    private final GalleryDAO galleryDAO;
    private final FileDAO fileDAO;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void register(GalleryDTO galleryDTO) {
        galleryDAO.save(galleryDTO);
        List<FileVO> files = galleryDTO.getFiles();

        Optional.ofNullable(files).ifPresent(fileList -> {
            fileList.forEach(file -> {
                file.setBoardNumber(galleryDTO.getBoardNumber());
                fileDAO.save(file);
            });
        });
    }

    @Override
    public void modify(GalleryDTO galleryDTO) {
        galleryDAO.setBoardVO(galleryDTO);
        fileDAO.remove(galleryDTO.getBoardNumber());
        List<FileVO> files = galleryDTO.getFiles();
        Optional.ofNullable(files).ifPresent(fileList -> {
            fileList.forEach(file -> {
                file.setBoardNumber(galleryDTO.getBoardNumber());
                fileDAO.save(file);
            });
        });
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(Long boardNumber) {
        fileDAO.remove(boardNumber);
        galleryDAO.remove(boardNumber);
    }

    @Override
    public GalleryDTO show(Long boardNumber) {
        GalleryDTO galleryDTO = new GalleryDTO();
        galleryDTO.create(galleryDAO.findById(boardNumber));
        galleryDTO.setFiles(fileDAO.findAll(boardNumber));
        return galleryDTO;
    }

    @Override
    public List<GalleryVO> showAll(Criteria criteria) {return galleryDAO.findAll(criteria);}

    @Override
    public int getTotal() {return galleryDAO.findCountAll();}
}
