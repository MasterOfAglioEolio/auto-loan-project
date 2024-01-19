package com.verystrong.car_loan_project.service;

import com.verystrong.car_loan_project.domain.Entry;
import com.verystrong.car_loan_project.dto.EntryDto;

public interface EntryService {

    Entry create(Long applicationId, EntryDto dto);
    Entry get(Long applicationId);
    Entry update(Long entryId, EntryDto dto);
    void delete(Long entryId);


}
