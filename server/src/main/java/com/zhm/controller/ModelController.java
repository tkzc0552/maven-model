package com.zhm.controller;

import com.zhm.dto.Result;
import com.zhm.entity.Model;
import com.zhm.jpa.essential.domain.PageableFactory;
import com.zhm.jpa.essential.jpa.search.DynamicSpecifications;
import com.zhm.jpa.essential.jpa.search.Operator;
import com.zhm.jpa.essential.jpa.search.SearchFilter;
import com.zhm.server.Servlets;
import com.zhm.service.ModelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "这是一个模拟的例子，比较全面")
@RestController
@RequestMapping(value = "model")
public class ModelController {
    @Autowired
    private ModelService modelService;

    @ApiOperation(value = "分页查询",notes = "分页查询",httpMethod = "GET")
    @RequestMapping(name = "分页查询", value = {""}, method = RequestMethod.GET)
    public Page<Model> pageForList(WebRequest request, Pageable pageable)throws Exception {
        Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
        Collection<SearchFilter> filters = SearchFilter.parse(searchParams);
        SearchFilter.addFilter(filters, SearchFilter.build("deleteFlag", Operator.EQ, 0));
        Specification<Model> specification = DynamicSpecifications.bySearchFilter(filters);
        pageable = PageableFactory.create(pageable, "createTime", Sort.Direction.DESC);
        Page<Model> page = modelService.findPage(specification, pageable);
        return page;
    }

    /**
     *
     *  不分页查询
     * @param
     * @return
     */
    @ApiOperation(value = "不分页查询",notes = "不分页查询",httpMethod = "GET")
    @RequestMapping(name = "不分页查询", value = {"/queryList/{name}"}, method = RequestMethod.GET)
    public Result queryForList(@PathVariable String name)throws Exception {
        try{
            Map<String, Object> searchParams = new HashMap<>();
            Collection<SearchFilter> filters = SearchFilter.parse(searchParams);
            if(name!=null){
                SearchFilter.addFilter(filters, SearchFilter.build("name", Operator.EQ,name ));
            }
            SearchFilter.addFilter(filters, SearchFilter.build("deleteFlag", Operator.EQ, 0));
            Specification<Model> specification = DynamicSpecifications.bySearchFilter(filters);
            List<Model> plist = modelService.findAll(specification);
            return Result.sendSuccess("查询成功！",plist);
        }catch (Exception e){
            return Result.sendFailure("查询异常");
        }
    }

    /**
     * 新增/修改
     *
     * @param model
     * @retu rn
     */
    @ApiOperation(value = "新增/修改",notes = "新增/修改",httpMethod = "POST")
    @RequestMapping(name = "新增/修改", value = {""}, method = RequestMethod.POST)
    public Result add(@RequestBody Model model) throws Exception {
        return  modelService.add(model);
    }
}
