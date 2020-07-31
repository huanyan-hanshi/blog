package com.lin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lin.entity.Blog;
import com.lin.queryvo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BlogDao extends BaseMapper<Blog>{
    ShowBlog getBlogById(Long id);

    List<Blog> getAllBlog();

    List<BlogQuery> getAllBlogQuery();


    int updateBlog(ShowBlog showBlog);


    List<BlogQuery> searchByTitleOrTypeOrRecommend(SearchBlog searchBlog);

    List<FirstPageBlog> getFirstPageBlog();

    List<RecommendBlog> getAllRecommendBlog();


    List<FirstPageBlog> getSearchBlog(@Param("query") String query);

    DetailedBlog getDetailedBlog(Long id);

    int updateViews(Long id);

    //    根据博客id查询出评论数量
    int getCommentCountById(Long id);

    List<FirstPageBlog> getByTypeId(Long typeId);

    Integer getBlogViewTotal();


}
