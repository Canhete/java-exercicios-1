import java.util.ArrayList;
import java.util.List;

// Um ou mais estudantes podem se matricular em uma ou mais Cursos
// Relação de Muitos-para-Muitos

public class AssociacoEstudanteCurso {
    public static class Estudante {
        // Atributos
        private String nome;
        private List<Matricula> matriculas = new ArrayList<>(); // Lista de matriculas para cada Estudante

        // Constructor
        public Estudante(String nome) {
            this.nome = nome;
        }

        // Métodos
        public void matricular(Curso curso) {
            boolean jaMatriculado = matriculas.stream()
                    .filter(Matricula::isAtiva)
                    .anyMatch(m -> m.getCurso().equals(curso));

            if (jaMatriculado) {
                throw new IllegalStateException("Estudante já está matriculado nessa disciplina.");
            }

            Matricula m = new Matricula(this, curso);
            this.matriculas.add(m);
            curso.getMatriculas().add(m); // Mantém os dois lados sincronizados
        }

        // Estudante apenas busca — quem age é a Matrícula
        public Matricula buscarMatricula(Curso curso) {
            return matriculas.stream()
                    .filter(m -> m.getCurso().equals(curso))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Matrícula não encontrada."));
        }

        // Getters
        public String getNome() { return nome; }
    }

    public static class Matricula {
        // Classe de gerenciamento da relação entre Estudante e Curso
        private Estudante estudante;
        private Curso curso;
        private StatusMatricula status;

        enum StatusMatricula {
            ATIVA, TRANCADA, CANCELADA
        }

        // Constructor
        public Matricula(Estudante estudante, Curso curso) {
            this.estudante = estudante;
            this.curso = curso;
            this.status = StatusMatricula.ATIVA;
        }

        // Métodos
        public void trancar() {
            if (this.status == StatusMatricula.ATIVA) {
                this.status = StatusMatricula.TRANCADA;
            }
        }

        public void reativar() {
            if (this.status == StatusMatricula.TRANCADA) {
                this.status = StatusMatricula.ATIVA;
            }
        }

        public void cancelar() {
            if (this.status != StatusMatricula.CANCELADA) {
                this.status = StatusMatricula.CANCELADA;
            }
        }

        // Getters
        public Estudante getEstudante() { return estudante; }
        public Curso getCurso() { return curso; }
        public StatusMatricula getStatus() { return status; }
        public boolean isAtiva() { return this.status == StatusMatricula.ATIVA; }
    }

    public static class Curso {
        // Atributos
        private String titulo;
        private List<Matricula> matriculas = new ArrayList<>();

        // Constructor
        public Curso(String titulo) {
            this.titulo = titulo;
        }

        // Getters
        public String getTitulo() { return titulo; }
        public List<Matricula> getMatriculas() { return matriculas; }
    }

    public static void main(String[] args) {
        // Vetor de Estudantes
        ArrayList<Estudante> estudantes = new ArrayList<>();

        estudantes.add(new Estudante("Ana"));
        estudantes.add(new Estudante("Beto"));
        estudantes.add(new Estudante("Carlos"));
        estudantes.add(new Estudante("Dante"));
        estudantes.add(new Estudante("Eduardo"));
        estudantes.add(new Estudante("Fred"));

        // Vetor de Cursos
        ArrayList<Curso> cursos = new ArrayList<>();

        cursos.add(new Curso("Algoritmos e Programação"));
        cursos.add(new Curso("Banco de Dados"));
        cursos.add(new Curso("Álgebra Linear"));
        cursos.add(new Curso("Matemática Discreta"));
        cursos.add(new Curso("Metodologia Científica"));

        // Matriculas
        estudantes.get(0).matricular(cursos.get(0));
        estudantes.get(1).matricular(cursos.get(0));
        estudantes.get(2).matricular(cursos.get(1));
        estudantes.get(3).matricular(cursos.get(0));
        estudantes.get(4).matricular(cursos.get(2));
        estudantes.get(1).matricular(cursos.get(1));
        estudantes.get(0).matricular(cursos.get(4));
        estudantes.get(1).matricular(cursos.get(3));
        estudantes.get(0).matricular(cursos.get(2));
        estudantes.get(4).matricular(cursos.get(1));
        estudantes.get(2).matricular(cursos.get(0));
        estudantes.get(4).matricular(cursos.get(3));
        estudantes.get(4).matricular(cursos.get(4));

        // Trancaram e cancelaram
        estudantes.get(0).buscarMatricula(cursos.get(2)).cancelar();
        estudantes.get(1).buscarMatricula(cursos.get(0)).trancar();

        // Tabela
        int colNome = 10; // Largura da coluna de nomes
        int colStatus = 25;
        // Cabeçalho com nome das Cursos
        System.out.printf("%-" + colNome + "s", "Aluno");
        for (Curso c : cursos) {
            System.out.printf("%-" + colStatus + "s", c.getTitulo());
        }
        System.out.println();

        // Linha separadora
        int totalLargura = colNome + colStatus * cursos.size();
        System.out.println("-".repeat(totalLargura));

        // Linhas dos alunos
        for (Estudante e : estudantes) {
            System.out.printf("%-" + colNome + "s", e.getNome());

            for (Curso c : cursos) {
                String statusTexto;
                try {
                    Matricula m = e.buscarMatricula(c);
                    statusTexto = m.getStatus().toString();
                } catch (IllegalArgumentException ex) {
                    statusTexto = "-"; // Não matriculado
                }
                System.out.printf("%-" + colStatus + "s", statusTexto);
            }
            System.out.println();
        }

    }
}