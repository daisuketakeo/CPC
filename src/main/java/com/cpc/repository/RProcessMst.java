package com.cpc.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import com.cpc.model.PROCESS_MASTER;

/**
 * 工程マスタ repository
 */
@Mapper
@Component
public interface RProcessMst{
 
    @Insert("INSERT INTO PROCESS_MASTER ( "
            + "  PROCESS_ID "
            + ", PROCESS_NAME "
         +") VALUES ( "
            + "  #{PROCESS_ID} "
            + ", #{PROCESS_NAME} "
         +")"
         )
    int insert(PROCESS_MASTER model);
    
    @Update({
        "<script>",
        "UPDATE PROCESS_MASTER ",
        "  <set>",
        "    <if test='PROCESS_NAME != null'> , PROCESS_NAME = #{PROCESS_NAME} </if>",
        "  </set>",
        "  WHERE ",
        "       PROCESS_ID = #{PROCESS_ID}",
        "</script>",
    })
    int update(PROCESS_MASTER model);
    
    @Delete("DELETE FROM PROCESS_MASTER "
         +" WHERE "
            + "     PROCESS_ID = #{PROCESS_ID} "
         )
    int delete(PROCESS_MASTER model);

    @Select({
     "<script>",
        "SELECT * FROM PROCESS_MASTER ",
        "  <where>",
        "    <if test='PROCESS_ID != &quot;&quot; and PROCESS_ID != null'>",
        "      AND PROCESS_ID = #{PROCESS_ID}",
        "    </if>",
        "  </where>",
        "</script>",
    })
    List<PROCESS_MASTER> select(PROCESS_MASTER model);
    
}
