package com.modele;

import java.util.*;
import javax.swing.table.AbstractTableModel;
import com.metier.Parc;
import com.metier.Borne;

import com.metier.Station;
public class ModeleBorneTypeCharge extends AbstractTableModel {
	private final String[] entetes = { "idBorne", "date mise en service", "libelle emplacement", "puissance"};
	private List<Borne> listeTypeChargeBorne = null;

	private Parc unParc;
	// on récupère l'ensemble des bornes et l'ensemble des stations
	// on instancie un objet Parc et on affecte la liste des stations
	public ModeleBorneTypeCharge(Parc p) {
		unParc = p;
		
		}
	// on crée une collection de travail avec les bornes correspondant au type sélectionné par l'utilisateur
	// c'est cette collection qui sera utilsée pour remplir la table
	public  void ChargeListeBorne(int code) {
		listeTypeChargeBorne = new ArrayList<Borne>();
		for (Station s: unParc.getLeParcBorne()) {
		for (Borne b: s.getLesBornes()) 	{
			if (b.getTypeCharge().getCodeTypeCharge() == code) 	{
				listeTypeChargeBorne.add(b);
			}
		}
		}
	}
	@Override
	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}

	@Override
	public int getColumnCount() {
		return entetes.length;
	}

	@Override
	public int getRowCount() {
		return listeTypeChargeBorne.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			// idBorne
			return listeTypeChargeBorne.get(rowIndex).getIdBorne();
		case 1:
			// Date de mise en service
			return listeTypeChargeBorne.get(rowIndex).getDateMiseEnService();
		case 2:
			// on fait appel à une nouvelle méthode de Parc qui récupère le libelleEmplacement de la station
			// on évite ainsi de refaire appel à AccesData
			// autrement on aurais pu passer par 
			//return AccesData.getStation(listeTypeChargeBorne.get(rowIndex).getIdStation()).getLibelleEmplacement();
			return unParc.getLibelleStation(listeTypeChargeBorne.get(rowIndex).getIdStation());
		case 3:
			// puissance
			return listeTypeChargeBorne.get(rowIndex).getTypeCharge().getPuissanceTypeCharge();
		default:
			throw new IllegalArgumentException();
	}
	}
}

