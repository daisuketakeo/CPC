package com.cpc.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import com.cpc.model.WORK_RESULT_TABLE;

/**
 * 作業実績テーブル repository
 */
@Mapper
@Component
public interface RWorkResult{
 
    @Insert("INSERT INTO WORK_RESULT_TABLE ( "
            + "  WORK_RESULT_NO "
            + ", PROCESS_ID "
            + ", WORK_GROUP "
            + ", WORK_ID "
            + ", ID "
            + ", CHECK_RESULT "
            + ", CHECK_REASON "
            + ", CHECK_COA "
            + ", CHECK_COA_REASON "
            + ", CHECK_FILE_NAME "
            + ", CHECK_FILE_BASE64 "
            + ", LABEL "
            + ", COUNT_RESULT "
            + ", WORK_USERID "
            + ", WORK_USERNAME "
            + ", WORK_DATE "
         +") VALUES ( "
            + "  #{WORK_RESULT_NO} "
            + ", #{PROCESS_ID} "
            + ", #{WORK_GROUP} "
            + ", #{WORK_ID} "
            + ", #{ID} "
            + ", #{CHECK_RESULT} "
            + ", #{CHECK_REASON} "
            + ", #{CHECK_COA} "
            + ", #{CHECK_COA_REASON} "
            + ", #{CHECK_FILE_NAME} "
            + ", #{CHECK_FILE_BASE64} "
            + ", #{LABEL} "
            + ", #{COUNT_RESULT} "
            + ", #{WORK_USERID} "
            + ", #{WORK_USERNAME} "
            + ", #{WORK_DATE} "
         +")"
         )
    int insert(WORK_RESULT_TABLE model);
    
    @Update({
        "<script>",
        "UPDATE WORK_RESULT_TABLE ",
        "  <set>",
        "    <if test='PROCESS_ID != null'> , PROCESS_ID = #{PROCESS_ID} </if>",
        "    <if test='WORK_GROUP != null'> , WORK_GROUP = #{WORK_GROUP} </if>",
        "    <if test='WORK_ID != null'> , WORK_ID = #{WORK_ID} </if>",
        "    <if test='ID != null'> , ID = #{ID} </if>",
        "    <if test='CHECK_RESULT != null'> , CHECK_RESULT = #{CHECK_RESULT} </if>",
        "    <if test='CHECK_REASON != null'> , CHECK_REASON = #{CHECK_REASON} </if>",
        "    <if test='CHECK_COA != null'> , CHECK_COA = #{CHECK_COA} </if>",
        "    <if test='CHECK_COA_REASON != null'> , CHECK_COA_REASON = #{CHECK_COA_REASON} </if>",
        "    <if test='CHECK_FILE_NAME != null'> , CHECK_FILE_NAME = #{CHECK_FILE_NAME} </if>",
        "    <if test='CHECK_FILE_BASE64 != null'> , CHECK_FILE_BASE64 = #{CHECK_FILE_BASE64} </if>",
        "    <if test='LABEL != null'> , LABEL = #{LABEL} </if>",
        "    <if test='COUNT_RESULT != null'> , COUNT_RESULT = #{COUNT_RESULT} </if>",
        "    <if test='WORK_USERID != null'> , WORK_USERID = #{WORK_USERID} </if>",
        "    <if test='WORK_USERNAME != null'> , WORK_USERNAME = #{WORK_USERNAME} </if>",
        "    <if test='WORK_DATE != null'> , WORK_DATE = #{WORK_DATE} </if>",
        "  </set>",
        "  WHERE ",
        "       WORK_RESULT_NO = #{WORK_RESULT_NO}",
        "</script>",
    })
    int update(WORK_RESULT_TABLE model);
    
    @Delete("DELETE FROM WORK_RESULT_TABLE "
         +" WHERE "
            + "     WORK_RESULT_NO = #{WORK_RESULT_NO} "
         )
    int delete(WORK_RESULT_TABLE model);

    @Select({
     "<script>",
        "SELECT * FROM WORK_RESULT_TABLE ",
        "  <where>",
        "    <if test='WORK_RESULT_NO != &quot;&quot; and WORK_RESULT_NO != null'>",
        "      AND WORK_RESULT_NO = #{WORK_RESULT_NO}",
        "    </if>",
        "    <if test='PROCESS_ID != &quot;&quot; and PROCESS_ID != null'>",
        "      AND PROCESS_ID = #{PROCESS_ID}",
        "    </if>",
        "    <if test='WORK_GROUP != &quot;&quot; and WORK_GROUP != null'>",
        "      AND WORK_GROUP = #{WORK_GROUP}",
        "    </if>",
        "    <if test='WORK_ID != &quot;&quot; and WORK_ID != null'>",
        "      AND WORK_ID = #{WORK_ID}",
        "    </if>",
        "    <if test='ID != &quot;&quot; and ID != null'>",
        "      AND ID = #{ID}",
        "    </if>",
        "  </where>",
        "</script>",
    })
    List<WORK_RESULT_TABLE> select(WORK_RESULT_TABLE model);
    
}
