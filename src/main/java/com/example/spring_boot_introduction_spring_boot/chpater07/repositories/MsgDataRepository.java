package com.example.spring_boot_introduction_spring_boot.chpater07.repositories;

import com.example.spring_boot_introduction_spring_boot.chpater07.MsgData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MsgDataRepository extends JpaRepository<MsgData, Long> {
}
