package com.dao;

import com.pojo.Details;

import java.util.Map;

public interface DetailsDao {

    int insertDeatils(Details details);

    Details selectDetailById(Map map);
}
