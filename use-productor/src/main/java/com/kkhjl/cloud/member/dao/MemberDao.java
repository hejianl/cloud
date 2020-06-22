package com.kkhjl.cloud.member.dao;

import com.kkhjl.cloud.member.bo.MemberInfo;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberDao {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "address", column = "address"),
            @Result(property = "identify", column = "identify")
    })
    @Select("select * from member_info where identify=#{identify}")
    MemberInfo selectMemberById(String id);
    int batchInsert(List<MemberInfo> list);
    @Update("update member_info set sort=sort +1 where id=#{memberId}")
    int sortIncrementById(long memberId) throws Exception;
    @Update("update member_info set sort=sort +1 where identify=#{identify}")
    int sortIncrementByIdentify(long identify)  throws Exception;
}
