package br.csi.eventos_voluntarios.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "inscricoes", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"voluntario_id", "evento_id"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Inscricao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voluntario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evento_id", nullable = false)
    private Evento evento;

    @CreationTimestamp
    @Column(name = "data_inscricao", updatable = false)
    private LocalDateTime dataInscricao;

    private String status;
    private String observacoes;
}