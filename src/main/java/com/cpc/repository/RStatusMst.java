package com.cpc.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import com.cpc.model.STATUS_MASTER;

/**
 * ステータスマスタ repository
 */
@Mapper
@Component
public interface RStatusMst{
 
    @Insert("INSERT INTO STATUS_MASTER ( "
            + "  TABLE_TYPE "
            + ", STATUS_CODE "
            + ", STATUS_NAME "
         +") VALUES ( "
            + "  #{TABLE_TYPE} "
            + ", #{STATUS_CODE} "
            + ", #{STATUS_NAME} "
         +")"
         )
    int insert(STATUS_MASTER model);
    
    @Update({
        "<script>",
        "UPDATE STATUS_MASTER ",
        "  <set>",
        "    <if test='STATUS_NAME != null'> , STATUS_NAME = #{STATUS_NAME} </if>",
        "  </set>",
        "  WHERE ",
        "       TABLE_TYPE = #{TABLE_TYPE}",
        "   AND STATUS_CODE = #{STATUS_CODE}",
        "</script>",
    })
    int update(STATUS_MASTER model);
    
    @Delete("DELETE FROM STATUS_MASTER "
         +" WHERE "
            + "     TABLE_TYPE = #{TABLE_TYPE} "
            + " AND STATUS_CODE = #{STATUS_CODE} "
         )
    int delete(STATUS_MASTER model);

    @Select({
     "<script>",
        "SELECT * FROM STATUS_MASTER ",
        "  <where>",
        "    <if test='TABLE_TYPE != &quot;&quot; and TABLE_TYPE != null'>",
        "      AND TABLE_TYPE = #{TABLE_TYPE}",
        "    </if>",
        "    <if test='STATUS_CODE != &quot;&quot; and STATUS_CODE != null'>",
        "      AND STATUS_CODE = #{STATUS_CODE}",
        "    </if>",
        "  </where>",
        "</script>",
    })
    List<STATUS_MASTER> select(STATUS_MASTER model);
    
}
