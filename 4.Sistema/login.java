//Método para Consultar, verificar e validar Acesso
    public boolean consultar(String login, String senha) {
        boolean autenticado = false;
        String sql;
        try {
            Connection conn = ConnectionMySQL.getConnection();
            sql = "SELECT nome, senha, acesso FROM usuario WHERE nome=? and senha=?";
            PreparedStatement ps;
            ps = conn.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, senha);
            ResultSet rs;
            rs = ps.executeQuery();
            if (rs.next()) {
                String usuario = rs.getString("nome");
                String senha = rs.getString("senha");
                autenticado = true;
            } else {
                //JOptionPane.showMessageDialog(this, "Acesso Negado ");
                ps.close();
                return autenticado;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
        return autenticado;
    }