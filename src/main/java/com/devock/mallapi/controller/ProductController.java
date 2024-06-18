package com.devock.mallapi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.devock.mallapi.dto.PageRequestDTO;
import com.devock.mallapi.dto.PageResponseDTO;
import com.devock.mallapi.dto.ProductDTO;
import com.devock.mallapi.service.ProductService;
import com.devock.mallapi.service.TodoService;
import com.devock.mallapi.util.CustomFileUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService; // ProductServcie 주입
    private final CustomFileUtil fileUtil;

    private final TodoService service;

    /*
     * @PostMapping("/")
     * public Map<String, String> register(ProductDTO productDTO) {
     * 
     * log.info("rgister: " + productDTO);
     * 
     * List<MultipartFile> files = productDTO.getFiles();
     * 
     * List<String> uploadFileNames = fileUtil.saveFiles(files);
     * 
     * productDTO.setUploadFileNames(uploadFileNames);
     * 
     * log.info(uploadFileNames);
     * 
     * return Map.of("RESULT", "SUCCESS");
     * }
     */

    @GetMapping("/")
    public String viewTest() {

        return "viewTest";
    }

    @GetMapping("/view/{fileName}")
    public ResponseEntity<Resource> viewFileGET(@PathVariable String fileName) {
        log.info("fileName: " + fileName);

        return fileUtil.getFile(fileName);
    }

    @GetMapping("/list")
    public PageResponseDTO<ProductDTO> list(PageRequestDTO pageRequestDTO) {
        log.info("list............." + pageRequestDTO);
        return productService.getList(pageRequestDTO);
    }

    @PostMapping("/")
    public Map<String, Long> register(ProductDTO productDTO) {
        log.info("rgister: " + productDTO);

        List<MultipartFile> files = productDTO.getFiles();
        List<String> uploadFileNames = fileUtil.saveFiles(files);
        productDTO.setUploadFileNames(uploadFileNames);

        log.info(uploadFileNames);

        // 서비스 호출
        Long pno = productService.register(productDTO);
        return Map.of("RESULT", pno);
    }

    @GetMapping("/{pno}")
    public ProductDTO read(@PathVariable(name = "pno") Long tno) {
        return productService.get(tno);
    }
}
