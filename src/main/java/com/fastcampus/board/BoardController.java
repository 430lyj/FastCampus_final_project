package com.fastcampus.board;

import com.fastcampus.board.domain.Board;
import com.fastcampus.board.dto.PostDto;
import com.fastcampus.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class BoardController {
    // TODO BoardController는 JSP를 이용한 화면 로직과 연결되어 있습니다.
    //  다른 부분은 바꾸지 말고 TODO 부분만 작성해주시기를 권장합니다 :)
    // TODO please write code on only TODO part in BoardController

    private final BoardRepository boardRepository;

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String createPost(@ModelAttribute("command") PostDto postDto){
        /* TODO: 게시물 추가 로직*/
        Board board = new Board();
        board.createPost(postDto.getTitle(), postDto.getNickName(), postDto.getContent(), 0);
        boardRepository.save(board);
        return "redirect:/"; // 추가 후 홈 화면으로
    }

    @RequestMapping("/")
    public String ReadAllPost(Model model){
        /* TODO 게시물 전체를 받아오는 로직 */
        Iterable<Board> boards = boardRepository.findAll();

        List<PostDto> postList = new ArrayList<>();
        for (Board board : boards) {
            postList.add(new PostDto(board.getId(), board.getWriter(), board.getTitle(), board.getContent()));
            board.upCnt();
        }
        boardRepository.saveAll(boards);
        model.addAttribute("postList", postList);
        return "index";
    }

    @RequestMapping(value="/update",method = RequestMethod.POST)
    public String updatePost(@ModelAttribute("command") PostDto postDto){
        System.out.println("update " + postDto);
        /* TODO 게시물 수정 로직 */
        Long postId = postDto.getPostId();
        Optional<Board> board = boardRepository.findById(postId);
        if (board.isPresent()){
            Board realBoard = board.get();
            realBoard.updatePost(postDto.getTitle(), postDto.getNickName(), postDto.getContent());
            realBoard.upCnt();
            boardRepository.save(realBoard);
        }
        return "redirect:/";
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String deletePost(@PathVariable Long id){
        System.out.println("삭제 " + id);
        /* TODO 게시물 삭제 로직 */
        Optional<Board> toBeDeleted = boardRepository.findById(id);
        if (toBeDeleted.isPresent()){
            Board board = toBeDeleted.get();
            boardRepository.delete(board);
        }
        return "redirect:/";
    }

    // ***************************************************************************************************
    // ******************************************* Do not edit *******************************************
    // 아래 부분은 수정 안하셔도 됩니다. (글 생성, 글 업데이트 창으로 연결하는 부분)

    @RequestMapping(value="/createView")
    public String ViewCreate(Model model){
        model.addAttribute("command", new PostDto());
        return "create";
    }

    @RequestMapping(value="/updateView/{id}")
    public String ViewUpdate(@PathVariable Long id, Model model){
        PostDto postDto = new PostDto();
        postDto.setPostId(id);
        model.addAttribute("command",postDto);
        return "update";
    }
}

