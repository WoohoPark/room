package com.example.room.host.dao.impl;

import com.example.room.host.dao.HostDAO;
import com.example.room.host.dto.HostDto;
import com.example.room.host.entity.Host;
import com.example.room.host.repository.HostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class HostDAOImpl implements HostDAO {

    HostRepository hostRepository;
    @Override
    public HostDto create(HostDto hostDto){
        Host host = hostDto.toEntity();
        return new HostDto(hostRepository.save(host));
    }
}
