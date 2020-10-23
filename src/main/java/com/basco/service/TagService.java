package com.basco.service;

import com.basco.pojo.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface TagService {

    Tag saveTag(Tag tag);

    void deleteTag(Long id);

    Tag updateTage(Long id, Tag tag);

    Tag getTag(Long id);

    Tag getTagByName(String name);

    List<Tag> listTag(String ids);

    Page<Tag> listTag(Pageable pageable);

    List<Tag> listTag();

    List<Tag> listTagTop(Integer size);

    Tag updateTag(Long id, Tag tag);
}
