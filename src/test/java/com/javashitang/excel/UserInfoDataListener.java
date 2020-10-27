package com.javashitang.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

/**
 * @author lilimin
 * @since 2020-10-19
 */
public class UserInfoDataListener extends AnalysisEventListener<UserInfo> {

    @Override
    public void invoke(UserInfo userInfo, AnalysisContext analysisContext) {
        System.out.println(userInfo);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
