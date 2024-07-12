package br.unicamp.ic.inf335.beans;

public class ProdutoBean implements java.io.Serializable, Comparable<ProdutoBean>{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String codigo;
    private String nome;
    private String descricao;
    private Double valor;
    private String estado;

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        if (codigo == null ) throw new IllegalArgumentException("Código não informado");
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        if (nome == null ) throw new IllegalArgumentException("Nome não informado");
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        if (descricao == null ) throw new IllegalArgumentException("Descrição não informada");
        this.descricao = descricao;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        if (valor == null ) throw new IllegalArgumentException("Valor não informado");
        this.valor = valor;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        if (estado == null ) throw new IllegalArgumentException("Estado não informado");
        this.estado = estado;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public ProdutoBean () {
        codigo = new String();
        nome = new String();
        descricao = new String();
        valor = 0.0;
        estado = new String();
    }


    public ProdutoBean(String codigo, String nome, String descricao, Double valor, String estado) {
        super();
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.estado = estado;
    }

    @Override
    public int compareTo(ProdutoBean p) {
        if (valor > p.getValor()) {
            return 1;
        } else if (valor < p.getValor()) {
            return -1;
        } else
            return 0;
    }



}
