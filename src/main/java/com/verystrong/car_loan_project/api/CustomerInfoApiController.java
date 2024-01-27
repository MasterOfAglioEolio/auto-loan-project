package com.verystrong.car_loan_project.api;

import com.verystrong.car_loan_project.domain.CustomerInfo;
import com.verystrong.car_loan_project.dto.CustomerInfoDto;
import com.verystrong.car_loan_project.exception.BaseException;
import com.verystrong.car_loan_project.exception.ResultType;
import com.verystrong.car_loan_project.repository.CustomerInfoRepository;
import com.verystrong.car_loan_project.service.CustomerInfoService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class CustomerInfoApiController {

    @Autowired
    private CustomerInfoRepository customerInfoRepository;

    @Autowired
    private CustomerInfoService customerInfoService;

    @Autowired
    private ModelMapper modelMapper;
    @GetMapping("/api/info")
    public Map<String, Object> getItems() throws IllegalAccessException {
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
        return items;
    }

    @PostMapping("/api/register")
    public CustomerInfoDto create(@RequestBody CustomerInfoDto dto)
    {
        return customerInfoService.create(dto);
    }

    @GetMapping("/api/info/{customerId}")
    public CustomerInfoDto show(@PathVariable Long customerId)
    {
        log.info("[api] show customerInfo"+customerId);
        CustomerInfo customerInfo= customerInfoRepository.findById(customerId).orElseThrow(() -> {
            throw new BaseException(ResultType.SYSTEM_ERROR);
        });
        CustomerInfoDto saved = modelMapper.map(customerInfo, CustomerInfoDto.class);
        return saved;
    }

    @PatchMapping("/api/customerinfo/{customerId}")
    public ResponseEntity<Object> update(@PathVariable Long customerId, @RequestBody CustomerInfoDto dto)
    {

        //1.DTO->엔티티 변환하기
        // 2. id 찾기
        CustomerInfoDto saved = customerInfoService.update(dto);
        CustomerInfoDto target = customerInfoService.get(customerId);
        // 3. 잘못된 요청 처리하기
        if (target == null || (customerId != target.getCustomerId())){
            log.info("잘못된 요청 id {} customerInfo{} ", customerId);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        //4. 업데이트 및 정상 응답(200)하기
        target.equals(saved);
        log.info("update OK {}", ResponseEntity.status(HttpStatus.OK).body(saved));
        return ResponseEntity.status(HttpStatus.OK).body(saved);

    }

    @DeleteMapping("/api/customerinfo/{customerId}")
    public ResponseEntity<CustomerInfo> delete(@PathVariable Long customerId) {
        //1. 대상 찾기
        CustomerInfoDto target = customerInfoService.get(customerId);
        //2. 잘못된 요청 처리하기
        if(target == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        //대상 삭제
        customerInfoService.delete(customerId);
        return ResponseEntity.status(HttpStatus.OK).body(null);

    }

}
