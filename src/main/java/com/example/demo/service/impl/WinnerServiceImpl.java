package com.example.demo.service.impl;

import com.example.demo.entity.Winner;
import com.example.demo.repository.WinnerRepository;
import com.example.demo.service.WinnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WinnerServiceImpl implements WinnerService {

    private final WinnerRepository winnerRepository;

    @Autowired
    public WinnerServiceImpl(WinnerRepository winnerRepository) {
        this.winnerRepository = winnerRepository;
    }

    @Override
    public Page<Winner> getAllWinners(Pageable pageable) {
        return winnerRepository.findAll(pageable);
    }

    @Override
    public Winner getWinnerById(Long id) {
        return winnerRepository.findById(id).orElse(null);
    }

    @Override
    public String addWinner(Winner winner) {
        winnerRepository.save(winner);
        return "Winner added successfully";
    }

    @Override
    public String updateWinner(Long id, Winner winner) {
        Optional<Winner> existingWinnerOptional = winnerRepository.findById(id);
        if (existingWinnerOptional.isPresent()) {
            Winner existingWinner = existingWinnerOptional.get();
            existingWinner.setPhoneNumber(winner.getPhoneNumber());
            existingWinner.setType(winner.getType());
            // Set other fields as needed
            winnerRepository.save(existingWinner);
            return "Winner updated successfully";
        } else {
            return "Winner not found";
        }
    }

    @Override
    public String deleteWinner(Long id) {
        Optional<Winner> winnerOptional = winnerRepository.findById(id);
        if (winnerOptional.isPresent()) {
            winnerRepository.delete(winnerOptional.get());
            return "Winner deleted successfully";
        } else {
            return "Winner not found";
        }
    }
}
