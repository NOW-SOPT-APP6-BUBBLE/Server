package com.sopt.mobile.repository;

import com.sopt.mobile.domain.ArtistMember;
import com.sopt.mobile.domain.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount, Long> {

}
