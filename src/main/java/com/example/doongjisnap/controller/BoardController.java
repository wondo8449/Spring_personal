package com.example.doongjisnap.controller;

import com.example.doongjisnap.aspect.annotation.LogStatus;
import com.example.doongjisnap.domain.vo.BoardVO;
import com.example.doongjisnap.domain.vo.Criteria;
import com.example.doongjisnap.domain.vo.PageDTO;
import com.example.doongjisnap.service.BoardService;
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
@RequestMapping("/faq/*")
public class BoardController {
    private final BoardService boardService;

//  게시글 목록
//    @GetMapping("/list")
//    public void list(Model model){
//        model.addAttribute("boards", boardService.showAll());
//    }

    @LogStatus
    @GetMapping("/list")
    public void list(Criteria criteria, Model model){
        if(criteria.getPage() == 0){
            criteria.create(1, 20);
        }
        model.addAttribute("boards", boardService.showAll(criteria));
        model.addAttribute("pagination", new PageDTO().createPageDTO(criteria, boardService.getTotal()));
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
    @LogStatus
    @GetMapping("/write")
    public void write(Criteria criteria, Model model) {model.addAttribute("board", new BoardVO());
    }

    @LogStatus
    @PostMapping("/write")
    public RedirectView write(BoardVO boardVO, RedirectAttributes redirectAttributes) {
        boardService.register(boardVO);
        redirectAttributes.addFlashAttribute("boardNumber", boardVO.getBoardNumber());
        return new RedirectView("/faq/list");
    }
//  게시글 상세보기
    @LogStatus
    @GetMapping(value = {"/update", "/read"})
    public void read(Long boardNumber, Criteria criteria, Model model) {
        model.addAttribute("board", boardService.show(boardNumber));
    }

//  게시글 수정
    @LogStatus
    @PostMapping ("/update")
    public RedirectView update(BoardVO boardVO, RedirectAttributes redirectAttributes) {
        boardService.modify(boardVO);
        redirectAttributes.addAttribute("boardNumber", boardVO.getBoardNumber());
        return new RedirectView("/faq/read");
    }

//  게시글 삭제
    @LogStatus
    @GetMapping("/delete")
    public RedirectView delete(Long boardNumber) {
        boardService.remove(boardNumber);
        return new RedirectView("/faq/list");
    }
}
