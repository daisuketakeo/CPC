package com.cpc.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import com.cpc.model.WORK_GROUP_STATUS_TABLE;

/**
 * 作業グループステータステーブル repository
 */
@Mapper
@Component
public interface RWorkGroupStatus{
 
    @Insert("INSERT INTO WORK_GROUP_STATUS_TABLE ( "
            + "  BATCH_ID "
            + ", PROCESS_ID "
            + ", WORK_GROUP "
            + ", STATUS "
            + ", DEVIATION_NO "
            + ", DEVIATION_DATE "
            + ", REPORTED_DATE "
            + ", REPORTED_BY "
            + ", OCCURRENT_DATE "
            + ", CLOSING_DATE "
            + ", REVIEWED_DATE "
            + ", REVIEWED_BY "
            + ", BATCH_RELEASE "
         +") VALUES ( "
            + "  #{BATCH_ID} "
            + ", #{PROCESS_ID} "
            + ", #{WORK_GROUP} "
            + ", #{STATUS} "
            + ", #{DEVIATION_NO} "
            + ", #{DEVIATION_DATE} "
            + ", #{REPORTED_DATE} "
            + ", #{REPORTED_BY} "
            + ", #{OCCURRENT_DATE} "
            + ", #{CLOSING_DATE} "
            + ", #{REVIEWED_DATE} "
            + ", #{REVIEWED_BY} "
            + ", #{BATCH_RELEASE} "
         +")"
         )
    int insert(WORK_GROUP_STATUS_TABLE model);
    
    @Update({
        "<script>",
        "UPDATE WORK_GROUP_STATUS_TABLE ",
        "  <set>",
        "    <if test='STATUS != null'> , STATUS = #{STATUS} </if>",
        "    <if test='DEVIATION_NO != null'> , DEVIATION_NO = #{DEVIATION_NO} </if>",
        "    <if test='DEVIATION_DATE != null'> , DEVIATION_DATE = #{DEVIATION_DATE} </if>",
        "    <if test='REPORTED_DATE != null'> , REPORTED_DATE = #{REPORTED_DATE} </if>",
        "    <if test='REPORTED_BY != null'> , REPORTED_BY = #{REPORTED_BY} </if>",
        "    <if test='OCCURRENT_DATE != null'> , OCCURRENT_DATE = #{OCCURRENT_DATE} </if>",
        "    <if test='CLOSING_DATE != null'> , CLOSING_DATE = #{CLOSING_DATE} </if>",
        "    <if test='REVIEWED_DATE != null'> , REVIEWED_DATE = #{REVIEWED_DATE} </if>",
        "    <if test='REVIEWED_BY != null'> , REVIEWED_BY = #{REVIEWED_BY} </if>",
        "    <if test='BATCH_RELEASE != null'> , BATCH_RELEASE = #{BATCH_RELEASE} </if>",
        "  </set>",
        "  WHERE ",
        "       BATCH_ID = #{BATCH_ID}",
        "   AND PROCESS_ID = #{PROCESS_ID}",
        "   AND WORK_GROUP = #{WORK_GROUP}",
        "</script>",
    })
    int update(WORK_GROUP_STATUS_TABLE model);
    
    @Delete("DELETE FROM WORK_GROUP_STATUS_TABLE "
         +" WHERE "
            + "     BATCH_ID = #{BATCH_ID} "
            + " AND PROCESS_ID = #{PROCESS_ID} "
            + " AND WORK_GROUP = #{WORK_GROUP} "
         )
    int delete(WORK_GROUP_STATUS_TABLE model);

    @Select({
     "<script>",
        "SELECT * FROM WORK_GROUP_STATUS_TABLE ",
        "  <where>",
        "    <if test='BATCH_ID != &quot;&quot; and BATCH_ID != null'>",
        "      AND BATCH_ID = #{BATCH_ID}",
        "    </if>",
        "    <if test='PROCESS_ID != &quot;&quot; and PROCESS_ID != null'>",
        "      AND PROCESS_ID = #{PROCESS_ID}",
        "    </if>",
        "    <if test='WORK_GROUP != &quot;&quot; and WORK_GROUP != null'>",
        "      AND WORK_GROUP = #{WORK_GROUP}",
        "    </if>",
        "  </where>",
        "</script>",
    })
    List<WORK_GROUP_STATUS_TABLE> select(WORK_GROUP_STATUS_TABLE model);
    
}
