package dto;

import java.time.LocalDateTime;

public class EditalDTO {
    private LocalDateTime dataInicio;
    private LocalDateTime dataLimite;
    private String disciplinas;
    private int vagas;
    private float pesoCRE;
    private float pesoDisciplina;

    public EditalDTO(LocalDateTime dataInicio, LocalDateTime dataLimite, String disciplinas, int vagas, float pesoCRE, float pesoDisciplina) {
        this.dataInicio = dataInicio;
        this.dataLimite = dataLimite;
        this.disciplinas = disciplinas;
        this.vagas = vagas;
        this.pesoCRE = pesoCRE;
        this.pesoDisciplina = pesoDisciplina;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(LocalDateTime dataLimite) {
        this.dataLimite = dataLimite;
    }

    public String getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(String disciplinas) {
        this.disciplinas = disciplinas;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public float getPesoCRE() {
        return pesoCRE;
    }

    public void setPesoCRE(float pesoCRE) {
        this.pesoCRE = pesoCRE;
    }

    public float getPesoDisciplina() {
        return pesoDisciplina;
    }

    public void setPesoDisciplina(float pesoDisciplina) {
        this.pesoDisciplina = pesoDisciplina;
    }
}
