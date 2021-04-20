package com.cargo.repository;

import com.cargo.model.Parcel;
import com.cargo.model.enums.ParcelStatus;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParcelRepository extends JpaRepository<Parcel, Long> {

    List<Parcel> findAllByAccount_Id(long id, Sort sort);

    List<Parcel> findAllByStatus(ParcelStatus status, Sort sort);

}
