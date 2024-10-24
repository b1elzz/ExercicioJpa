package aula22_10;

import javax.persistence.*;

@Entity
@Table(name = "REGISTRO")
public class Registro {


    @Id
    @GeneratedValue(strategy=GenerationType.TABLE , generator="registro_generator")
    @TableGenerator(name="registro_generator",
            table="chave",
            pkColumnName="id",
            valueColumnName="valor",
            allocationSize=1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sobreNome")
    private String sobreNome;

    @Column(name = "idade")
    private int idade;


    public Registro(){

    }

    public Registro(String nome, String sobrenome, Integer idade){
        this.nome = nome;
        this.sobreNome = sobrenome;
        this.idade = idade;
    }

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getSobreNome() {
        return sobreNome;
    }


    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }


    public int getIdade() {
        return idade;
    }


    public void setIdade(int idade) {
        this.idade = idade;
    }


    


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((sobreNome == null) ? 0 : sobreNome.hashCode());
        result = prime * result + idade;
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Registro other = (Registro) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (sobreNome == null) {
            if (other.sobreNome != null)
                return false;
        } else if (!sobreNome.equals(other.sobreNome))
            return false;
        if (idade != other.idade)
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "Registro [id=" + id + ", nome=" + nome + ", sobreNome=" + sobreNome + ", idade=" + idade + "]";
    }

    


}
