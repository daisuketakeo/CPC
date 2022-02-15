package com.cpc.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import com.cpc.model.MATERIAL_GROUP_TABLE;

/**
 * マテリアルグループテーブル repository
 */
@Mapper
@Component
public interface RMaterialGroup{
 
    @Insert("INSERT INTO MATERIAL_GROUP_TABLE ( "
            + "  MATERIAL_GORUP_ID "
            + ", MATERIAL_NO "
         +") VALUES ( "
            + "  #{MATERIAL_GORUP_ID} "
            + ", #{MATERIAL_NO} "
         +")"
         )
    int insert(MATERIAL_GROUP_TABLE model);
    
    @Update({
        "<script>",
        "UPDATE MATERIAL_GROUP_TABLE ",
        "  <set>",
        "  </set>",
        "  WHERE ",
        "       MATERIAL_GORUP_ID = #{MATERIAL_GORUP_ID}",
        "   AND MATERIAL_NO = #{MATERIAL_NO}",
        "</script>",
    })
    int update(MATERIAL_GROUP_TABLE model);
    
    @Delete("DELETE FROM MATERIAL_GROUP_TABLE "
         +" WHERE "
            + "     MATERIAL_GORUP_ID = #{MATERIAL_GORUP_ID} "
            + " AND MATERIAL_NO = #{MATERIAL_NO} "
         )
    int delete(MATERIAL_GROUP_TABLE model);

    @Select({
     "<script>",
        "SELECT * FROM MATERIAL_GROUP_TABLE ",
        "  <where>",
        "    <if test='MATERIAL_GORUP_ID != &quot;&quot; and MATERIAL_GORUP_ID != null'>",
        "      AND MATERIAL_GORUP_ID = #{MATERIAL_GORUP_ID}",
        "    </if>",
        "    <if test='MATERIAL_NO != &quot;&quot; and MATERIAL_NO != null'>",
        "      AND MATERIAL_NO = #{MATERIAL_NO}",
        "    </if>",
        "  </where>",
        "</script>",
    })
    List<MATERIAL_GROUP_TABLE> select(MATERIAL_GROUP_TABLE model);
    
}
