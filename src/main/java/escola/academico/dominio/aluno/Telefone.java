package escola.academico.dominio.aluno;

public class Telefone {

    private String ddd;
    private String numero;

    public Telefone(String ddd, String numero) {
        if(ddd == null || numero == null){
            throw new IllegalArgumentException("DDD e número do telefone são obrigatórios.");
        }
        if(!ddd.matches("\\d{2}")){
            throw new IllegalArgumentException("DDD inválido.");
        }
        if(!numero.matches("\\d{8}|\\d{9}")){
            throw new IllegalArgumentException("Número de telefone inválido.");
        }

        this.ddd = ddd;
        this.numero = numero;
    }

    public String getDdd() {
        return ddd;
    }

    public String getNumero() {
        return numero;
    }
}
