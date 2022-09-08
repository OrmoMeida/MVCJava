/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import control.MusicaControl;
import model.Musica;
import pExceptions.MusicNotFoundException;

/**
 *
 * @author aluno
 */
public class FrmMusica extends javax.swing.JFrame {
    private MusicaControl lstMusica;

    /**
     * Creates new form FrmMusica
     */
    public FrmMusica() {
        initComponents();
        initTable();
        try {
            lstMusica = MusicaControl.getInstance();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        fillTable();

        // showStuff();
    }

    private void initTable() {
        DefaultTableModel data = new DefaultTableModel();

        data.setRowCount(0);
        data.addColumn("Nome");
        data.addColumn("Autor");
        data.addColumn("Álbum");
        data.addColumn("Duração");
        data.addColumn("Data de publicação");

        tableMusica.setModel(data);
    }

    private void limparCampos() {
        txtNome.setText("");
        txtAutor.setText("");
        txtAlbum.setText("");
        txtDuracao.setText("");
        txtDataPub.setText("");
        txtNome.requestFocus();
    }

    private void trimAll() {
        txtNome.setText(txtNome.getText().trim());
        txtAutor.setText(txtAutor.getText().trim());
        txtAlbum.setText(txtAlbum.getText().trim());
        txtDuracao.setText(txtDuracao.getText().trim());
        txtDataPub.setText(txtDataPub.getText().trim());
        txtBuscaAutor.setText(txtBuscaAutor.getText().trim());
    }

    private boolean checkCampos() {
        trimAll();
        String errMessage = "";

        if (txtNome.getText().isEmpty()) {
            errMessage = "O campo nome não pode estar vazio.";
            txtNome.requestFocus();
        } else if (txtAutor.getText().isEmpty()) {
            errMessage = "O campo autor não pode estar vazio.";
            txtAutor.requestFocus();
        } else if (txtAlbum.getText().isEmpty()) {
            errMessage = "O campo álbum não pode estar vazio.";
            txtAlbum.requestFocus();
        } else if (txtDuracao.getText().isEmpty()) {
            errMessage = "O campo duração não pode estar vazio.";
            txtDuracao.requestFocus();
            // } else if (!Musica.durationCheck.matcher(txtDuracao.getText()).matches()) {
            // errMessage = "Formato de data incorreto: Deve estar como dd/MM/AAAA";
            // txtDuracao.requestFocus();
        } else if (txtDataPub.getText().isEmpty()) {
            errMessage = "O campo data de publicação não pode estar vazio.";
            txtDataPub.requestFocus();
            // } else if (!Musica.dataCheck.matcher(txtDataPub.getText()).matches()) {
            // errMessage = "Formato de duração incorreto: Deve estar como MM:SS";
            // txtDataPub.requestFocus();
        }

        if (!errMessage.isEmpty())
            JOptionPane.showMessageDialog(null, errMessage);

        return !errMessage.isEmpty();
    }

    private void checkCamposRemover() {
        trimAll();
        String errMessage = "";

        if (txtBuscaNome.getText().isEmpty()) {
            errMessage = "O campo nome não pode estar vazio.\nAutor e nome são necessários para realizar a pesquisa.";
            txtBuscaNome.requestFocus();
        } else if (txtBuscaAutor.getText().isEmpty()) {
            errMessage = "O campo autor não pode estar vazio.\nAutor e nome são necessários para realizar a pesquisa.";
            txtBuscaAutor.requestFocus();
        }

        if (!errMessage.isEmpty())
            JOptionPane.showMessageDialog(null, errMessage);
    }

    private void fillTable(ArrayList<Musica> lMusicas) {
        DefaultTableModel data = new DefaultTableModel();

        data.setRowCount(0);
        data.addColumn("Nome");
        data.addColumn("Autor");
        data.addColumn("Álbum");
        data.addColumn("Duração");
        data.addColumn("Data de publicação");

        for (Musica musica : lMusicas) {
            data.addRow(musica.toObjects());
        }

        tableMusica.setModel(data);
    }

    private void fillTable() {
        fillTable(lstMusica.getList());
    }

    private void showMusica(Musica e) {
        JOptionPane.showMessageDialog(null, e.toString(), "Musiquinha!", 1);
    }

    private void showMusica(ArrayList<Musica> e) throws MusicNotFoundException {
        if (e.size() == 1)
            showMusica(e.get(0));
        else if (e.size() > 1) {
            fillTable(e);
        } else {
            throw new MusicNotFoundException();
        }
    }

    // private void showStuff() {
    // for (Musica musica : lstMusica.getList()) {
    // JOptionPane.showMessageDialog(null, musica.toString(), "Música!", 1);
    // }
    // }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNome = new javax.swing.JTextField();
        txtAutor = new javax.swing.JTextField();
        txtAlbum = new javax.swing.JTextField();
        txtDuracao = new javax.swing.JTextField();
        txtDataPub = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblAlbum = new javax.swing.JLabel();
        lblDuracao = new javax.swing.JLabel();
        lblDataPublicacao = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMusica = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtBuscaNome = new javax.swing.JTextPane();
        txtBuscaAutor = new javax.swing.JTextPane();
        lblBuscaNome = new javax.swing.JLabel();
        lblAutor = new javax.swing.JLabel();
        btnBusca = new javax.swing.JButton();
        lblBusca = new javax.swing.JLabel();
        btnFetch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtAlbum.setToolTipText("");

        lblNome.setText("Nome");

        jLabel1.setText("Autor");

        lblAlbum.setText("Álbum");

        lblDuracao.setText("Duração");

        lblDataPublicacao.setText("Data Publicação");

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        tableMusica.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null }
                },
                new String[] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }));
        jScrollPane1.setViewportView(tableMusica);

        jScrollPane2.setViewportView(txtBuscaNome);

        lblBuscaNome.setText("Nome");

        lblAutor.setText("Autor");

        btnBusca.setText("Buscar");
        btnBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaActionPerformed(evt);
            }
        });

        lblBusca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBusca.setText("BUSCA");

        btnFetch.setText("Atualizar tabela");
        btnFetch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFetchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lblBuscaNome)
                                                                        .addComponent(lblAutor))
                                                                .addGap(74, 74, 74)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jScrollPane2)
                                                                        .addComponent(txtBuscaAutor)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lblNome,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                64,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel1)
                                                                        .addComponent(lblAlbum,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                54,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lblDuracao)
                                                                        .addComponent(lblDataPublicacao))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txtDuracao)
                                                                        .addComponent(txtAutor)
                                                                        .addComponent(txtAlbum)
                                                                        .addComponent(txtDataPub)
                                                                        .addComponent(txtNome,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                200, Short.MAX_VALUE)))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                layout.createSequentialGroup()
                                                                                        .addComponent(btnBusca)
                                                                                        .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(btnRemover))
                                                                        .addComponent(btnCadastrar,
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(btnFetch,
                                                                                javax.swing.GroupLayout.Alignment.TRAILING))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                layout.createSequentialGroup()
                                                        .addGap(0, 0, Short.MAX_VALUE)
                                                        .addComponent(lblBusca)
                                                        .addGap(137, 137, 137)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblNome))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtAlbum, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblAlbum, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                10, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtDuracao,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblDuracao))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(txtDataPub,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblDataPublicacao,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnCadastrar)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblBusca)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(lblBuscaNome,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jScrollPane2))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(lblAutor, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(txtBuscaAutor,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btnRemover)
                                                        .addComponent(btnBusca))
                                                .addGap(26, 26, 26)
                                                .addComponent(btnFetch))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCadastrarActionPerformed
        if (checkCampos())
            return;

        String nome = txtNome.getText();
        String album = txtAlbum.getText();
        String autor = txtAutor.getText();
        String duracao = txtDuracao.getText();
        String dataPub = txtDataPub.getText();

        try {
            Musica e = new Musica(nome, album, autor, duracao, dataPub);
            lstMusica.add(e);
            limparCampos();
            fillTable();
            JOptionPane.showMessageDialog(null, "A música \"" + e.getNome() + "\" foi inserida com sucesso.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Houve um erro no banco de dados :(" + e.getMessage());
        }
    }// GEN-LAST:event_btnCadastrarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnRemoverActionPerformed
        checkCamposRemover();

        String nome = txtBuscaNome.getText();
        String autor = txtBuscaAutor.getText();

        try {
            lstMusica.find(nome, autor);
            if (JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja excluir essa música?") == 0) {
                JOptionPane.showMessageDialog(null, "Sim!");
                lstMusica.remove(nome, autor);
            } else {
                txtBuscaAutor.requestFocus();
            }
        } catch (MusicNotFoundException e) {
            btnBuscaActionPerformed(evt);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algo deu errado:  " + e.getMessage());
        }
        fillTable();
    }// GEN-LAST:event_btnRemoverActionPerformed

    private void btnBuscaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnBuscaActionPerformed
        trimAll();

        if (txtBuscaNome.getText().isEmpty() && txtBuscaAutor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha ao menos um dos campos para realizar a busca.");
            txtBuscaNome.requestFocus();
        } else if (!txtBuscaAutor.getText().isEmpty() && !txtBuscaNome.getText().isEmpty()) {
            try {
                showMusica(lstMusica.find(txtBuscaNome.getText(), txtBuscaAutor.getText()));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Algo deu errado:  " + e.getMessage());
            } catch (MusicNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Essa música não foi encontrada.");
                txtBuscaNome.requestFocus();
            }
        } else if (!txtBuscaNome.getText().isEmpty() && txtBuscaAutor.getText().isEmpty()) {
            try {
                try {
                    showMusica(lstMusica.findByName(txtBuscaNome.getText()));
                } catch (MusicNotFoundException e) {
                    JOptionPane.showMessageDialog(null, "Nenhuma música com esse nome foi encontrada.");
                    txtBuscaNome.requestFocus();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Algo deu errado:  " + e.getMessage());
            }
        } else if (txtBuscaNome.getText().isEmpty() && !txtBuscaAutor.getText().isEmpty()) {
            try {
                try {
                    showMusica(lstMusica.findByAuthor(txtBuscaAutor.getText()));
                } catch (MusicNotFoundException e) {
                    JOptionPane.showMessageDialog(null, "Nenhuma música desse autor foi encontrada.");
                    txtBuscaNome.requestFocus();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Algo deu errado:  " + e.getMessage());
            }
        }
    }// GEN-LAST:event_btnBuscaActionPerformed

    private void btnFetchActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnFetchActionPerformed
        fillTable();
    }// GEN-LAST:event_btnFetchActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMusica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMusica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMusica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMusica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMusica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBusca;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnFetch;
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAlbum;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblBusca;
    private javax.swing.JLabel lblBuscaNome;
    private javax.swing.JLabel lblDataPublicacao;
    private javax.swing.JLabel lblDuracao;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTable tableMusica;
    private javax.swing.JTextField txtAlbum;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextPane txtBuscaAutor;
    private javax.swing.JTextPane txtBuscaNome;
    private javax.swing.JTextField txtDataPub;
    private javax.swing.JTextField txtDuracao;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
