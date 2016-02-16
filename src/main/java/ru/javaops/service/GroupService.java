package ru.javaops.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.javaops.model.Group;
import ru.javaops.repository.GroupRepository;

/**
 * GKislin
 * 15.02.2016
 */
@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    @Cacheable("group")
    public Group getByName(String name) {
        return groupRepository.findByName(name);
    }
}
