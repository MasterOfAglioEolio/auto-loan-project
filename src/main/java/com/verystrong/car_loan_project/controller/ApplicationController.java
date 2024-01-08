package com.verystrong.car_loan_project.controller;

import com.verystrong.car_loan_project.domain.Application;
import com.verystrong.car_loan_project.dto.ApplicationDto;
import com.verystrong.car_loan_project.dto.FileDto;
import com.verystrong.car_loan_project.service.ApplicationService;
import com.verystrong.car_loan_project.service.FileStorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/application")
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private FileStorageService fileStorageService;


    @GetMapping()
    public String choice(){
        return "application/choice";
    }
    @GetMapping("/form")
    public String ApplicationForm(){

        return "application/form";
    }

    @PostMapping("/form")
    public String create(ApplicationDto dto){

        ApplicationDto saved = applicationService.create(dto);
        Long applicationId= saved.getApplicationId();
        log.info("[create Application]:"+saved);
        return "redirect:/application/"+applicationId;
    }

    @GetMapping("/{applicationId}")
    public String get(@PathVariable Long applicationId, Model model)
    {
        ApplicationDto application = applicationService.get(applicationId);
        //2. 모델에 데이터 등록하기
        // application이라는 이름으로 application 객체를 모델에 등록합니다.
        // 이를 통해 application이라는 이름으로 application 객체를 ""뷰""로 전달할 수 있게 됩니다.
        model.addAttribute("application_model", application);
//        log.info("[get Model]:"+model.addAttribute("application_model", application));

        //3. 뷰 페이지 반환하기
        return "application/edit";

    }
    @GetMapping("/{applicationId}/edit")  // TODO: URI에 행위에 대한 동사 표현이 들어가면 안된다(CRUD 기능을 나타내는 것은 URI에 사용하지 않는다.)
    public String edit(@PathVariable Long applicationId, Model model)
    {
        ApplicationDto application = applicationService.get(applicationId);
        //2. 모델에 데이터 등록하기
        model.addAttribute("application", application);
        //3. 뷰페이지 설정하기
        return "application/edit";
    }

    @PostMapping("/update")
    public String update(ApplicationDto dto)
    {

        //3. 리퍼지토리로 엔티티를 DB에 저장

        ApplicationDto saved = applicationService.update(dto);
        return "redirect:/application/"+saved.getApplicationId();
    }

    @GetMapping("/{applicationId}/delete")
    public String delete(@PathVariable Long applicationId, RedirectAttributes rttr)
    {
        applicationService.delete(applicationId);
        rttr.addFlashAttribute("msg","삭제되었습니다.");
        //3. 결과 페이지로 리다이렉트
        return "redirect:/application";

    }

    @PostMapping("/{applicationId}/terms")
    public String acceptTerms(@PathVariable Long applicationId, ApplicationDto.AcceptTerms terms) {
        applicationService.acceptTerms(applicationId, terms);
//         return applicationService.acceptTerms(applicationId, terms);
        return "redirect:/application";
//    }
    }

    @PostMapping("/files")
    public String upload(@PathVariable Long applicationId,MultipartFile file){

        fileStorageService.save(applicationId,file);
        return "redirect:/files";
    }

    @GetMapping("/{applicationId}/files")
    public String download(@PathVariable Long applicationId, @RequestParam(value="filename") String filename) throws IllegalStateException, IOException {
        Resource file = fileStorageService.load(applicationId, filename);
        ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
        return "/files";
    }

    @DeleteMapping("/{applicationId}/files")
    public String deleteAll(@PathVariable Long applicationId) {
        fileStorageService.deleteAll(applicationId);
        return "/files";
    }

    @GetMapping("/{applicationId}/files/infos")
    public String getFileInfos(@PathVariable Long applicationId) {
        List<FileDto> fileInfos = fileStorageService.loadAll(applicationId).map(path -> {
            String fileName= path.getFileName().toString();
            return FileDto.builder()
                    .name(fileName)
                    .url(MvcUriComponentsBuilder.fromMethodName(ApplicationController.class, "download", applicationId, fileName).build().toString()).build();
        }).collect(Collectors.toList());

//        return ok(fileInfos);
        return "/files";
    }

    @PutMapping("/{applicationId}/contract")
    public String contract(@PathVariable Long applicationId) {
//        return ok(applicationService.contract(applicationId));
        applicationService.contract(applicationId);
        return "/contract";
    }

}
