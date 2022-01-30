package com.cpc.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import com.cpc.model.PROC_INSTRUCTIONS_DETAIL_MASTER;

/**
 * 工程別製造指図詳細マスタ repository
 */
@Mapper
@Component
public interface RProcInstructionsDetailMst{
 
    @Insert("INSERT INTO PROC_INSTRUCTIONS_DETAIL_MASTER ( "
            + "  IM_ID "
            + ", INS_PROC_ID "
            + ", INS_PROC_DETAIL_ID "
            + ", ITEM_CONDITION "
            + ", MATERIAL_NO_NAME "
            + ", REQUIRED_QUANTITY "
            + ", USER_LOT_NO "
            + ", CAPTURE "
         +") VALUES ( "
            + "  #{IM_ID} "
            + ", #{INS_PROC_ID} "
            + ", #{INS_PROC_DETAIL_ID} "
            + ", #{ITEM_CONDITION} "
            + ", #{MATERIAL_NO_NAME} "
            + ", #{REQUIRED_QUANTITY} "
            + ", #{USER_LOT_NO} "
            + ", #{CAPTURE} "
         +")"
         )
    int insert(PROC_INSTRUCTIONS_DETAIL_MASTER model);
    
    @Update({
        "<script>",
        "UPDATE PROC_INSTRUCTIONS_DETAIL_MASTER ",
        "  <set>",
        "    <if test='ITEM_CONDITION != null'> , ITEM_CONDITION = #{ITEM_CONDITION} </if>",
        "    <if test='MATERIAL_NO_NAME != null'> , MATERIAL_NO_NAME = #{MATERIAL_NO_NAME} </if>",
        "    <if test='REQUIRED_QUANTITY != null'> , REQUIRED_QUANTITY = #{REQUIRED_QUANTITY} </if>",
        "    <if test='USER_LOT_NO != null'> , USER_LOT_NO = #{USER_LOT_NO} </if>",
        "    <if test='CAPTURE != null'> , CAPTURE = #{CAPTURE} </if>",
        "  </set>",
        "  WHERE ",
        "       IM_ID = #{IM_ID}",
        "   AND INS_PROC_ID = #{INS_PROC_ID}",
        "   AND INS_PROC_DETAIL_ID = #{INS_PROC_DETAIL_ID}",
        "</script>",
    })
    int update(PROC_INSTRUCTIONS_DETAIL_MASTER model);
    
    @Delete("DELETE FROM PROC_INSTRUCTIONS_DETAIL_MASTER "
         +" WHERE "
            + "     IM_ID = #{IM_ID} "
            + " AND INS_PROC_ID = #{INS_PROC_ID} "
            + " AND INS_PROC_DETAIL_ID = #{INS_PROC_DETAIL_ID} "
         )
    int delete(PROC_INSTRUCTIONS_DETAIL_MASTER model);

    @Select({
     "<script>",
        "SELECT * FROM PROC_INSTRUCTIONS_DETAIL_MASTER ",
        "  <where>",
        "    <if test='IM_ID != &quot;&quot; and IM_ID != null'>",
        "      AND IM_ID = #{IM_ID}",
        "    </if>",
        "    <if test='INS_PROC_ID != &quot;&quot; and INS_PROC_ID != null'>",
        "      AND INS_PROC_ID = #{INS_PROC_ID}",
        "    </if>",
        "    <if test='INS_PROC_DETAIL_ID != &quot;&quot; and INS_PROC_DETAIL_ID != null'>",
        "      AND INS_PROC_DETAIL_ID = #{INS_PROC_DETAIL_ID}",
        "    </if>",
        "  </where>",
        "</script>",
    })
    List<PROC_INSTRUCTIONS_DETAIL_MASTER> select(PROC_INSTRUCTIONS_DETAIL_MASTER model);
    
}
