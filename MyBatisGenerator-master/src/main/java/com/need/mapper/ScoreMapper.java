package com.need.mapper;

import com.need.entity.Score;
import com.need.entity.ScoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScoreMapper {
    long countByExample(ScoreExample example);

    int deleteByExample(ScoreExample example);

    int deleteByPrimaryKey(String sId);

    int insert(Score record);

    int insertSelective(Score record);

    List<Score> selectByExample(ScoreExample example);

    Score selectByPrimaryKey(String sId);

    int updateByExampleSelective(@Param("record") Score record, @Param("example") ScoreExample example);

    int updateByExample(@Param("record") Score record, @Param("example") ScoreExample example);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);
}