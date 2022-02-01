package com.cpc.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import com.cpc.model.WORK_MASTER;

/**
 * 作業手順マスタ repository
 */
@Mapper
@Component
public interface RWorkMst{
 
    @Insert("INSERT INTO WORK_MASTER ( "
            + "  PROCESS_ID "
            + ", WORK_GROUP "
            + ", WORK_ID "
            + ", WORK "
            + ", AUTHORITY "
            + ", CAPTURE1 "
            + ", CAPTURE2 "
            + ", CAPTURE3 "
            + ", CAPTURE4 "
            + ", CAPTURE5 "
            + ", CSV1 "
            + ", CSV2 "
            + ", CSV3 "
            + ", CSV4 "
            + ", CSV5 "
         +") VALUES ( "
            + "  #{PROCESS_ID} "
            + ", #{WORK_GROUP} "
            + ", #{WORK_ID} "
            + ", #{WORK} "
            + ", #{AUTHORITY} "
            + ", #{CAPTURE1} "
            + ", #{CAPTURE2} "
            + ", #{CAPTURE3} "
            + ", #{CAPTURE4} "
            + ", #{CAPTURE5} "
            + ", #{CSV1} "
            + ", #{CSV2} "
            + ", #{CSV3} "
            + ", #{CSV4} "
            + ", #{CSV5} "
         +")"
         )
    int insert(WORK_MASTER model);
    
    @Update({
        "<script>",
        "UPDATE WORK_MASTER ",
        "  <set>",
        "    <if test='WORK != null'> , WORK = #{WORK} </if>",
        "    <if test='AUTHORITY != null'> , AUTHORITY = #{AUTHORITY} </if>",
        "    <if test='CAPTURE1 != null'> , CAPTURE1 = #{CAPTURE1} </if>",
        "    <if test='CAPTURE2 != null'> , CAPTURE2 = #{CAPTURE2} </if>",
        "    <if test='CAPTURE3 != null'> , CAPTURE3 = #{CAPTURE3} </if>",
        "    <if test='CAPTURE4 != null'> , CAPTURE4 = #{CAPTURE4} </if>",
        "    <if test='CAPTURE5 != null'> , CAPTURE5 = #{CAPTURE5} </if>",
        "    <if test='CSV1 != null'> , CSV1 = #{CSV1} </if>",
        "    <if test='CSV2 != null'> , CSV2 = #{CSV2} </if>",
        "    <if test='CSV3 != null'> , CSV3 = #{CSV3} </if>",
        "    <if test='CSV4 != null'> , CSV4 = #{CSV4} </if>",
        "    <if test='CSV5 != null'> , CSV5 = #{CSV5} </if>",
        "  </set>",
        "  WHERE ",
        "       PROCESS_ID = #{PROCESS_ID}",
        "   AND WORK_GROUP = #{WORK_GROUP}",
        "   AND WORK_ID = #{WORK_ID}",
        "</script>",
    })
    int update(WORK_MASTER model);
    
    @Delete("DELETE FROM WORK_MASTER "
         +" WHERE "
            + "     PROCESS_ID = #{PROCESS_ID} "
            + " AND WORK_GROUP = #{WORK_GROUP} "
            + " AND WORK_ID = #{WORK_ID} "
         )
    int delete(WORK_MASTER model);

    @Select({
     "<script>",
        "SELECT * FROM WORK_MASTER ",
        "  <where>",
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
    List<WORK_MASTER> select(WORK_MASTER model);
    
}
