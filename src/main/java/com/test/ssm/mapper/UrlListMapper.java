package com.test.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.test.ssm.domain.DetailWithBLOBs;
import com.test.ssm.domain.UrlList;

public interface UrlListMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table url_list
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table url_list
     *
     * @mbggenerated
     */
    int insert(UrlList record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table url_list
     *
     * @mbggenerated
     */
    int insertSelective(UrlList record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table url_list
     *
     * @mbggenerated
     */
    UrlList selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table url_list
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(UrlList record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table url_list
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(UrlList record);

	List<UrlList> selectListByPage(@Param("page")int page);

	int getUrlListTotalPage();

}