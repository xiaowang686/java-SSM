package com.dao;

import com.pojo.Detail;

import java.util.Map;

public interface DetailsDao {

    int insertDeatils(Detail details);

    Detail selectDetailById(Map map);
}
