/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hangmangame;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

/**
 *
 * @author Gurleen Kaur
 */
public class GameFrame extends javax.swing.JFrame {
    private HangmanGame game;

    /**
     * Creates new form GameFrame
     */
    public GameFrame() {
        game= new HangmanGame();
        initComponents();
        setSize(400, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        updateUI();
        setupKeyboard();
    }

private void setupKeyboard() {

    aButton.addActionListener(e -> guess('a', aButton));
    bButton.addActionListener(e -> guess('b', bButton));
    cButton.addActionListener(e -> guess('c', cButton));
    dButton.addActionListener(e -> guess('d', dButton));
    eButton.addActionListener(e -> guess('e', eButton));
    fButton.addActionListener(e -> guess('f', fButton));
    gButton.addActionListener(e -> guess('g', gButton));
    hButton.addActionListener(e -> guess('h', hButton));
    iButton.addActionListener(e -> guess('i', iButton));

    jButton.addActionListener(e -> guess('j', jButton));
    kButton.addActionListener(e -> guess('k', kButton));
    lButton.addActionListener(e -> guess('l', lButton));
    mButton.addActionListener(e -> guess('m', mButton));
    nButton.addActionListener(e -> guess('n', nButton));
    oButton.addActionListener(e -> guess('o', oButton));
    pButton.addActionListener(e -> guess('p', pButton));
    qButton.addActionListener(e -> guess('q', qButton));
    rButton.addActionListener(e -> guess('r', rButton));

    sButton.addActionListener(e -> guess('s', sButton));
    tButton.addActionListener(e -> guess('t', tButton));
    uButton.addActionListener(e -> guess('u', uButton));
    vButton.addActionListener(e -> guess('v', vButton));
    wButton.addActionListener(e -> guess('w', wButton));
    xButton.addActionListener(e -> guess('x', xButton));
    yButton.addActionListener(e -> guess('y', yButton));
    zButton.addActionListener(e -> guess('z', zButton));
}
private void guess(char letter, JButton button) {

    if (game.getGuessedLetters().contains(letter)) {
        return;
    }

    boolean correct = game.guessLetter(letter);

    button.setEnabled(false);

    if (correct) {

        guessedLabel.setText("✓ Correct Guess!");
    } else {
        guessedLabel.setText("✗ Incorrect Guess!");
    }

    updateUI();


    // Player won

    if (game.isWon()) {

        JOptionPane.showMessageDialog(
                this,
                "Congratulations!\n"
                + "The word was: "
                + game.getSecretWord(),
                "You Won!",
                JOptionPane.INFORMATION_MESSAGE
        );

        disableKeyboard();

        return;
    }


    // Game over

    if (game.isGameOver()) {

        JOptionPane.showMessageDialog(
                this,
                "Game Over!\n"
                + "The word was: "
                + game.getSecretWord(),
                "Game Over",
                JOptionPane.ERROR_MESSAGE
        );

        disableKeyboard();
    }
}
private void updateUI() {

    StringBuilder word = new StringBuilder();

    for (char c : game.getCurrentWord().toCharArray()) {

        word.append(c);
        word.append(" ");
    }

    wordLabel.setText(
            word.toString()
    );


    attemptsLabel.setText(
            "Attempts Left: "
            + game.getAttemptsLeft()
    );


    StringBuilder guessed =
            new StringBuilder();

    for (char c : game.getGuessedLetters()) {

        guessed.append(
                Character.toUpperCase(c)
        );

        guessed.append(" ");
    }

    guessedLabel.setText(
            "Guessed: "
            + guessed.toString()
    );


    updateHangman();
}
private void updateHangman() {

    int wrongGuesses = 6 - game.getAttemptsLeft();

    String drawing = "";

    switch (wrongGuesses) {

        case 0:
            drawing =
                    "   ______<br>" +
                    "   |    |<br>" +
                    "   |<br>" +
                    "   |<br>" +
                    "   |<br>" +
                    "___|________";
            break;

        case 1:
            drawing =
                    "   ______<br>" +
                    "   |    |<br>" +
                    "   |    O<br>" +
                    "   |<br>" +
                    "   |<br>" +
                    "___|________";
            break;

        case 2:
            drawing =
                    "   ______<br>" +
                    "   |    |<br>" +
                    "   |    O<br>" +
                    "   |    |<br>" +
                    "   |<br>" +
                    "___|________";
            break;

        case 3:
            drawing =
                    "   ______<br>" +
                    "   |    |<br>" +
                    "   |    O<br>" +
                    "   |   /|<br>" +
                    "   |<br>" +
                    "___|________";
            break;

        case 4:
            drawing =
                    "   ______<br>" +
                    "   |    |<br>" +
                    "   |    O<br>" +
                    "   |   /|\\<br>" +
                    "   |<br>" +
                    "___|________";
            break;

        case 5:
            drawing =
                    "   ______<br>" +
                    "   |    |<br>" +
                    "   |    O<br>" +
                    "   |   /|\\<br>" +
                    "   |   /<br>" +
                    "___|________";
            break;

        case 6:
            drawing =
                    "   ______<br>" +
                    "   |    |<br>" +
                    "   |    O<br>" +
                    "   |   /|\\<br>" +
                    "   |   / \\<br>" +
                    "___|________";
            break;
    }

    hangmanPanel.setText(
            "<html><pre>" + drawing + "</pre></html>"
    );
}
private void disableKeyboard() {

    aButton.setEnabled(false);
    bButton.setEnabled(false);
    cButton.setEnabled(false);
    dButton.setEnabled(false);
    eButton.setEnabled(false);
    fButton.setEnabled(false);
    gButton.setEnabled(false);
    hButton.setEnabled(false);
    iButton.setEnabled(false);
    jButton.setEnabled(false);
    kButton.setEnabled(false);
    lButton.setEnabled(false);
    mButton.setEnabled(false);
    nButton.setEnabled(false);
    oButton.setEnabled(false);
    pButton.setEnabled(false);
    qButton.setEnabled(false);
    rButton.setEnabled(false);
    sButton.setEnabled(false);
    tButton.setEnabled(false);
    uButton.setEnabled(false);
    vButton.setEnabled(false);
    wButton.setEnabled(false);
    xButton.setEnabled(false);
    yButton.setEnabled(false);
    zButton.setEnabled(false);
}
private void resetKeyboard() {

    aButton.setEnabled(true);
    bButton.setEnabled(true);
    cButton.setEnabled(true);
    dButton.setEnabled(true);
    eButton.setEnabled(true);
    fButton.setEnabled(true);
    gButton.setEnabled(true);
    hButton.setEnabled(true);
    iButton.setEnabled(true);
    jButton.setEnabled(true);
    kButton.setEnabled(true);
    lButton.setEnabled(true);
    mButton.setEnabled(true);
    nButton.setEnabled(true);
    oButton.setEnabled(true);
    pButton.setEnabled(true);
    qButton.setEnabled(true);
    rButton.setEnabled(true);
    sButton.setEnabled(true);
    tButton.setEnabled(true);
    uButton.setEnabled(true);
    vButton.setEnabled(true);
    wButton.setEnabled(true);
    xButton.setEnabled(true);
    yButton.setEnabled(true);
    zButton.setEnabled(true);
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        hangmanPanel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        attemptsLabel = new javax.swing.JLabel();
        guessedLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        wordLabel = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        aButton = new javax.swing.JButton();
        bButton = new javax.swing.JButton();
        cButton = new javax.swing.JButton();
        dButton = new javax.swing.JButton();
        eButton = new javax.swing.JButton();
        fButton = new javax.swing.JButton();
        gButton = new javax.swing.JButton();
        hButton = new javax.swing.JButton();
        iButton = new javax.swing.JButton();
        jButton = new javax.swing.JButton();
        kButton = new javax.swing.JButton();
        lButton = new javax.swing.JButton();
        mButton = new javax.swing.JButton();
        nButton = new javax.swing.JButton();
        oButton = new javax.swing.JButton();
        pButton = new javax.swing.JButton();
        qButton = new javax.swing.JButton();
        rButton = new javax.swing.JButton();
        sButton = new javax.swing.JButton();
        tButton = new javax.swing.JButton();
        uButton = new javax.swing.JButton();
        vButton = new javax.swing.JButton();
        wButton = new javax.swing.JButton();
        xButton = new javax.swing.JButton();
        yButton = new javax.swing.JButton();
        zButton = new javax.swing.JButton();
        newGameButton = new javax.swing.JButton();
        homeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(400, 500));

        headerPanel.setBackground(new java.awt.Color(255, 248, 239));

        titleLabel.setFont(new java.awt.Font("Audiowide", 1, 18)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(90, 62, 43));
        titleLabel.setText("HANGMAN");

        hangmanPanel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        hangmanPanel.setForeground(new java.awt.Color(90, 62, 43));
        hangmanPanel.setText("<html>\n<pre>\n   ______\n   |    |\n   |\n   |\n   |\n___|________\n</pre>\n</html>");

        jPanel2.setBackground(new java.awt.Color(255, 248, 239));
        jPanel2.setLayout(new java.awt.GridLayout(3, 9, 5, 5));

        attemptsLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        attemptsLabel.setForeground(new java.awt.Color(90, 62, 43));
        attemptsLabel.setText("Attempts Left: 6/6");
        jPanel2.add(attemptsLabel);

        guessedLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        guessedLabel.setForeground(new java.awt.Color(90, 62, 43));
        guessedLabel.setText("Guessed Letters:");
        jPanel2.add(guessedLabel);

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hangmanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(titleLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titleLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(hangmanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 248, 239));

        wordLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        wordLabel.setForeground(new java.awt.Color(90, 62, 43));
        wordLabel.setText("_ _ _ _ _ _");

        statusLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        statusLabel.setForeground(new java.awt.Color(90, 62, 43));
        statusLabel.setText("Guess the letter");

        aButton.setBackground(new java.awt.Color(255, 248, 239));
        aButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        aButton.setForeground(new java.awt.Color(90, 62, 43));
        aButton.setText("A");
        aButton.setFocusPainted(false);

        bButton.setBackground(new java.awt.Color(255, 248, 239));
        bButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bButton.setForeground(new java.awt.Color(90, 62, 43));
        bButton.setText("B");
        bButton.setFocusPainted(false);

        cButton.setBackground(new java.awt.Color(255, 248, 239));
        cButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cButton.setForeground(new java.awt.Color(90, 62, 43));
        cButton.setText("C");
        cButton.setFocusPainted(false);

        dButton.setBackground(new java.awt.Color(255, 248, 239));
        dButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dButton.setForeground(new java.awt.Color(90, 62, 43));
        dButton.setText("D");
        dButton.setFocusPainted(false);

        eButton.setBackground(new java.awt.Color(255, 248, 239));
        eButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        eButton.setForeground(new java.awt.Color(90, 62, 43));
        eButton.setText("E");
        eButton.setFocusPainted(false);

        fButton.setBackground(new java.awt.Color(255, 248, 239));
        fButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        fButton.setForeground(new java.awt.Color(90, 62, 43));
        fButton.setText("F");
        fButton.setFocusPainted(false);

        gButton.setBackground(new java.awt.Color(255, 248, 239));
        gButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        gButton.setForeground(new java.awt.Color(90, 62, 43));
        gButton.setText("G");
        gButton.setFocusPainted(false);

        hButton.setBackground(new java.awt.Color(255, 248, 239));
        hButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        hButton.setForeground(new java.awt.Color(90, 62, 43));
        hButton.setText("H");
        hButton.setFocusPainted(false);

        iButton.setBackground(new java.awt.Color(255, 248, 239));
        iButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        iButton.setForeground(new java.awt.Color(90, 62, 43));
        iButton.setText("I");
        iButton.setFocusPainted(false);

        jButton.setBackground(new java.awt.Color(255, 248, 239));
        jButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton.setForeground(new java.awt.Color(90, 62, 43));
        jButton.setText("J");
        jButton.setFocusPainted(false);

        kButton.setBackground(new java.awt.Color(255, 248, 239));
        kButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        kButton.setForeground(new java.awt.Color(90, 62, 43));
        kButton.setText("K");
        kButton.setFocusPainted(false);

        lButton.setBackground(new java.awt.Color(255, 248, 239));
        lButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lButton.setForeground(new java.awt.Color(90, 62, 43));
        lButton.setText("L");
        lButton.setFocusPainted(false);

        mButton.setBackground(new java.awt.Color(255, 248, 239));
        mButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        mButton.setForeground(new java.awt.Color(90, 62, 43));
        mButton.setText("M");
        mButton.setFocusPainted(false);

        nButton.setBackground(new java.awt.Color(255, 248, 239));
        nButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nButton.setForeground(new java.awt.Color(90, 62, 43));
        nButton.setText("N");
        nButton.setFocusPainted(false);

        oButton.setBackground(new java.awt.Color(255, 248, 239));
        oButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        oButton.setForeground(new java.awt.Color(90, 62, 43));
        oButton.setText("O");
        oButton.setFocusPainted(false);

        pButton.setBackground(new java.awt.Color(255, 248, 239));
        pButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pButton.setForeground(new java.awt.Color(90, 62, 43));
        pButton.setText("P");
        pButton.setFocusPainted(false);

        qButton.setBackground(new java.awt.Color(255, 248, 239));
        qButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        qButton.setForeground(new java.awt.Color(90, 62, 43));
        qButton.setText("Q");
        qButton.setFocusPainted(false);

        rButton.setBackground(new java.awt.Color(255, 248, 239));
        rButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rButton.setForeground(new java.awt.Color(90, 62, 43));
        rButton.setText("R");
        rButton.setFocusPainted(false);

        sButton.setBackground(new java.awt.Color(255, 248, 239));
        sButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sButton.setForeground(new java.awt.Color(90, 62, 43));
        sButton.setText("S");
        sButton.setFocusPainted(false);

        tButton.setBackground(new java.awt.Color(255, 248, 239));
        tButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tButton.setForeground(new java.awt.Color(90, 62, 43));
        tButton.setText("T");
        tButton.setFocusPainted(false);

        uButton.setBackground(new java.awt.Color(255, 248, 239));
        uButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        uButton.setForeground(new java.awt.Color(90, 62, 43));
        uButton.setText("U");
        uButton.setFocusPainted(false);

        vButton.setBackground(new java.awt.Color(255, 248, 239));
        vButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        vButton.setForeground(new java.awt.Color(90, 62, 43));
        vButton.setText("V");
        vButton.setFocusPainted(false);

        wButton.setBackground(new java.awt.Color(255, 248, 239));
        wButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        wButton.setForeground(new java.awt.Color(90, 62, 43));
        wButton.setText("W");
        wButton.setFocusPainted(false);

        xButton.setBackground(new java.awt.Color(255, 248, 239));
        xButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        xButton.setForeground(new java.awt.Color(90, 62, 43));
        xButton.setText("X");
        xButton.setFocusPainted(false);

        yButton.setBackground(new java.awt.Color(255, 248, 239));
        yButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        yButton.setForeground(new java.awt.Color(90, 62, 43));
        yButton.setText("Y");
        yButton.setFocusPainted(false);

        zButton.setBackground(new java.awt.Color(255, 248, 239));
        zButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        zButton.setForeground(new java.awt.Color(90, 62, 43));
        zButton.setText("Z");
        zButton.setFocusPainted(false);

        newGameButton.setBackground(new java.awt.Color(90, 62, 43));
        newGameButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        newGameButton.setForeground(new java.awt.Color(255, 255, 255));
        newGameButton.setText("NEW GAME");
        newGameButton.setFocusPainted(false);
        newGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameButtonActionPerformed(evt);
            }
        });

        homeButton.setBackground(new java.awt.Color(90, 62, 43));
        homeButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        homeButton.setForeground(new java.awt.Color(255, 255, 255));
        homeButton.setText("HOME");
        homeButton.setFocusPainted(false);
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(wordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(137, 137, 137))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(statusLabel)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(aButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(bButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(dButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(gButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(hButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(mButton, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                                            .addComponent(sButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(tButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(iButton, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                                    .addComponent(oButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(uButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(yButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                                    .addComponent(pButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(vButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(zButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(qButton, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                                    .addComponent(wButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(xButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(eButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(fButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(kButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(newGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(wordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusLabel)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aButton)
                    .addComponent(bButton)
                    .addComponent(cButton)
                    .addComponent(dButton)
                    .addComponent(eButton)
                    .addComponent(fButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gButton)
                    .addComponent(hButton)
                    .addComponent(iButton)
                    .addComponent(jButton)
                    .addComponent(kButton)
                    .addComponent(lButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mButton)
                    .addComponent(nButton)
                    .addComponent(oButton)
                    .addComponent(pButton)
                    .addComponent(qButton)
                    .addComponent(rButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sButton)
                    .addComponent(tButton)
                    .addComponent(uButton)
                    .addComponent(vButton)
                    .addComponent(wButton)
                    .addComponent(xButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yButton)
                    .addComponent(zButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(homeButton)
                    .addComponent(newGameButton))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameButtonActionPerformed
        // TODO add your handling code here:
        game.startNewGame();

    resetKeyboard();

    guessedLabel.setText(
            "Guess a letter"
    );

    updateUI();
    }//GEN-LAST:event_newGameButtonActionPerformed

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        // TODO add your handling code here:
        HomeScreen home = new HomeScreen();
        home.setVisible(true);

    this.dispose();
    }//GEN-LAST:event_homeButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aButton;
    private javax.swing.JLabel attemptsLabel;
    private javax.swing.JButton bButton;
    private javax.swing.JButton cButton;
    private javax.swing.JButton dButton;
    private javax.swing.JButton eButton;
    private javax.swing.JButton fButton;
    private javax.swing.JButton gButton;
    private javax.swing.JLabel guessedLabel;
    private javax.swing.JButton hButton;
    private javax.swing.JLabel hangmanPanel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JButton homeButton;
    private javax.swing.JButton iButton;
    private javax.swing.JButton jButton;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton kButton;
    private javax.swing.JButton lButton;
    private javax.swing.JButton mButton;
    private javax.swing.JButton nButton;
    private javax.swing.JButton newGameButton;
    private javax.swing.JButton oButton;
    private javax.swing.JButton pButton;
    private javax.swing.JButton qButton;
    private javax.swing.JButton rButton;
    private javax.swing.JButton sButton;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JButton tButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton uButton;
    private javax.swing.JButton vButton;
    private javax.swing.JButton wButton;
    private javax.swing.JLabel wordLabel;
    private javax.swing.JButton xButton;
    private javax.swing.JButton yButton;
    private javax.swing.JButton zButton;
    // End of variables declaration//GEN-END:variables
}
