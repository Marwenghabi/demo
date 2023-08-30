package com.example.demo.service;

import com.example.demo.entity.Winner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface WinnerService {

    Page<Winner> getAllWinners(Pageable pageable);

    Winner getWinnerById(Long id);

    String addWinner(Winner winner);

    String updateWinner(Long id, Winner winner);

    String deleteWinner(Long id);
}
