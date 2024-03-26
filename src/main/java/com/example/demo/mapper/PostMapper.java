package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Post;

/* mybatis는 mapper를 붙인다 */
@Mapper
public interface PostMapper {
    public List<Post> listPost(); //listPost가 post.xml에 id가 listPost인 쿼리를 참고
    
}
