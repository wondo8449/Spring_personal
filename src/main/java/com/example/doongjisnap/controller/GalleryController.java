package com.example.doongjisnap.controller;

import com.example.doongjisnap.domain.vo.*;
import com.example.doongjisnap.service.BoardService;
import com.example.doongjisnap.service.GalleryBoardService;
import com.example.doongjisnap.service.GalleryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/gallery/*")
public class GalleryController {
    private final GalleryService galleryService;

//  게시글 목록
//    @GetMapping("/list")
//    public void list(Model model){
//        model.addAttribute("boards", boardService.showAll());
//    }

    @GetMapping("/list")
    public void list(Criteria criteria, Model model){
        if(criteria.getPage() == 0){
            criteria.create(1, 20);
        }
        model.addAttribute("boards", galleryService.showAll(criteria));
        model.addAttribute("pagination", new PageDTO().createPageDTO(criteria, galleryService.getTotal()));
    }
//    리턴 타입을 void로 작성해도 되지만,
//    다른 컨트롤러에서 getList()를 호출하기 때문에
//    html 경로를 직접 문자열로 작성해야 한다.
//    public String list(Criteria criteria,Model model){
//        if(criteria.getPage() == 0){
//            criteria.create(1, 20);
//        }
//        model.addAttribute("boards", boardService.showAll(criteria));
//        model.addAttribute("pagination", new PageDTO().createPageDTO(criteria, boardService.getTotal()));
//        return "/faq/list";
//    }

    //  게시글 등록
    @GetMapping("/write")
    public void write(Criteria criteria, Model model) {
        model.addAttribute("board", new GalleryVO());
    }

    @PostMapping("/write")
    public RedirectView write(GalleryDTO galleryDTO, RedirectAttributes redirectAttributes) {
        galleryService.register(galleryDTO);
        redirectAttributes.addFlashAttribute("boardNumber", galleryDTO);
        return new RedirectView("/gallery/list");
    }
    //  게시글 상세보기
    @GetMapping(value = {"/update", "/read"})
    public void read(Long boardNumber, Criteria criteria,Model model) {
        model.addAttribute("board", galleryService.show(boardNumber));
    }

    //  게시글 수정
    @PostMapping ("/update")
    public RedirectView update(GalleryDTO galleryDTO, RedirectAttributes redirectAttributes) {
        galleryService.modify(galleryDTO);
        redirectAttributes.addAttribute("boardNumber", galleryDTO.getBoardNumber());
        return new RedirectView("/gallery/read");
    }

    //  게시글 삭제
    @GetMapping("/delete")
    public RedirectView delete(Long boardNumber) {
        galleryService.remove(boardNumber);
        return new RedirectView("/gallery/list");
    }
}

