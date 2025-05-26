package com.bootcamp.makemycake.repositories;

import com.bootcamp.makemycake.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDateTime;
import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
    @Query("SELECT c FROM Commande c WHERE c.client.id = :clientId")
    List<Commande> findByClientId(Long clientId);

    @Query("SELECT c FROM Commande c WHERE c.patisserie.id = :patisserieId")
    List<Commande> findByPatisserieId(Long patisserieId);

    @Query("SELECT c FROM Commande c WHERE c.statut = 'EN_ATTENTE' AND c.patisserie.id = :patisserieId")
    List<Commande> findPendingByPatisserieId(Long patisserieId);

    @Query("SELECT FUNCTION('DATE_FORMAT', c.dateCreation, :format) as period, " +
           "SUM(c.montantTotal) as total " +
           "FROM Commande c " +
           "WHERE c.patisserie.id = :patisserieId " +
           "AND c.statut = 'TERMINEE' " +
           "AND c.dateCreation BETWEEN :startDate AND :endDate " +
           "GROUP BY FUNCTION('DATE_FORMAT', c.dateCreation, :format) " +
           "ORDER BY period DESC")
    List<Object[]> findRevenueByPatisserieAndDateRange(
        @Param("patisserieId") Long patisserieId,
        @Param("format") String format,
        @Param("startDate") LocalDateTime startDate,
        @Param("endDate") LocalDateTime endDate
    );
}