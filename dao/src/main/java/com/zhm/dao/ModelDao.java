package com.zhm.dao;

import com.zhm.entity.Model;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ModelDao extends JpaSpecificationExecutor<Model>,PagingAndSortingRepository<Model,Integer> {
}
