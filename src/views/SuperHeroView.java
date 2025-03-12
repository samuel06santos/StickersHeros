package views;

import controllers.SuperHeroController;
import models.SuperHero;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import javafx.embed.swing.JFXPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

public class SuperHeroView extends JFrame {
    private SuperHeroController controller;
    private JList<String> listHerois;
    private DefaultListModel<String> listModel;
    private JPanel panelVideo;
    private JTextField txtNome;
    private JTextArea txtDescricao;
    private JTextArea txtPoderes;
    private JTextField txtGrupo;
    private JTextArea txtHabilidades;
    private JButton btnAnterior, btnProximo, btnAdicionar, btnRemover, btnAtualizar, btnSelecionarImagem, btnSelecionarVideo, btnPauseVideo, btnPlayVideo, btnAbrirVideo;
    private JLabel lblImagem, lblVideo;
    private JFrame frame;
    private JFXPanel jfxPanel;
    private VideoPlayerPanel videoPlayerPanel;
    private File imagemSelecionada, videoSelecionado;

    public SuperHeroView() {
        controller = new SuperHeroController();
        controller.seedHerois();

        setTitle("Stickers Heros");
        setSize(1080, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Cores personalizadas
        Color backgroundColor = new Color(45, 45, 45);
        Color foregroundColor = new Color(230, 230, 230);
        Color borderColor = new Color(70, 70, 70);

        // Painel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelPrincipal.setBackground(backgroundColor);

        // Inicializando o modelo e o JList
        listModel = new DefaultListModel<>();
        listHerois = new JList<>(listModel);
        listHerois.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listHerois.addListSelectionListener(e -> carregarHeroiSelecionado());
        listHerois.setBackground(backgroundColor);
        listHerois.setForeground(foregroundColor);

        // Adicionando o JList a um JScrollPane
        JScrollPane scrollPane = new JScrollPane(listHerois);
        scrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(borderColor), "Lista de Heróis", 0, 0, null, foregroundColor));
        scrollPane.setBackground(backgroundColor);
        scrollPane.getViewport().setBackground(backgroundColor);
        scrollPane.getViewport().setForeground(foregroundColor);
        scrollPane.setPreferredSize(new Dimension(200, 0));
//        scrollPane.setViewportView(listHerois);

        // Inicializando os campos de texto do formulário
        txtNome = new JTextField();
        txtNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
        txtNome.setPreferredSize(new Dimension(150, 25));
        txtNome.setBackground(backgroundColor);
        txtNome.setForeground(foregroundColor);
        txtNome.setCaretColor(foregroundColor);
        txtNome.setBorder(BorderFactory.createCompoundBorder(
            txtNome.getBorder(),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));

