package com.xicheng.es.dao;

import com.xicheng.es.entity.Customer;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author xichengxml
 * @date 2019/2/26 16:43
 */
public interface CustomerRepository extends ElasticsearchRepository<Customer, String> {

    /**
     * 名字起成finByFirstName会报错
     * @param firstName
     * @return
     */
    Customer findByFirstName(String firstName);

    List<Customer> findByLastName(String lastName);
}
