package com.example.eregistrardemo.service.impl;

import com.example.eregistrardemo.model.Transcript;
import com.example.eregistrardemo.repository.TranscriptRepository;
import com.example.eregistrardemo.service.TranscriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranscriptServiceImpl implements TranscriptService {

    @Autowired
    private TranscriptRepository transcriptRepository;

    @Override
    public Transcript save(Transcript t) {
        return transcriptRepository.save(t);
    }
}
