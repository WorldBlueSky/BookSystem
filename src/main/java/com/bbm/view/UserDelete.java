package com.bbm.view;

import com.bbm.db.ReaderTypeDao;
import com.bbm.db.UserDao;
import com.bbm.model.Reader;
import com.bbm.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UserDelete extends JFrame implements ActionListener {
    private final JPanel ReaderConditionPane;
    private JPanel panel,btnPanel,
            centerPanel,selectResultPane,bookPane;

    private JLabel labUserName;
    private JTextField txtUserName;

    private JButton btnDelete,btnExit;

    private JTable table;

    private JScrollPane scrollPane;


    public UserDelete(){
        setTitle("ɾ���û�");//���ñ���
        setSize(500,400);
        setLocationRelativeTo(null);
        panel=new JPanel(new BorderLayout());
        setContentPane(panel);



        // ���ö������

        ReaderConditionPane =new JPanel();

        labUserName = new JLabel("�û���:");
        txtUserName = new JTextField(18);

        ReaderConditionPane.add(labUserName);
        ReaderConditionPane.add(txtUserName);


        panel.add(ReaderConditionPane,BorderLayout.NORTH);


        //�м����
        centerPanel=new JPanel();
        selectResultPane=new JPanel(); // ��ѯ���
        table=new JTable();  // ��

        String[] colName= {"�û����","�û���","����"};
        Object[][] r = getSelect(UserDao.selectUser());

        table = new JTable(r,colName);

        scrollPane=new JScrollPane(table);  // �ѱ������ѯ���
        scrollPane.setPreferredSize(new Dimension(400,250));//���ѯ���Ĵ�С
        selectResultPane.add(scrollPane);

        // ������İ�ť����
        bookPane=new JPanel(new GridLayout(1,2));

        centerPanel.add(selectResultPane);
        centerPanel.add(bookPane);
        panel.add(centerPanel,BorderLayout.CENTER);

        btnPanel=new JPanel();


        btnDelete=new JButton("ɾ��");
        btnExit=new JButton("�˳�");


        btnPanel.add(btnDelete);
        btnPanel.add(btnExit);

        btnDelete.addActionListener(this);
        btnExit.addActionListener(this);

        panel.add(btnPanel,BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new UserDelete();
    }

    //�Ѳ�ѯ�Ľ���ŵ�һ����ά�����У�Ŀ����Ҫ�ŵ�JTable��
    private Object[][] getSelect(List<User> list){

        String[] colName= {"�û����","�û���","����"};

        //����һ����������3�еĶ�ά���ݣ��и���list���ж�
        Object[][] results=new Object[list.size()][colName.length];

        //��list�е�ÿһ��Reader�еĸ����зŵ���ά���ݵĸ�������
        for(int i=0;i<list.size();i++){
            User user = list.get(i);//��ȡlist�е�ÿһ��reader
            results[i][0]=user.getId();
            results[i][1]=user.getName();
            results[i][2]=user.getPassword();

        }

        return results;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnDelete){
            // ��ȡ����� ͼ�����ͱ�ţ�����UsertypeDao��delete ��������ɾ��

           String name = txtUserName.getText();
           int ret = UserDao.deleteUser(name);
           if(ret==1){
                JOptionPane.showMessageDialog(null,"ɾ���ɹ�!");
           }else{
               JOptionPane.showMessageDialog(null,"ɾ��ʧ��!");
           }
        }

        if(e.getSource()==btnExit){
            System.exit(1);
        }
    }
}
