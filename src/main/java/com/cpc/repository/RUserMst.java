package com.cpc.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import com.cpc.model.USER_MASTER;

/**
 * ユーザマスタ repository
 */
@Mapper
@Component
public interface RUserMst{
 
    @Insert("INSERT INTO USER_MASTER ( "
            + "  USERID "
            + ", USERNAME "
            + ", PASSWORD "
            + ", AUTHORITY "
         +") VALUES ( "
            + "  #{USERID} "
            + ", #{USERNAME} "
            + ", #{PASSWORD} "
            + ", #{AUTHORITY} "
         +")"
         )
    int insert(USER_MASTER model);
    
    @Update({
        "<script>",
        "UPDATE USER_MASTER ",
        "  <set>",
        "    <if test='USERNAME != null'> , USERNAME = #{USERNAME} </if>",
        "    <if test='PASSWORD != null'> , PASSWORD = #{PASSWORD} </if>",
        "    <if test='AUTHORITY != null'> , AUTHORITY = #{AUTHORITY} </if>",
        "  </set>",
        "  WHERE ",
        "       USERID = #{USERID}",
        "</script>",
    })
    int update(USER_MASTER model);
    
    @Delete("DELETE FROM USER_MASTER "
         +" WHERE "
            + "     USERID = #{USERID} "
         )
    int delete(USER_MASTER model);

    @Select({
     "<script>",
        "SELECT * FROM USER_MASTER ",
        "  <where>",
        "    <if test='USERID != &quot;&quot; and USERID != null'>",
        "      AND USERID = #{USERID}",
        "    </if>",
        "    <if test='USERNAME != &quot;&quot; and USERNAME != null'>",
        "      AND USERNAME = #{USERNAME}",
        "    </if>",
        "  </where>",
        "</script>",
    })
    List<USER_MASTER> select(USER_MASTER model);
    
}
