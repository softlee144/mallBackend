package com.devock.mallapi.repository.search;

import java.util.List;
import java.util.Objects;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.devock.mallapi.domain.Product;
import com.devock.mallapi.domain.QProduct;
import com.devock.mallapi.domain.QProductImage;
import com.devock.mallapi.dto.PageRequestDTO;
import com.devock.mallapi.dto.PageResponseDTO;
import com.devock.mallapi.dto.ProductDTO;
import com.querydsl.jpa.JPQLQuery;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ProductSearchImpl extends QuerydslRepositorySupport implements ProductSearch {

    public ProductSearchImpl() {
        super(Product.class);
    }

    @Override
    public PageResponseDTO<ProductDTO> searchList(PageRequestDTO pageRequestDTO) {

        log.info("================================== searchList");

        Pageable pageable = PageRequest.of(
                pageRequestDTO.getPage() - 1,
                pageRequestDTO.getSize(),
                Sort.by("pno").descending());

        QProduct product = QProduct.product;
        QProductImage productImage = QProductImage.productImage;

        // 현재는 from절만 만들어진 상태
        JPQLQuery<Product> query = from(product);
        query.leftJoin(product.imageList, productImage);
        query.where(productImage.ord.eq(0)); // 이미지는 대표 이미지만 표시

        Objects.requireNonNull(getQuerydsl()).applyPagination(pageable, query);

        List<Product> productList = query.fetch();
        long count = query.fetchCount();

        log.info("============================");
        log.info(productList);

        return null;
    }

}
