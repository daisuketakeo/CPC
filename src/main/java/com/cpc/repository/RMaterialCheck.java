package com.cpc.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import com.cpc.model.MATERIAL_CHECK_TABLE;

/**
 * マテリアルチェックテーブル repository
 */
@Mapper
@Component
public interface RMaterialCheck{
 
    @Insert("INSERT INTO MATERIAL_CHECK_TABLE ( "
            + "  MATERIAL_NO "
            + ", BATCH_ID "
            + ", PROCESS_ID "
            + ", WORK_GROUP "
            + ", WORK_ID "
            + ", CHECK_USERID "
            + ", CHECK_USERNAME "
            + ", CHECK_DATE "
         +") VALUES ( "
            + "  #{MATERIAL_NO} "
            + ", #{BATCH_ID} "
            + ", #{PROCESS_ID} "
            + ", #{WORK_GROUP} "
            + ", #{WORK_ID} "
            + ", #{CHECK_USERID} "
            + ", #{CHECK_USERNAME} "
            + ", #{CHECK_DATE} "
         +")"
         )
    int insert(MATERIAL_CHECK_TABLE model);
    
    @Update({
        "<script>",
        "UPDATE MATERIAL_CHECK_TABLE ",
        "  <set>",
        "    <if test='CHECK_USERID != null'> , CHECK_USERID = #{CHECK_USERID} </if>",
        "    <if test='CHECK_USERNAME != null'> , CHECK_USERNAME = #{CHECK_USERNAME} </if>",
        "    <if test='CHECK_DATE != null'> , CHECK_DATE = #{CHECK_DATE} </if>",
        "  </set>",
        "  WHERE ",
        "       MATERIAL_NO = #{MATERIAL_NO}",
        "   AND BATCH_ID = #{BATCH_ID}",
        "   AND PROCESS_ID = #{PROCESS_ID}",
        "   AND WORK_GROUP = #{WORK_GROUP}",
        "   AND WORK_ID = #{WORK_ID}",
        "</script>",
    })
    int update(MATERIAL_CHECK_TABLE model);
    
    @Delete("DELETE FROM MATERIAL_CHECK_TABLE "
         +" WHERE "
            + "     MATERIAL_NO = #{MATERIAL_NO} "
            + " AND BATCH_ID = #{BATCH_ID} "
            + " AND PROCESS_ID = #{PROCESS_ID} "
            + " AND WORK_GROUP = #{WORK_GROUP} "
            + " AND WORK_ID = #{WORK_ID} "
         )
    int delete(MATERIAL_CHECK_TABLE model);

    @Select({
     "<script>",
        "SELECT * FROM MATERIAL_CHECK_TABLE ",
        "  <where>",
        "    <if test='MATERIAL_NO != &quot;&quot; and MATERIAL_NO != null'>",
        "      AND MATERIAL_NO = #{MATERIAL_NO}",
        "    </if>",
        "    <if test='BATCH_ID != &quot;&quot; and BATCH_ID != null'>",
        "      AND BATCH_ID = #{BATCH_ID}",
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
        "  </where>",
        "</script>",
    })
    List<MATERIAL_CHECK_TABLE> select(MATERIAL_CHECK_TABLE model);
    
}
