package com.controller;

import com.pojo.Brand;
import com.pojo.PageBean;
import com.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Create by LCX on 1/26/2022 10:34 PM
 */
@RestController
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 分页条件查询
     * @param currentPage
     * @param pageSize
     * @param brand
     * @return
     */

    @RequestMapping(value = "/brand/{currentPage}/{pageSize}",method = RequestMethod.POST)
//    @ResponseBody()
    public PageBean<Brand> selectByPageAndCondition(@PathVariable("currentPage") int currentPage, @PathVariable("pageSize") int pageSize,@RequestBody Brand brand){
        System.out.println(brand);
        PageBean<Brand> brandPageBean = brandService.selectByPageAndCondition(currentPage, pageSize,brand);

        return brandPageBean;
    }

    /**
     *批量删除
     * @param ids
     * @return
     */
    @RequestMapping(value = "/brand",method = RequestMethod.DELETE)
//    @ResponseBody
    public String deleteBrands(@RequestBody int[] ids){
        brandService.deleteByIds(ids);
        return "success";
    }
    /**
     * 删一个
     * @param id
     * @return
     */
    @RequestMapping(value = "/brand/{id}",method = RequestMethod.DELETE)
//    @ResponseBody
    public String deleteById(@PathVariable("id") int id){
        brandService.deleteById(id);
        return "success";
    }

    /**
     * 添加
     * @param brand
     * @return
     */
    @RequestMapping(value = "/brand",method = RequestMethod.POST)
//    @ResponseBody
    public String addBrand(@RequestBody Brand brand){
        brandService.add(brand);
        return "success";
    }

    /**
     * 修改
     * @param brand
     * @return
     */
    @RequestMapping(value = "/brand",method = RequestMethod.PUT)
//    @ResponseBody
    public String updateBrand(@RequestBody Brand brand){
        brandService.update(brand);
        return "success";
    }
}
