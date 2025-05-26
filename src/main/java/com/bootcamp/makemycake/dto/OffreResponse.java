package com.bootcamp.makemycake.dto;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class OffreResponse {
    private Long id;
    private String typeEvenement;
    private Double kilos;
    private Double prix;
    private String photoUrl;
    private String ville;
    private boolean valide;
    private Long patisserieId;
    private String patisserieNom;
    private LocalDateTime createdAt;

    // Ajoutez ces champs
    private Long validatedByAdminId;
    private String validatedByAdminName;
}
