package com.service.impl;

import com.mapper.BrandMapper;
import com.pojo.Brand;
import com.pojo.PageBean;
import com.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by LCX on 1/26/2022 10:04 PM
 */
@Service
public class BrandServiceImpl implements BrandService {

    //
    @Autowired
    private BrandMapper brandMapper;

    /**
     * 查询所有品牌
     * @return
     */
    @Override
    public List<Brand> selectAll(){

        return brandMapper.selectAll();
    }

    @Override
    public Brand selectBrandById(int id) {
        return brandMapper.selectBrandById(id);
    }

    /**
     * 添加品牌
     * @param brand
     */
    @Override
    public void add(Brand brand) {
        brandMapper.add(brand);
    }

    /**
     * 修改品牌
     * @param brand
     */
    @Override
    public void update(Brand brand) {

        brandMapper.update(brand);
    }
    /**
     * 批量删除
     * @param ids
     */
    @Override
    public void deleteByIds(int[] ids) {
        brandMapper.deleteByIds(ids);
    }

    /**
     * 根据id删除该品牌
     * @param id
     */
    @Override
    public void deleteById(int id) {
        brandMapper.deleteById(id);
    }

    /**
     * 分页查询
     * @param currentPage 当前页码
     * @param pageSize 每页展示条数
     * @return
     */
    @Override
    public PageBean<Brand> selectByPage(int currentPage, int pageSize) {

        //开始索引
        int begin=(currentPage-1)*pageSize;
        //查询条数
        int size=pageSize;
        //调用分页查询的方法查询当前页品牌集合
        List<Brand> rows = brandMapper.selectByPage(begin, size);
        //当前页品牌的总条数
        int totalCount = brandMapper.selectTotalCount();
        //封装到PageBean对象中
        PageBean<Brand> pageBean=new PageBean<>();
        pageBean.setTotalCount(totalCount);
        pageBean.setRows(rows);

        return pageBean;
    }

    /**
     * 分页条件查询
     * @param currentPage 当前页码
     * @param pageSize 每页展示条数
     * @param brand 查询条件
     * @return
     */
    @Override
    public PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize,Brand brand) {
        //开始索引
        int begin=(currentPage-1)*pageSize;
        //查询条数
        int size=pageSize;
        //处理brand条件
        String brandName=brand.getBrandName();
        if(brandName!=null && brandName.length()>0){
            brand.setBrandName("%"+brandName+"%");
        }
        String companyName=brand.getCompanyName();
        if(companyName!=null && companyName.length()>0){
            brand.setCompanyName("%"+companyName+"%");
        }
        //调用分页查询的方法查询当前页品牌集合
        List<Brand> rows = brandMapper.selectByPageAndCondition(begin, size,brand);
        //当前页品牌的总条数
        int totalCount = brandMapper.selectTotalCountByCondition(brand);
        //封装到PageBean对象中
        PageBean<Brand> pageBean=new PageBean<>();
        pageBean.setTotalCount(totalCount);
        pageBean.setRows(rows);

        return pageBean;
    }
}
