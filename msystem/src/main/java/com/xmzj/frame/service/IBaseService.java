/**
 * Simple to Introduction
 *
 * @ProjectName: [PeakeCloud]
 * @Package: [com.poobo.frame.service.IBaseService.java]
 * @ClassName: [IBaseService]
 * @Description: [一句话描述该类的功能]
 * @Author: [lei.ma]
 * @CreateDate: [2016年6月1日 下午7:26:24]
 * @UpdateUser: [RayMa]
 * @UpdateDate: [2016年6月1日 下午7:26:24]
 * @UpdateRemark: [说明本次修改内容]
 * @Version: [v1.0]
 */
package com.xmzj.frame.service;

import java.io.Serializable;
import java.util.List;
import com.xmzj.common.util.PageController;

/**
 * @author lei.ma 2016年6月1日 下午7:26:24
 *
 */
public interface IBaseService<T, ID extends Serializable> {
    void setBaseMapper();

    int countByExample(T example);

    int deleteByExample(T example);

    int deleteByPrimaryKey(String pkGlobalId);

    int insert(T record);

    int insertSelective(T record);

    List<T> selectByExampleWithBLOBs(T example);

    List<T> selectByExample(T example);

    T selectByPrimaryKey(String pkGlobalId);


    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKeyWithBLOBs(T record);

    int updateByPrimaryKey(T record);

    List<T> findAll();

    PageController<T> getPageList(T record, Integer pageSize, Integer pageNow);


    List<T> findByParams(T record);



    T findObjectByParams(T record);

    /**
     * 分页获取列表（直接传行号）
     * @param record
     * @param pageSize
     * @param rowIndex
     * @return
     */
    public List<T> getRowList(T record, Integer pageSize, Integer rowIndex);
}
