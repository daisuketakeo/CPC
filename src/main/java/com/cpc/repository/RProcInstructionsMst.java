package com.cpc.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import com.cpc.model.PROC_INSTRUCTIONS_MASTER;

/**
 * 工程別製造指図マスタ repository
 */
@Mapper
@Component
public interface RProcInstructionsMst{
 
    @Insert("INSERT INTO PROC_INSTRUCTIONS_MASTER ( "
            + "  IM_ID "
            + ", INS_PROC_ID "
            + ", RECIPE_NAME "
            + ", CELL_TYPE "
            + ", TARGET_AMOUNT "
            + ", INCUBATION "
            + ", END_POINT "
            + ", COMMENT "
         +") VALUES ( "
            + "  #{IM_ID} "
            + ", #{INS_PROC_ID} "
            + ", #{RECIPE_NAME} "
            + ", #{CELL_TYPE} "
            + ", #{TARGET_AMOUNT} "
            + ", #{INCUBATION} "
            + ", #{END_POINT} "
            + ", #{COMMENT} "
         +")"
         )
    int insert(PROC_INSTRUCTIONS_MASTER model);
    
    @Update({
        "<script>",
        "UPDATE PROC_INSTRUCTIONS_MASTER ",
        "  <set>",
        "    <if test='RECIPE_NAME != null'> , RECIPE_NAME = #{RECIPE_NAME} </if>",
        "    <if test='CELL_TYPE != null'> , CELL_TYPE = #{CELL_TYPE} </if>",
        "    <if test='TARGET_AMOUNT != null'> , TARGET_AMOUNT = #{TARGET_AMOUNT} </if>",
        "    <if test='INCUBATION != null'> , INCUBATION = #{INCUBATION} </if>",
        "    <if test='END_POINT != null'> , END_POINT = #{END_POINT} </if>",
        "    <if test='COMMENT != null'> , COMMENT = #{COMMENT} </if>",
        "  </set>",
        "  WHERE ",
        "       IM_ID = #{IM_ID}",
        "   AND INS_PROC_ID = #{INS_PROC_ID}",
        "</script>",
    })
    int update(PROC_INSTRUCTIONS_MASTER model);
    
    @Delete("DELETE FROM PROC_INSTRUCTIONS_MASTER "
         +" WHERE "
            + "     IM_ID = #{IM_ID} "
            + " AND INS_PROC_ID = #{INS_PROC_ID} "
         )
    int delete(PROC_INSTRUCTIONS_MASTER model);

    @Select({
     "<script>",
        "SELECT * FROM PROC_INSTRUCTIONS_MASTER ",
        "  <where>",
        "    <if test='IM_ID != &quot;&quot; and IM_ID != null'>",
        "      AND IM_ID = #{IM_ID}",
        "    </if>",
        "    <if test='INS_PROC_ID != &quot;&quot; and INS_PROC_ID != null'>",
        "      AND INS_PROC_ID = #{INS_PROC_ID}",
        "    </if>",
        "  </where>",
        "</script>",
    })
    List<PROC_INSTRUCTIONS_MASTER> select(PROC_INSTRUCTIONS_MASTER model);
    
}
