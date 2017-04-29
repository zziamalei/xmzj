/**
 * Simple to Introduction
 *
 * @ProjectName: [PeakeCloud]
 * @Package: [com.poobo.frame.mapper.BaseMapper.java]
 * @ClassName: [BaseMapper]
 * @Description: [一句话描述该类的功能]
 * @Author: [lei.ma]
 * @CreateDate: [2016年6月1日 下午7:21:54]
 * @UpdateUser: [RayMa]
 * @UpdateDate: [2016年6月1日 下午7:21:54]
 * @UpdateRemark: [说明本次修改内容]
 * @Version: [v1.0]
 */
package com.xmzj.frame.mapper;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @author lei.ma 2016年6月1日 下午7:21:54
 */
public interface BaseMapper<T, ID extends Serializable> {

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

    Integer totalCount(T record);

    List<T> pageList(@Param("obj") T obj, @Param("size") int size, @Param("rowIndex") int rowIndex);

    List<T> findByParams(T record);

    T findObjectByParams(T record);

    List<T> getRowList(@Param("record") T obj, @Param("pageSize") Integer pageSize, @Param("rowIndex") Integer rowIndex);
}
