package com.example.mentoring.service;

import com.example.mentoring.entity.Board;
import com.example.mentoring.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public List<Board> getBoards() {
        List<Board> boards = boardRepository.findAll();
        return boards;
    }

    @Transactional(readOnly = true)
    public Board getBoard(Long id) {
        Board board = boardRepository.findById(id).get();
        return board;
    }

    @Transactional
    public Board save(Board board) {
        return boardRepository.save(board);
    }

    @Transactional
    public Board editBoard(Long id, Board updateBoard) {
        // 1. 기존 게시물을 꺼내온다
        Board board = boardRepository.findById(id).get();

        // 2. 기존 게시물에, updateBoard 정보를 덮어씌워준다.
        board.setTitle(updateBoard.getTitle());
        board.setContent(updateBoard.getContent());

        return board;
    }


    @Transactional
    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }

}


