package com.jay.mapper;

import com.jay.pojo.Blog;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    // insert
    int addBlog(Blog blog);

    // query
    List<Blog> queryBlogIF(Map<String, Object> map);

    // query
    List<Blog> queryBlogChoose(Map<String, Object> map);

    // query
    List<Blog> queryBlogWhere(Map<String, Object> map);

    //update
    List<Blog> updateBlog(Map<String, Object> map);

    // query
    List<Blog> queryBlogForEach(Map<String, Object> map);

    // delete
    int deleteBlogByAuthor(@Param("author") String author);
}
