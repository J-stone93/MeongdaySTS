package com.example.MeongdaySTS.product.service;

import com.example.MeongdaySTS.product.dto.ProductDTO;
import com.example.MeongdaySTS.product.entity.Product;
import com.example.MeongdaySTS.product.repository.ProductRepository;
import com.example.MeongdaySTS.product.util.ProductFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service    //서비스 클래스로 지정
public class
ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository repository;

    @Autowired
    private ProductFileUtil fileUtil;

    @Override
    public int register(ProductDTO dto) {
        Product entity = dtoToEntity(dto);

        List<String> imgPaths = new ArrayList<>();
        for (MultipartFile file : dto.getUploadFile()) {
            String imgPath = fileUtil.fileUpload(file);
            imgPaths.add(imgPath);
        }

        entity.setImgPaths(imgPaths); // 리스트로 필드를 추가하거나 연결 테이블에 저장

        repository.save(entity);
        return entity.getProductNo();
    }
    @Override
    public List<ProductDTO> getList() {
        List<Product> result = repository.findAll();
        List<ProductDTO> dtoList = new ArrayList<>();
        dtoList = result.stream()   //리스트에서 스트림 생성
                .map(this::entityToDto) //중간연산에서 entity를 dto로 변환
                .collect(Collectors.toList());  //최종연산 결과 리스트를 반환

        return dtoList;
    }

    @Override
    public ProductDTO read(int productNo) {
        Optional<Product> result = repository.findById(productNo);
        if (result.isPresent()) {
            Product product = result.get();
//            ProductDTO productDTO = entityToDto(product);
//            return productDTO;
            return entityToDto(product);
        } else {
            return null;
        }
    }

    @Override
    public void modify(ProductDTO dto) {
        Optional<Product> result = repository.findById(dto.getProductNo());  //옵셔널데이터확인이유 : 동시성 이슈

        if (result.isPresent()) {
            Product product = result.get();
            product.setProductName(dto.getProductName());
            product.setProductPrice(dto.getProductPrice());
//            product.setProductThembnail(dto.getProductThembnail());
            product.setImgPaths(dto.getImgPath());
            product.setProductCategory(dto.getProductCategory());

            repository.save(product);
        }
    }

    @Override
    public int remove(int productNo) {
        Optional<Product> result = repository.findById(productNo);
        if (result.isPresent()) {
            repository.deleteById(productNo);
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public List<ProductDTO> getByCategory(String productCategory) {
        // findByProductCategory() : 프로덕트리포지토리에서 만든 추상메소드사용
        List<Product> products = repository.findByProductCategory(productCategory);

        // stream().map(e -> entityToDto(e)).collect(Collectors.toList()); 같은코드
        return products.stream().map(this::entityToDto).collect(Collectors.toList());
    }
}
