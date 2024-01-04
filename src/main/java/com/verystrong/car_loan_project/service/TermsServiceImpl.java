package com.verystrong.car_loan_project.service;

import com.verystrong.car_loan_project.domain.Terms;
import com.verystrong.car_loan_project.dto.TermsDto;
import com.verystrong.car_loan_project.repository.TermsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class TermsServiceImpl implements TermsService{
    private final TermsRepository termsRepository;

    private final ModelMapper modelMapper;
    @Override
    public Terms create(TermsDto dto) {

        Terms terms = dto.toEntity();
        return termsRepository.save(terms);
    }

    @Override
    public List<Terms> getAll() {
        List<Terms> termsList = termsRepository.findAll();
        return termsList.stream().collect(Collectors.toList());
    }
}
