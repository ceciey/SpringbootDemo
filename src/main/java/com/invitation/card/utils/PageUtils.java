package com.invitation.card.utils;

import com.baomidou.mybatisplus.plugins.Page;

public class PageUtils {

    /**
     * 获取分页对象
     * 每页显示数量
     */

    public static  <T> Page<T> getPage(int pageNum,int pageSize){

        return new Page<>(pageNum,pageSize);
    }
}
