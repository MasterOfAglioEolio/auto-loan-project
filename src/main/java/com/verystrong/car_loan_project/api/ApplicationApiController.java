package com.verystrong.car_loan_project.api;

import com.verystrong.car_loan_project.domain.Application;
import com.verystrong.car_loan_project.domain.CustomerInfo;
import com.verystrong.car_loan_project.dto.ApplicationDto;
import com.verystrong.car_loan_project.dto.FileDto;
import com.verystrong.car_loan_project.service.ApplicationService;
import com.verystrong.car_loan_project.service.FileStorageService;
import com.verystrong.car_loan_project.service.JwtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Controller
public class ApplicationApiController {

    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private FileStorageService fileStorageService;
    @Autowired
    private JwtService jwtService;


    @GetMapping("/api/application")
    public ResponseEntity<Map<String, Object>> getItems() throws IllegalAccessException {
        Map<String, Object> items = new HashMap<>();

        for (Field field : Application.class.getDeclaredFields()) {
            String fieldName = field.getName();
            Class<?> fieldType = field.getType();

            // If the field type is an Enum, get all enum constants
            if (fieldType.isEnum()) {
                Object[] enumConstants = fieldType.getEnumConstants();
                List<String> enumValues = new ArrayList<>();
                try {
                    Method method = fieldType.getMethod("getName");
                    for (Object enumConstant : enumConstants) {
                        String value = (String) method.invoke(enumConstant);
                        enumValues.add(value);
                    }
                } catch (NoSuchMethodException | InvocationTargetException e) {
                    // If the getName method is not found, use the name of the enum constant
                    for (Object enumConstant : enumConstants) {
                        enumValues.add(((Enum<?>) enumConstant).name());
                    }
                }
                items.put(fieldName, enumValues);
            } else {
                items.put(fieldName, fieldType.getName());
            }
        }

        log.info("[items] : {}", items);
        return ResponseEntity.ok(items);
    }

    @PostMapping("/api/application/register")
    public ResponseEntity<ApplicationDto> create(@RequestBody ApplicationDto dto,
                                                 @CookieValue(value="token", required = false) String token){
        if(!jwtService.isValid(token))
        {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        String accountId=jwtService.getId(token);

        ApplicationDto saved = applicationService.create(dto, accountId);
        log.info("[create Application]:"+saved);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/api/application/{applicationId}")
    public ResponseEntity<ApplicationDto> get(@PathVariable Long applicationId) {
        ApplicationDto application = applicationService.get(applicationId);
        return new ResponseEntity<>(application, HttpStatus.OK);
    }

    @PostMapping("/api/application/{applicationId}")
    public ResponseEntity<ApplicationDto> update(@PathVariable Long applicationId, @RequestBody ApplicationDto dto) {
        ApplicationDto updated = applicationService.update(dto);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/api/application/{applicationId}")
    public ResponseEntity<Void> delete(@PathVariable Long applicationId) {
        applicationService.delete(applicationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
