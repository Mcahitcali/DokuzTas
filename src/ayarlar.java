
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("unchecked")
public class ayarlar extends JPanel{
    private ImageIcon icon=new ImageIcon(getClass().getResource("geri.png"));
    private ImageIcon onay=new ImageIcon(getClass().getResource("onay.png"));
    private JLabel label;
    private JButton geri,kaydet;
    static JComboBox combo,tas1,tas2,map;
    Font yazi = new Font("verdana", Font.BOLD, 15);
    Font baslik = new java.awt.Font("Algerian",Font.BOLD, 35);
   static ComboBoxModel arkaplan;
   
    ArrayList<String> renkler=new ArrayList<>();
    ArrayList<String> taslar1=new ArrayList<>();
    ArrayList<String> taslar2=new ArrayList<>();
    ArrayList<String> mapler=new ArrayList<>();
   
   static String t1="TAS-2",t2="TAS-3",mapp="MAP-1";
    Image mp1 = new ImageIcon(getClass().getResource("MAP\\"+mapp+".png")).getImage();
    Image ot1 = new ImageIcon(getClass().getResource("OYUNCU-1\\"+t1+".png")).getImage();
    Image ot2 = new ImageIcon(getClass().getResource("OYUNCU-2\\"+t2+".png")).getImage();
   static Color renk=new Color(149,117,114);
   @SuppressWarnings("unchecked")
    public ayarlar() {
        
        renkler.add("SIYAH");
        renkler.add("MAVI");
        renkler.add("GRI");
        renkler.add("BEYAZ");
        renkler.add("KIRMIZI");
        renkler.add("CYAN");
        renkler.add("MAGENTA");
        taslar1.add("TAS-1");
        taslar1.add("TAS-2");
        taslar1.add("TAS-3");
        taslar2.add("TAS-1");
        taslar2.add("TAS-2");
        taslar2.add("TAS-3");
        mapler.add("MAP-1");
        mapler.add("MAP-2");
        mapler.add("MAP-3");
        kaydet=new JButton(onay);
        kaydet.setBounds(600,400,100,100);
        kaydet.setOpaque(false);
        kaydet.setContentAreaFilled(false);
        kaydet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                renk_belirle();
                taslari_belirle();
                mapi_belirle();
            }
        });
        add(kaydet);
        geri=new JButton(icon);
        geri.setBounds(0,0,100,100);
        geri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Giris_Ekrani.giris.add(new Anamenu());
            }
        });
        geri.setContentAreaFilled(false);
        geri.setOpaque(false);
        add(geri);
        setBounds(0,0,700,500);
        setLayout(null);
        setBackground(new Color(113, 99, 169));
        label=new JLabel("AYARLAR");
        label.setForeground(Color.WHITE);
        label.setFont(baslik);
        label.setBounds(200,20,200,50);
        add(label);
        label=new JLabel("ARKA PLAN RENGİ: ");
        label.setFont(yazi);
        label.setForeground(Color.WHITE);
        label.setBounds(50,150,200,50);
        add(label);
        combo=new JComboBox();
       
        combo.setModel(new DefaultComboBoxModel(renkler.toArray()));
        combo.setBounds(250,160,200,40);
        combo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
              renk_belirle();
               repaint();
            }
        });
        add(combo);
        renk_belirle();
        
        label=new JLabel("OYUNCU-1 TASI : ");
        label.setFont(yazi);
        label.setForeground(Color.WHITE);
        label.setBounds(50,250,200,50);
        add(label);
        tas1=new JComboBox();
        
        tas1.setModel(new DefaultComboBoxModel(taslar1.toArray()));
        tas1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                
                taslari_belirle();
                ot1 = new ImageIcon(getClass().getResource("OYUNCU-1\\"+ayarlar.t1+".png")).getImage();
                repaint();
            }
        });
        tas1.setBounds(250,250,150,40);
        add(tas1);
       
        label=new JLabel("OYUNCU-2 TASI : ");
        label.setFont(yazi);
        label.setBounds(50,330,200,50);
        label.setForeground(Color.WHITE);
        add(label);
        tas2=new JComboBox();
        
        tas2.setModel(new DefaultComboBoxModel(taslar2.toArray()));
        tas2.setBounds(250,330,150,40);
        tas2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                
                taslari_belirle();
                ot2 = new ImageIcon(getClass().getResource("OYUNCU-2\\"+ayarlar.t2+".png")).getImage();
                repaint();
            }
        });
        add(tas2);
        taslari_belirle();
        label=new JLabel("OYUN TAHTASI : ");
        label.setFont(yazi);
        label.setBounds(50,415,200,50);
        label.setForeground(Color.WHITE);
        add(label);
        map=new JComboBox();
        
        map.setModel(new DefaultComboBoxModel(mapler.toArray()));
        map.setBounds(250,420,150,40);
        map.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                
                mapi_belirle();
                mp1 = new ImageIcon(getClass().getResource("MAP\\"+ayarlar.mapp+".png")).getImage();
                repaint();
            }
        });
        
        add(map);
        setVisible(true);
    }
    @SuppressWarnings("unchecked")
    public void renk_belirle(){
        if(combo.getSelectedItem().toString()=="SIYAH"){
            renk=Color.BLACK;
        }else if(combo.getSelectedItem().toString()=="MAVI"){
            renk=Color.BLUE;
        }else if(combo.getSelectedItem().toString()=="KIRMIZI"){
            renk=Color.RED;
        }else if(combo.getSelectedItem().toString()=="CYAN"){
            renk=Color.CYAN;
        }else if(combo.getSelectedItem().toString()=="MAGENTA"){
            renk=Color.MAGENTA;
        }else if(combo.getSelectedItem().toString()=="GRI"){
            renk=Color.GRAY;
        }else if(combo.getSelectedItem().toString()=="BEYAZ"){
            renk=Color.WHITE;
        }
    }
    @SuppressWarnings("unchecked")
    public void taslari_belirle(){
        if(tas1.getSelectedItem().toString()=="TAS-1"){
            t1="TAS-1";
        }else if(tas1.getSelectedItem().toString()=="TAS-2"){
            t1="TAS-2";
        }else if(tas1.getSelectedItem().toString()=="TAS-3"){
            t1="TAS-3";
        }
        if(tas2.getSelectedItem().toString()=="TAS-1"){
            t2="TAS-1";
        }else if(tas2.getSelectedItem().toString()=="TAS-2"){
            t2="TAS-2";
        }else if(tas2.getSelectedItem().toString()=="TAS-3"){
            t2="TAS-3";
        }
    }
    @SuppressWarnings("unchecked")
    public void mapi_belirle(){
         if(map.getSelectedItem().toString()=="MAP-1"){
            mapp="MAP-1";
        }else if(map.getSelectedItem().toString()=="MAP-2"){
            mapp="MAP-2";
        }
         else if(map.getSelectedItem().toString()=="MAP-3"){
            mapp="MAP-3";
        }
    }
    @SuppressWarnings("unchecked")
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(renk);
        g.fillRect(500,150  , 50, 50);
        g.drawImage(ot1 , 500, 240, 50,50,null);
        g.drawImage(ot2 , 500, 325, 50,50,null);
        g.drawImage(mp1,500,400,75,75,null);
    }
    
}
