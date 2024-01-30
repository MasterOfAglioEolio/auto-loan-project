package com.verystrong.car_loan_project.controller;

import com.verystrong.car_loan_project.dto.EntryDto;
import com.verystrong.car_loan_project.service.EntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/internal/applications") //사후처리에 대한 관리는 내부 임직원이한다는 가정하에 컨트롤러를 internal로 뺌
public class InternalController { // 대출 집행
    @Autowired private final EntryService entryService;
    @PostMapping("{applicationId}/entries")
    public String create(@PathVariable Long applicationId, @RequestBody EntryDto dto) {
        entryService.create(applicationId, dto);
        return "entry/";
    }

    @PutMapping("{applicationId}/entries")
    public String update(@PathVariable Long applicationId, @RequestBody EntryDto dto) {
        entryService.update(applicationId, dto);
//        return ok(entryService.update(applicationId, request));
        return "entry/";
    }

    @GetMapping("/{applicationId}/entries")
    public String get(@PathVariable Long applicationId) {
        entryService.get(applicationId);
//        return ok(entryService.get(applicationId));
        return "entry/";
    }

    @DeleteMapping("/{applicationId}/entries")
    public String delete(@PathVariable Long applicationId) {
        entryService.delete(applicationId);
//        return ok();
        return "entry/";
    }
}
