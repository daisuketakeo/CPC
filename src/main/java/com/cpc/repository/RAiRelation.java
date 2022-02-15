package com.cpc.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import com.cpc.model.AI_RELATION_TABLE;

/**
 * 受入指図連携テーブル repository
 */
@Mapper
@Component
public interface RAiRelation{
 
    @Insert("INSERT INTO AI_RELATION_TABLE ( "
            + "  IM_ID "
            + ", PROCESS_ID "
            + ", MATERIAL_NO "
         +") VALUES ( "
            + "  #{IM_ID} "
            + ", #{PROCESS_ID} "
            + ", #{MATERIAL_NO} "
         +")"
         )
    int insert(AI_RELATION_TABLE model);
    
    @Update({
        "<script>",
        "UPDATE AI_RELATION_TABLE ",
        "  <set>",
        "  </set>",
        "  WHERE ",
        "       IM_ID = #{IM_ID}",
        "   AND PROCESS_ID = #{PROCESS_ID}",
        "   AND MATERIAL_NO = #{MATERIAL_NO}",
        "</script>",
    })
    int update(AI_RELATION_TABLE model);
    
    @Delete("DELETE FROM AI_RELATION_TABLE "
         +" WHERE "
            + "     IM_ID = #{IM_ID} "
            + " AND PROCESS_ID = #{PROCESS_ID} "
            + " AND MATERIAL_NO = #{MATERIAL_NO} "
         )
    int delete(AI_RELATION_TABLE model);

    @Select({
     "<script>",
        "SELECT * FROM AI_RELATION_TABLE ",
        "  <where>",
        "    <if test='IM_ID != &quot;&quot; and IM_ID != null'>",
        "      AND IM_ID = #{IM_ID}",
        "    </if>",
        "    <if test='PROCESS_ID != &quot;&quot; and PROCESS_ID != null'>",
        "      AND PROCESS_ID = #{PROCESS_ID}",
        "    </if>",
        "    <if test='MATERIAL_NO != &quot;&quot; and MATERIAL_NO != null'>",
        "      AND MATERIAL_NO = #{MATERIAL_NO}",
        "    </if>",
        "  </where>",
        "</script>",
    })
    List<AI_RELATION_TABLE> select(AI_RELATION_TABLE model);
    
}
