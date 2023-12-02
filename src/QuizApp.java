import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizApp extends JFrame {
    private JLabel questionLabel;
    private JRadioButton optionARadioButton, optionBRadioButton, optionCRadioButton, optionDRadioButton;
    private JButton submitButton;
    private int currentQuestionIndex = 0;
    private int totalQuestions = 15; // Número total de perguntas
    private int correctAnswers = 0;

    private String[] questions = {
            "A Segunda Grande Guerra (1939-1945) adquiriu caráter mundial a partir de 7 de dezembro de 1941, quando",
            "Uma das principais causas da Segunda Guerra Mundial foi",
            "Como foi a participação do Brasil na Segunda Guerra Mundial ?",
            "O que aconteceu no evento conhecido como Dia D ?",
            "Em 1939, foi assinado o Tratado de não agressão Germano-Soviético. Qual o nome deste tratado?",
            "Com relação aos eventos que compõem a Segunda Guerra Mundial, assinale a alternativa correta:",
            "Inúmeras foram as guerras realizadas na história da humanidade. Umas curtas, outras longas, umas com poucos mortos, outras com milhões. Com certeza, a maior no quesito mortes foi a Segunda Guerra Mundial. Indique a alternativa que não é considerada uma de suas causas:",
            "Sobre a participação do Brasil na Segunda Guerra, marque a alternativa correta.",
            "A guerra travada por Japão e China e que acontecia paralelamente à Segunda Guerra Mundial recebeu qual nome?",
            "Qual dos países abaixo não foi invadido pelos nazistas ao longo da Segunda Guerra Mundial?",
            "Cidade soviética que foi cercada pelas tropas nazistas e foi deixada para que a população local morresse de fome:" ,
            "A primeira grande derrota japonesa na Segunda Guerra Mundial ocorreu durante a/o:",
            "Qual das batalhas abaixo NÃO aconteceu na Segunda Guerra Mundial?",
            "A ordem geopolítica do pós-Segunda Guerra Mundial articulou a bipolarização do poder entre",
            "Em relação à Segunda Guerra Mundial é correto afirmar que:"
    };
    private String[] correctAnswersArray = {"C", "B", "D", "B", "A", "B", "C", "A", "B", "D", "B", "A", "D", "C", "A"};
    private String[][] options = {
            {"A) Os russos tomaram a iniciativa de anexar os Estados Bálticos.", "B) Os alemães invadiram o litoral mediterrâneo da África", "C) Os japoneses atacaram a base norte-americana de Pearl Harbor", "D) Os franceses, por determinação do marechal Pétain, ocuparam o Sudeste da Ásia"},
            {"A) A rivalidade política e militar entre Alemanha e Itália no final da década de 1930.", "B) O surgimento e fortalecimento, na década de 1930, de governos totalitários na Europa, com objetivos expansionistas e militaristasa", "C) A política expansionista da França, que invadiu e conquistou vários territórios na Europa e na África no final da década de 1930.", "D) A aliança militar estabelecida por Itália, Alemanha e Estados Unidos no começo da década de 1930."},
            {"A) O Brasil participou enviando apenas medicamentos e médicos para ajudar os feridos de guerra das tropas aliadas.", "B) O Brasil ficou ao lado do Eixo e enviou soldados que combateram as forças aliadas em território italiano.", "C) O Brasil participou apenas fazendo a proteção do litoral e enviando armamentos às forças aliadas.", "D) O Brasil enviou soldados que combateram ao lado dos Aliados, principalmente em territórios da Itália."},
            {"A) A invasão alemã no território francês em 1940", "B) A invasão da Normandia pelas tropas aliadas em 1944.", "C) A ocupação da Polônia pela Alemanha em 1939.", "D) A ocupação do território alemão pelas tropas dos Estados Unidos em 1945."},
            {"A) Pacto Molotov-Ribbentrop", "B) Pacto de Varsóvia", "C) Tratado de Guerra da Alemanha.", "D) Acordo Econômico germano-soviético."},
            {"A) O pacto de não agressão nazi-soviético, firmado antes do início dos conflitos, serviu aos interesses de Stalin de organização de seu exército e posterior invasão da Polônia e Áustria.", "B) Os exércitos nazistas comandados por Hitler tiveram problemas para manter os inúmeros frontes de batalha criados após o período da guerra relâmpago (Blitzkrieg), principalmente pela ineficiência dos exércitos que compunham o Eixo.", "C) A guerra na África vencida pelos alemães foi o fator decisivo para que os exércitos nazistas pudessem alcançar o Canal da Mancha e infringir sérios danos à cidade de Londres por meio dos bombardeios da Luftwaffe.", "D) Os aliados começaram a contraofensiva ao Eixo pela península Balcânica, invadindo as ilhas gregas e depois promovendo a libertação total do território da Grécia."},
            {"A) Tratado de Versalhes.", "B) Corrida Armamentista.", "C) Revanchismo Francês frente à Alemanha.", "D) Imperialismo Italiano."},
            {"A) Apoiando o grupo dos Aliados, o país teve uma importante participação na Batalha de Monte Castelo.", "B) Em oposição aos Estados Unidos, Vargas ficou, em primeiro momento, ao lado das potências do Eixo.", "C) O país mostrou neutralidade até o fim do conflito, pois temia uma investida alemã.", "D) Após diversos ataques a navios brasileiros por parte dos alemães, Getúlio Vargas entrou no conflito, mas somente oferecendo auxílio na distribuição de suprimentos"},
            {"A) Primeira Guerra Sino-Japonesa", "B) Segunda Guerra Sino-Japonesa", "C) Guerra do Ópio", "D) Guerra do Pacífico"},
            {"A) Noruega", "B) Iugoslávia", "C) Bélgica", "D) Suíça"},
            {"A) Moscou", "B) Leningrado", "C) Kiev", "D) Stalingrado"},
            {"A) Batalha de Midway", "B) Batalha de Guadalcanal", "C) Batalha das Filipinas", "D) Invasão da Birmânia"},
            {"A) Batalha das Ardenas", "B) Cerco a Budapeste", "C) Batalha de Berlim", "D) Batalha de Verdun"},
            {"A)Alemanha Ocidental e Alemanha Oriental, com a instituição do Muro de Berlim.", "B)Rússia e China, com a instituição do protecionismo econômico.", "C)Estados Unidos e União Soviética, com a chamada Guerra Fria.", "D)Coreia do Norte e Coreia do Sul, com a deflagração da Guerra da Coreia."},
            {"A)Hitler empreendeu uma implacável perseguição aos judeus, que resultou na morte de seis milhões de pessoas.", "B)Os norte-americanos permaneceram neutros na guerra até 1941, quando bombardearam Hiroshima e Nagasaki.", "C)De Gaulle foi o chefe do governo de Vichy.", "D)Com o ataque alemão a Pearl Harbor, os norte-americanos resolveram entrar na guerra."}
    };

    public QuizApp() {
        setTitle("Quiz App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 300);
        setLocationRelativeTo(null);

        initializeComponents();

        setLayout(new GridLayout(6, 1));
        add(questionLabel);
        add(optionARadioButton);
        add(optionBRadioButton);
        add(optionCRadioButton);
        add(optionDRadioButton);
        add(submitButton);

        setVisible(true);
        startQuiz();
    }

    private void initializeComponents() {
        questionLabel = new JLabel(questions[currentQuestionIndex]);
        optionARadioButton = new JRadioButton(options[currentQuestionIndex][0]);
        optionBRadioButton = new JRadioButton(options[currentQuestionIndex][1]);
        optionCRadioButton = new JRadioButton(options[currentQuestionIndex][2]);
        optionDRadioButton = new JRadioButton(options[currentQuestionIndex][3]);
        submitButton = new JButton("Responder");

        ButtonGroup group = new ButtonGroup();
        group.add(optionARadioButton);
        group.add(optionBRadioButton);
        group.add(optionCRadioButton);
        group.add(optionDRadioButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
            }
        });
    }

    private void startQuiz() {
    }

    private void checkAnswer() {
        String correctAnswer = correctAnswersArray[currentQuestionIndex];

        // Lógica para verificar a resposta correta e destacar as opções
        if (optionARadioButton.isSelected() && correctAnswer.equals("A")) {
            highlightCorrectAnswer(optionARadioButton);
            correctAnswers++;
        } else if (optionBRadioButton.isSelected() && correctAnswer.equals("B")) {
            highlightCorrectAnswer(optionBRadioButton);
            correctAnswers++;
        } else if (optionCRadioButton.isSelected() && correctAnswer.equals("C")) {
            highlightCorrectAnswer(optionCRadioButton);
            correctAnswers++;
        } else if (optionDRadioButton.isSelected() && correctAnswer.equals("D")) {
            highlightCorrectAnswer(optionDRadioButton);
            correctAnswers++;
        } else {
            highlightIncorrectAnswer(correctAnswer);
        }

        // Adicione aqui a lógica para passar para a próxima pergunta ou exibir os resultados finais
        if (currentQuestionIndex < totalQuestions - 1) {
            currentQuestionIndex++;
            loadNextQuestion();
        } else {
            showFinalResults();
        }
    }

    private void highlightCorrectAnswer(JRadioButton option) {
        option.setForeground(Color.GREEN);
        JOptionPane.showMessageDialog(this, "Resposta correta!");
    }

    private void highlightIncorrectAnswer(String correctAnswer) {
        for (int i = 0; i < options[currentQuestionIndex].length; i++) {
            if (correctAnswer.equals("A") && i == 0) {
                setCorrectOptionColor(i);
            } else if (correctAnswer.equals("B") && i == 1) {
                setCorrectOptionColor(i);
            } else if (correctAnswer.equals("C") && i == 2) {
                setCorrectOptionColor(i);
            } else if (correctAnswer.equals("D") && i == 3) {
                setCorrectOptionColor(i);
            }

            if (optionARadioButton.isSelected() && i == 0) {
                setIncorrectOptionColor(i);
            } else if (optionBRadioButton.isSelected() && i == 1) {
                setIncorrectOptionColor(i);
            } else if (optionCRadioButton.isSelected() && i == 2) {
                setIncorrectOptionColor(i);
            } else if (optionDRadioButton.isSelected() && i == 3) {
                setIncorrectOptionColor(i);
            }
        }

        JOptionPane.showMessageDialog(this, "Resposta incorreta!\nA resposta correta é: " + correctAnswer);
    }

    private void setCorrectOptionColor(int index) {
        if (index == 0) {
            optionARadioButton.setForeground(Color.GREEN);
        } else if (index == 1) {
            optionBRadioButton.setForeground(Color.GREEN);
        } else if (index == 2) {
            optionCRadioButton.setForeground(Color.GREEN);
        } else if (index == 3) {
            optionDRadioButton.setForeground(Color.GREEN);
        }
    }

    private void setIncorrectOptionColor(int index) {
        if (index == 0) {
            optionARadioButton.setForeground(Color.RED);
        } else if (index == 1) {
            optionBRadioButton.setForeground(Color.RED);
        } else if (index == 2) {
            optionCRadioButton.setForeground(Color.RED);
        } else if (index == 3) {
            optionDRadioButton.setForeground(Color.RED);
        }
    }

    private void loadNextQuestion() {
        questionLabel.setText(questions[currentQuestionIndex]);
        optionARadioButton.setText(options[currentQuestionIndex][0]);
        optionBRadioButton.setText(options[currentQuestionIndex][1]);
        optionCRadioButton.setText(options[currentQuestionIndex][2]);
        optionDRadioButton.setText(options[currentQuestionIndex][3]);

        optionARadioButton.setForeground(Color.BLACK);
        optionBRadioButton.setForeground(Color.BLACK);
        optionCRadioButton.setForeground(Color.BLACK);
        optionDRadioButton.setForeground(Color.BLACK);
    }

    private void showFinalResults() {
        double percentage = (correctAnswers * 100.0) / totalQuestions;

        JOptionPane.showMessageDialog(
                this,
                "Quiz concluído!\nNúmero de acertos: " + correctAnswers +
                        "\nPorcentagem de acertos: " + String.format("%.2f", percentage) + "%",
                "Resultados",
                JOptionPane.INFORMATION_MESSAGE
        );
        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new QuizApp();
            }
        });
    }
}
