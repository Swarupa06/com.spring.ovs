package com.spring.ovs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.ovs.dtos.CooperativeSociety;


public interface CooperativeSocietyRepository extends JpaRepository< CooperativeSociety, Integer> {

}