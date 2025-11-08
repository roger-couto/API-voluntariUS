package br.csi.eventos_voluntarios.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record EventoCadastroDTO(
        @NotBlank String titulo,
        @NotBlank String descricao,

        @NotNull
        @Future(message = "A data do evento deve ser futura.")
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime dataEvento,

        @NotBlank String local,

        @NotNull
        @Min(value = 1, message = "O número máximo de voluntários deve ser ao menos 1.")
        Integer maxVoluntarios
) {}