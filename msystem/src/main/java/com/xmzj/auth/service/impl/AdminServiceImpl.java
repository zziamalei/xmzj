package com.xmzj.auth.service.impl;

import com.xmzj.auth.mapper.TblAdminMapper;
import com.xmzj.auth.model.TblAdmin;
import com.xmzj.auth.service.IAdminService;
import com.xmzj.frame.mapper.BaseMapper;
import com.xmzj.frame.service.impl.AbstractBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by RayMa on 2017/4/29.
 */
@Service
public class AdminServiceImpl extends AbstractBaseService<TblAdmin, String> implements IAdminService {

    @Autowired
    TblAdminMapper mapper;

    @Autowired
    public void setBaseMapper() {
        super.setBaseMapper(mapper);
    }
}
