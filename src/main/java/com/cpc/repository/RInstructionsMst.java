package com.cpc.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import com.cpc.model.INSTRUCTIONS_MASTER;

/**
 * 製造指図マスタ repository
 */
@Mapper
@Component
public interface RInstructionsMst{
 
    @Insert("INSERT INTO INSTRUCTIONS_MASTER ( "
            + "  IM_ID "
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
            + ", MATERIAL_GORUP_ID "
            + ", PROTOCOL "
         +") VALUES ( "
            + "  #{IM_ID} "
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
            + ", #{MATERIAL_GORUP_ID} "
            + ", #{PROTOCOL} "
         +")"
         )
    int insert(INSTRUCTIONS_MASTER model);
    
    @Update({
        "<script>",
        "UPDATE INSTRUCTIONS_MASTER ",
        "  <set>",
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
        "    <if test='MATERIAL_GORUP_ID != null'> , MATERIAL_GORUP_ID = #{MATERIAL_GORUP_ID} </if>",
        "    <if test='PROTOCOL != null'> , PROTOCOL = #{PROTOCOL} </if>",
        "  </set>",
        "  WHERE ",
        "       IM_ID = #{IM_ID}",
        "</script>",
    })
    int update(INSTRUCTIONS_MASTER model);
    
    @Delete("DELETE FROM INSTRUCTIONS_MASTER "
         +" WHERE "
            + "     IM_ID = #{IM_ID} "
         )
    int delete(INSTRUCTIONS_MASTER model);

    @Select({
     "<script>",
        "SELECT * FROM INSTRUCTIONS_MASTER ",
        "  <where>",
        "    <if test='IM_ID != &quot;&quot; and IM_ID != null'>",
        "      AND IM_ID = #{IM_ID}",
        "    </if>",
        "    <if test='NAME != &quot;&quot; and NAME != null'>",
        "      AND NAME = #{NAME}",
        "    </if>",
        "    <if test='MATERIAL_GORUP_ID != &quot;&quot; and MATERIAL_GORUP_ID != null'>",
        "      AND MATERIAL_GORUP_ID = #{MATERIAL_GORUP_ID}",
        "    </if>",
        "  </where>",
        "</script>",
    })
    List<INSTRUCTIONS_MASTER> select(INSTRUCTIONS_MASTER model);
    
}