        txtGrupo = new JTextField();
        txtGrupo.setFont(new Font("Tahoma", Font.PLAIN, 18));
        txtGrupo.setPreferredSize(new Dimension(150, 25));
        txtGrupo.setBackground(backgroundColor);
        txtGrupo.setForeground(foregroundColor);
        txtGrupo.setCaretColor(foregroundColor);
        txtGrupo.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(foregroundColor),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));

        txtDescricao = new JTextArea();
        txtDescricao.setFont(new Font("Tahoma", Font.PLAIN, 18));
        txtDescricao.setPreferredSize(new Dimension(300, 100));
        txtDescricao.setBackground(backgroundColor);
        txtDescricao.setForeground(foregroundColor);
        txtDescricao.setCaretColor(foregroundColor);
        txtDescricao.setLineWrap(true);
        txtDescricao.setWrapStyleWord(true);
        txtDescricao.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(foregroundColor),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
        txtPoderes = new JTextArea();
        txtPoderes.setFont(new Font("Tahoma", Font.PLAIN, 18));
        txtPoderes.setPreferredSize(new Dimension(300, 100));
        txtPoderes.setBackground(backgroundColor);
        txtPoderes.setForeground(foregroundColor);
        txtPoderes.setCaretColor(foregroundColor);
        txtPoderes.setLineWrap(true);
        txtPoderes.setWrapStyleWord(true);
        txtPoderes.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(foregroundColor),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));

        txtHabilidades = new JTextArea();
        txtHabilidades.setFont(new Font("Tahoma", Font.PLAIN, 18));
        txtHabilidades.setPreferredSize(new Dimension(300, 100) );
        txtHabilidades.setBackground(backgroundColor);
        txtHabilidades.setForeground(foregroundColor);
        txtHabilidades.setCaretColor(foregroundColor);
        txtHabilidades.setLineWrap(true);
        txtHabilidades.setWrapStyleWord(true);
        txtHabilidades.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(foregroundColor),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));

        // Painel de formulários
        JPanel panelFormulario = new JPanel(new GridBagLayout());
        panelFormulario.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(borderColor), "Dados do Herói", 0, 0, null, foregroundColor));
        panelFormulario.setBackground(backgroundColor);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setForeground(foregroundColor);
        panelFormulario.add(lblNome, gbc);
        gbc.gridx = 1;
        panelFormulario.add(txtNome, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel lblGrupo = new JLabel("Grupo:");
        lblGrupo.setForeground(foregroundColor);
        panelFormulario.add(lblGrupo, gbc);
        gbc.gridx = 1;
        panelFormulario.add(txtGrupo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel lblDescricao = new JLabel("Descrição:");
        lblDescricao.setForeground(foregroundColor);
        panelFormulario.add(lblDescricao, gbc);
        gbc.gridx = 1;
        panelFormulario.add(txtDescricao, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel lblPoderes = new JLabel("Poderes:");
        lblPoderes.setForeground(foregroundColor);
        panelFormulario.add(lblPoderes, gbc);
        gbc.gridx = 1;
        panelFormulario.add(txtPoderes, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        JLabel lblHabilidades = new JLabel("Habilidades:");
        lblHabilidades.setForeground(foregroundColor);
        panelFormulario.add(lblHabilidades, gbc);
        gbc.gridx = 1;
        panelFormulario.add(txtHabilidades, gbc);


        // Painel de imagem
        JPanel panelImagem = new JPanel(new BorderLayout());
        panelImagem.setPreferredSize(new Dimension(300, 300));
        panelImagem.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(borderColor), "Imagem do Herói", 0, 0, null, foregroundColor));
        panelImagem.setBackground(backgroundColor);
        lblImagem = new JLabel("Nenhuma imagem selecionada", SwingConstants.CENTER);
        lblImagem.setPreferredSize(new Dimension(300, 300));
        lblImagem.setBorder(BorderFactory.createLineBorder(borderColor));
        lblImagem.setForeground(foregroundColor);
        panelImagem.add(lblImagem, BorderLayout.CENTER);

        btnSelecionarImagem = new JButton("Selecionar Imagem...");
        btnSelecionarImagem.setBackground(backgroundColor);
        btnSelecionarImagem.setForeground(foregroundColor);
        panelImagem.add(btnSelecionarImagem, BorderLayout.SOUTH);

        // Painel de video
        videoPlayerPanel = new VideoPlayerPanel("");
        panelVideo = new JPanel(new BorderLayout());
        panelVideo.setPreferredSize(new Dimension(300, 300));
        panelVideo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(borderColor), "Vídeo do Herói", 0, 0, null, foregroundColor));
        panelVideo.setBackground(backgroundColor);
        panelVideo.add(videoPlayerPanel, BorderLayout.CENTER);

        lblVideo = new JLabel("Nenhum vídeo selecionado", SwingConstants.CENTER);
        lblVideo.setForeground(foregroundColor);

        btnSelecionarVideo = new JButton("Selecionar Vídeo...");
        btnSelecionarVideo.setBackground(backgroundColor);
        btnSelecionarVideo.setForeground(foregroundColor);

        // Painel de controles de vídeo
        JPanel panelVideoControls = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelVideoControls.setBackground(backgroundColor);

        btnPauseVideo = new JButton("⏸ Pause");
        btnPlayVideo = new JButton("▶ Play");
        btnPauseVideo.setBackground(backgroundColor);
        btnPauseVideo.setForeground(foregroundColor);
        btnPlayVideo.setBackground(backgroundColor);
        btnPlayVideo.setForeground(foregroundColor);
        panelVideoControls.add(btnPauseVideo);
        panelVideoControls.add(btnPlayVideo);

        // Adicionando os componentes ao painel de vídeo
        JPanel panelVideoColumn = new JPanel(new BorderLayout());
        panelVideoColumn.setBackground(backgroundColor);
        panelVideoColumn.add(btnSelecionarVideo, BorderLayout.NORTH);
        panelVideoColumn.add(panelVideoControls, BorderLayout.SOUTH);

        // Adicionando o painel de vídeo ao painel principal
        panelVideo.add(panelVideoColumn, BorderLayout.SOUTH);

        // Dividindo os painéis de imagem e vídeo
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panelImagem, panelVideo);
        splitPane.setBackground(backgroundColor);
        splitPane.setResizeWeight(0.5);


        // Painel de ações (botões)
        JPanel panelBotoes = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panelBotoes.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(borderColor), "Ações", 0, 0, null, foregroundColor));
        panelBotoes.setBackground(backgroundColor);

        btnAnterior = new JButton("◀ Anterior");
        btnAnterior.setBackground(backgroundColor);
        btnAnterior.setForeground(foregroundColor);

        btnProximo = new JButton("Próximo ▶");
        btnProximo.setBackground(backgroundColor);
        btnProximo.setForeground(foregroundColor);



        btnAdicionar = new JButton("➕ Adicionar");
        btnAdicionar.setBackground(backgroundColor);
        btnAdicionar.setForeground(foregroundColor);

        btnRemover = new JButton("❌ Remover");
        btnRemover.setBackground(backgroundColor);
        btnRemover.setForeground(foregroundColor);

        btnAtualizar = new JButton("\uD83D\uDD04 Atualizar");
        btnAtualizar.setBackground(backgroundColor);
        btnAtualizar.setForeground(foregroundColor);

        panelBotoes.add(btnAnterior);
        panelBotoes.add(btnProximo);
        panelBotoes.add(Box.createHorizontalStrut(80));
        panelBotoes.add(btnAdicionar);
        panelBotoes.add(btnAtualizar);
        panelBotoes.add(btnRemover);


        // Adicionando os painéis ao painel principal
        panelPrincipal.add(scrollPane, BorderLayout.WEST);
        panelPrincipal.add(panelFormulario, BorderLayout.CENTER);
        panelPrincipal.add(splitPane, BorderLayout.EAST);
        panelPrincipal.add(panelBotoes, BorderLayout.SOUTH);
        add(panelPrincipal);

        // Inicializando e configurando a interface
        carregarHeroiAtual();
        configurarEventos();
        configurarAtalhosTeclado();

        setVisible(true);
    }

    ///  Métodos auxiliares
    /// -----------------
    /// 1. carregarHeroiSelecionado
    /// 2. carregarHeroiAtual
    /// 3. configurarEventos
    /// 4. playVideo
    /// 5. pauseVideo
    /// 6. stopVideo
    /// 7. configurarAtalhosTeclado
    /// -----------------

    // Carrega os dados do herói selecionado na lista
    private void carregarHeroiSelecionado() {
        int index = listHerois.getSelectedIndex();
        if (index != -1) {
            SuperHero heroi = controller.listarTodosHerois().get(index);
            txtNome.setText(heroi.getNome());
            txtDescricao.setText(heroi.getDescricao());
            txtPoderes.setText(heroi.getPoderes());
            txtGrupo.setText(heroi.getGrupo());
            txtHabilidades.setText(heroi.getHabilidades());

            if (!heroi.getImagemPath().isEmpty()) {
                lblImagem.setText(null);
                lblImagem.setIcon(new ImageIcon(new ImageIcon(heroi.getImagemPath()).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
            } else {
                lblImagem.setIcon(null);
                lblImagem.setText("Nenhuma imagem");
            }

            if (!heroi.getVideoPath().isEmpty()) {
                playVideo(heroi.getVideoPath());
            } else {
                stopVideo();
            }
        }
    }

    // Carrega os dados do herói atual
    private void carregarHeroiAtual() {
        listModel.clear();
        for (SuperHero heroi : controller.listarTodosHerois()) {
            listModel.addElement(heroi.getNome());
        }
        if (!controller.listarTodosHerois().isEmpty()) {
            listHerois.setSelectedIndex(controller.getIndiceAtual());
            SuperHero heroiAtual = controller.getHeroiAtual();
            if (!heroiAtual.getVideoPath().isEmpty()) {
                playVideo(heroiAtual.getVideoPath());
            } else {
                stopVideo();
            }
        }
    }

    // Configura os eventos dos botões
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
                lblImagem.setIcon(new ImageIcon(new ImageIcon(imagemSelecionada.getAbsolutePath()).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
            }
        });

        btnSelecionarVideo.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                videoSelecionado = fileChooser.getSelectedFile();
                playVideo(videoSelecionado.getAbsolutePath());
            }
        });

        btnPlayVideo.addActionListener(e -> {
            if (videoPlayerPanel != null) {
                videoPlayerPanel.playVideo();
                btnPlayVideo.setEnabled(false);
                btnPauseVideo.setEnabled(true);
            }
        });

        btnPauseVideo.addActionListener(e -> {
            if (videoPlayerPanel != null) {
                videoPlayerPanel.pauseVideo();
                btnPlayVideo.setEnabled(true);
                btnPauseVideo.setEnabled(false);
            }
        });
    }

    // Reproduz o vídeo no painel de vídeo
    public void playVideo(String videoPath) {
        File videoFile = new File(videoPath);
        if (!videoFile.exists()) {
            lblVideo.setText("Arquivo não encontrado: " + videoPath);
            lblVideo.setHorizontalAlignment(SwingConstants.CENTER);
            lblVideo.setVerticalAlignment(SwingConstants.CENTER);
            videoPlayerPanel.stopVideo();
            panelVideo.remove(videoPlayerPanel);
            panelVideo.add(lblVideo, BorderLayout.CENTER, 0);
            panelVideo.revalidate();
            panelVideo.repaint();
            btnPlayVideo.setEnabled(false);
            btnPauseVideo.setEnabled(false);
            return;
        }
        videoPlayerPanel = new VideoPlayerPanel(videoPath);
        panelVideo.remove(lblVideo);
        panelVideo.add(videoPlayerPanel, BorderLayout.CENTER, 0);
        panelVideo.revalidate();
        panelVideo.repaint();
        btnPlayVideo.setEnabled(true);
        btnPauseVideo.setEnabled(false);
    }

    // Pausa o vídeo no painel de vídeo
    public void pauseVideo() {
        if (videoPlayerPanel != null) {
            videoPlayerPanel.pauseVideo();
            btnPlayVideo.setEnabled(true);
            btnPauseVideo.setEnabled(false);
        }
    }

    // Para o vídeo no painel de vídeo
    public void stopVideo() {
        if (videoPlayerPanel != null) {
            videoPlayerPanel.stopVideo();
            btnPlayVideo.setEnabled(true);
            btnPauseVideo.setEnabled(false);
        }
    }

    // Configura os atalhos de teclado
    // Pressione Enter para adicionar um novo herói
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
        SwingUtilities.invokeLater(() -> {
         new SuperHeroView();
        });
    }
}
