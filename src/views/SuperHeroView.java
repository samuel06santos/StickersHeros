package views;

import controllers.SuperHeroController;
import models.SuperHero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

public class SuperHeroView extends JFrame {
    private SuperHeroController controller;

    private JTextField txtNome, txtDescricao, txtPoderes, txtGrupo, txtHabilidades;
    private JButton btnAnterior, btnProximo, btnAdicionar, btnRemover, btnAtualizar, btnSelecionarImagem, btnAbrirVideo;
    private JLabel lblImagem;
    private File imagemSelecionada, videoSelecionado;

    public SuperHeroView() {
        controller = new SuperHeroController();

        setTitle("Stickers Heros");
        setSize(1080, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Painel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        txtNome = new JTextField();
        txtNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
        txtNome.setPreferredSize(new Dimension(150, 25));

        txtGrupo = new JTextField();
        txtGrupo.setFont(new Font("Tahoma", Font.PLAIN, 18));
        txtGrupo.setPreferredSize(new Dimension(150, 25));

        txtDescricao = new JTextField();
        txtDescricao.setFont(new Font("Tahoma", Font.PLAIN, 18));
        txtDescricao.setPreferredSize(new Dimension(150, 100));

        txtPoderes = new JTextField();
        txtPoderes.setFont(new Font("Tahoma", Font.PLAIN, 18));
        txtPoderes.setPreferredSize(new Dimension(150, 100));

        txtHabilidades = new JFormattedTextField();
        txtHabilidades.setFont(new Font("Tahoma", Font.PLAIN, 18));
        txtHabilidades.setPreferredSize(new Dimension(150, 100) );


        // Painel de formulários
        JPanel panelFormulario = new JPanel(new GridBagLayout());
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Dados do Herói"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panelFormulario.add(new JLabel("Nome:"), gbc);
        gbc.gridx = 1;
        panelFormulario.add(txtNome, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panelFormulario.add(new JLabel("Grupo:"), gbc);

        gbc.gridx = 1;
        panelFormulario.add(txtGrupo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panelFormulario.add(new JLabel("Descrição:"), gbc);

        gbc.gridx = 1;
        panelFormulario.add(txtDescricao, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panelFormulario.add(new JLabel("Poderes:"), gbc);

        gbc.gridx = 1;
        panelFormulario.add(txtPoderes, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panelFormulario.add(new JLabel("Habilidades:"), gbc);

        gbc.gridx = 1;
        panelFormulario.add(txtHabilidades, gbc);

        // Painel de imagem
        JPanel panelImagem = new JPanel(new BorderLayout());
        panelImagem.setBorder(BorderFactory.createTitledBorder("Imagem do Herói"));
        lblImagem = new JLabel("Nenhuma imagem selecionada", SwingConstants.CENTER);
        lblImagem.setPreferredSize(new Dimension(150, 150));
        lblImagem.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelImagem.add(lblImagem, BorderLayout.CENTER);

        btnSelecionarImagem = new JButton("Selecionar Imagem");
        panelImagem.add(btnSelecionarImagem, BorderLayout.SOUTH);

        // Painel de botões
        JPanel panelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelBotoes.setBorder(BorderFactory.createTitledBorder("Ações"));

        btnAnterior = new JButton("◀ Anterior");
        btnProximo = new JButton("Próximo ▶");
        btnAdicionar = new JButton("Adicionar");
        btnRemover = new JButton("Remover");
        btnAtualizar = new JButton("Atualizar");
        btnAbrirVideo = new JButton("Abrir Vídeo");

        panelBotoes.add(btnAnterior);
        panelBotoes.add(btnProximo);
        panelBotoes.add(btnAdicionar);
        panelBotoes.add(btnRemover);
        panelBotoes.add(btnAtualizar);
        panelBotoes.add(btnAbrirVideo);


        panelPrincipal.add(panelFormulario, BorderLayout.CENTER);
        panelPrincipal.add(panelImagem, BorderLayout.EAST);
        panelPrincipal.add(panelBotoes, BorderLayout.SOUTH);
        add(panelPrincipal);

        carregarHeroiAtual();
        configurarEventos();

        configurarAtalhosTeclado();

        setVisible(true);
    }

    private void carregarHeroiAtual() {
        SuperHero heroi = controller.getHeroiAtual();
        if (heroi != null) {
            txtNome.setText(heroi.getNome());
            txtDescricao.setText(heroi.getDescricao());
            txtPoderes.setText(heroi.getPoderes());
            txtGrupo.setText(heroi.getGrupo());
            txtHabilidades.setText(heroi.getHabilidades());

            if (!heroi.getImagemPath().isEmpty()) {
                lblImagem.setIcon(new ImageIcon(new ImageIcon(heroi.getImagemPath()).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
            } else {
                lblImagem.setIcon(null);
                lblImagem.setText("Nenhuma imagem");
            }
        }
    }

    private void configurarEventos() {
        btnAnterior.addActionListener(e -> {
            controller.heroiAnterior();
            carregarHeroiAtual();
        });

        btnProximo.addActionListener(e -> {
            controller.proximoHeroi();
            carregarHeroiAtual();
        });

        btnAdicionar.addActionListener(e -> {
            controller.adicionarHeroi(
                    txtNome.getText(),
                    txtDescricao.getText(),
                    txtPoderes.getText(),
                    txtGrupo.getText(),
                    txtHabilidades.getText(),
                    imagemSelecionada != null ? imagemSelecionada.getAbsolutePath() : "",
                    videoSelecionado != null ? videoSelecionado.getAbsolutePath() : ""
            );
            JOptionPane.showMessageDialog(this, "Herói adicionado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            carregarHeroiAtual();
        });

        btnRemover.addActionListener(e -> {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja remover este herói?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                controller.removerHeroi(txtNome.getText());
                carregarHeroiAtual();
            }
        });

        btnAtualizar.addActionListener(e -> {
            controller.atualizarHeroi(
                    controller.getIndiceAtual(),
                    txtNome.getText(),
                    txtDescricao.getText(),
                    txtPoderes.getText(),
                    txtGrupo.getText(),
                    txtHabilidades.getText(),
                    imagemSelecionada != null ? imagemSelecionada.getAbsolutePath() : "",
                    videoSelecionado != null ? videoSelecionado.getAbsolutePath() : ""
            );
            JOptionPane.showMessageDialog(this, "Herói atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            carregarHeroiAtual();
        });

        btnSelecionarImagem.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                imagemSelecionada = fileChooser.getSelectedFile();
                lblImagem.setIcon(new ImageIcon(new ImageIcon(imagemSelecionada.getAbsolutePath()).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
            }
        });

        btnAbrirVideo.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                videoSelecionado = fileChooser.getSelectedFile();
                try {
                    Desktop.getDesktop().open(videoSelecionado);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao abrir o vídeo!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void configurarAtalhosTeclado() {
        txtNome.addKeyListener(new KeyListener() {
            @Override public void keyTyped(KeyEvent e) {}
            @Override public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnAdicionar.doClick();
                }
            }
            @Override public void keyReleased(KeyEvent e) {}
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SuperHeroView::new);
    }
}
