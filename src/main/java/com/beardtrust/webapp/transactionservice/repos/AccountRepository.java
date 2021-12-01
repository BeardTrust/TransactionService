/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beardtrust.webapp.transactionservice.repos;

import com.beardtrust.webapp.transactionservice.entities.AccountEntity;
import com.beardtrust.webapp.transactionservice.entities.FinancialAsset;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Nathanael <Nathanael.Grier at your.org>
 */
@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, String> {
    
    Page<AccountEntity> findByCreateDate(LocalDate createDate, Pageable page);

    @Override
    Page<AccountEntity> findAll(Pageable page);

    public Page<AccountEntity> findAllByUser_UserId(String userId, Pageable page);

    public Page<AccountEntity> findAllByUser_UserIdAndInterestOrBalance_DollarsOrBalance_Cents(String id, Integer newSearch, Integer newSearch0, Integer newSearch1, Pageable page);

    public Page<AccountEntity> findAllByUser_UserIdAndCreateDate(String id, LocalDate parse, Pageable page);

    public Page<AccountEntity> findAllByBalance_DollarsOrBalance_CentsOrInterestIsLike(Integer newSearch, Integer newSearch0, Integer newSearch1, Pageable page);

    public List<AccountEntity> findAllByUser_UserId(String userId);

    Page<AccountEntity> findAllIgnoreCaseByNicknameContainingOrType_IdOrType_NameContainingOrType_IsActiveAndUser_UserIdIs(String search, String search1, String search2, Boolean valueOf, String search3, Pageable page);

    Page<AccountEntity> findByUser_UserIdAndNicknameContainingOrUser_UserIdAndType_IdOrUser_UserIdAndType_NameContainingOrUser_UserIdAndType_IsActiveOrUser_UserIdAndIdAllIgnoreCase(String id, String search, String id1, String search1, String id2, String search2, String id3, Boolean valueOf, String id4, String search3, Pageable page);

    List<FinancialAsset> findAllByType_IdAndBalance_DollarsGreaterThanAndBalance_IsNegativeAndType_IsActive(String s, int dollars, boolean b, boolean b1);

    List<FinancialAsset> findAllByType_IdAndBalance_DollarsGreaterThanAndBalance_IsNegativeIs(String s, int dollars, boolean b);
}
