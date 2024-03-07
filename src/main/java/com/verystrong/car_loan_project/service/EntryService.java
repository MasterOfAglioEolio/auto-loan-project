package com.verystrong.car_loan_project.service;

import com.verystrong.car_loan_project.domain.Entry;
import com.verystrong.car_loan_project.dto.EntryDto;

public interface EntryService {

    EntryDto create(Long applicationId, EntryDto dto,String accountId);
    EntryDto get(Long applicationId,String accountId);
    EntryDto update(Long entryId, EntryDto dto,String accountId);
    void delete(Long entryId);


}
