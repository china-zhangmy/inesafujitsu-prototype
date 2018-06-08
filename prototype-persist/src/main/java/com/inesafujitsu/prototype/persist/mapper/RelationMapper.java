package com.inesafujitsu.prototype.persist.mapper;

import com.inesafujitsu.prototype.model.business.Relation;
import org.apache.ibatis.annotations.*;

@Mapper
public interface RelationMapper {


    @Select("SELECT * FROM relation r WHERE r.x_table_name = #{xTableName} " +
            "and r.x_id = #{xId} " +
            "and r.y_table_name = #{yTableName} " +
            "and r.y_id = #{yId}")
    @Results({
            @Result(property = "xTableName", column = "x_table_name"),
            @Result(property = "xId", column = "x_id"),
            @Result(property = "yTableName", column = "y_table_name"),
            @Result(property = "yId", column = "y_id")
    })
    Relation getOne(@Param("xTableName") String xTableName,
                    @Param("xId") String xId,
                    @Param("yTableName") String yTableName,
                    @Param("yId") String yId);

    @Insert("INSERT INTO relation(x_table_name, x_id, y_table_name, y_id) " +
            "VALUES(#{xTableName}, #{xId}, #{yTableName}, #{yId})")
    void insert(@Param("xTableName") String xTableName,
                @Param("xId") String xId,
                @Param("yTableName") String yTableName,
                @Param("yId") String yId);

    @Delete("DELETE FROM relation WHERE x_table_name = #{xTableName} " +
            "and x_id = #{xId} " +
            "and y_table_name = #{yTableName} " +
            "and y_id = #{yId}")
    void delete(@Param("xTableName") String xTableName,
                @Param("xId") String xId,
                @Param("yTableName") String yTableName,
                @Param("yId") String yId);

}
