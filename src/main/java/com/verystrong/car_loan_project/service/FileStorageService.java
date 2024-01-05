package com.verystrong.car_loan_project.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface FileStorageService {

    void save(Long applicationId, MultipartFile file);

    Resource load(Long applicationId, String file);

    void deleteAll(Long applicationId);

    Stream<Path> loadAll(Long applicationId);
}
