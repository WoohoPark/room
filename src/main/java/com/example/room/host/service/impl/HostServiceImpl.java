package com.example.room.host.service.impl;

import com.example.room.host.dao.HostDAO;
import com.example.room.host.dto.HostDto;
import com.example.room.host.service.HostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HostServiceImpl implements HostService {
    HostDAO hostDAO;
    @Override
    public HostDto create(HostDto hostDto) {
        return hostDAO.create(hostDto);
    }
}
