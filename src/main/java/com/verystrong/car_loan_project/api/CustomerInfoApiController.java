package com.verystrong.car_loan_project.api;

import com.verystrong.car_loan_project.domain.CustomerInfo;
import com.verystrong.car_loan_project.dto.CustomerInfoDto;
import com.verystrong.car_loan_project.exception.BaseException;
import com.verystrong.car_loan_project.exception.ResultType;
import com.verystrong.car_loan_project.repository.CustomerInfoRepository;
import com.verystrong.car_loan_project.service.CustomerInfoService;
import com.verystrong.car_loan_project.service.JwtService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

@Slf4j
@RestController
public class CustomerInfoApiController {

    @Autowired
    private CustomerInfoService customerInfoService;

    @Autowired
    private JwtService jwtService;

    @GetMapping("/api/info")
    public ResponseEntity<Map<String, Object>> getItems() throws IllegalAccessException {
        Map<String, Object> items = new HashMap<>();

        for (Field field : CustomerInfo.class.getDeclaredFields()) {
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

    @PostMapping("/api/info/register")
    public ResponseEntity<CustomerInfoDto> create(@RequestBody CustomerInfoDto dto,
                                                  @CookieValue(value="token", required = false) String token)
    {
        if(!jwtService.isValid(token))
        {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        String accountId=jwtService.getId(token);


        CustomerInfoDto saved = customerInfoService.create(dto,accountId);
        log.info("Created customerInfo: {}", saved);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/api/info/{accountId}")
    public ResponseEntity<CustomerInfoDto> get(@CookieValue(value="token", required = false) String token)
    {
        String accountId=jwtService.getId(token);
        log.info("[api] show customerInfo"+accountId);

        CustomerInfoDto customerInfo = customerInfoService.get(accountId);
        return new ResponseEntity<>(customerInfo, HttpStatus.OK);
    }

    @PutMapping("/api/info/{accountId}")
    public ResponseEntity<Object> update(@RequestBody CustomerInfoDto dto,
                                         @CookieValue(value="token", required = false) String token)
    {
        String accountId=jwtService.getId(token);
        CustomerInfoDto updated = customerInfoService.update(dto, accountId);
        // 3. 잘못된 요청 처리하기
        if (updated == null || (!Objects.equals(accountId, updated.getAccount()))){
            log.info("잘못된 요청 id {} customerInfo{} ", accountId,updated);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        //4. 업데이트 및 정상 응답(200)하기
        return new ResponseEntity<>(updated, HttpStatus.OK);

    }

    @DeleteMapping("/api/info/{customerId}")
    public ResponseEntity<CustomerInfo> delete(@CookieValue(value="token", required = false) String token) {
        String accountId=jwtService.getId(token);
        //1. 대상 찾기
        CustomerInfoDto target = customerInfoService.get(accountId);
        //2. 잘못된 요청 처리하기
        if(target == null) {
            log.error("Invalid request for id {}", accountId);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        //대상 삭제
        customerInfoService.delete(accountId);
        log.info("Deleted customerInfo with id {}", accountId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

}
