package com.cpc.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import com.cpc.model.WORK_GROUP_MASTER;

/**
 * 作業グループマスタ repository
 */
@Mapper
@Component
public interface RWorkGroupMst{
 
    @Insert("INSERT INTO WORK_GROUP_MASTER ( "
            + "  PROCESS_ID "
            + ", WORK_GROUP "
            + ", WORK_GROUP_NAME "
            + ", BEFORE_WORK_GROUP "
            + ", STATUS "
            + ", DISPLAY_TYPE "
         +") VALUES ( "
            + "  #{PROCESS_ID} "
            + ", #{WORK_GROUP} "
            + ", #{WORK_GROUP_NAME} "
            + ", #{BEFORE_WORK_GROUP} "
            + ", #{STATUS} "
            + ", #{DISPLAY_TYPE} "
         +")"
         )
    int insert(WORK_GROUP_MASTER model);
    
    @Update({
        "<script>",
        "UPDATE WORK_GROUP_MASTER ",
        "  <set>",
        "    <if test='WORK_GROUP_NAME != null'> , WORK_GROUP_NAME = #{WORK_GROUP_NAME} </if>",
        "    <if test='BEFORE_WORK_GROUP != null'> , BEFORE_WORK_GROUP = #{BEFORE_WORK_GROUP} </if>",
        "    <if test='STATUS != null'> , STATUS = #{STATUS} </if>",
        "    <if test='DISPLAY_TYPE != null'> , DISPLAY_TYPE = #{DISPLAY_TYPE} </if>",
        "  </set>",
        "  WHERE ",
        "       PROCESS_ID = #{PROCESS_ID}",
        "   AND WORK_GROUP = #{WORK_GROUP}",
        "</script>",
    })
    int update(WORK_GROUP_MASTER model);
    
    @Delete("DELETE FROM WORK_GROUP_MASTER "
         +" WHERE "
            + "     PROCESS_ID = #{PROCESS_ID} "
            + " AND WORK_GROUP = #{WORK_GROUP} "
         )
    int delete(WORK_GROUP_MASTER model);

    @Select({
     "<script>",
        "SELECT * FROM WORK_GROUP_MASTER ",
        "  <where>",
        "    <if test='PROCESS_ID != &quot;&quot; and PROCESS_ID != null'>",
        "      AND PROCESS_ID = #{PROCESS_ID}",
        "    </if>",
        "    <if test='WORK_GROUP != &quot;&quot; and WORK_GROUP != null'>",
        "      AND WORK_GROUP = #{WORK_GROUP}",
        "    </if>",
        "  </where>",
        "  order by PROCESS_ID asc,WORK_GROUP asc",
        "</script>",
    })
    List<WORK_GROUP_MASTER> select(WORK_GROUP_MASTER model);
    
}
