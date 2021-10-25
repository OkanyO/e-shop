package com.ecommerce.shop.data.repository;

import com.ecommerce.shop.data.model.Currency;
import com.ecommerce.shop.data.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.bind.annotation.GetMapping;


import javax.transaction.Transactional;
import java.util.List;

import static com.ecommerce.shop.data.model.Currency.NGN;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Slf4j
@Sql(scripts = {"/db/insert.sql"})
class ProductRepositoryTest {
    @Autowired
    ProductRepository productRepositoryImpl;

    @BeforeEach
    void setUp() {
    }
    @Test
    public void createProductTest(){
        Product product = new Product();
        product.setName("Nuel Sofa");
        product.setPrice(4000.0);
        product.setCurrency(Currency.NGN);
        product.setDetails("the main body of matter in a manuscript, book, newspaper, etc., as distinguished from notes, appendixes, headings, illustrations, etc.\n" +
                "the original words of an author or speaker, as opposed to a translation, paraphrase, commentary, or the like: The newspaper published the whole text of the speech.\n" +
                "the actual wording of anything written or printed: You have not kept to the text of my remarks.");

        assertThat(product).isNotNull();
        assertThat(product.getId()).isNull();
        log.info("Product before saving ->{}", product);
    productRepositoryImpl.save(product);
    assertThat(product.getId()).isNotNull();
    log.info("Product after saving ->{}",product);
    }
    @Test
    @Transactional
    public void whenFindAllProductIsCalledThenProductListIsReturnedTest(){
        List<Product> product = productRepositoryImpl.findAll();
        assertThat(product).hasSize(4);
        log.info("Product returned from database ->{}",product);
    }
    @Test
    public void findExistingProductById(){
        Product existingProduct =
                productRepositoryImpl.findById(110l).orElse(null);
        assertThat(existingProduct).isNotNull();
        log.info("Product -> {}", existingProduct);
    }
    @Test
    public void deleteExistingProduct(){
        assertThat(productRepositoryImpl.findById(110l).orElse(null)).isNotNull();
        productRepositoryImpl.deleteById(110l);
        assertThat(productRepositoryImpl.findById(110l).orElse(null)).isNull();
    }
}