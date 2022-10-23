package com.dao;

import com.pojo.Member;
import com.pojo.MemberSearchCondition;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MemberDao {


//      List<Member> queryMemberBySearch(Map<String,Object> map);


        List<Member> queryMemberBySearch(MemberSearchCondition params);

        List<Member> queryMemberByCity(List<String> param);

        List<Member> queryMemberByNick(@Param("keyWord") String keyWord);
}
