package com.cpc.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import com.cpc.model.PROCESS_STATUS_TABLE;

/**
 * 工程別ステータステーブル repository
 */
@Mapper
@Component
public interface RProcessStatus{
 
    @Insert("INSERT INTO PROCESS_STATUS_TABLE ( "
            + "  BATCH_ID "
            + ", PROCESS_ID "
            + ", STATUS "
         +") VALUES ( "
            + "  #{BATCH_ID} "
            + ", #{PROCESS_ID} "
            + ", #{STATUS} "
         +")"
         )
    int insert(PROCESS_STATUS_TABLE model);
    
    @Update({
        "<script>",
        "UPDATE PROCESS_STATUS_TABLE ",
        "  <set>",
        "    <if test='STATUS != null'> , STATUS = #{STATUS} </if>",
        "  </set>",
        "  WHERE ",
        "       BATCH_ID = #{BATCH_ID}",
        "   AND PROCESS_ID = #{PROCESS_ID}",
        "</script>",
    })
    int update(PROCESS_STATUS_TABLE model);
    
    @Delete("DELETE FROM PROCESS_STATUS_TABLE "
         +" WHERE "
            + "     BATCH_ID = #{BATCH_ID} "
            + " AND PROCESS_ID = #{PROCESS_ID} "
         )
    int delete(PROCESS_STATUS_TABLE model);

    @Select({
     "<script>",
        "SELECT * FROM PROCESS_STATUS_TABLE ",
        "  <where>",
        "    <if test='BATCH_ID != &quot;&quot; and BATCH_ID != null'>",
        "      AND BATCH_ID = #{BATCH_ID}",
        "    </if>",
        "    <if test='PROCESS_ID != &quot;&quot; and PROCESS_ID != null'>",
        "      AND PROCESS_ID = #{PROCESS_ID}",
        "    </if>",
        "  </where>",
        "</script>",
    })
    List<PROCESS_STATUS_TABLE> select(PROCESS_STATUS_TABLE model);
    
}
