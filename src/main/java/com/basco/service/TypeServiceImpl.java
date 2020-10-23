package com.basco.service;

import com.basco.NotFoundException;
import com.basco.dao.TpyeRepository;
import com.basco.pojo.Type;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TpyeRepository tpyeRepository;

    @Transactional
    @Override
    public Type saveType(Type type) {
        return tpyeRepository.save(type);
    }

    @Transactional
    @Override
    public void deleteType(Long id) {
        tpyeRepository.deleteById(id);
    }
    @Transactional
    @Override
    public Type updateType(Long id, Type type) {
        Type t = tpyeRepository.findById(id).orElse(null);
        if (t == null) {
            throw new NotFoundException("ID不存在");
        }
        BeanUtils.copyProperties(type, t);
        return tpyeRepository.save(t);
    }

    @Transactional
    @Override
    public Type getType(Long id) {
        return tpyeRepository.getOne(id);
    }

    @Override
    public Type getTypeByName(String name) {
        return tpyeRepository.findByName(name);
    }

    @Transactional
    @Override
    public Page<Type> listType(Pageable pageable) {
        return tpyeRepository.findAll(pageable);
    }

    @Override
    public List<Type> listType() {
        return tpyeRepository.findAll();
    }

    @Override
    public List<Type> listTypeTop(Integer size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "blogs.size");
        Pageable pageable = PageRequest.of(0,size,sort);
        return tpyeRepository.findTop(pageable);
    }
}
