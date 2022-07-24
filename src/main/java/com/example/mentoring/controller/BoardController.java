package com.example.mentoring.controller;

import com.example.mentoring.entity.Board;
import com.example.mentoring.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    // 전체 게시물 조회
    @GetMapping("/boards")
    public ResponseEntity<?> getBoards() {
        return new ResponseEntity<>(boardService.getBoards(), HttpStatus.OK);
    }

    // 단건 게시글 조회
    @GetMapping("/boards/{id}")
    public ResponseEntity<?> getBoard(@PathVariable("id") Long id) {
        return new ResponseEntity<>(boardService.getBoard(id), HttpStatus.OK);
    }

    // POST 게시글 작성
    @PostMapping("/boards")
    public ResponseEntity<?> save(@RequestBody Board board) {
        return new ResponseEntity<>(boardService.save(board), HttpStatus.CREATED);
    }


    // PUT 게시글 수정
    @PutMapping("/boards/{id}")
    public ResponseEntity<?> editBoard(@PathVariable("id") Long id, @RequestBody Board updateBoard) {
        return new ResponseEntity<>(boardService.editBoard(id, updateBoard), HttpStatus.OK);
    }


    // DELETE 게시글 삭제
    @DeleteMapping("/boards/{id}")
    public ResponseEntity<?> deleteBoard(@PathVariable("id") Long id) {
        boardService.deleteBoard(id);
        return new ResponseEntity<>("삭제 완료", HttpStatus.OK);
    }
}
