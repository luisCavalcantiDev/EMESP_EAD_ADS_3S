package br.metodista.ead.scs13.main;

import br.metodista.ead.scs13.enumeracoes.*;

public class TestEnumeracoes {

    public static void main(String[] args) {
        
        System.out.println("Exibindo enumerações...");
        System.out.println("*****************************************");
        
        System.out.println("Cursos");        
        for (Cursos _curso : Cursos.values()) {
            System.out.println("Curso: " + _curso);
            System.out.println("Atributos:");
            System.out.println("Nome: " + _curso.getNome());
            System.out.println("Tipo:" + _curso.getTipo());
            System.out.println("---------------------------------------------");
        }
        
        System.out.println("*****************************************");
        
        System.out.println("Databases");        
        for (Databases _database : Databases.values()) {
            System.out.println("Database: " + _database);
            System.out.println("Atributos: ");
            System.out.println("Fornecedor: " + _database.getFornecedor());
            System.out.println("Versão: " + _database.getVersao());
            System.out.println("---------------------------------------------");
        }
                
        System.out.println("*****************************************");
        
        System.out.println("PolosMetodista");        
        for (PolosMetodista _poloMetodista : PolosMetodista.values()) {
            System.out.println("Polo: " + _poloMetodista);
            System.out.println("Atributos:");
            System.out.println("Estado: " + _poloMetodista.getNomeEstado());
            System.out.println("UF: " + _poloMetodista.getUF());
            System.out.println("---------------------------------------------");
        }
                
        System.out.println("*****************************************");
        
        System.out.println("Profissoes");        
        for (Profissoes _profissao : Profissoes.values()) {
            System.out.println("Profissão: " + _profissao);
            System.out.println("Atributos:");
            System.out.println("Descrição: " + _profissao.getDescricao());
            System.out.println("Média Salário: " + _profissao.getMediaSalario());
            System.out.println("---------------------------------------------");
        }
                
        System.out.println("*****************************************");
        
        System.out.println("Tecnologias");        
        for (Tecnologias _tecnologia : Tecnologias.values()) {
            System.out.println("Tecnologia: " + _tecnologia);
            System.out.println("Atributos:");
            System.out.println("Descrição: " + _tecnologia.getDescricao());
            System.out.println("Empresa: " + _tecnologia.getEmpresa());
            System.out.println("---------------------------------------------");
        }
    }    
}
