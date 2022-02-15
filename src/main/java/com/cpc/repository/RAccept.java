package com.cpc.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import com.cpc.model.ACCEPT_TABLE;

/**
 * 受入テーブル repository
 */
@Mapper
@Component
public interface RAccept{
 
    @Insert("INSERT INTO ACCEPT_TABLE ( "
            + "  MATERIAL_NO "
            + ", MATERIAL_NAME "
            + ", CATEGORY_NO "
            + ", MANUFACTURER "
            + ", QTY "
            + ", STORAGE "
            + ", LOT_NO "
            + ", EXP_DATE "
            + ", USER_LOT_NO "
            + ", STORAGE_LOCATION "
            + ", REQUIRED_AMOUNT "
            + ", PREPARED_AMOUNT "
            + ", QA_APP_STATUS "
            + ", STATUS "
         +") VALUES ( "
            + "  #{MATERIAL_NO} "
            + ", #{MATERIAL_NAME} "
            + ", #{CATEGORY_NO} "
            + ", #{MANUFACTURER} "
            + ", #{QTY} "
            + ", #{STORAGE} "
            + ", #{LOT_NO} "
            + ", #{EXP_DATE} "
            + ", #{USER_LOT_NO} "
            + ", #{STORAGE_LOCATION} "
            + ", #{REQUIRED_AMOUNT} "
            + ", #{PREPARED_AMOUNT} "
            + ", #{QA_APP_STATUS} "
            + ", #{STATUS} "
         +")"
         )
    int insert(ACCEPT_TABLE model);
    
    @Update({
        "<script>",
        "UPDATE ACCEPT_TABLE ",
        "  <set>",
        "    <if test='MATERIAL_NAME != null'> , MATERIAL_NAME = #{MATERIAL_NAME} </if>",
        "    <if test='CATEGORY_NO != null'> , CATEGORY_NO = #{CATEGORY_NO} </if>",
        "    <if test='MANUFACTURER != null'> , MANUFACTURER = #{MANUFACTURER} </if>",
        "    <if test='QTY != null'> , QTY = #{QTY} </if>",
        "    <if test='STORAGE != null'> , STORAGE = #{STORAGE} </if>",
        "    <if test='LOT_NO != null'> , LOT_NO = #{LOT_NO} </if>",
        "    <if test='EXP_DATE != null'> , EXP_DATE = #{EXP_DATE} </if>",
        "    <if test='USER_LOT_NO != null'> , USER_LOT_NO = #{USER_LOT_NO} </if>",
        "    <if test='STORAGE_LOCATION != null'> , STORAGE_LOCATION = #{STORAGE_LOCATION} </if>",
        "    <if test='REQUIRED_AMOUNT != null'> , REQUIRED_AMOUNT = #{REQUIRED_AMOUNT} </if>",
        "    <if test='PREPARED_AMOUNT != null'> , PREPARED_AMOUNT = #{PREPARED_AMOUNT} </if>",
        "    <if test='QA_APP_STATUS != null'> , QA_APP_STATUS = #{QA_APP_STATUS} </if>",
        "    <if test='STATUS != null'> , STATUS = #{STATUS} </if>",
        "  </set>",
        "  WHERE ",
        "       MATERIAL_NO = #{MATERIAL_NO}",
        "</script>",
    })
    int update(ACCEPT_TABLE model);
    
    @Delete("DELETE FROM ACCEPT_TABLE "
         +" WHERE "
            + "     MATERIAL_NO = #{MATERIAL_NO} "
         )
    int delete(ACCEPT_TABLE model);

    @Select({
     "<script>",
        "SELECT * FROM ACCEPT_TABLE ",
        "  <where>",
        "    <if test='MATERIAL_NO != &quot;&quot; and MATERIAL_NO != null'>",
        "      AND MATERIAL_NO = #{MATERIAL_NO}",
        "    </if>",
        "  </where>",
        "</script>",
    })
    List<ACCEPT_TABLE> select(ACCEPT_TABLE model);
    
}
