package com.cpc.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import com.cpc.model.INSTRUCTIONS_TABLE;

/**
 * 製造指図テーブル repository
 */
@Mapper
@Component
public interface RInstructions{
 
    @Insert("INSERT INTO INSTRUCTIONS_TABLE ( "
            + "  BATCH_ID "
            + ", IM_ID "
            + ", NAME "
            + ", COMMENT "
            + ", CELL_TYPE "
            + ", INPUT_AMOUNT "
            + ", TARGET_AMOUNT_CELLS "
            + ", TARGET_AMOUNT_BAGS "
            + ", TOTAL_PASSAGE_TIMES "
            + ", DURATION_EST "
            + ", MEDIUM "
            + ", ECM_COATING "
            + ", DISSOCIATION_REAGENT "
            + ", PRE_CULTURE_VESSEL "
            + ", PRE_CULTURE_MATERIAL_NAME "
            + ", PRE_CULTURE_VOLUME "
            + ", PRE_CULTURE_INCUBATION_TIME "
            + ", ICP1_VESSEL "
            + ", ICP1_MATERIAL_NAME "
            + ", ICP1_VOLUME "
            + ", ICP1_INCUBATION_TIME "
            + ", ICP2_VESSEL "
            + ", ICP2_MATERIAL_NAME "
            + ", ICP2_VOLUME "
            + ", ICP2_INCUBATION_TIME "
            + ", ICP3_VESSEL "
            + ", ICP3_MATERIAL_NAME "
            + ", ICP3_VOLUME "
            + ", ICP3_INCUBATION_TIME "
            + ", PROTOCOL "
            + ", STARTING_TIME "
            + ", FINISH_TIME "
            + ", PRE_CULTURE_KIT_RT_LABEL "
            + ", PRE_CULTURE_KIT_P4T_LABEL "
            + ", PRE_CULTURE_KIT_M20T_LABEL "
            + ", PRE_CULTURE_COUNT "
            + ", EX_CULTURE_KIT_RT_LABEL "
            + ", EX_CULTURE_KIT_P4T_LABEL "
            + ", EX_CULTURE_KIT_M20T_LABEL "
            + ", STATUS "
         +") VALUES ( "
            + "  #{BATCH_ID} "
            + ", #{IM_ID} "
            + ", #{NAME} "
            + ", #{COMMENT} "
            + ", #{CELL_TYPE} "
            + ", #{INPUT_AMOUNT} "
            + ", #{TARGET_AMOUNT_CELLS} "
            + ", #{TARGET_AMOUNT_BAGS} "
            + ", #{TOTAL_PASSAGE_TIMES} "
            + ", #{DURATION_EST} "
            + ", #{MEDIUM} "
            + ", #{ECM_COATING} "
            + ", #{DISSOCIATION_REAGENT} "
            + ", #{PRE_CULTURE_VESSEL} "
            + ", #{PRE_CULTURE_MATERIAL_NAME} "
            + ", #{PRE_CULTURE_VOLUME} "
            + ", #{PRE_CULTURE_INCUBATION_TIME} "
            + ", #{ICP1_VESSEL} "
            + ", #{ICP1_MATERIAL_NAME} "
            + ", #{ICP1_VOLUME} "
            + ", #{ICP1_INCUBATION_TIME} "
            + ", #{ICP2_VESSEL} "
            + ", #{ICP2_MATERIAL_NAME} "
            + ", #{ICP2_VOLUME} "
            + ", #{ICP2_INCUBATION_TIME} "
            + ", #{ICP3_VESSEL} "
            + ", #{ICP3_MATERIAL_NAME} "
            + ", #{ICP3_VOLUME} "
            + ", #{ICP3_INCUBATION_TIME} "
            + ", #{PROTOCOL} "
            + ", #{STARTING_TIME} "
            + ", #{FINISH_TIME} "
            + ", #{PRE_CULTURE_KIT_RT_LABEL} "
            + ", #{PRE_CULTURE_KIT_P4T_LABEL} "
            + ", #{PRE_CULTURE_KIT_M20T_LABEL} "
            + ", #{PRE_CULTURE_COUNT} "
            + ", #{EX_CULTURE_KIT_RT_LABEL} "
            + ", #{EX_CULTURE_KIT_P4T_LABEL} "
            + ", #{EX_CULTURE_KIT_M20T_LABEL} "
            + ", #{STATUS} "
         +")"
         )
    int insert(INSTRUCTIONS_TABLE model);
    
