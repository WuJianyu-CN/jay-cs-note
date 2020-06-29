package com.jay.mapper;

import com.jay.pojo.Blog;
import com.jay.utils.IdUtils;
import com.jay.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.time.LocalDate;
import java.util.*;

public class BlogMapperTest {

    @Test
    public void addBlog() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

            Blog blog = new Blog();
            blog.setId(IdUtils.getId());
            blog.setTitle("Easy life");
            blog.setAuthor("Jay Wu");
            blog.setCreateTime(LocalDate.now());
            blog.setViews(9999);
            mapper.addBlog(blog);

            blog.setId(IdUtils.getId());
            blog.setTitle("Easy work");
            mapper.addBlog(blog);

            blog.setId(IdUtils.getId());
            blog.setTitle("Easy study");
            mapper.addBlog(blog);


            blog.setId(IdUtils.getId());
            blog.setTitle("Easy traver");
            mapper.addBlog(blog);
        }
    }

    @Test
    public void queryBlogIF() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            Map<String, Object> map = new HashMap<>();
            map.put("title", "Easy%");
            map.put("author", "Jay Wu");

            List<Blog> blogs = mapper.queryBlogIF(map);
            blogs.forEach(System.out::println);
        }
    }

    @Test
    public void queryBlogChoose() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            Map<String, Object> map = new HashMap<>();
            map.put("title", "Easy%");
            map.put("author", "Jay Wu");

            List<Blog> blogs = mapper.queryBlogChoose(map);
            blogs.forEach(System.out::println);

        }
    }

    @Test
    public void queryBlogWhere() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            Map<String, Object> map = new HashMap<>();
            map.put("title", "Easy%");
            map.put("author", "Jay Wu");

            List<Blog> blogs = mapper.queryBlogWhere(map);
            blogs.forEach(System.out::println);

        }
    }

    @Test
    public void queryBlogForEach() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            Map<String, Object> map = new HashMap<>();
            ArrayList<Integer> ids = new ArrayList<>();
            ids.add(1);
            ids.add(3);
            map.put("ids", ids);

            List<Blog> blogs = mapper.queryBlogForEach(map);
            blogs.forEach(System.out::println);
        }
    }

    @Test
    public void updateBlog() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            Map<String, Object> map = new HashMap<>();
            map.put("title", "Easy life2");
            map.put("author", "Jay Wu");
            map.put("id", "d7859b90c7854291a3749955eaf26155");

            List<Blog> blogs = mapper.updateBlog(map);
            blogs.forEach(System.out::println);
        }
    }

    @Test
    public void deleteBlogByAuthor() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            mapper.deleteBlogByAuthor("Jay Wu");
        }
    }


}