package UserInterface;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import Metier.Facade;
import Metier.Proxy;
import PersistenceDB.JugeDB;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
@SuppressWarnings({ "serial" })
public class window extends JFrame {
	
	private static window wind ;
	private JPanel panelPersonnes;
	private List listPersonnes;
	private List listJuges;
	private ArrayList<Proxy> arrayListJuge;
	private Facade facade = new Facade();
	
	public void setPanelPersonnes(JPanel panelPersonnes) {
		this.panelPersonnes = panelPersonnes;
	}
	public window() {
		
		wind = this;
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		
		
		//GESTION ENQUETEURS ----------------------------------------------------------------------------------
		
		
		final JPanel panelEnqueteur = new JPanel();
		tabbedPane.addTab("Gestion Enqueteurs", null, panelEnqueteur, null);
		panelEnqueteur.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPanelEnqueteur = new JTabbedPane(JTabbedPane.TOP);
		panelEnqueteur.add(tabbedPanelEnqueteur, BorderLayout.CENTER);
		
		panelPersonnes = new JPanel();
		tabbedPanelEnqueteur.addTab("Personnes", null, panelPersonnes, null);
		panelPersonnes.setLayout(new BorderLayout(0, 0));
		
		listPersonnes = new List();
		listPersonnes.setMultipleMode(false);
		panelPersonnes.add(listPersonnes, BorderLayout.CENTER);
		
		JPanel panel_25 = new JPanel();
		panelPersonnes.add(panel_25, BorderLayout.SOUTH);
		panel_25.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnConsulterPersonnes = new JButton("Consulter");
		btnConsulterPersonnes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ConsulterEnqueteur(listPersonnes.getSelectedItem());
			}
		});
		panel_25.add(btnConsulterPersonnes);
		
		JButton btnModifierPersonnes = new JButton("Modifier");
		btnModifierPersonnes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ModifierEnqueteur(listPersonnes.getSelectedItem());
			}
		});
		panel_25.add(btnModifierPersonnes);
		
		JButton btnAjouterPersonnes = new JButton("Ajouter");
		btnAjouterPersonnes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AjouterEnqueteur();
			}
		});
		panel_25.add(btnAjouterPersonnes);
		
		JButton btnSupprimerPersonnes = new JButton("Supprimer");
		btnSupprimerPersonnes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(wind, "Etes-vous sur?");
				if(confirm == JOptionPane.YES_OPTION){
					//TODO Delete
				}
			}
		});
		panel_25.add(btnSupprimerPersonnes);
		
		JPanel panelCorps = new JPanel();
		tabbedPanelEnqueteur.addTab("Corps", null, panelCorps, null);
		panelCorps.setLayout(new BorderLayout(0, 0));
		
		final List listCorps = new List();
		panelCorps.add(listCorps, BorderLayout.CENTER);
		
		
		JPanel panel_26 = new JPanel();
		panelCorps.add(panel_26, BorderLayout.SOUTH);
		panel_26.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		JButton btnNewButtonCorps = new JButton("Modifier");
		btnNewButtonCorps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ModifierCorp(listCorps.getSelectedItem());
			}
		});
		panel_26.add(btnNewButtonCorps);
		
		JButton btnAjouterCorps = new JButton("Ajouter");
		btnAjouterCorps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AjouterCorp();
			}
		});
		panel_26.add(btnAjouterCorps);
		
		JButton btnSupprimerCorps = new JButton("Supprimer");
		btnSupprimerCorps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(wind, "Etes-vous sur?");
				if(confirm == JOptionPane.YES_OPTION){
					//TODO Delete
				}
			}
		});
		panel_26.add(btnSupprimerCorps);
		
		JPanel panelLieux = new JPanel();
		tabbedPanelEnqueteur.addTab("Lieux", null, panelLieux, null);
		panelLieux.setLayout(new BorderLayout(0, 0));
		
		final List listLieux = new List();
		panelLieux.add(listLieux, BorderLayout.CENTER);
		
		JPanel panel_27 = new JPanel();
		panelLieux.add(panel_27, BorderLayout.SOUTH);
		panel_27.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		JButton btnModifierLieux = new JButton("Modifier");
		btnModifierLieux.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ModifierLieu(listLieux.getSelectedItem());
			}
		});
		panel_27.add(btnModifierLieux);
		
		JButton btnAjouterLieux = new JButton("Ajouter");
		btnAjouterLieux.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AjouterLieu(listLieux.getSelectedItem());
			}
		});
		panel_27.add(btnAjouterLieux);
		
		JButton btnSupprimerLieux = new JButton("Supprimer");
		btnSupprimerLieux.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(panelEnqueteur, "Etes-vous sur?");
				if(confirm == JOptionPane.YES_OPTION){
					//TODO Delete
				}
			}
		});
		panel_27.add(btnSupprimerLieux);
		
		JPanel panelServices = new JPanel();
		tabbedPanelEnqueteur.addTab("Services", null, panelServices, null);
		panelServices.setLayout(new BorderLayout(0, 0));
		
		final List listServices = new List();
		panelServices.add(listServices, BorderLayout.CENTER);
		
		JPanel panel_28 = new JPanel();
		panelServices.add(panel_28, BorderLayout.SOUTH);
		panel_28.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		JButton btnModifierServices = new JButton("Modifier");
		btnModifierServices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ModifierService(listServices.getSelectedItem());
			}
		});
		panel_28.add(btnModifierServices);
		
		JButton btnAjouterServices = new JButton("Ajouter");
		btnAjouterServices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AjouterService();
			}
		});
		panel_28.add(btnAjouterServices);
		
		JButton btnSupprimerServices = new JButton("Supprimer");
		btnSupprimerServices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(wind, "Etes-vous sur?");
				if(confirm == JOptionPane.YES_OPTION){
					//TODO Delete
				}
			}
		});
		panel_28.add(btnSupprimerServices);
		
		JPanel panelTitresEnq = new JPanel();
		tabbedPanelEnqueteur.addTab("Titres Enqueteurs", null, panelTitresEnq, null);
		panelTitresEnq.setLayout(new BorderLayout(0, 0));
		
		List listTitresEnq = new List();
		panelTitresEnq.add(listTitresEnq, BorderLayout.CENTER);
		
		JPanel panel_29 = new JPanel();
		panelTitresEnq.add(panel_29, BorderLayout.SOUTH);
		panel_29.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnConsulterTitresEnq = new JButton("Consulter");
		btnConsulterTitresEnq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_29.add(btnConsulterTitresEnq);
		
		JButton btnModifierTitresEnq = new JButton("Modifier");
		btnModifierTitresEnq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_29.add(btnModifierTitresEnq);
		
		JButton btnAjouterTitresEnq = new JButton("Ajouter");
		btnAjouterTitresEnq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_29.add(btnAjouterTitresEnq);
		
		JButton btnSupprimerTitresEnq = new JButton("Supprimer");
		btnSupprimerTitresEnq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(wind, "Etes-vous sur?");
				if(confirm == JOptionPane.YES_OPTION){
					//TODO Delete
				}
			}
		});
		panel_29.add(btnSupprimerTitresEnq);
		
		JPanel panelInstJuridique = new JPanel();
		tabbedPane.addTab("Gestion Inst. Juridiques", null, panelInstJuridique, null);
		panelInstJuridique.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPanelInstJuridique = new JTabbedPane(JTabbedPane.TOP);
		panelInstJuridique.add(tabbedPanelInstJuridique, BorderLayout.CENTER);
		
		JPanel panelTGI = new JPanel();
		tabbedPanelInstJuridique.addTab("TGI", null, panelTGI, null);
		panelTGI.setLayout(new BorderLayout(0, 0));
		
		List listTGI = new List();
		panelTGI.add(listTGI, BorderLayout.CENTER);
		
		JPanel panel_30 = new JPanel();
		panelTGI.add(panel_30, BorderLayout.SOUTH);
		panel_30.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnConsulterTGI = new JButton("Consulter");
		btnConsulterTGI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_30.add(btnConsulterTGI);
		
		JButton btnModifierTGI = new JButton("Modifier");
		btnModifierTGI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_30.add(btnModifierTGI);
		
		JButton btnAjouterTGI = new JButton("Ajouter");
		btnAjouterTGI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_30.add(btnAjouterTGI);
		
		JButton btnSupprimerTGI = new JButton("Supprimer");
		btnSupprimerTGI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel_30.add(btnSupprimerTGI);
		
		final JPanel panelProcureur = new JPanel();
		tabbedPanelInstJuridique.addTab("Procureurs", null, panelProcureur, null);
		panelProcureur.setLayout(new BorderLayout(0, 0));
		
		final List listProcureur = new List();
		panelProcureur.add(listProcureur, BorderLayout.CENTER);
		
		JPanel panel_31 = new JPanel();
		panelProcureur.add(panel_31, BorderLayout.SOUTH);
		panel_31.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnConsulterProcureur = new JButton("Consulter");
		btnConsulterProcureur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ConsulterProcureur(listProcureur.getSelectedItem());
			}
		});
		panel_31.add(btnConsulterProcureur);
		
		JButton btnModifierProcureur = new JButton("Modifier");
		btnModifierProcureur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ModifierProcureur(listProcureur.getSelectedItem());
			}
		});
		panel_31.add(btnModifierProcureur);
		
		JButton btnAjouterProcureur = new JButton("Ajouter");
		btnAjouterProcureur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AjouterProcureur();
			}
		});
		panel_31.add(btnAjouterProcureur);
		
		JButton btnSupprimerProcureur = new JButton("Supprimer");
		btnSupprimerProcureur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(wind, "Etes-vous sur?");
				if(confirm == JOptionPane.YES_OPTION){
					//TODO Delete
				}
			}
		});
		panel_31.add(btnSupprimerProcureur);
		
		final JPanel panelJuges = new JPanel();
		
		
		tabbedPanelInstJuridique.addTab("Juges", null, panelJuges, null);
		panelJuges.setLayout(new BorderLayout(0, 0));
		listJuges = new List();
		listJuges.setMultipleMode(false);
		
		panelJuges.add(listJuges, BorderLayout.CENTER);
		
		
		arrayListJuge = new ArrayList<Proxy>();
		ResultSet res = (ResultSet) facade.proxy("juge", 0);
		Proxy p;
		try {
			while(res.next()){
				p=new Proxy(res.getInt("id_juge"),res.getString("nom")+" "+res.getString("prenom"));
				arrayListJuge.add(p);
				listJuges.add(p.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		JPanel panel_32 = new JPanel();
		panelJuges.add(panel_32, BorderLayout.SOUTH);
		panel_32.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnConsulterJuges = new JButton("Consulter");
		btnConsulterJuges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listJuges.getSelectedItem()!=null){
					System.out.println(listJuges.getSelectedIndex());
					new ConsulterJuge(arrayListJuge.get(listJuges.getSelectedIndex()));
				}
				else
					JOptionPane.showMessageDialog(panelJuges, "Veuillez selectionner un juge");
			}
		});
		panel_32.add(btnConsulterJuges);
		
		JButton btnModifierJuges = new JButton("Modifier");
		btnModifierJuges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listJuges.getSelectedItem()!=null)
					new ModifierJuge(arrayListJuge.get(listJuges.getSelectedIndex()),(window) panelPersonnes.getParent().getParent().getParent().getParent().getParent().getParent().getParent());
				else
					JOptionPane.showMessageDialog(panelJuges, "Veuillez selectionner un juge");
			}
		});
		panel_32.add(btnModifierJuges);
		
		JButton btnAjouterJuges = new JButton("Ajouter");
		btnAjouterJuges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AjouterJuge(wind);
				
			}
		});
		panel_32.add(btnAjouterJuges);
		
		JButton btnSupprimerJuges = new JButton("Supprimer");
		btnSupprimerJuges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listJuges.getSelectedItem()!=null){
					int confirm = JOptionPane.showConfirmDialog(panelJuges, "Etes-vous sur?");
					if(confirm == JOptionPane.YES_OPTION){
						final JugeDB j = (JugeDB) facade.create("juge",null);
						j.load(arrayListJuge.get(listJuges.getSelectedIndex()).getIdBase());
						j.supprimer();
						refreshPanelJuges();
					}
				}
				else
					JOptionPane.showMessageDialog(panelJuges, "Veuillez selectionner un juge");
			}
		});
		panel_32.add(btnSupprimerJuges);
		
		JPanel panelCoursAppel = new JPanel();
		tabbedPanelInstJuridique.addTab("Cours d'appel", null, panelCoursAppel, null);
		panelCoursAppel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_33 = new JPanel();
		panelCoursAppel.add(panel_33, BorderLayout.SOUTH);
		panel_33.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnConsulterCoursAppel = new JButton("Consulter");
		btnConsulterCoursAppel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_33.add(btnConsulterCoursAppel);
		
		JButton btnModifierCoursAppel = new JButton("Modifier");
		btnModifierCoursAppel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_33.add(btnModifierCoursAppel);
		
		JButton btnAjouterCoursAppel = new JButton("Ajouter");
		btnAjouterCoursAppel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_33.add(btnAjouterCoursAppel);
		
		JButton btnSupprimerCoursAppel = new JButton("Supprimer");
		btnSupprimerCoursAppel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_33.add(btnSupprimerCoursAppel);
		
		List listCoursAppel = new List();
		panelCoursAppel.add(listCoursAppel, BorderLayout.CENTER);
		
		JPanel panelTitres = new JPanel();
		tabbedPanelInstJuridique.addTab("Titres", null, panelTitres, null);
		panelTitres.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_34 = new JPanel();
		panelTitres.add(panel_34, BorderLayout.SOUTH);
		panel_34.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnConsulterTitres = new JButton("Consulter");
		btnConsulterTitres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_34.add(btnConsulterTitres);
		
		JButton btnModifierTitres = new JButton("Modifier");
		btnModifierTitres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_34.add(btnModifierTitres);
		
		JButton btnAjouterTitres = new JButton("Ajouter");
		btnAjouterTitres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_34.add(btnAjouterTitres);
		
		JButton btnSupprimerTitres = new JButton("Supprimer");
		btnSupprimerTitres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_34.add(btnSupprimerTitres);
		
		List listTitres = new List();
		panelTitres.add(listTitres, BorderLayout.CENTER);
		
		final JPanel panelGreffiers = new JPanel();
		tabbedPanelInstJuridique.addTab("Greffiers", null, panelGreffiers, null);
		panelGreffiers.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_35 = new JPanel();
		panelGreffiers.add(panel_35, BorderLayout.SOUTH);
		panel_35.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		final List listGreffiers = new List();
		panelGreffiers.add(listGreffiers, BorderLayout.CENTER);
		
		JButton btnConsulterGreffiers = new JButton("Consulter");
		btnConsulterGreffiers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ConsulterGreffier(listGreffiers.getSelectedItem());
			}
		});
		panel_35.add(btnConsulterGreffiers);
		
		JButton btnModifierGreffiers = new JButton("Modifier");
		btnModifierGreffiers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ModifierGreffier(listGreffiers.getSelectedItem());
			}
		});
		panel_35.add(btnModifierGreffiers);
		
		JButton btnAjouterGreffiers = new JButton("Ajouter");
		btnAjouterGreffiers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AjouterGreffier();
			}
		});
		panel_35.add(btnAjouterGreffiers);
		
		JButton btnSupprimerGreffiers = new JButton("Supprimer");
		btnSupprimerGreffiers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(panelGreffiers, "Etes-vous sur?");
				if(confirm == JOptionPane.YES_OPTION){
					//TODO Delete
				}
			}
		});
		panel_35.add(btnSupprimerGreffiers);

		
		JPanel panelServicesTGI = new JPanel();
		tabbedPanelInstJuridique.addTab("Services TGI", null, panelServicesTGI, null);
		panelServicesTGI.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_36 = new JPanel();
		panelServicesTGI.add(panel_36, BorderLayout.SOUTH);
		panel_36.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnConsulterServicesTGI = new JButton("Consulter");
		btnConsulterServicesTGI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_36.add(btnConsulterServicesTGI);
		
		JButton btnModifierServicesTGI = new JButton("Modifier");
		btnModifierServicesTGI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_36.add(btnModifierServicesTGI);
		
		JButton btnAjouterServicesTGI = new JButton("Ajouter");
		btnAjouterServicesTGI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_36.add(btnAjouterServicesTGI);
		
		JButton btnSupprimerServicesTGI = new JButton("Supprimer");
		btnSupprimerServicesTGI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_36.add(btnSupprimerServicesTGI);
		
		List listServicesTGI = new List();
		panelServicesTGI.add(listServicesTGI, BorderLayout.CENTER);
		
		JPanel panelAffaire = new JPanel();
		tabbedPane.addTab("Gestion Affaire", null, panelAffaire, null);
		panelAffaire.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPanelGestionAffaire = new JTabbedPane(JTabbedPane.TOP);
		panelAffaire.add(tabbedPanelGestionAffaire, BorderLayout.CENTER);
		
		JPanel panelInfosGenerales = new JPanel();
		tabbedPanelGestionAffaire.addTab("Informations generales", null, panelInfosGenerales, null);
		panelInfosGenerales.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_37 = new JPanel();
		panelInfosGenerales.add(panel_37, BorderLayout.SOUTH);
		panel_37.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnConsulterInfosGenerales = new JButton("Creer");
		btnConsulterInfosGenerales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AjouterAffaire(wind);
			}
		});
		panel_37.add(btnConsulterInfosGenerales);
		
		JButton btnModifierInfosGenerales = new JButton("Modifier");
		btnModifierInfosGenerales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_37.add(btnModifierInfosGenerales);
		
		JButton btnAjouterInfosGenerales = new JButton("Finaliser");
		btnAjouterInfosGenerales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_37.add(btnAjouterInfosGenerales);
		
		JButton btnSupprimerInfosGenerales = new JButton("Consulter");
		btnSupprimerInfosGenerales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_37.add(btnSupprimerInfosGenerales);
		
		JButton btnAjoutMissionInfosGenerales = new JButton("Ajout Mission");
		btnAjoutMissionInfosGenerales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_37.add(btnAjoutMissionInfosGenerales);
		
		JButton btnModifMissionInfosGenerales = new JButton("Modif. Mission");
		btnModifMissionInfosGenerales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_37.add(btnModifMissionInfosGenerales);
		
		JButton btnSupMissionInfosGenerales = new JButton("Sup. Mission");
		btnSupMissionInfosGenerales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_37.add(btnSupMissionInfosGenerales);
		
		List listInfosGenerales = new List();
		panelInfosGenerales.add(listInfosGenerales, BorderLayout.CENTER);
		
		JPanel panelDevis = new JPanel();
		tabbedPanelGestionAffaire.addTab("Devis", null, panelDevis, null);
		panelDevis.setLayout(new BorderLayout(0, 0));
		
		List listDevis = new List();
		panelDevis.add(listDevis, BorderLayout.CENTER);
		
		JPanel panel_38 = new JPanel();
		panelDevis.add(panel_38, BorderLayout.SOUTH);
		panel_38.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnConsulterDevis = new JButton("Consulter");
		btnConsulterDevis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_38.add(btnConsulterDevis);
		
		JButton btnModifierDevis = new JButton("Modifier");
		btnModifierDevis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_38.add(btnModifierDevis);
		
		JButton btnAjouterDevis = new JButton("Ajouter");
		btnAjouterDevis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_38.add(btnAjouterDevis);
		
		JButton btnSupprimerDevis = new JButton("Supprimer");
		btnSupprimerDevis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_38.add(btnSupprimerDevis);
		
		JPanel panelScelles = new JPanel();
		tabbedPanelGestionAffaire.addTab("Scelles", null, panelScelles, null);
		panelScelles.setLayout(new BorderLayout(0, 0));
		
		List listScelles = new List();
		panelScelles.add(listScelles, BorderLayout.CENTER);
		
		JPanel panel_39 = new JPanel();
		panelScelles.add(panel_39, BorderLayout.SOUTH);
		panel_39.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnConsulterScelles = new JButton("Consulter");
		btnConsulterScelles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_39.add(btnConsulterScelles);
		
		JButton btnModifierScelles = new JButton("Mofifier");
		btnModifierScelles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_39.add(btnModifierScelles);
		
		JButton btnAjouterScelles = new JButton("Ajouter");
		btnAjouterScelles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_39.add(btnAjouterScelles);
		
		JButton btnSupprimerScelles = new JButton("Supprimer");
		btnSupprimerScelles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_39.add(btnSupprimerScelles);
		
		JPanel panelTypesMissions = new JPanel();
		tabbedPanelGestionAffaire.addTab("Types de mission", null, panelTypesMissions, null);
		panelTypesMissions.setLayout(new BorderLayout(0, 0));
		
		List listTypesMissions = new List();
		panelTypesMissions.add(listTypesMissions, BorderLayout.CENTER);
		
		JPanel panel_40 = new JPanel();
		panelTypesMissions.add(panel_40, BorderLayout.SOUTH);
		panel_40.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnConsulterTypesMissions = new JButton("Consulter");
		btnConsulterTypesMissions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_40.add(btnConsulterTypesMissions);
		
		JButton btnModifierTypesMissions = new JButton("Modifier");
		btnModifierTypesMissions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_40.add(btnModifierTypesMissions);
		
		JButton btnAjouterTypesMissions = new JButton("Ajouter");
		btnAjouterTypesMissions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_40.add(btnAjouterTypesMissions);
		
		JButton btnSupprimerTypesMissions = new JButton("Supprimer");
		btnSupprimerTypesMissions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_40.add(btnSupprimerTypesMissions);
		
		JPanel panelTypesObjets = new JPanel();
		tabbedPanelGestionAffaire.addTab("Types d'objets", null, panelTypesObjets, null);
		panelTypesObjets.setLayout(new BorderLayout(0, 0));
		
		List listTypesObjets = new List();
		panelTypesObjets.add(listTypesObjets, BorderLayout.CENTER);
		
		JPanel panel_41 = new JPanel();
		panelTypesObjets.add(panel_41, BorderLayout.SOUTH);
		panel_41.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnConsulterTypesObjets = new JButton("Consulter");
		btnConsulterTypesObjets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_41.add(btnConsulterTypesObjets);
		
		JButton btnModifierTypesObjets = new JButton("Modifier");
		btnModifierTypesObjets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_41.add(btnModifierTypesObjets);
		
		JButton btnAjouterTypesObjets = new JButton("Ajouter");
		btnAjouterTypesObjets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_41.add(btnAjouterTypesObjets);
		
		JButton btnSupprimerTypesObjets = new JButton("Supprimer");
		btnSupprimerTypesObjets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_41.add(btnSupprimerTypesObjets);
		
		JPanel panelMaterielsLogiciels = new JPanel();
		tabbedPanelGestionAffaire.addTab("Materiels/Logiciels", null, panelMaterielsLogiciels, null);
		panelMaterielsLogiciels.setLayout(new BorderLayout(0, 0));
		
		List listMaterielsLogiciels = new List();
		panelMaterielsLogiciels.add(listMaterielsLogiciels, BorderLayout.CENTER);
		
		JPanel panel_42 = new JPanel();
		panelMaterielsLogiciels.add(panel_42, BorderLayout.SOUTH);
		panel_42.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnConsulterMaterielsLogiciels = new JButton("Consulter");
		btnConsulterMaterielsLogiciels.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_42.add(btnConsulterMaterielsLogiciels);
		
		JButton btnModifierMaterielsLogiciels = new JButton("Modifier");
		btnModifierMaterielsLogiciels.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_42.add(btnModifierMaterielsLogiciels);
		
		JButton btnAjouterMaterielsLogiciels = new JButton("Ajouter");
		btnAjouterMaterielsLogiciels.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_42.add(btnAjouterMaterielsLogiciels);
		
		JButton btnSupprimerMaterielsLogiciels = new JButton("Supprimer");
		btnSupprimerMaterielsLogiciels.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_42.add(btnSupprimerMaterielsLogiciels);
		
		JPanel panelTarifications = new JPanel();
		tabbedPanelGestionAffaire.addTab("Tarification", null, panelTarifications, null);
		panelTarifications.setLayout(new BorderLayout(0, 0));
		
		List listTarifications = new List();
		panelTarifications.add(listTarifications, BorderLayout.CENTER);
		
		JPanel panel_43 = new JPanel();
		panelTarifications.add(panel_43, BorderLayout.SOUTH);
		panel_43.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnConsulterTarifications = new JButton("Consulter");
		btnConsulterTarifications.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_43.add(btnConsulterTarifications);
		
		JButton btnModifierTarifications = new JButton("Modifier");
		btnModifierTarifications.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_43.add(btnModifierTarifications);
		
		JButton btnAjouterTarifications = new JButton("Ajouter");
		btnAjouterTarifications.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_43.add(btnAjouterTarifications);
		
		JButton btnSupprimerTarifications = new JButton("Supprimer");
		btnSupprimerTarifications.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_43.add(btnSupprimerTarifications);
		
		JPanel panelSuiviAffaire = new JPanel();
		tabbedPane.addTab("Suivi Affaire", null, panelSuiviAffaire, null);
		panelSuiviAffaire.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPanelSuiviAffaire = new JTabbedPane(JTabbedPane.TOP);
		panelSuiviAffaire.add(tabbedPanelSuiviAffaire, BorderLayout.CENTER);
		
		JPanel panelFrais = new JPanel();
		tabbedPanelSuiviAffaire.addTab("Frais", null, panelFrais, null);
		panelFrais.setLayout(new BorderLayout(0, 0));
		
		List listFrais = new List();
		panelFrais.add(listFrais, BorderLayout.CENTER);
		
		JPanel panel_44 = new JPanel();
		panelFrais.add(panel_44, BorderLayout.SOUTH);
		panel_44.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnConsulterFrais = new JButton("Consulter");
		btnConsulterFrais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_44.add(btnConsulterFrais);
		
		JButton btnModifierFrais = new JButton("Modifier");
		btnModifierFrais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_44.add(btnModifierFrais);
		
		JButton btnAjouterFrais = new JButton("Ajouter");
		btnAjouterFrais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_44.add(btnAjouterFrais);
		
		JButton btnSupprimerFrais = new JButton("Supprimer");
		btnSupprimerFrais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_44.add(btnSupprimerFrais);
		
		JPanel panelObjets = new JPanel();
		tabbedPanelSuiviAffaire.addTab("Objets", null, panelObjets, null);
		panelObjets.setLayout(new BorderLayout(0, 0));
		
		List listObjets = new List();
		panelObjets.add(listObjets, BorderLayout.CENTER);
		
		JPanel panel_45 = new JPanel();
		panelObjets.add(panel_45, BorderLayout.SOUTH);
		panel_45.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnConsulterObjets = new JButton("Consulter");
		btnConsulterObjets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_45.add(btnConsulterObjets);
		
		JButton btnModifierObjets = new JButton("Modifier");
		btnModifierObjets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_45.add(btnModifierObjets);
		
		JButton btnAjouterObjets = new JButton("Ajouter");
		btnAjouterObjets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_45.add(btnAjouterObjets);
		
		JButton btnSupprimerObjets = new JButton("Supprimer");
		btnSupprimerObjets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_45.add(btnSupprimerObjets);
		
		JButton btnAjoutSsObjet = new JButton("Ajout ss Objet");
		btnAjoutSsObjet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_45.add(btnAjoutSsObjet);
		
		JButton btnModifSsObjet = new JButton("Modif. ss Objet");
		btnModifSsObjet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_45.add(btnModifSsObjet);
		
		JButton btnSuprSsObjet = new JButton("Supr. ss. Objet");
		btnSuprSsObjet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_45.add(btnSuprSsObjet);
		this.setSize(800,600);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//this.pack();
		this.repaint();
	}
	
	public void refreshPanelJuges(){
		listJuges.removeAll();
		arrayListJuge.clear();
		ResultSet res = (ResultSet) facade.proxy("juge", 0);
		Proxy p;
		try {
			while(res.next()){
				p=new Proxy(res.getInt("id_juge"),res.getString("nom")+" "+res.getString("prenom"));
				arrayListJuge.add(p);
				listJuges.add(p.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