    @Update({
        "<script>",
        "UPDATE INSTRUCTIONS_TABLE ",
        "  <set>",
        "    <if test='IM_ID != null'> , IM_ID = #{IM_ID} </if>",
        "    <if test='NAME != null'> , NAME = #{NAME} </if>",
        "    <if test='COMMENT != null'> , COMMENT = #{COMMENT} </if>",
        "    <if test='CELL_TYPE != null'> , CELL_TYPE = #{CELL_TYPE} </if>",
        "    <if test='INPUT_AMOUNT != null'> , INPUT_AMOUNT = #{INPUT_AMOUNT} </if>",
        "    <if test='TARGET_AMOUNT_CELLS != null'> , TARGET_AMOUNT_CELLS = #{TARGET_AMOUNT_CELLS} </if>",
        "    <if test='TARGET_AMOUNT_BAGS != null'> , TARGET_AMOUNT_BAGS = #{TARGET_AMOUNT_BAGS} </if>",
        "    <if test='TOTAL_PASSAGE_TIMES != null'> , TOTAL_PASSAGE_TIMES = #{TOTAL_PASSAGE_TIMES} </if>",
        "    <if test='DURATION_EST != null'> , DURATION_EST = #{DURATION_EST} </if>",
        "    <if test='MEDIUM != null'> , MEDIUM = #{MEDIUM} </if>",
        "    <if test='ECM_COATING != null'> , ECM_COATING = #{ECM_COATING} </if>",
        "    <if test='DISSOCIATION_REAGENT != null'> , DISSOCIATION_REAGENT = #{DISSOCIATION_REAGENT} </if>",
        "    <if test='PRE_CULTURE_VESSEL != null'> , PRE_CULTURE_VESSEL = #{PRE_CULTURE_VESSEL} </if>",
        "    <if test='PRE_CULTURE_MATERIAL_NAME != null'> , PRE_CULTURE_MATERIAL_NAME = #{PRE_CULTURE_MATERIAL_NAME} </if>",
        "    <if test='PRE_CULTURE_VOLUME != null'> , PRE_CULTURE_VOLUME = #{PRE_CULTURE_VOLUME} </if>",
        "    <if test='PRE_CULTURE_INCUBATION_TIME != null'> , PRE_CULTURE_INCUBATION_TIME = #{PRE_CULTURE_INCUBATION_TIME} </if>",
        "    <if test='ICP1_VESSEL != null'> , ICP1_VESSEL = #{ICP1_VESSEL} </if>",
        "    <if test='ICP1_MATERIAL_NAME != null'> , ICP1_MATERIAL_NAME = #{ICP1_MATERIAL_NAME} </if>",
        "    <if test='ICP1_VOLUME != null'> , ICP1_VOLUME = #{ICP1_VOLUME} </if>",
        "    <if test='ICP1_INCUBATION_TIME != null'> , ICP1_INCUBATION_TIME = #{ICP1_INCUBATION_TIME} </if>",
        "    <if test='ICP2_VESSEL != null'> , ICP2_VESSEL = #{ICP2_VESSEL} </if>",
        "    <if test='ICP2_MATERIAL_NAME != null'> , ICP2_MATERIAL_NAME = #{ICP2_MATERIAL_NAME} </if>",
        "    <if test='ICP2_VOLUME != null'> , ICP2_VOLUME = #{ICP2_VOLUME} </if>",
        "    <if test='ICP2_INCUBATION_TIME != null'> , ICP2_INCUBATION_TIME = #{ICP2_INCUBATION_TIME} </if>",
        "    <if test='ICP3_VESSEL != null'> , ICP3_VESSEL = #{ICP3_VESSEL} </if>",
        "    <if test='ICP3_MATERIAL_NAME != null'> , ICP3_MATERIAL_NAME = #{ICP3_MATERIAL_NAME} </if>",
        "    <if test='ICP3_VOLUME != null'> , ICP3_VOLUME = #{ICP3_VOLUME} </if>",
        "    <if test='ICP3_INCUBATION_TIME != null'> , ICP3_INCUBATION_TIME = #{ICP3_INCUBATION_TIME} </if>",
        "    <if test='PROTOCOL != null'> , PROTOCOL = #{PROTOCOL} </if>",
        "    <if test='STARTING_TIME != null'> , STARTING_TIME = #{STARTING_TIME} </if>",
        "    <if test='FINISH_TIME != null'> , FINISH_TIME = #{FINISH_TIME} </if>",
        "    <if test='PRE_CULTURE_KIT_RT_LABEL != null'> , PRE_CULTURE_KIT_RT_LABEL = #{PRE_CULTURE_KIT_RT_LABEL} </if>",
        "    <if test='PRE_CULTURE_KIT_P4T_LABEL != null'> , PRE_CULTURE_KIT_P4T_LABEL = #{PRE_CULTURE_KIT_P4T_LABEL} </if>",
        "    <if test='PRE_CULTURE_KIT_M20T_LABEL != null'> , PRE_CULTURE_KIT_M20T_LABEL = #{PRE_CULTURE_KIT_M20T_LABEL} </if>",
        "    <if test='PRE_CULTURE_COUNT != null'> , PRE_CULTURE_COUNT = #{PRE_CULTURE_COUNT} </if>",
        "    <if test='EX_CULTURE_KIT_RT_LABEL != null'> , EX_CULTURE_KIT_RT_LABEL = #{EX_CULTURE_KIT_RT_LABEL} </if>",
        "    <if test='EX_CULTURE_KIT_P4T_LABEL != null'> , EX_CULTURE_KIT_P4T_LABEL = #{EX_CULTURE_KIT_P4T_LABEL} </if>",
        "    <if test='EX_CULTURE_KIT_M20T_LABEL != null'> , EX_CULTURE_KIT_M20T_LABEL = #{EX_CULTURE_KIT_M20T_LABEL} </if>",
        "    <if test='STATUS != null'> , STATUS = #{STATUS} </if>",
        "  </set>",
        "  WHERE ",
        "       BATCH_ID = #{BATCH_ID}",
        "</script>",
    })
    int update(INSTRUCTIONS_TABLE model);
    
    @Delete("DELETE FROM INSTRUCTIONS_TABLE "
         +" WHERE "
            + "     BATCH_ID = #{BATCH_ID} "
         )
    int delete(INSTRUCTIONS_TABLE model);

    @Select({
     "<script>",
        "SELECT * FROM INSTRUCTIONS_TABLE ",
        "  <where>",
        "    <if test='BATCH_ID != &quot;&quot; and BATCH_ID != null'>",
        "      AND BATCH_ID = #{BATCH_ID}",
        "    </if>",
        "    <if test='IM_ID != &quot;&quot; and IM_ID != null'>",
        "      AND IM_ID = #{IM_ID}",
        "    </if>",
        "    <if test='NAME != &quot;&quot; and NAME != null'>",
        "      AND NAME = #{NAME}",
        "    </if>",
        "  </where>",
        "</script>",
    })
    List<INSTRUCTIONS_TABLE> select(INSTRUCTIONS_TABLE model);
    
}
