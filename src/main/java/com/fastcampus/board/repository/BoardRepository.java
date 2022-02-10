package com.fastcampus.board.repository;

import com.fastcampus.board.domain.Board;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Long> {

}
