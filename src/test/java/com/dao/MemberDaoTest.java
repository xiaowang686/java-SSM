package com.dao;

import com.pojo.Member;
import com.pojo.MemberSearchCondition;
import com.utils.MybatisUtil;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MemberDaoTest extends TestCase {

    public void testQueryMemberBySearch() {

        //使用Map的方式传动态Sql条件参数
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("gender","男");
        hashMap.put("age",25);

        //使用实体类的方式传动态Sql条件参数
        MemberSearchCondition param = new MemberSearchCondition();
        param.setGender("女");
        param.setMinAge(18);
        param.setMaxAge(25);
        //param.setCity("深圳");

        MemberDao memberDao = MybatisUtil.getMapper(MemberDao.class);
        List<Member> memberList = memberDao.queryMemberBySearch(param);
        for (Member member:memberList){
            System.out.println(member);
        }

    }

    @Test
    public void testQueryMemberByCity() {
        //动态Sql语句遍历集合
        List<String> list = new ArrayList<>();
        list.add("广州");
        list.add("深圳");
        MemberDao memberDao = MybatisUtil.getMapper(MemberDao.class);
        List<Member> memberList = memberDao.queryMemberByCity(list);
        for (Member member:memberList){
            System.out.println(member);
        }

    }

    @Test
    public void testQueryMemberByNick() {
        MemberDao memberDao = MybatisUtil.getMapper(MemberDao.class);
        List<Member> memberList = memberDao.queryMemberByNick("小");
        for (Member member:memberList){
            System.out.println(member);
        }
    }
}