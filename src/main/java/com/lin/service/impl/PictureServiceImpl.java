package com.lin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.dao.PictureDao;
import com.lin.entity.Picture;
import com.lin.service.PictureService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("pictureService")
public class PictureServiceImpl extends ServiceImpl<PictureDao, Picture> implements PictureService {
    @Override
    public List<Picture> listPicture() {
        return baseMapper.selectList(new QueryWrapper<Picture>().select("*").orderByDesc());
    }

    @Override
    public int savePicture(Picture picture) {
        return baseMapper.insert(picture);
    }

    @Override
    public Picture getPicture(Long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public int updatePicture(Picture picture) {
        return baseMapper.updateById(picture);
    }

    @Override
    public void deletePicture(Long id) {
        baseMapper.deleteById(id);
    }
}
