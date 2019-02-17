package com.merrill.service.impl;

import com.merrill.dao.entity.Step;
import com.merrill.dao.mapper.StepMapper;
import com.merrill.service.IStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: 梅峰鑫
 * Date: 2019-02-15
 * Time: 16:20
 * Description:
 */

@Service
public class StepServiceImpl implements IStepService {
    @Autowired
    private StepMapper stepMapper;

    @Override
    public Step getStepByOptionID(Long id) {
        Long stepID;
        if (id == -1l){
            stepID = stepMapper.getStepMinID();
        } else {
            stepID = stepMapper.getStepIDByOptionID(id);
        }
        Step step = stepMapper.getStepByID(stepID);
        if (step == null){
            step = new Step();
        }
        return step;
    }
}
