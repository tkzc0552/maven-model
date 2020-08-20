package com.zhm.service;

import com.zhm.dao.ModelDao;
import com.zhm.dto.Result;
import com.zhm.entity.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;


@Service
public class ModelService {
    @Autowired
    private ModelDao modelDao;

    /**
     * 分页查询
     * @param specification
     * @param pageable
     * @return
     */
    public Page<Model> findPage(Specification<Model> specification, Pageable pageable) {
        return modelDao.findAll(specification, pageable);
    }

    /**
     *排序全域查询
     * @param specification
     * @param sort
     * @return
     */
    public List<Model> findAll(Specification<Model> specification, Sort sort) {
        return modelDao.findAll(specification,sort);
    }

    /**
     * 全域查询
     * @param specification
     * @return
     */
    public List<Model> findAll(Specification<Model> specification) {
        return modelDao.findAll(specification);
    }

    /**
     * 单个查询
     * @param id
     * @return
     */
    public Model findOne(Integer id) {
        return modelDao.findById(id).get();
    }

    /**
     * 新增/编辑
     * @param model
     * @return
     */
    public Result add(Model model){
        try{
            if(model.getId()!=0){
                model.setUpdateTime(new Date());
            }else{
                model.setCreateTime(new Date());
            }
            modelDao.save(model);
            return Result.sendSuccess("新增/编辑成功！");
        }catch (Exception e){
            return  Result.sendFailure("新增失败");
        }


    }


}
