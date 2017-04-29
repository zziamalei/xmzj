/**
 * Simple to Introduction
 *
 * @ProjectName: [PeakeCloud]
 * @Package: [com.poobo.frame.service.AbstractBaseService.java]
 * @ClassName: [AbstractBaseService]
 * @Description: [一句话描述该类的功能]
 * @Author: [lei.ma]
 * @CreateDate: [2016年6月1日 下午7:27:39]
 * @UpdateUser: [RayMa]
 * @UpdateDate: [2016年6月1日 下午7:27:39]
 * @UpdateRemark: [说明本次修改内容]
 * @Version: [v1.0]
 */
package com.xmzj.frame.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import com.xmzj.common.ConstantKey;
import com.xmzj.common.util.PageController;
import com.xmzj.frame.mapper.BaseMapper;
import com.xmzj.frame.service.IBaseService;
import org.springframework.beans.factory.annotation.Value;


/**
 * @author lei.ma 2016年6月1日 下午7:27:39
 */
public abstract class AbstractBaseService<T, ID extends Serializable> implements IBaseService<T, ID> {


    /**
     * 项目地址
     */
    @Value("#{configProperties['basePath']}")
    public String basePath;


    @Resource
    private BaseMapper<T, ID> baseMapper;

    public void setBaseMapper(BaseMapper<T, ID> baseMapper) {
        this.baseMapper = baseMapper;
    }

    public void setBaseMapper() {
        this.baseMapper = baseMapper;
    }

    /*
         * (non-Javadoc)
         *
         * @see com.poobo.frame.service.IBaseService#countByExample(com.model.
         * TblAdExample)
         */
    public int countByExample(T example) {
        return baseMapper.countByExample(example);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.poobo.frame.service.IBaseService#deleteByExample(com.model.
     * TblAdExample)
     */
    public int deleteByExample(T example) {
        return baseMapper.deleteByExample(example);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.poobo.frame.service.IBaseService#deleteByPrimaryKey(java.lang.String)
     */
    public int deleteByPrimaryKey(String pkGlobalId) {
        return baseMapper.deleteByPrimaryKey(pkGlobalId);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.poobo.frame.service.IBaseService#insert(com.model.TblAd)
     */
    public int insert(T record) {
        return baseMapper.insert(record);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.poobo.frame.service.IBaseService#insertSelective(com.model.TblAd)
     */
    public int insertSelective(T record) {
        return baseMapper.insertSelective(record);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.poobo.frame.service.IBaseService#selectByExampleWithBLOBs(com.model.
     * TblAdExample)
     */
    public List<T> selectByExampleWithBLOBs(T example) {
        return baseMapper.selectByExampleWithBLOBs(example);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.poobo.frame.service.IBaseService#selectByExample(com.model.
     * TblAdExample)
     */
    public List<T> selectByExample(T example) {
        return baseMapper.selectByExample(example);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.poobo.frame.service.IBaseService#selectByPrimaryKey(java.lang.String)
     */
    public T selectByPrimaryKey(String pkGlobalId) {
        return baseMapper.selectByPrimaryKey(pkGlobalId);
    }


    /*
     * (non-Javadoc)
     *
     * @see
     * com.poobo.frame.service.IBaseService#updateByPrimaryKeySelective(com.
     * model.TblAd)
     */
    public int updateByPrimaryKeySelective(T record) {
        return baseMapper.updateByPrimaryKeySelective(record);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.poobo.frame.service.IBaseService#updateByPrimaryKeyWithBLOBs(com.
     * model.TblAd)
     */
    public int updateByPrimaryKeyWithBLOBs(T record) {
        return baseMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.poobo.frame.service.IBaseService#updateByPrimaryKey(com.model.TblAd)
     */
    public int updateByPrimaryKey(T record) {
        return baseMapper.updateByPrimaryKey(record);
    }

    public List<T> findAll() {
        return baseMapper.findAll();
    }

    public PageController<T> getPageList(T record, Integer pageSize, Integer pageNow) {
        int totalCount = baseMapper.totalCount(record);
        if (null == pageSize) {
            pageSize = ConstantKey.DEFAULT_PAGE_SIZE;
        }
        if (null == pageNow) {
            pageNow = 1;
        }
        PageController<T> page = new PageController<T>(totalCount, pageSize, pageNow);
        if (totalCount > 0) {
            List<T> list = baseMapper.pageList(record, pageSize, (pageNow - 1) * pageSize);
            page.setDataList(list);
        }

        return page;
    }

    public List<T> findByParams(T record) {
        return baseMapper.findByParams(record);
    }


    public T findObjectByParams(T record) {
        return baseMapper.findObjectByParams(record);
    }


    public List<T> getRowList(T record, Integer pageSize, Integer rowIndex) {
        if (null == pageSize) {
            pageSize = ConstantKey.DEFAULT_PAGE_SIZE;
        }
        if (null == rowIndex) {
            rowIndex = 0;
        }
        return baseMapper.getRowList(record, pageSize, rowIndex);
    }


}
