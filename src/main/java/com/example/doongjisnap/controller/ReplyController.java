package com.example.doongjisnap.controller;

import com.example.doongjisnap.domain.vo.Criteria;
import com.example.doongjisnap.domain.vo.ReplyDTO;
import com.example.doongjisnap.domain.vo.ReplyVO;
import com.example.doongjisnap.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reply/*")
public class ReplyController {
    private final ReplyService replyService;

//    write 원본
//    @PostMapping(value = "/new", consumes = "application/json", produces = "text/plain; charset=utf-8")
//    public ResponseEntity<String> write(@RequestBody ReplyVO replyVO) throws UnsupportedEncodingException {
//        replyService.register(replyVO);
//        return new ResponseEntity<>(new String("write success".getBytes(), "UTF-8"), HttpStatus.OK);
//    }

    @PostMapping("/new")
    public String write(@RequestBody ReplyVO replyVO) {
        replyService.register(replyVO);
        return "write success";
    }

    @GetMapping("/list/{boardNumber}/{page}")
    public ReplyDTO list(@PathVariable("boardNumber") Long boardNumber, @PathVariable int page){
        return new ReplyDTO(replyService.showAll(boardNumber, new Criteria().create(page, 5)), replyService.count(boardNumber));
    }

//    실제 기능상 큰 차이는 없지만 부분 수정은 Patch, 전체 수정은 Put 사용. 하지만 실무에서는 Post를 사용
//    @PatchMapping(value = {"/{rno}", "/{rno}/{replyWriter}"})
//    public void modify(@RequestBody ReplyVO replyVO, @PathVariable("rno") Long replyNumber, @PathVariable(value = "replyWriter", required = false) String replyWriter) {
//        replyVO.setReplyNumber(replyNumber);
//        replyVO.setReplyWriter(Optional.ofNullable(replyWriter).orElse(replyService.show(replyNumber).getReplyWriter()));
//        replyService.modify(replyVO);
//    }

    @PostMapping("/modify")
    public void modify(@RequestBody ReplyVO replyVO) {
//      Optional은 JDK8부터 지원되는 검증 클래스이며, ofNullable(Object)로 사용한다
//      ifPresent()를 사용하여 Null 여부 검사가 가능하며, null이 아니라며
        replyVO.setReplyWriter(Optional.ofNullable(replyVO.getReplyWriter()).orElse(replyService.show(replyVO.getReplyNumber()).getReplyWriter()));
        replyService.modify(replyVO);
    }

    @DeleteMapping("/{replyNumber}")
    public void remove(@PathVariable Long replyNumber) {
        replyService.remove(replyNumber);
    }

    @GetMapping("/{replyNumber}")
    public ReplyVO show(@PathVariable Long replyNumber) {
        return replyService.show(replyNumber);
    }
}
