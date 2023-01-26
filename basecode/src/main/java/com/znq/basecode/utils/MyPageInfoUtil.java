package com.znq.basecode.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// import com.github.pagehelper.PageInfo;

public class MyPageInfoUtil {

    // mybatis 分页信息简化
    // public static Map<String, Object> getPageInfoDetail(List list) {
    // PageInfo<?> pageInfo = new PageInfo(list);
    // Map<String, Object> pageInfoMap = new HashMap<>();
    // pageInfoMap.put("list", pageInfo.getList());
    // pageInfoMap.put("pageNum", pageInfo.getPageNum());
    // pageInfoMap.put("pageSize", pageInfo.getPageSize());
    // pageInfoMap.put("pageTotal", pageInfo.getTotal());
    // pageInfoMap.put("pages", pageInfo.getPages());
    // return pageInfoMap;
    // }

    public static Map<String, Object> pageUtil(List<?> list,
            Integer pageNum, Integer size) {
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("pageNum", pageNum);
        returnMap.put("pageSize", size);
        returnMap.put("pageTotal", list.size());
        returnMap.put("pages", (list.size() / size) + 1);
        int lower = (pageNum - 1) * size; // 下限
        List<?> newList = list.stream().skip(lower).limit(size).collect(Collectors.toList());
        returnMap.put("list", newList);
        return returnMap;
    }

}
