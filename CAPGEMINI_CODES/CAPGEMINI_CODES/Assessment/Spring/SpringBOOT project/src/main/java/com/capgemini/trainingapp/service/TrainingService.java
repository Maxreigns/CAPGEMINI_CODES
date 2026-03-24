package com.capgemini.trainingapp.service;

import com.capgemini.trainingapp.entity.Training;
import com.capgemini.trainingapp.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainingService {

    @Autowired
    TrainingRepository repo;

    public List<Training> getCurrentAndUpcoming() {

        LocalDate today = LocalDate.now();

        return repo.findAll()
                .stream()
                .filter(t -> !t.getEndDate().isBefore(today))
                .collect(Collectors.toList());
    }

    public List<Training> searchCurrentAndUpcoming(String name) {

        LocalDate today = LocalDate.now();

        return repo.findByTopicContainingIgnoreCase(name)
                .stream()
                .filter(t -> !t.getEndDate().isBefore(today))
                .collect(Collectors.toList());
    }

    public List<Training> searchUpcoming(String name) {

        LocalDate today = LocalDate.now();

        return repo.findByTopicContainingIgnoreCase(name)
                .stream()
                .filter(t -> t.getStartDate().isAfter(today))
                .collect(Collectors.toList());
    }
}