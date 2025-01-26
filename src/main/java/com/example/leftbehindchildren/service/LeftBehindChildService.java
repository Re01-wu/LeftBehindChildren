package com.example.leftbehindchildren.service;

import com.example.leftbehindchildren.entity.LeftBehindChild;
import java.util.List;

public interface LeftBehindChildService {
    // 创建留守儿童信息
    LeftBehindChild createChild(LeftBehindChild child);

    // 更新留守儿童信息
    LeftBehindChild updateChild(Long id, LeftBehindChild child);

    // 获取所有留守儿童信息
    List<LeftBehindChild> getAllChildren();

    // 根据ID获取留守儿童信息
    LeftBehindChild getChildById(Long id);

    // 根据身份证号获取留守儿童信息
    LeftBehindChild getChildByIdNumber(String idNumber);

    // 删除留守儿童信息
    void deleteChild(Long id);

    // 根据学校查询留守儿童
    List<LeftBehindChild> getChildrenBySchool(String school);

    // 根据状态查询留守儿童
    List<LeftBehindChild> getChildrenByStatus(String status);
}
