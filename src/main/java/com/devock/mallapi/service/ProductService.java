package com.devock.mallapi.service;

import org.springframework.transaction.annotation.Transactional;

import com.devock.mallapi.dto.PageRequestDTO;
import com.devock.mallapi.dto.PageResponseDTO;
import com.devock.mallapi.dto.ProductDTO;

@Transactional
public interface ProductService {

    public PageResponseDTO<ProductDTO> getList(PageRequestDTO pageRequestDTO);

    Long register(ProductDTO productDTO);

    ProductDTO get(Long pno);
}
