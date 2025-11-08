package br.csi.eventos_voluntarios.dto;

public record DadosToken(String token, String tipo) {
    public DadosToken(String token) {
        this(token, "Bearer");
    }
}